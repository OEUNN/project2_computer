package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.OrderDao;
import dao.OrderDetailDao;
import dto.OrderDetail;
import dto.Orders;
import dto.Product;
 
public class OrderService {
	private ServletContext application;
	private DataSource ds;
	private OrderDao orderDao;
	private OrderDetailDao orderDetailDao;

	public OrderService(ServletContext application) {
		this.application = application;
		this.orderDao = (OrderDao) application.getAttribute("orderDao");
		this.orderDetailDao = (OrderDetailDao) application.getAttribute("orderDetailDao");
		
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

	public List<Orders> getOrder(String userId) {
		List<Orders> list = new ArrayList<>();
		List<OrderDetail> detailList = new ArrayList<>();
		List<Orders> orders = new ArrayList<>();
		List<OrderDetail> details = new ArrayList<>();
		ProductService productService = (ProductService) application.getAttribute("productService");
		Connection conn = null;
		try {
			conn = ds.getConnection();
			//OrderDetailDao orderDetailDao = (OrderDetailDao) application.getAttribute("orderDetailDao");
			list = orderDao.selectOrder(userId, conn);
			
			for(Orders order : list) {
				String orderId = order.getOrderId();
				detailList = orderDetailDao.selectOrderDetail(orderId, conn);
				for(OrderDetail orderDetail : detailList) {	
					Product product = productService.getProduct(orderDetail.getProduct().getProductId());
					orderDetail.setProduct(product);
					details.add(orderDetail);
				}
				order.setOrderDetail(detailList);
				orders.add(order);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {conn.close();} catch(Exception e) {};
			}
		
		return orders;
	}
}

