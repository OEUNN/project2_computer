package servlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.BasketService;
import Service.ProductService;
import dto.BasketDetail;
import dto.Product;
 
@WebServlet(name = "product.CreateBasketDetailController", urlPatterns =  "/product/CreateBasketDetailController" )
public class CreateBasketDetailController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BasketListController doGet()실행");
		BasketDetail basketDetail = new BasketDetail();
		
		//jsp에서 넘어온 값들을 Parmeter으로 얻어내어 basketDetail객체에 set함 
		String colorName = request.getParameter("colorName");
		String capacityName = request.getParameter("capaName");
		System.out.println(colorName);
		
		String productId = request.getParameter("productId");
		System.out.println(productId);
		System.out.println(capacityName);
		//int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		
//		basketDetail.setCapacityId(capacityId);
//		basketDetail.setColorId(colorId);
		basketDetail.setProductId(productId);
//		
//		//price를 얻기 위해 productId를 통해서 product 객체 가져오고 그걸로 price get함
//		ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
//		Product product = productService.getProduct(productId);	
//		product.getProductImageList();
//		//파라미터로 얻어온 수량과 가격을 곱하여 detail에 저장할 가격을 얻어냄
//		int price = product.getProductPrice()*quantity;
//		//수량과 가격을 basketDetail에 저장함
//		basketDetail.setPrice(price);
//		basketDetail.setProductQnt(quantity);
//		
//		//basketDetail 테이블에 Dao통해서 데이터 넣기
//		BasketService basketService = (BasketService) request.getServletContext().getAttribute("basketDetailService");
//		basketService.addBasketDetail(basketDetail);
//		
		//JSP로 이동
		response.sendRedirect("ProductListController");
	}

}
