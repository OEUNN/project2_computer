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

	public void insertColor(Color color, Connection conn)throws Exception {
		String sql = "insert into product_color(color_id,color_name,product_id)" +
				 "values('color'||color_id.nextval,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 입력됨.
		pstmt.setString(1, color.getColorName());
		pstmt.setString(2, color.getProductId());
		
		pstmt.executeUpdate();
		pstmt.close();
	}
	
}
