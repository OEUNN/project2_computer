package Service;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;

import DAO.BasketDao;
import DAO.BasketDetailDao;
import DAO.OrderDao;
import DAO.OrderDetailDao;
import DAO.ProductDao;
import context.ConnectionProvider;

public class OrderService {
	private ServletContext application;
	private DataSource ds;
	private OrderDao orderDao;

	public OrderService(ServletContext application) {
		this.application=application;
		orderDao = (OrderDao)application.getAttribute("orderDao");
		ds=(DataSource)application.getAttribute("dataSource");
	}

	public String takeOrder(JSONArray insertData, String userId, JSONObject receiveData, int totalPrice) {
		Connection conn=null;
		OrderDetailDao orderDetailDao = (OrderDetailDao)application.getAttribute("orderDetailDao");
		BasketDetailDao basketDetailDao = (BasketDetailDao)application.getAttribute("basketDetailDao");
		try {
			String orderId = orderDao.insertOrder(userId, totalPrice, receiveData, conn);
			boolean check = true;
			for (int i = 0; i < insertData.length(); i++) {
				JSONObject detailData = insertData.getJSONObject(i);
				check = orderDetailDao.insertOrderDetail(orderId, detailData.getInt("product_qnt"),
						detailData.getInt("price"), detailData.getString("productDetailId"),conn);
				if (check == false) {
					System.out.println("insert 실패 " + i + "번째");
					return "fail";
				}
			}
			check = basketDetailDao.deleteBasketDetail(userId,conn);
			if (check == false) {
				System.out.println("바구니 삭제 실패");
				return "fail";
			}
		}catch(Exception e) {
			
		}finally {
			try {conn.close();} catch(Exception e) {};
		}
		return "success";
	}

}
