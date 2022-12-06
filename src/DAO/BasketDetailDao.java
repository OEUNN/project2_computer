package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.BasketDetail;

public class BasketDetailDao {

	public boolean insertBasketPro(BasketDetail basketDetail,Connection conn) throws Exception {
		boolean result = false;
		String sql = "insert into basket_detail"
				+ "(basket_detail_id,PRODUCT_DETAIL_DETAIL_ID ,basket_id, price,PRODUCT_QNT ) "
				+ "values('basD'||basket_detail_id.nextval,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, basketDetail.getProductId());
		pstmt.setString(2, basketDetail.getUserId());
		pstmt.setInt(3, basketDetail.getPrice());
		pstmt.setInt(4, basketDetail.getProductQnt());
		
		if (pstmt.executeUpdate() == 1) {
			result = true;
		}
				
		return result;
	}

	public List<BasketDetail> selectBasketDetails(String userId, Connection conn)  throws Exception{
		BasketDetail basketDetail = new BasketDetail();
		List<BasketDetail> list = new ArrayList<>();
		String sql = "select p.product_name, d.detail_color, d.detail_capacity, b.price, b.product_qnt, "
				+ "(b.price*b.product_qnt )as sum, b.basket_detail_id ,d.detail_id "
				+ "from product p, product_detail d, basket_detail b " + "where p.product_id=d.product_product_id "
				+ "and b.product_detail_detail_id=d.detail_id " + "and b.basket_users_user_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			basketDetail.setBasketDetailId(rs.getString("product_name"));
			basketDetail.setPrice(rs.getInt("price"));
			basketDetail.setProductId(rs.getString("product_id"));
			basketDetail.setProductQnt(rs.getInt("product_qnt"));
			list.add(basketDetail);

		}
		return list;
	}

	public boolean deleteBasketDetail(String userId, Connection conn) throws Exception {
		boolean result = false;

		String sql = "delete from basket_detail where basket_users_user_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		if (pstmt.executeUpdate() != 0) {
			result = true;
		}

		return result;

	}
	
	public BasketDetail selectBasketDetail(String basketDetailId, Connection conn) throws Exception {
		String sql = "select basket_detail_id, basket_id, price, product_qnt, product_id from basket_detail where basket_detail_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, basketDetailId);
		ResultSet rs = pstmt.executeQuery();
		BasketDetail basketDetail = new BasketDetail();

		if (rs.next()) {
			basketDetail.setBasketDetailId(basketDetailId);
			basketDetail.setPrice(rs.getInt("price"));
			basketDetail.setProductId(rs.getString("product_id"));
			basketDetail.setProductQnt(rs.getInt("product_qnt"));
		}
		
		return basketDetail;
	}
	
}
