package Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.BasketDao;
import dao.BasketDetailDao;
import dto.Basket;
import dto.BasketDetail;

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
	
	//BasketDetail 넣고 성공하면 basket을 업데이트
	public boolean addBasketDetail(BasketDetail basketDetail) {
		Connection conn = null;
		boolean result = false;
		try {
			conn = ds.getConnection();
				//해당 productId가 존재한다면 BasketDetailDao 호출함
				if (basketDetail.getProductId() != null) {
					boolean basketDetailResult = basketDetailDao.insertBasketPro(basketDetail,conn);
					if (basketDetailResult) {
						//basketDeatil이 존재한다면 BasketDao를 호출함
						String basketId = basketDetail.getUserId();
						BasketDao basketDao= (BasketDao)application.getAttribute("basketDao");
						Basket basket = basketDao.selectBasket(basketId, conn);
						int totalPrice = basket.getTotalPrice()+basketDetail.getPrice();
						basket.setTotalPrice(totalPrice);
						result = basketDao.updateBasket(basket, conn);					
					}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();} catch(Exception e) {};
		}

		return result;
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
	public Basket getBasket(String userId) {
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

	public boolean CreateBasket(String userId) {
		Connection conn = null;
		boolean result = false;
		try {
			conn = ds.getConnection();
			result = basketDao.Create(userId, conn);
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
	
	public List<BasketDetail> getBasketDetailList(String userId){
		Connection conn = null;
		List<BasketDetail> list = new ArrayList<>();
		try {
			conn = ds.getConnection();
			list = basketDetailDao.selectBasketDetails(userId, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();} catch(Exception e) {};
		}
		
		return list;
	}
	

}
