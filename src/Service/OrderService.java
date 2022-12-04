package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import DAO.OrderDao;
import DAO.OrderDetailDao;
import DTO.BasketDetail;
import DTO.OrderDetail;
import DTO.Orders;

public class OrderService {
	private ServletContext application;
	private DataSource ds;
	
	public OrderService(ServletContext application) {
		this.application=application;
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/java");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//주문하기
	public boolean takeOrder(OrderDetail orderDeatil, String userId, Orders order,int totalPrice) {
		Connection conn = null;
		boolean result = false;
		try {
			conn = ds.getConnection();
			OrderDao orderDao= (OrderDao) application.getAttribute("orderDao");
			OrderDetailDao orderDetailDao = (OrderDetailDao) application.getAttribute("orderDetailDao");
			String orderId=orderDao.insertOrder(order, conn); 
			result = orderDetailDao.insertOrderDetail(orderId, orderDeatil, conn);
			if(result) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {conn.close();} catch(Exception e) {};
		}
		
		return result;
		
	}
	
	//장바구니에서 주문하기
		public boolean basketDetailToOrderDeatail(String orderId, List<String> basketDetailIdList) {
			boolean result = false;
			Connection conn = null;
			BasketService basketService = (BasketService) application.getAttribute("basketService");
			try {
				conn = ds.getConnection();
				int totalPrice = 0;
				int quantity = 0;
				
				for(String basketDetailId : basketDetailIdList ) {
					BasketDetail basketDetail = basketService.
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {conn.close();} catch(Exception e) {};
			}
			return result;
		}
		
		//바로 주문하기
		
		public boolean addOrderDetail() {
			
		}

}
