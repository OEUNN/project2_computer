package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Service.UserService;

@WebServlet(name = "user.CheckController", urlPatterns ="/user/CheckController")
public class CheckController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String check = request.getParameter("check");
		String value= request.getParameter("value");
		
		ServletContext application = request.getServletContext();
		UserService userService = (UserService) application.getAttribute("userService");
		boolean result = userService.check(check, value);
		System.out.println(result);
		response.setContentType("application/json; charset=UTF-8"); 
		PrintWriter pw = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", result);
		pw.println(jsonObject.toString());
		pw.flush();
		pw.close();
		
		
	}
	

}
