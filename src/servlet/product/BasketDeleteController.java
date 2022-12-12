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
 
@WebServlet(name = "product.BasketDeleteController", urlPatterns =  "/product/BasketDeleteController" )
public class BasketDeleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
		BasketService basketService = (BasketService) request.getServletContext().getAttribute("basketService");
		String[] IdArray = request.getParameterValues("checkedId");
		for(int i=0; i<IdArray.length;i++) {
			basketService.deleteBasketDetail(IdArray[i]);
			
		}
		
	
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginId");
		Basket basket = basketService.getBasket(userId);
		int totalPrice = 0;
		List<BasketDetail> list = basketService.getBasketDetailList(userId);
		for(BasketDetail basketDetail : list ) {
			totalPrice += basketDetail.getPrice();
		}
	
		basket.setTotalPrice(totalPrice);
		basketService.updateBasket(basket);
	
		int count = basketService.countBasketDetail(basket);
		List<BasketDetail> detailList = basket.getBasketDetail();
		List<BasketDetail> myList = new ArrayList<>();
		for(BasketDetail basketDetail : detailList) {
			Product product = productService.getProduct(basketDetail.getProduct().getProductId());
			basketDetail.setProduct(product);
			myList.add(basketDetail);
		}	
		basket.setBasketDetail(myList);
		
		request.setAttribute("basket", basket);
		request.setAttribute("count", count);
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/product/basketUpdate.jsp").forward(request, response);
		
		
	
		
		
	}

}
