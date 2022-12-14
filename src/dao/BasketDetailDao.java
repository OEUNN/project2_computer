package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Basket;
import dto.BasketDetail;
import dto.Capacity;
import dto.Color;
import dto.Product;

public class BasketDetailDao {
	public boolean insertBasketPro(BasketDetail basketDetail,Connection conn) throws Exception {
		boolean result = false;
		String sql = "insert into basket_detail (basket_detail_id,basket_id,price,product_qnt,product_id,color_id,capacity_id)"
				+ "values('basD'||basket_detail_id.nextval,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, basketDetail.getBasketId());
		pstmt.setInt(2, basketDetail.getPrice());
		pstmt.setInt(3, basketDetail.getProductQnt());
		pstmt.setString(4, basketDetail.getProduct().getProductId());
		pstmt.setString(5, basketDetail.getColor().getColorId());
		pstmt.setString(6, basketDetail.getCapacity().getCapacityId());

		if (pstmt.executeUpdate() == 1) {
			result = true;
		}
				
		return result;
	}

	

	public void deleteBasketDetail(String basketDetailId, Connection conn) throws Exception {
		String sql = "delete from basket_detail where basket_detail_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, basketDetailId);
		if (pstmt.executeUpdate() != 0) {
		}


	}
	
	public List<BasketDetail> selectBasketDetails(String basketId, Connection conn) throws Exception {
		String sql = "select b.BASKET_DETAIL_ID,b.BASKET_ID,PRODUCT_QNT, b.PRICE, " + 
				"				p.product_id, p.PRODUCT_NAME,PRODUCT_price, " + 
				"				c.color_id, c.color_name, " + 
				"				ca.capacity_id, ca.capacity_name " + 
				"				from basket_detail b, product p, product_color c, product_capacity ca " + 
				"				where b.color_id= c.color_id and b.capacity_id=ca.capacity_id and " + 
				"                b.product_id=p.product_id and basket_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, basketId);
		ResultSet rs = pstmt.executeQuery();
		List<BasketDetail> basketDetailList = new ArrayList<>();
	

		while(rs.next()) {
			BasketDetail basketDetail = new BasketDetail();	
			Product product = new Product();
			Color color = new Color();
			Capacity capacity = new Capacity();
			
			product.setProductId(rs.getString("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setProductPrice(rs.getInt("product_price"));
			
			color.setColorId(rs.getString("color_id"));
			color.setColorName(rs.getString("color_name"));
			
			capacity.setCapacityId(rs.getString("capacity_id"));
			capacity.setCapacityName(rs.getString("capacity_name"));
			
			basketDetail.setBasketDetailId(rs.getString("basket_detail_id"));
			basketDetail.setBasketId(rs.getString("basket_id"));
			basketDetail.setProductQnt(rs.getInt("product_qnt"));
			basketDetail.setPrice(rs.getInt("price"));
			basketDetail.setProduct(product);
			basketDetail.setColor(color);
			basketDetail.setCapacity(capacity);
			basketDetail.setProductQnt(rs.getInt("product_qnt"));
			basketDetailList.add(basketDetail);
			
		}
		
		return basketDetailList;
	}



	public BasketDetail selectBasketDetail(BasketDetail basketDetail, Connection conn) throws Exception {	
		String sql = "select basket_detail_id, price, product_qnt from basket_detail where color_id=? and capacity_id=? and product_id=? and basket_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, basketDetail.getColor().getColorId());
		pstmt.setString(2, basketDetail.getCapacity().getCapacityId());
		pstmt.setString(3, basketDetail.getProduct().getProductId());
		pstmt.setString(4,  basketDetail.getBasketId());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			basketDetail.setBasketDetailId(rs.getString("basket_detail_id"));
			basketDetail.setPrice(rs.getInt("price"));
			basketDetail.setProductQnt(rs.getInt("product_qnt"));
		}
		
		return basketDetail;
	}



	public void updateBasketDetail(BasketDetail basketDetail, Connection conn) throws Exception {
		String sql = "update basket_detail set product_qnt=?, price=? where basket_detail_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, basketDetail.getProductQnt());
		pstmt.setInt(2, basketDetail.getPrice());
		pstmt.setString(3, basketDetail.getBasketDetailId());
		pstmt.executeUpdate();
		
	}



	public boolean checkBasketDetail(BasketDetail basketDetail, Connection conn) throws Exception {
		String sql = "select basket_detail_id from basket_detail where color_id=? and capacity_id=? and product_id=? and basket_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, basketDetail.getColor().getColorId());
		pstmt.setString(2, basketDetail.getCapacity().getCapacityId());
		pstmt.setString(3, basketDetail.getProduct().getProductId());
		pstmt.setString(4,  basketDetail.getBasketId());
		ResultSet rs = pstmt.executeQuery();
		boolean result = false;
		if(rs.next()) {		
			result = true;
		}
		return result;
	}



	public int countBasketDetail(Basket basket, Connection conn) throws Exception{
		String sql = "select count(*) from basket_detail where basket_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, basket.getUserId());
		ResultSet rs = pstmt.executeQuery();
		int result = 0;
		if(rs.next()) {
			result = rs.getInt(1);
		}
		return result;
	}



	public BasketDetail selectBasketDetailOne(String basketDetailId, Connection conn) throws Exception {
		BasketDetail basketDetail = new BasketDetail();
		String sql = "select b.BASKET_DETAIL_ID,b.BASKET_ID,PRODUCT_QNT, b.PRICE, " + 
				"				p.product_id, p.PRODUCT_NAME,PRODUCT_price, " + 
				"				c.color_id, c.color_name, " + 
				"				ca.capacity_id, ca.capacity_name " + 
				"				from basket_detail b, product p, product_color c, product_capacity ca " + 
				"				where b.color_id= c.color_id and b.capacity_id=ca.capacity_id and " + 
				"                b.product_id=p.product_id and basket_detail_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, basketDetailId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			basketDetail = new BasketDetail();	
			Product product = new Product();
			Color color = new Color();
			Capacity capacity = new Capacity();
			
			product.setProductId(rs.getString("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setProductPrice(rs.getInt("product_price"));
			
			color.setColorId(rs.getString("color_id"));
			color.setColorName(rs.getString("color_name"));
			
			capacity.setCapacityId(rs.getString("capacity_id"));
			capacity.setCapacityName(rs.getString("capacity_name"));
			
			basketDetail.setBasketDetailId(rs.getString("basket_detail_id"));
			basketDetail.setBasketId(rs.getString("basket_id"));
			basketDetail.setProductQnt(rs.getInt("product_qnt"));
			basketDetail.setPrice(rs.getInt("price"));
			basketDetail.setProduct(product);
			basketDetail.setColor(color);
			basketDetail.setCapacity(capacity);
			basketDetail.setProductQnt(rs.getInt("product_qnt"));
		}
		
		return basketDetail;
	}



	public String selectBasketDetailId(String colorId,String capacityId, Connection conn) throws Exception{
		String basketDetailId = "";
		String sql = "select basket_detail_id from basket_detail where color_id=? and capacity_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, colorId);
		pstmt.setString(2, capacityId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			basketDetailId = rs.getString("basket_detail_id");
		}
		return basketDetailId;
		
	}
	
}
