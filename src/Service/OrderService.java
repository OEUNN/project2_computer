package Service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.OrderDao;
import dao.OrderDetailDao;
import dto.OrderDetail;
import dto.Orders;
 
public class OrderService {
	private ServletContext application;
	private DataSource ds;
	private OrderDao orderDao;

	public OrderService(ServletContext application) {
		this.application = application;
		this.orderDao = (OrderDao) application.getAttribute("orderDao");
		ds = (DataSource) application.getAttribute("dataSource");
	}

	// 주문하기
	public int takeOrder(Orders order) {
		Connection conn = null;
		int orderId = 0;
		try {
			conn = ds.getConnection();
			orderId = orderDao.insertOrder(order, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {conn.close();} catch(Exception e) {};
			}
		
		return orderId;
	}
	
	public boolean insertOrderDetail(OrderDetail orderDetail) {
		Connection conn = null;
		boolean result = false;
		try {
			conn = ds.getConnection();
			OrderDetailDao orderDetailDao = (OrderDetailDao) application.getAttribute("orderDetailDao");
			result = orderDetailDao.insertOrderDetail(orderDetail, conn);
			if(result) {
			result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {conn.close();} catch(Exception e) {};
			}
		
		return result;
		
	}
}

