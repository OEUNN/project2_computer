package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Capacity;
import dto.Product;
import dto.ProductImage;

public class CapacityDao {
	public Capacity selectCapacity (String capacityId,Connection conn) throws Exception{
		Capacity capacity = new Capacity();
		String sql = "SELECT capacity_id,capacity_name, product_id FROM product_capacity WHERE capacity_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, capacityId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {	
			capacity.setCapacityId(capacityId);
			capacity.setCapacityName(rs.getString("capacity_name"));
			capacity.setProductId(rs.getString("product_id"));
		
		}
		
		return capacity;
	}


}
