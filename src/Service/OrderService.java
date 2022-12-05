package Service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import DAO.OrderDao;
import DAO.OrderDetailDao;
import DTO.OrderDetail;
import DTO.Orders;

public class OrderService {
	private ServletContext application;
	private DataSource ds;
	private OrderDao orderDao;

	public OrderService(ServletContext application) {
		this.application = application;
		orderDao = (OrderDao) application.getAttribute("orderDao");
		ds = (DataSource) application.getAttribute("dataSource");
	}

	// 주문하기
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
		} finally {
			try {conn.close();} catch(Exception e) {};
			}
		
		return result;
	}
}
