package servlet.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.BasketService;
import Service.OrderService;
import dto.Basket;
import dto.BasketDetail;
import dto.OrderDetail;
import dto.Orders;
 
@WebServlet(name = "product.OrderController", urlPatterns =  "/product/OrderController" )
public class OrderController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderController doGet()실행");
		
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/product/order.jsp").forward(request, response);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasketService basketService = (BasketService) request.getServletContext().getAttribute("basketService");
		
		request.setCharacterEncoding("UTF-8");
		System.out.println("OrderController doPost() 실행");
		int post = Integer.parseInt(request.getParameter("userPost"));
		String receiverAddr = request.getParameter("userAddr");
		String receiverDetailAdrr = request.getParameter("userDetailAddr");
		String receiverPhone = request.getParameter("user_phone");
		String receiverName = request.getParameter("user_id");
		
		OrderService orderService = (OrderService) request.getServletContext().getAttribute("orderService");
		HttpSession session = request.getSession();
		
		String loginId = (String) session.getAttribute("loginId");
		int totalPrice = 0;
		List<OrderDetail> orderDetailList = (List<OrderDetail>) session.getAttribute("orderDetail");
		for(OrderDetail orderDetail : orderDetailList) {
			
			totalPrice += orderDetail.getPrice();
			
			//colorId랑 capacityId가 같으면 같은 basketDetail이라고 간주
			String colorId = orderDetail.getColor().getColorId();
			String capacityId = orderDetail.getCapacity().getCapacityId();
			//해당 basketDetailId를 통해 basketDetail 하나를 삭제함
			String basketDetailId = basketService.isOrdered(colorId,capacityId);
			basketService.deleteBasketDetail(basketDetailId);
			
			//basketDetail이 삭제되었으므로 basket도 수정이 필요함
			Basket basket = basketService.getBasket(loginId);
			int basketPrice = 0;
			List<BasketDetail> list = basketService.getBasketDetailList(loginId);
			for(BasketDetail basketDetail : list ) {
				basketPrice += basketDetail.getPrice();
			}
		
			basket.setTotalPrice(basketPrice);
			basketService.updateBasket(basket);
			
		}
		Orders order = new Orders();
		order.setPost(post);
		order.setReceiverAddr(receiverAddr);
		order.setReceiverDetailAdrr(receiverDetailAdrr);
		order.setReceiverPhone(receiverPhone);
		order.setUserId(loginId);
		order.setTotalPrice(totalPrice);
		order.setReceiverName(receiverName);
		
		
		int orderId = orderService.takeOrder(order);
		for(OrderDetail orderDetail : orderDetailList) {
			orderDetail.setOrderId(orderId);
			orderService.insertOrderDetail(orderDetail);
		}

		response.sendRedirect("ProductListController");
		
	}
}
