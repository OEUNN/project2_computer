package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "user.MypageController", urlPatterns ="/user/MypageController")
public class MypageController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MypageController service() 실행");
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/user/mypage.jsp").forward(request, response);
	}

}
