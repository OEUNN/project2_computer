package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Orders;

public class OrderDao {
	public int insertOrder(Orders order, Connection conn) throws SQLException {
		String sql = "insert into orders values(order_id.NEXTVAL,sysdate,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"order_id"});
		int orderId = 0;
		pstmt.setString(1, order.getUserId());
		pstmt.setInt(2, order.getTotalPrice());
		pstmt.setString(3, order.getReceiverName());
		pstmt.setString(4, order.getReceiverAddr());
		pstmt.setString(5, order.getReceiverPhone());
		pstmt.setInt(6, order.getPost());
		pstmt.setString(7, order.getReceiverDetailAdrr());
		 int rows = pstmt.executeUpdate();
		  if(rows ==  1) {
	          ResultSet rs= pstmt.getGeneratedKeys(); // 삽입된 orders_id 값 가져오기 
	          if(rs.next()) {
	        	  orderId = rs.getInt(1);
	          }
	        }            
	      return orderId;   
	   }

	public String selectOrderId(String userId, Connection conn) throws SQLException {
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

	public List<Orders> selectOrder(String userId, Connection conn) throws Exception {
		String sql = "select order_id, order_date, receiver_name, total_price from orders where user_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,userId);
		ResultSet rs = pstmt.executeQuery();
		List<Orders> list = new ArrayList<>();
		while (rs.next()) {
			Orders order = new Orders();
			order.setOrderId(rs.getString("order_id"));
			order.setOrderDate(rs.getDate("order_date"));
			order.setReceiverName(rs.getString("receiver_name"));
			order.setUserId(userId);
			
			list.add(order);
		}
			
		return list;
	}


}
