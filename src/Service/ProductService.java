package Service;

import java.sql.Connection; 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.ProductCapacityDao;
import dao.ProductColorDao;
import dao.ProductDao;
import dao.ProductImageDao;
import dto.Product;
import util.Pager;

public class ProductService {
	private ServletContext application;
	private DataSource ds;
	private ProductDao productDao;
	private ProductColorDao productColorDao;
	private ProductCapacityDao productCapacityDao; 
	private ProductImageDao productImageDao; 
	
	
	public ProductService(ServletContext application) {
		this.application=application;
		productDao = (ProductDao)application.getAttribute("productDao");
		productColorDao= (ProductColorDao)application.getAttribute("productColorDao");
		productCapacityDao= (ProductCapacityDao)application.getAttribute("productCapacityDao");
		productImageDao= (ProductImageDao)application.getAttribute("productImageDao");
		
		ds=(DataSource)application.getAttribute("dataSource");
	}
	
	public List<Product> getList(Pager page) {
		Connection conn = null;
		List<Product> list = new ArrayList<>();
		try {
			conn=ds.getConnection();
			list = productDao.selectProducts(page,conn);
			for(Product product:list){
				product.setColorList(productColorDao.selectColor(product,conn));
				product.setCapacityList(productCapacityDao.selectCapacity(product,conn));
				product.setProductImageList(productImageDao.selectImage(product,conn));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return list;
	}

	public int getTotalRow() {
		Connection conn = null;
		int count=0;
		try {
			conn=ds.getConnection();
			count = productDao.selectCountProduct(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return count;
	}

	public Product getProduct(String productId) {
		Connection conn = null;
		Product product = new Product();
		try {
			conn=ds.getConnection();
			product = productDao.selectProduct(productId,conn);
			product.setColorList(productColorDao.selectColor(product, conn));
			product.setCapacityList(productCapacityDao.selectCapacity(product,conn));
			product.setProductImageList(productImageDao.selectImage(product,conn));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return product;
	}

}
