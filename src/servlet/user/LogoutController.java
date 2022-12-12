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
 
@WebServlet(name = "user.LogoutController", urlPatterns ="/user/LogoutController")
public class LogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LogoutController service() 실행");
		
		HttpSession session = request.getSession();
		
		//session에 저장된 객체 제거
		session.removeAttribute("loginId");
		session.removeAttribute("isAdmin");
		
		response.sendRedirect("../product/ProductListController");
	}
	

}
