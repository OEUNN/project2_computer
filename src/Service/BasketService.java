package Service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import DAO.BasketDao;
import DAO.BasketDetailDao;
import DAO.ProductDao;
import DTO.Basket;
import DTO.BasketDetail;
import DTO.Product;

public class BasketService {
	String Output;
	private ServletContext application;
	private DataSource ds;
	private BasketDao basketDao;
	private BasketDetailDao basketDetailDao;
	
	public BasketService(ServletContext application) {
		this.application=application;
		basketDao = (BasketDao)application.getAttribute("basketDao");
		ds=(DataSource)application.getAttribute("dataSource");
	}

	public BasketDetail addBasketProduct(String userId, String productDetailId, int quantity) {
		Connection conn = null;
		ProductDao productDao= (ProductDao)application.getAttribute("productDao");
		BasketDetail basketDetail = new BasketDetail();
		try {
			conn = ds.getConnection();
			if (productDetailId.contains("proD")) {
				Product product = productDao.selectProductSubQuery(productDetailId, conn);
				
				//해당 productId가 존재한다면 BasketDetailDao 호출함
				if (product.getProdcutId() != null) {
					basketDetail = basketDetailDao.insertBasketPro(userId, productDetailId, quantity, product.getProductPrice(),conn);
					
					if (basketDetail.getBasketDetailId() != null) {
						//basketDeatil이 존재한다면 BasketDao를 호출함
						BasketDao basketDao= (BasketDao)application.getAttribute("basketDao");
						basketDao.updateBasket(userId, basketDetail, conn);
					}
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();} catch(Exception e) {};
		}

		return basketDetail;
	}
	
	//단 하나의 basketDetail을 가져옴
	public BasketDetail getBasketDetail(String basketDetailId) {
		Connection conn = null;
		BasketDetail basketDetail = null;
		try {
			conn = ds.getConnection();
			basketDetailDao.selectBasketDetail(basketDetailId, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();} catch(Exception e) {};
		}

		return basketDetail;
	}
	
	
	//상품명, 옵션1,옵션2, 수량,가격,주문가격
	public Basket printBasket(String userId) {
		Connection conn = null;
		Basket basket = null;
		try {
			conn = ds.getConnection();
			basket = basketDao.selectBasket(userId, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();} catch(Exception e) {};
		}
		
		return basket;
	}

	public boolean CreateBasket(Basket basket) {
		Connection conn = null;
		boolean result = false;
		try {
			conn = ds.getConnection();
			result = basketDao.Create(basket, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();} catch(Exception e) {};
		}
		
		return result;
	}

	public String deleteBasketAll(Basket basket) {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			Output = (basketDetailDao.deleteBasketDetail(basket.getUserId(),conn)) ? "success" : "fail";
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();} catch(Exception e) {};
		}
		
		return Output;
	}

}
