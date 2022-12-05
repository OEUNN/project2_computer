package servlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.Basket;

@WebServlet(name = "product.ChoiceController", urlPatterns =  "/product/ChoiceController" )
public class ChoiceController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("choice");
		System.out.println(choice);
		switch(choice) {
			case "basket":
				request.getParameter("color");
				request.getParameter("capa");
				request.getParameter("price");	
				request.getParameter("productId");
				request.getParameter("productPrice");
				request.getParameter("quantity");
				Basket basket = new Basket();
				HttpSession session = request.getSession();
				//session.setAttribute("basket", arg1);
				
				request.getRequestDispatcher("/WEB-INF/views/product/productDetail.jsp").forward(request, response);	
				break;
				
			case "buy":
				request.getRequestDispatcher("/WEB-INF/views/product/order.jsp").forward(request, response);
				break;
		
		
		}
		
		//JSP로 이동
		
	}

}
