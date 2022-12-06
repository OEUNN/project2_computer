package Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import DAO.ProductCapacityDao;
import DAO.ProductColorDao;
import DAO.ProductDao;
import DTO.Color;
import DTO.Product;
import util.Pager;

public class ProductService {
	private ServletContext application;
	private DataSource ds;
	private ProductDao productDao;
	private ProductColorDao productColorDao;
	private ProductCapacityDao productCapacityDao;
	public ProductService(ServletContext application) {
		this.application=application;
		productDao = (ProductDao)this.application.getAttribute("productDao");
		ds=(DataSource)this.application.getAttribute("dataSource");
		productColorDao=(ProductColorDao)this.application.getAttribute("productColorDao");
		productCapacityDao=(ProductCapacityDao)this.application.getAttribute("productCapacityDao");
		
	}
	
	public List<Product> getList(Pager page) {
		Connection conn = null;
		List<Product> list = new ArrayList<>();
		try {
			conn=ds.getConnection();
			list = productDao.selectProducts(page,conn);
			
			for(Product product:list){
				List<Color> colorList=productColorDao.selectColor(product,conn);
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
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return product;
	}

}
