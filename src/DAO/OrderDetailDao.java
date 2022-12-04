package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DTO.OrderDetail;
import util.ConnectionProvider;

public class OrderDetailDao {

	public Boolean insertOrderDetail(String orderId, OrderDetail orderDetail, Connection conn) throws SQLException {
		String sql ="insert into order_detail "
				+ "(ORDER_DETAIL_ID,ORDERS_ORDER_ID,PRODUCT_QNT,PRICE,PRODUCT_DETAIL_DETAIL_ID)"
				+ "values('OrdD'||order_detail_id.nextval,?,?,?,?)";
		Boolean result=true;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderId);
			pstmt.setInt(2, orderDetail.getProductQnt());
			pstmt.setInt(3, orderDetail.getPrice());
			pstmt.setString(4, orderDetail.getOrderDetailId());
			if(pstmt.executeUpdate()!=1) {
				result=false;
			}
		return result;
		
	}

}
