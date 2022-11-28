package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "user.LoginController", urlPatterns ="/user/LoginController")
public class LoginController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login service() 실행");
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
	}

}
