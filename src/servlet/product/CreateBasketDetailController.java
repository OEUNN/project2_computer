package servlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.BasketService;
import Service.CapacityService;
import Service.ColorService;
import Service.ProductService;
import dto.BasketDetail;
import dto.Product;
 
@WebServlet(name = "product.CreateBasketDetailController", urlPatterns =  "/product/CreateBasketDetailController" )
public class CreateBasketDetailController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
		ColorService colorService = (ColorService) request.getServletContext().getAttribute("colorService");
		CapacityService capacityService = (CapacityService) request.getServletContext().getAttribute("capacityService");
		BasketService basketService = (BasketService) request.getServletContext().getAttribute("basketService");
		//jsp에서 넘어온 값들을 Parmeter으로 얻어내어 basketDetail객체에 set함 
		String colorId = request.getParameter("colorId");
		String capacityId = request.getParameter("capaId");
		String price = request.getParameter("price");		
		String productId = request.getParameter("productId");
		String quantity = request.getParameter("quantity");
		
		BasketDetail basketDetail = new BasketDetail();
		int productPrice = Integer.parseInt(price);
		int productQuantity = Integer.parseInt(quantity);
		Product product = productService.getProduct(productId);
		 
		HttpSession session = request.getSession();
		String basketId = (String) session.getAttribute("loginId");
		System.out.println(basketId);
		basketDetail.setBasketId(basketId);
		basketDetail.setProduct(product);
		basketDetail.setProductQnt(Integer.parseInt(quantity));
		basketDetail.setColor(colorService.getColor(colorId));
		basketDetail.setCapacity(capacityService.getCapacity(capacityId));
		basketDetail.setPrice(productPrice*productQuantity);
	
		
		basketService.addBasketDetail(basketDetail);
		request.setAttribute("product", product);

		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/product/productDetail.jsp").forward(request, response);
		
	}

}
