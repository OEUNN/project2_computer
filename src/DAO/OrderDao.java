package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;

import util.ConnectionProvider;

public class OrderDao {

	public String insertOrder(String userId, int totalPrice, JSONObject receiveData) {
		Connection conn=ConnectionProvider.getConnection();
		String sql = "insert into orders values('Ord'||order_id.NEXTVAL,sysdate,'주문완료',?,?,?,?,?)";
		String result=null;
				try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId );
			pstmt.setInt(2, totalPrice);
			pstmt.setString(3, receiveData.getString("receiver"));
			pstmt.setString(4, receiveData.getString("receiverAddress"));
			pstmt.setString(5, receiveData.getString("receiverPhone"));
			if(pstmt.executeUpdate()==1) {
				result=selectOrderId(userId,conn);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionProvider.exit(conn);
		}
		return result;
	}

	private String selectOrderId(String userId, Connection conn) {
		String sql="select rownum,order_id from (select * from orders order by rownum desc) "
						+ "where rownum=1 and user_user_id= ?";
		String result=null;
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					result=rs.getString("order_id");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return result;
	}



}
