package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Color;
import dto.Product;

public class ProductColorDao {

	public List<Color> selectColor(Product product, Connection conn)throws Exception {
		List<Color> list = new ArrayList<>();

		String sql = "SELECT COLOR_ID, COLOR_NAME FROM PRODUCT_COLOR WHERE PRODUCT_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, String.valueOf(product.getProductId()));
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Color colorDto = new Color();
			colorDto.setProductId(product.getProductId());
			colorDto.setColorId(rs.getString("COLOR_ID"));
			colorDto.setColorName(rs.getString("COLOR_NAME"));
			list.add(colorDto);
		}

		return list;
	}
	
}
