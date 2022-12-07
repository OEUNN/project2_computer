package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Orders;

public class OrderDao {

	public String insertOrder(Orders order, Connection conn) throws SQLException {
		String sql = "insert into orders values('Ord'||order_id.NEXTVAL,sysdate,'주문완료',?,?,?,?,?)";
		String result=null;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, order.getUserId());
		pstmt.setInt(2, order.getTotalPrice());
		pstmt.setString(3, order.getReceiverName());
		pstmt.setString(4, order.getReceiverAddress());
		pstmt.setString(5, order.getReceiverPhone());
		if (pstmt.executeUpdate() == 1) {
			result = selectOrderId(order.getUserId(), conn);
		}
			
		return result;
	}

	private String selectOrderId(String userId, Connection conn) throws SQLException {
		String sql="select rownum,order_id from (select * from orders order by rownum desc) "
						+ "where rownum=1 and user_user_id= ?";
		String result=null;
		PreparedStatement pstmt;
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					result=rs.getString("order_id");
				}
			
		return result;
	}


}
