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
import dto.Capacity;
import dto.Color;
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
	
	public List<Product> getList(Pager page,Product productCategory) {
		Connection conn = null;
		List<Product> list = new ArrayList<>();
		try {
			conn=ds.getConnection();
			list = productDao.selectProducts(page,conn,productCategory);
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

	public int getTotalRow(Product product) {
		Connection conn = null;
		int count=0;
		try {
			conn=ds.getConnection();
			count = productDao.selectCountProduct(conn,product);
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

	public Product getCategory() {
		Connection conn = null;
		Product product = new Product();
		try {
			conn=ds.getConnection();
			
			product.setGraphcCardList(productDao.selectCategory("PRODUCT_GRAPHIC_CARD", conn));
			product.setCpuList(productDao.selectCategory("PRODUCT_CPU",conn));
			product.setMainboardList(productDao.selectCategory("PRODUCT_MAINBOARD",conn));
			product.setMemoryList(productDao.selectCategory("PRODUCT_MEMORY",conn));
			product.setOsList(productDao.selectCategory("PRODUCT_OS",conn));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return product;
	}

	public void insertProduct(Product product) {
		Connection conn = null;
		
		try {
			conn=ds.getConnection();
			productDao.inserProduct(product,conn);
			for(Color color:product.getColorList()) {
				color.setProductId(product.getProductId());
				productColorDao.insertColor(color, conn);
				
			}
			for(Capacity capacity:product.getCapacityList()) {
				capacity.setProductId(product.getProductId());
				productCapacityDao.insertCapacity(capacity,conn);
				
			}
			//productImageDao.insertImage(product,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
	}

}
