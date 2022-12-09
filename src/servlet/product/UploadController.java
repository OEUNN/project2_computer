package servlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "product.UploadController", urlPatterns ="/product/UploadController")
public class UploadController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Upload service() 실행");
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/product/upload2.jsp").forward(request, response);
	}

}
