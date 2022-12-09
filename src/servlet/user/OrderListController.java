package servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "user.OrderListController", urlPatterns ="/user/OrderListController")
public class OrderListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderListController service() 실행");
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/user/orderList.jsp").forward(request, response);
	}

}
