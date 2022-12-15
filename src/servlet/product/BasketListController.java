package servlet.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.BasketService;
import Service.ProductService;
import dto.Basket;
import dto.BasketDetail;
import dto.Product;
 
@WebServlet(name = "product.BasketListController", urlPatterns = "/product/BasketListController" )
public class BasketListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("BasketListController doGet()실행");
		BasketService basketService = (BasketService) request.getServletContext().getAttribute("basketService");
		ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginId");
		Basket basket = basketService.getBasket(userId);
		int count = basketService.countBasketDetail(basket);
		List<BasketDetail> list = basket.getBasketDetail();
		List<BasketDetail> myList = new ArrayList<>();
		for(BasketDetail basketDetail : list) {
			Product product = productService.getProduct(basketDetail.getProduct().getProductId());
			basketDetail.setProduct(product);
			myList.add(basketDetail);
		}	
		basket.setBasketDetail(myList);
		//productService.getProduct(productId)
		request.setAttribute("basket", basket);		
		request.setAttribute("count", count);
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/product/basketList.jsp").forward(request, response);
	}

}
