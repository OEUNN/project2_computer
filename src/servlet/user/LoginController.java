package servlet.user;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.UserService;
import dto.Users;

@WebServlet(name = "user.LoginController", urlPatterns ="/user/LoginController")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login service() 실행");
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		//System.out.println(userId);
		//System.out.println(userPwd);
		
		ServletContext application = request.getServletContext();
		UserService userService = (UserService) application.getAttribute("userService");
		
		Users users = new Users();
		users = userService.userLogin(userId, userPwd);
		
		if(users.getUserId().equals("")) {
			request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("loginId", users.getUserId());
			session.setAttribute("isAdmin",users.isAdmin());
			if(users.isAdmin()) {
				response.sendRedirect("UploadController");
			}else {
				response.sendRedirect("../product/ProductListController");
			}
		}
		
	}
}
