package servlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.OrderService;

@WebServlet(name = "product.OrderController", urlPatterns =  "/product/OrderController" )
public class OrderController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderController doGet()실행");
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/product/order.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderController doPost() 실행");
		OrderService orderService = (OrderService) request.getServletContext().getAttribute("orderService");
		//해당 디테일 Parameter 얻어서 post로 처리하는 코드
		
		request.getRequestDispatcher("/WEB-INF/views/product/order.jsp").forward(request, response);
		
	}
}
