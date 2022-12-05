package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public BasketService(ServletContext application) {
		this.application=application;
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/java");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BasketDetail addBasketProduct(String userId, String productDetailId, int quantity) {
		Connection conn = null;

		ProductDao productDao= (ProductDao)application.getAttribute("productDao");
		BasketDetailDao basketDetailDao= (BasketDetailDao)application.getAttribute("basketDetailDao");	
		BasketDetail basketDetail = new BasketDetail();
		try {
			conn = ds.getConnection();
			if (productDetailId.contains("proD")) {
				Product product = productDao.selectProductSubQuery(productDetailId);
				
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
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
			BasketDetailDao basketDetailDao = (BasketDetailDao) application.getAttribute("basketDetailDao");
			basketDetailDao.selectBasketDetail(basketDetailId, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return basketDetail;
	}
	
	
	//상품명, 옵션1,옵션2, 수량,가격,주문가격
	public Basket printBasket(String userId) {
		Connection conn = null;
		Basket basket = null;
		try {
			conn = ds.getConnection();
			BasketDao basketDao = (BasketDao)application.getAttribute("basketDao");
			basket = basketDao.selectBasket(userId, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {conn.close();} catch(Exception e) {};
		}
		

		return basket;
	}

	public boolean CreateBasket(Basket basket) {
		Connection conn = null;
		boolean result = false;
		try {
			conn = ds.getConnection();
			BasketDao basketDao = (BasketDao)application.getAttribute("basketDao");
			result = basketDao.Create(basket, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {conn.close();} catch(Exception e) {};
		}
		
		return result;
	}

	public String deleteBasketAll(Basket basket) {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			BasketDetailDao basketDetailDao = (BasketDetailDao)application.getAttribute("basketDetailDao");
			Output = (basketDetailDao.deleteBasketDetail(basket.getUserId(),conn)) ? "success" : "fail";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {conn.close();} catch(Exception e) {};
		}
		
		return Output;
	}

}
