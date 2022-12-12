package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletContext;

import Service.BasketService;
import dto.Basket;
import dto.BasketDetail;
public class BasketDao {
	String Output;
	private ServletContext application;

	public BasketDao(ServletContext application) {
		this.application = application;
	}

	public void Create(String userId, Connection conn) throws Exception {
		String sql = "insert into basket (basket_id, totla_price)  values  ( ?,0 ) ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.executeUpdate();
		pstmt.close();
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
		String sql = "select basket_id, total_price from basket where basket_id=?";
		 PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, basketId);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			basket.setUserId(rs.getString("basket_id"));
			basket.setTotalPrice(rs.getInt("total_price"));
		}
		return basket;
	}
	

}
