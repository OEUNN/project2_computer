package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Capacity;
import dto.Product;
import dto.ProductImage;

public class ProductImageDao {

	public List<ProductImage> selectImage(Product product, Connection conn)throws Exception {
		List<ProductImage> list = new ArrayList<>();

		String sql = "SELECT IMAGE_ID, FILE_NAME,SAVED_NAME,CONTENT_TYPE  FROM PRODUCT_IMAGE WHERE PRODUCT_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, String.valueOf(product.getProductId()));
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ProductImage imageDto = new ProductImage();
			imageDto.setProductId(product.getProductId());
			imageDto.setImageId(rs.getInt("IMAGE_ID"));
			imageDto.setFileName(rs.getString("FILE_NAME"));
			imageDto.setSavedName(rs.getString("SAVED_NAME"));
			imageDto.setContentType(rs.getString("CONTENT_TYPE"));
			
			list.add(imageDto);
		}
		
		return list;
	}

}
