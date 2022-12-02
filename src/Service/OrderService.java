package Service;

import java.sql.Connection;

import javax.servlet.ServletContext;

import org.json.JSONArray;
import org.json.JSONObject;

import DAO.BasketDetailDao;
import DAO.OrderDao;
import DAO.OrderDetailDao;
import util.ConnectionProvider;

public class OrderService {
	private ServletContext application;

	public OrderService(ServletContext application) {
		this.application=application;
	}

	public String takeOrder(JSONArray insertData, String userId, JSONObject receiveData, int totalPrice) {
		OrderDao orderDao = (OrderDao)application.getAttribute("orderDao");
		OrderDetailDao orderDetailDao = (OrderDetailDao)application.getAttribute("orderDetailDao");
		Connection conn=ConnectionProvider.getConnection();
		
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
		BasketDetailDao basketDetailDao = (BasketDetailDao)application.getAttribute("basketDetailDao");
		check = basketDetailDao.deleteBasketDetail(userId,conn);
		if (check == false) {
			System.out.println("바구니 삭제 실패");
			return "fail";
		}
		return "success";
	}

}
