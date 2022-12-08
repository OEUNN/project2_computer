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
import Service.ReviewBoardService;
import dto.Product;
import dto.ReviewBoard;
import util.Pager;

@WebServlet(name = "product.ProductDetailController", urlPatterns =  "/product/ProductDetailController" )
public class ProductDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductDetailController service()실행");
		ServletContext application = request.getServletContext();
		ProductService productService= (ProductService)application.getAttribute("productService");
		ReviewBoardService reviewBoardService = (ReviewBoardService)application.getAttribute("reviewBoardService");
		//페이징 대상이 되는 전체 행수 얻기
		String strPageNo = request.getParameter("pageNo");
		if(strPageNo==null) {
			strPageNo="1";
		}
		int pageNo=Integer.parseInt(strPageNo);
		int totalBoardNum = reviewBoardService.getTotalRowReviewBoard();
		
		//Pager 생성
		Pager pager = new Pager(10,5,totalBoardNum,pageNo);
		List<ReviewBoard> reviewBoardList=reviewBoardService.readReviewBoard(pager);
		Product product=productService.getProduct(request.getParameter("productId"));
		request.setAttribute("product", product);
		request.setAttribute("reviewBoardList", reviewBoardList);
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/product/productDetail.jsp").forward(request, response);
	}

}
