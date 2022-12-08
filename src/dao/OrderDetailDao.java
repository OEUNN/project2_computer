package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.OrderDetail;

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

}
