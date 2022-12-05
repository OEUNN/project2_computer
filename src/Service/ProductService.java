package Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import DAO.ProductDao;
import DAO.ProductDetailDao;
import DTO.Product;
import DTO.ProductDetail;
import util.Pager;

public class ProductService {
	private ServletContext application;
	private DataSource ds;
	
	public ProductService(ServletContext application) {
		this.application=application;
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/team3");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Product> getList(Pager page) {
		Connection conn = null;
		ProductDao productDao = (ProductDao)application.getAttribute("productDao");
		List<Product> list = new ArrayList<>();
		try {
			conn=ds.getConnection();
			list = productDao.selectProducts(page,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return list;
	}

	public int getTotalRow() {
		Connection conn = null;
		ProductDao productDao = (ProductDao)application.getAttribute("productDao");
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

	public Product getProductContent(String productId) {
		Connection conn = null;
		ProductDao productDao = (ProductDao)application.getAttribute("productDao");
		Product productDto = new Product();
		try {
			conn=ds.getConnection();
			productDto = productDao.selectProduct(productId,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return productDto;
	}

	public List<ProductDetail> getProductDetailList(String productId) {
		Connection conn = null;
		ProductDetailDao productDetailDao = (ProductDetailDao)application.getAttribute("productDetailDao");
		List<ProductDetail> list = new ArrayList<>();
		try {
			conn=ds.getConnection();
			list =  productDetailDao.selectProductDetails(productId,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return list;
	}

}
