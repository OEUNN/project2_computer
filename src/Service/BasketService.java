package Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import DAO.BasketDao;
import DAO.BasketDetailDao;
import DAO.ProductDao;
import DTO.Basket;
import DTO.BasketDetail;
import DTO.Product;

public class BasketService {
	
	String Output;
	private ServletContext application;
	
	public BasketService(ServletContext application) {
		this.application=application;
	}

	public BasketDetail addBasketProduct(String userId, String productDetailId, int quantity) {
		ProductDao productDao= (ProductDao)application.getAttribute("productDao");
		BasketDetailDao basketDetailDao= (BasketDetailDao)application.getAttribute("basketDetailDao");	
		BasketDetail basketDetail = new BasketDetail();
		
		if (productDetailId.contains("proD")) {
			Product product = productDao.selectProductSubQuery(productDetailId);
			//해당 productId가 존재한다면 BasketDetailDao 호출함
			if (product.getProdcutId() != null) {
				basketDetail = basketDetailDao.insertBasketPro(userId, productDetailId, quantity, product.getProductPrice(),null);
				if (basketDetail.getBasketDetailId() != null) {
					//basketDeatil이 존재한다면 BasketDao를 호출함
					BasketDao basketDao= (BasketDao)application.getAttribute("basketDao");
					basketDao.updateBasket(userId, basketDetail);
				}
			}

		} 

		return basketDetail;
	}

	//상품명, 옵션1,옵션2, 수량,가격,주문가격
	public Basket printBasket(String userId) {
		
		BasketDao basketDao = (BasketDao)application.getAttribute("basketDao");
		Basket basket = basketDao.selectBasket(userId);

		return basket;
	}

	public String Create_Basket(Basket basket) {
		Db = new BasketDao();
		Output = Db.Create(basket);
		return Output;
	}

	public String deleteBasketAll(Basket basket) {
		BasketDao bdd = new BasketDao();
		Output = (bdd.deleteBasket(basket.getUserId())) ? "success" : "fail";
		return Output;
	}

}
