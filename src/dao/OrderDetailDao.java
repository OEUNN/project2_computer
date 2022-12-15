package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BasketDetail;
import dto.Capacity;
import dto.Color;
import dto.OrderDetail;
import dto.Product;

public class OrderDetailDao {
	public Boolean insertOrderDetail(OrderDetail orderDetail, Connection conn) throws SQLException {
		String sql = "insert into order_detail "
				+ "(ORDER_DETAIL_ID,ORDER_ID,PRODUCT_QNT,price,PRODUCT_ID,color_id,capacity_id)"
				+ "values(order_detail_id.nextval,?,?,?,?,?,?)";
		Boolean result = true;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, orderDetail.getOrderId());
		pstmt.setInt(2, orderDetail.getProductQnt());
		pstmt.setInt(3, orderDetail.getPrice());
		pstmt.setString(4, orderDetail.getProduct().getProductId());
		pstmt.setString(5, orderDetail.getColor().getColorId());
		pstmt.setString(6, orderDetail.getCapacity().getCapacityId());
		if (pstmt.executeUpdate() != 1) {
			result = false;
		}
		return result;

	}

	public List<OrderDetail> selectOrderDetail(String orderId, Connection conn) throws Exception {
	String sql = "select o.order_DETAIL_ID,o.order_ID,PRODUCT_QNT, o.PRICE, " + 
				"				p.product_id, p.PRODUCT_NAME,PRODUCT_price, " + 
				"				c.color_id, c.color_name, " + 
				"				ca.capacity_id, ca.capacity_name " + 
				"				from order_detail o, product p, product_color c, product_capacity ca " + 
				"				where o.color_id= c.color_id and o.capacity_id=ca.capacity_id and " + 
				"                o.product_id=p.product_id and order_id=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, orderId);
	ResultSet rs = pstmt.executeQuery();
	List<OrderDetail> orderDetailList = new ArrayList<>();


	while(rs.next()) {
		OrderDetail orderDetail = new OrderDetail();	
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
		
		orderDetail.setOrderDetailId(rs.getInt("order_DETAIL_ID"));
		orderDetail.setOrderId(rs.getInt("order_id"));
		orderDetail.setProductQnt(rs.getInt("product_qnt"));
		orderDetail.setPrice(rs.getInt("price"));
		orderDetail.setProduct(product);
		orderDetail.setColor(color);
		orderDetail.setCapacity(capacity);
		orderDetail.setProductQnt(rs.getInt("product_qnt"));
		orderDetailList.add(orderDetail);
		
	}
	
	return orderDetailList;
		
	}

}
