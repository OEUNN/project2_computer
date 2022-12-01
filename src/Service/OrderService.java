package Service;

import org.json.JSONArray;
import org.json.JSONObject;

import DAO.BasketDetailDao;
import DAO.OrderDao;
import DAO.OrderDetailDao;

public class OrderService {

	public String takeOrder(JSONArray insertData, String userId, JSONObject receiveData,int totalPrice) {
		
		OrderDao orderDao=new OrderDao();
		OrderDetailDao orderDetailDao = new OrderDetailDao();
		String orderId=orderDao.insertOrder(userId, totalPrice,receiveData);
		boolean check=true;
		for(int i=0;i<insertData.length();i++) {
			JSONObject detailData =insertData.getJSONObject(i);
			check=orderDetailDao.insertOrderDetail(orderId,detailData.getInt("product_qnt"),detailData.getInt("price"),detailData.getString("productDetailId"));
			if(check==false) {
				System.out.println("insert 실패 "+i+"번째");
				return "fail";
			}
		}
		BasketDetailDao basketDetailDao = new BasketDetailDao();
		check=basketDetailDao.deleteBasketDetail(userId);
		if(check==false) {
			System.out.println("바구니 삭제 실패");
			return"fail";
		}
		return "success";
	}

}
