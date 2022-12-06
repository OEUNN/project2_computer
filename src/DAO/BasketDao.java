package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletContext;

import DTO.Basket;
import DTO.BasketDetail;
import Service.BasketService;

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

	public boolean updateBasket(Basket basket, Connection conn) throws Exception {
		boolean result = false;
		String sql = "update basket set total_price=? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, basket.getTotalPrice());
		if (pstmt.executeUpdate() == 1) {
			result = true;
		}
		return result;
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
