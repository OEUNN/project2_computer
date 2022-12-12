package servlet.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ProductService;
import dto.Product;
import util.Pager;

@WebServlet(name = "product.UploadController", urlPatterns ="/product/UploadController")
public class UploadController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Upload service() 실행");
		String strPageNo = request.getParameter("pageNo");
		Product product=new Product();
		if(strPageNo==null) {
			strPageNo="1";
		}
		
		int pageNo=Integer.parseInt(strPageNo);
		ServletContext application = request.getServletContext();
		ProductService productService= (ProductService)application.getAttribute("productService");
		//페이징 대상이 되는 전체 행수 얻기
		int totalBoardNum = productService.getTotalRow(product);
		
		//Pager 생성
		Pager pager = new Pager(3,5,totalBoardNum,pageNo);
		
		//pageNo에 해당하는 게시물 가져오기
		List<Product> productList=productService.getList(pager,product);
		//JSP에서 사용할수 있도록 request범위에 저장
		
		request.setAttribute("pager", pager);
		request.setAttribute("productList",productList);
		
		//JSP로 이동
		if(strPageNo.equals("1")) {
			request.getRequestDispatcher("/WEB-INF/views/product/upload.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/product/productTable.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
