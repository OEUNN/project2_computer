package servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@MultipartConfig(maxFileSize = 1024*1024*10, maxRequestSize=1024*1024*20)
@WebServlet(name = "user.JoinController", urlPatterns ="/user/JoinController")
public class JoinController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JoinController service() 실행");
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/user/join.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JoinController doPost()");
		String userId = request.getParameter("userId");
		System.out.println(userId);
		
	}
	

}
