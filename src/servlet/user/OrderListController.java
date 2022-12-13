package servlet.user;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.OrderService;
import dto.Orders;
 
@WebServlet(name = "user.OrderListController", urlPatterns ="/user/OrderListController")
public class OrderListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderListController service() 실행");
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginId");
		OrderService orderService = (OrderService) request.getServletContext().getAttribute("orderService");
		List<Orders> orders = orderService.getOrder(userId);
	
		request.setAttribute("orders", orders);
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/user/orderList2.jsp").forward(request, response);
	}

}
