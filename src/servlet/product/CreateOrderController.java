package servlet.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.ProductService;
import dto.OrderDetail;
import dto.Product;
import dto.ProductImage;

@WebServlet(name = "product.CreateOrderController", urlPatterns =  "/product/CreateOrderController" )
public class CreateOrderController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CreateOrderController doPost()실행");
		ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
		
		//jsp에서 넘어온 값들을 Parmeter으로 얻어내어 basketDetail객체에 set함 
		String[] colorName = request.getParameterValues("colorName");
		String[] capacityName = request.getParameterValues("capaName");
		String price[] = request.getParameterValues("price");		
		String productId[] = request.getParameterValues("productId");
		String quantity[] = request.getParameterValues("quantity");
		
		List<OrderDetail> list = new ArrayList<>();
		List<ProductImage> imageList = new ArrayList<>();
		
		for(int i=0; i<colorName.length;i++) {	
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setColorName(colorName[i]);
			orderDetail.setCapacityName(capacityName[i]);
			orderDetail.setPrice(Integer.parseInt(price[i]));
			Product product = productService.getProduct(productId[i]);
			
			orderDetail.setProduct(product);
			orderDetail.setProductQnt(Integer.parseInt(quantity[i]));
			list.add(orderDetail);
		}
		
		
	
//		orderDetail.setColorName(colorName);
//		orderDetail.setCapacityName(capacityName);
//		orderDetail.setPrice(price);
//		orderDetail.setProductId(productId);
//		orderDetail.setProductQnt(quantity);
		
		HttpSession session = request.getSession();
		session.setAttribute("orderDetail", list);
		
		//JSP로 이동
		response.sendRedirect("OrderController");
	}

}
