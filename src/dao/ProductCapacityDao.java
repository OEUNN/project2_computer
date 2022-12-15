package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Capacity;
import dto.Color;
import dto.Product;

public class ProductCapacityDao {
	public List<Capacity> selectCapacity(Product product, Connection conn) throws Exception {
		List<Capacity> list = new ArrayList<>();

		String sql = "SELECT CAPACITY_ID, CAPACITY_NAME FROM PRODUCT_CAPACITY WHERE PRODUCT_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, String.valueOf(product.getProductId()));
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Capacity capacityDto = new Capacity();
			capacityDto.setProductId(product.getProductId());
			capacityDto.setCapacityId(rs.getString("CAPACITY_ID"));
			capacityDto.setCapacityName(rs.getString("CAPACITY_NAME"));
			list.add(capacityDto);
		}
		
		return list;
	}

	public void insertCapacity(Capacity capacity, Connection conn)throws Exception {
		String sql = "insert into product_capacity(capacity_id,capacity_name,product_id)" +
				 "values('capa'||capacity_id.nextval,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 입력됨.
		pstmt.setString(1, capacity.getCapacityName());
		pstmt.setString(2, capacity.getProductId());
		
		pstmt.executeUpdate();
		pstmt.close();
	}
	
}
