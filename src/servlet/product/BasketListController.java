package servlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.BasketService;
 
@WebServlet(name = "product.BasketListController", urlPatterns =  "/product/BasketListController" )
public class BasketListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BasketListController doGet()실행");
		BasketService basketService = (BasketService) request.getServletContext().getAttribute("basketService");
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginId");
		basketService.getBasket(userId);
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/product/basketList.jsp").forward(request, response);
	}

}
