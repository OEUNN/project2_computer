package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;

import dto.Basket;
import dto.BasketDetail;

public class BasketDao {
	String Output;
	private ServletContext application;

	public BasketDao(ServletContext application) {
		this.application = application;
	}

	public boolean Create(String userId, Connection conn) throws Exception {
		boolean result = false;
		String sql = "insert into basket (user_id)  values  ( ? ) ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		int row = pstmt.executeUpdate();
		
		if(row == 1) {
			result = true;
		}
		return result;
	}

	public Basket updateBasket(String userId, BasketDetail basketDetail, Connection conn) throws Exception {
		String sql = "update basket set total_price=total_price+? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, basketDetail.getPrice());
		if (pstmt.executeUpdate() == 1) {
			return selectBasket(userId, conn);
		}
		return null;
	}

	public Basket selectBasket(String basketId, Connection conn) throws Exception {
		BasketDetailDao basketDetailDao = (BasketDetailDao) application.getAttribute("basketDetailDao");
		List<BasketDetail> list = basketDetailDao.selectBasketDetails(basketId, conn);
		
		Basket basket = new Basket();
		basket.setBasketDetail(list);
		String sql = "select user_id, total_price from basket where user_id=?";
		 PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, basketId);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			basket.setUserId(rs.getString("user_id"));
			basket.setTotalPrice(rs.getInt("total_price"));
		}
		return basket;
	}
	

}
