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
		basketDetailDao = (BasketDetailDao)application.getAttribute("basketDetailDao");
		ds=(DataSource)application.getAttribute("dataSource");
	}
	
	//BasketDetail 넣고 성공하면 basket을 업데이트
	public boolean addBasketDetail(BasketDetail basketDetail) {
		Connection conn = null;
		boolean result = false;
		String basketId = basketDetail.getBasketId();
		BasketDao basketDao= (BasketDao)application.getAttribute("basketDao");
		
		try {
			conn = ds.getConnection();
				//이미 존재하는 상품, 컬러, 용량이라면		
					//insert하지 않고 basketDetail update 필요			
					boolean checkBasketDetail = basketDetailDao.checkBasketDetail(basketDetail, conn);
					if(checkBasketDetail) {		
						
						BasketDetail myBasketDetail = new BasketDetail();
						myBasketDetail.setBasketId(basketDetail.getBasketId());
						myBasketDetail.setCapacity(basketDetail.getCapacity());
						myBasketDetail.setColor(basketDetail.getColor());
						myBasketDetail.setProduct(basketDetail.getProduct());
						
						myBasketDetail = basketDetailDao.selectBasketDetail(myBasketDetail, conn);
						
					
						int price = myBasketDetail.getPrice() + basketDetail.getPrice();
						int quantity = myBasketDetail.getProductQnt() + basketDetail.getProductQnt();
					
				
						myBasketDetail.setPrice(price);
						myBasketDetail.setProductQnt(quantity);
						basketDetailDao.updateBasketDetail(myBasketDetail, conn);		
						
						Basket basket = basketDao.selectBasket(basketId, conn);
						int totalPrice = basket.getTotalPrice()+basketDetail.getPrice();
						basket.setTotalPrice(totalPrice);
						result = basketDao.updateBasket(basket, conn);
						
					} else {
						basketDetailDao.insertBasketPro(basketDetail,conn);
						
						Basket basket = basketDao.selectBasket(basketId, conn);
						int totalPrice = basket.getTotalPrice()+basketDetail.getPrice();
						basket.setTotalPrice(totalPrice);
						result = basketDao.updateBasket(basket, conn);
					}
					//basketDeatil이 존재한다면 BasketDao를 호출함
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();} catch(Exception e) {};
		}

		return result;
	}
	
	//단 하나의 basketDetail을 가져옴
	
	
	
	//상품명, 옵션1,옵션2, 수량,가격,주문가격
	public Basket getBasket(String userId) {
		Connection conn = null;
		Basket basket = null;
		try {
			conn = ds.getConnection();
			basket = basketDao.selectBasket(userId, conn);
			List<BasketDetail> list = basketDetailDao.selectBasketDetails(userId, conn);
			basket.setBasketDetail(list);
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();} catch(Exception e) {};
		}
		
		return basket;
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

	public int countBasketDetail(Basket basket) {
		int count = 0;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			count = basketDetailDao.countBasketDetail(basket, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();} catch(Exception e) {};
		}
		
		return count;
		
	}

	public void deleteBasketDetail(String basketDetailId) {

		Connection conn = null;
		try {
			conn = ds.getConnection();
			basketDetailDao.deleteBasketDetail(basketDetailId, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();} catch(Exception e) {};
		}
		
	
		
	}

	public void updateBasket(Basket basket) {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			basketDao.updateBasket(basket, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();} catch(Exception e) {};
		}
		
	}


	public BasketDetail getBasketDetail(String basketDetailId) {
		Connection conn = null;
		BasketDetail basketDetail = new BasketDetail();
		try {
			conn = ds.getConnection();
			basketDetail = basketDetailDao.selectBasketDetailOne(basketDetailId, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();} catch(Exception e) {};
		}
		
		return basketDetail;
	}

	public String isOrdered(String colorId, String capacityId) {
		String basketDetailId = "";
		Connection conn = null;
		try {
			conn = ds.getConnection();
			basketDetailId = basketDetailDao.selectBasketDetailId(colorId,capacityId, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();} catch(Exception e) {};
		}
		
		return basketDetailId;
		
	}

	

}
