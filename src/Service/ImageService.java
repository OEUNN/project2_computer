package Service;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.ProductImageDao;
import dto.ProductImage;

public class ImageService {
	private ServletContext application;
	private DataSource ds;

	private ProductImageDao productImageDao; 
	
	public ImageService(ServletContext application) {
		this.application=application;
		
		productImageDao= (ProductImageDao)this.application.getAttribute("productImageDao");
		
		ds=(DataSource)this.application.getAttribute("dataSource");
	}

	public ProductImage getProductImage(String imageId) {
		Connection conn = null;
		ProductImage productImage = new ProductImage();
		try {
			
			conn=ds.getConnection();
			productImage = productImageDao.selectImage(imageId,conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return productImage;
	}
	
}
