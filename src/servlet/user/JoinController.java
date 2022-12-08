package servlet.user;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Service.UserService;
import dto.Users;

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
		request.setCharacterEncoding("UTF-8");
		System.out.println("JoinController doPost()");
		
		ServletContext application = request.getServletContext();
		UserService userService = (UserService) application.getAttribute("userService");
		Users usersDto = new Users();
		//문자파트
		usersDto.setUserId(request.getParameter("userId"));
		usersDto.setUserPwd(request.getParameter("userPwd"));
		usersDto.setUserName(request.getParameter("userName"));
		usersDto.setUserPhone(request.getParameter("userPhone"));
		usersDto.setUserEmail(request.getParameter("userEmail"));
		usersDto.setUserNickname(request.getParameter("userNickname"));
		usersDto.setUserPost(Integer.parseInt(request.getParameter("userPost")));
		usersDto.setUserAddr(request.getParameter("userAddr"));
		usersDto.setUserDetailAddr(request.getParameter("userDetailAddr"));
		
		//파일 파트
		Part filePart = request.getPart("userImg");
		if(!filePart.getSubmittedFileName().equals("")) {
			String fileName = filePart.getSubmittedFileName();
			String savedName = new Date(). getTime() + "-"+fileName;
			String fileType = filePart.getContentType();
			
			usersDto.setUserFileName(fileName);
			usersDto.setUserSavedName(savedName);
			usersDto.setUserContentType(fileType);
			
			String filePath = "C:/Temp/download" + savedName;
			filePart.write(filePath);
		}
		
		userService.userJoin(usersDto);
		response.sendRedirect("../user/LoginController");
	}
}
