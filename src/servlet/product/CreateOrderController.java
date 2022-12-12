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

import Service.CapacityService;
import Service.ColorService;
import Service.ProductService;
import dto.OrderDetail;
import dto.Product;
import dto.ProductImage;
 
@WebServlet(name = "product.CreateOrderController", urlPatterns =  "/product/CreateOrderController" )
public class CreateOrderController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CreateOrderController doPost()실행");
		ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
		ColorService colorService = (ColorService) request.getServletContext().getAttribute("colorService");
		CapacityService capacityService = (CapacityService) request.getServletContext().getAttribute("capacityService");
		//jsp에서 넘어온 값들을 Parmeter으로 얻어내어 basketDetail객체에 set함 
		String[] colorId = request.getParameterValues("colorId");
		String[] capacityId = request.getParameterValues("capaId");
		String price[] = request.getParameterValues("price");		
		String productId[] = request.getParameterValues("productId");
		String quantity[] = request.getParameterValues("quantity");
		
		List<OrderDetail> list = new ArrayList<>();
		
		for(int i=0; i<colorId.length;i++) {	
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setColor(colorService.getColor(colorId[i]));
			orderDetail.setCapacity(capacityService.getCapacity(capacityId[i]));
			int productPrice = Integer.parseInt(price[i]);
			int productQuantity = Integer.parseInt(quantity[i]);
			orderDetail.setPrice(productPrice*productQuantity);
			Product product = productService.getProduct(productId[i]);
			orderDetail.setProduct(product);
			orderDetail.setProductQnt(Integer.parseInt(quantity[i]));
			list.add(orderDetail);
		}
		

		HttpSession session = request.getSession();
		session.setAttribute("orderDetail", list);
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/product/order.jsp").forward(request, response);
	}

}
