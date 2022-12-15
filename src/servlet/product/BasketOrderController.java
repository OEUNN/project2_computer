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

import Service.BasketService;
import Service.CapacityService;
import Service.ColorService;
import Service.ProductService;
import dto.BasketDetail;
import dto.OrderDetail;
import dto.Product;
import dto.ProductImage;
 
@WebServlet(name = "product.BasketOrderController", urlPatterns =  "/product/BasketOrderController" )
public class BasketOrderController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("CreateOrderController doPost()실행");
		BasketService basketService = (BasketService) request.getServletContext().getAttribute("basketService");
		ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
		//jsp에서 넘어온 값들을 Parmeter으로 얻어내어 basketDetail객체에 set함 
		String[] basketDetailId = request.getParameterValues("basket");
		
		List<OrderDetail> list = new ArrayList<>();
		

		for(int i=0; i<basketDetailId.length;i++) {	
			BasketDetail basketDetail = basketService.getBasketDetail(basketDetailId[i]);
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setColor(basketDetail.getColor());
			orderDetail.setCapacity(basketDetail.getCapacity());
			int productPrice = basketDetail.getProduct().getProductPrice();
			int productQuantity = basketDetail.getProductQnt();
			orderDetail.setPrice(productPrice*productQuantity);
			String productId = basketDetail.getProduct().getProductId();
			Product product = productService.getProduct(productId);
			orderDetail.setProduct(product);
			orderDetail.setProductQnt(productQuantity);
		
			list.add(orderDetail);
		}
		
		

		

		HttpSession session = request.getSession();
		session.setAttribute("orderDetail", list);
		
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/product/order.jsp").forward(request, response);
	}

}
