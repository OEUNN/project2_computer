package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;

import org.json.JSONArray;
import org.json.JSONObject;

import DTO.Basket;
import DTO.BasketDetail;
import util.ConnectionProvider;

public class BasketDao {
	String Output;
	
	private ServletContext application;
	
	public BasketDao(ServletContext application) {
		this.application=application;
	}


	public boolean Create (Basket basket, Connection conn) {	
		boolean result=false;
		try {
			String sql = "insert into basket (user_id)  values  ( ? ) ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, basket.getUserId());
			pstmt.executeUpdate();
			result=true;
		} catch (SQLException e) {
			result=false;
		} 
		
		return result;
	}
	
	
	public Basket updateBasket(String userId, BasketDetail bd) {
		PreparedStatement pstmt;
		Connection conn = ConnectionProvider.getConnection();
		String sql="update basket set total_price=total_price+? ";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bd.getPrice());
			if(pstmt.executeUpdate()==1) {
				return selectBasket(userId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionProvider.exit(conn);
		}
		return null;
	}

	public Basket selectBasket(String basketId) {
		BasketDetailDao basketDetailDao = (BasketDetailDao)application.getAttribute("basketDetailDao");
		List<BasketDetail> list = basketDetailDao.selectBasketDetails(basketId,null);
		Basket basket = new Basket();
		basket.setBasketDetail(list);
		PreparedStatement pstmt;
		Connection conn = ConnectionProvider.getConnection();
		String sql="select user_id, total_price from basket where user_id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, basketId);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				basket.setUserId(rs.getString("user_id"));
				basket.setTotalPrice(rs.getInt("total_price"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionProvider.exit(conn);
		}
		return basket;
	}


}
