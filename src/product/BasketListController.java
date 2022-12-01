package product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "product.BasketListController", urlPatterns =  "/product/BasketListController" )
public class BasketListController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BasketListController service()실행");
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/product/basketList.jsp").forward(request, response);
	}

}
