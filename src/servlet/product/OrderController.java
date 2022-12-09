package servlet.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.OrderService;
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
