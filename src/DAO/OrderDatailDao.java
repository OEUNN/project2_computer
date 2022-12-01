package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionProvider;

public class OrderDatailDao {

	public Boolean insertOrderDetail(String orderId, int qnt, int price, String productDetailId) {
		Connection conn=ConnectionProvider.getConnection();
		String sql ="insert into order_detail "
				+ "(ORDER_DETAIL_ID,ORDERS_ORDER_ID,PRODUCT_QNT,PRICE,PRODUCT_DETAIL_DETAIL_ID)"
				+ "values('OrdD'||order_detail_id.nextval,?,?,?,?)";
		Boolean result=true;
				try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderId);
			pstmt.setInt(2, qnt);
			pstmt.setInt(3, price);
			pstmt.setString(4, productDetailId);
			if(pstmt.executeUpdate()!=1) {
				result=false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			result=false;
		}finally {
			ConnectionProvider.exit(conn);
		}
		return result;
		
	}

}
