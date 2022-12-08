package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Capacity;
import dto.Color;
import dto.Product;
import dto.ProductImage;

public class ColorDao {

	public Color selectColor(String colorId, Connection conn) throws Exception{
		Color color = new Color();
		String sql = "SELECT color_id,color_name, product_id FROM product_color WHERE color_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, colorId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {	
			color.setColorId(colorId);
			color.setColorName(rs.getString("color_name"));
			color.setProductId(rs.getString("product_id"));
		
		}
		
		return color;
	}

	

}
