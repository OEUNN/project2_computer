package Service;

import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletContext;

import DAO.ProductDao;
import DAO.ProductDetailDao;
import DTO.Product;
import DTO.ProductDetail;
import util.ConnectionProvider;
import util.Pager;

public class ProductService {
	private ServletContext application;
	
	public ProductService(ServletContext application) {
		this.application=application;
	}
	public List<Product> getList(Pager page) {
		Connection conn=ConnectionProvider.getConnection();
		ProductDao productDao = (ProductDao)application.getAttribute("productDao");
		return productDao.selectProducts(page,conn);
	}

	public int getTotalRow() {
		Connection conn=ConnectionProvider.getConnection();
		ProductDao productDao = (ProductDao)application.getAttribute("productDao");
		return productDao.selectCountProduct(conn);
	}

	public Product getProductContent(String productId) {
		Connection conn=ConnectionProvider.getConnection();
		ProductDao productDao = (ProductDao)application.getAttribute("productDao");
		return productDao.selectProduct(productId,conn);
	}

	public List<ProductDetail> getProductDetailList(String productId) {
		Connection conn=ConnectionProvider.getConnection();
		ProductDao productDao = (ProductDao)application.getAttribute("productDao");
		ProductDetailDao productDetailDao = (ProductDetailDao)application.getAttribute("productDetailDao");
		return productDetailDao.selectProductDetails(productId,conn);
	}

}
