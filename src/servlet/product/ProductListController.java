package servlet.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Service.ProductService;
import dto.Product;
import util.Pager;

@WebServlet(name = "product.ProductListController", urlPatterns =  "/product/ProductListController" )

public class ProductListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductListController service()실행!!!!");
		String strPageNo = request.getParameter("pageNo");
		if(strPageNo==null) {
			strPageNo="1";
		}
		int pageNo=Integer.parseInt(strPageNo);
		ServletContext application = request.getServletContext();
		ProductService productService= (ProductService)application.getAttribute("productService");
		//페이징 대상이 되는 전체 행수 얻기
		int totalBoardNum = productService.getTotalRow();
		
		//Pager 생성
		Pager pager = new Pager(3,5,totalBoardNum,pageNo);
		
		//pageNo에 해당하는 게시물 가져오기
		List<Product> productList=productService.getList(pager);
		//JSP에서 사용할수 있도록 request범위에 저장
		request.setAttribute("pager", pager);
		request.setAttribute("productList",productList);
		/*for(Product product:productList) {
			System.out.println(product);
			
		}*/
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/product/productList.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductListController service()실행!!!!");
		String strPageNo = request.getParameter("pageNo");
		if(strPageNo==null) {
			strPageNo="1";
		}
		int pageNo=Integer.parseInt(strPageNo);
		ServletContext application = request.getServletContext();
		ProductService productService= (ProductService)application.getAttribute("productService");
		//페이징 대상이 되는 전체 행수 얻기
		int totalBoardNum = productService.getTotalRow();
		
		//Pager 생성
		Pager pager = new Pager(3,5,totalBoardNum,pageNo);
		
		//pageNo에 해당하는 게시물 가져오기
		List<Product> productList=productService.getList(pager);
		//JSP에서 사용할수 있도록 request범위에 저장
		request.setAttribute("pager", pager);
		request.setAttribute("productList",productList);
		request.getRequestDispatcher("/WEB-INF/views/product/product.jsp").forward(request, response);
		/*response.setContentType("application/json; charset=UTF-8");

		JSONObject root = new JSONObject();
		root.put("pager", pager);
		root.put("productList", productList);
		
		String json=root.toString();
		
		PrintWriter pw = response.getWriter();
		pw.println(json);
		pw.flush();
		pw.close();*/
		
	}

}
