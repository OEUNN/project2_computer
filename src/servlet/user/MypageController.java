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

@WebServlet(name = "user.MypageController", urlPatterns ="/user/MypageController")
public class MypageController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("MypageController service() 실행");
		ServletContext application = request.getServletContext();
		UserService userService = (UserService) application.getAttribute("userService");
		
		HttpSession session = request.getSession();
		String loginId =(String)session.getAttribute("loginId");
		System.out.println(loginId);
		
		Users usersDto = new Users();
		usersDto = userService.userInfo(loginId);
		
		request.setAttribute("users", usersDto);
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/user/mypage.jsp").forward(request, response);
	}

}
