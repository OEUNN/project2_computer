package servlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.BasketDetail;
import DTO.OrderDetail;
import DTO.Orders;
import DTO.Product;
import Service.BasketService;
import Service.ProductService;

@WebServlet(name = "product.DetailButtonChoiceController", urlPatterns =  "/product/DetailButtonChoiceController" )
public class DetailButtonChoiceController extends HttpServlet {	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("choice");
		System.out.println(choice);
		switch(choice) {
			case "basket":
				//장바구니에 담을 때 detail을 만들어서 추가
				BasketDetail basketDetail = new BasketDetail();
				
				//jsp에서 넘어온 값들을 Parmeter으로 얻어내어 basketDetail객체에 set함 
				int colorId = Integer.parseInt(request.getParameter("colorId"));
				int capacityId = Integer.parseInt(request.getParameter("capaId"));
				String productId = request.getParameter("productId");
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				//basketDetail.setCapacityId(capacityId);
				//basketDetail.setColorId(colorId);
				basketDetail.setProductId(productId);
				
				//price를 얻기 위해 productId를 통해서 product 객체 가져오고 그걸로 price get함
				ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
				Product product = productService.getProduct(productId);	
				product.getProductImageList();
				//파라미터로 얻어온 수량과 가격을 곱하여 detail에 저장할 가격을 얻어냄
				int price = product.getProductPrice()*quantity;
				//수량과 가격을 basketDetail에 저장함
				basketDetail.setPrice(price);
				basketDetail.setProductQnt(quantity);
				
				//basketDetail 테이블에 Dao통해서 데이터 넣기
				BasketService basketService = (BasketService) request.getServletContext().getAttribute("basketDetailService");
				basketService.addBasketDetail(basketDetail);
				request.getRequestDispatcher("/WEB-INF/views/product/productDetail.jsp").forward(request, response);		
				break;
				
			case "buy":
				//order 객체에 필요해서 넘어온 parameter들을 얻어 객체 생성
				//colorId = Integer.parseInt(request.getParameter("colorId"));
				//capacityId = Integer.parseInt(request.getParameter("capaId"));
				//productId = request.getParameter("productId");
				quantity = Integer.parseInt(request.getParameter("quantity"));
				productService = (ProductService) request.getServletContext().getAttribute("productService");
				
				OrderDetail orderDetail = new OrderDetail();
				//product = productService.getProduct(productId);	
				//price = product.getProductPrice()*quantity;
				colorId = 1;
				capacityId = 1;
				price=1000;
				productId = "3";
				orderDetail.setPrice(price);
				orderDetail.setProductQnt(quantity);
				orderDetail.setCapacityId(capacityId);
				orderDetail.setColorId(colorId);
				orderDetail.setProductId(productId);
				
				request.setAttribute("orderDetail", orderDetail);
				
				request.getRequestDispatcher("/WEB-INF/views/product/order.jsp").forward(request, response);
				break;
		
		
		}
		
		//JSP로 이동
		
	}

}
