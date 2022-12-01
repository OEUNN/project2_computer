package Service;

import java.util.List;

import DAO.ProductDao;
import DAO.ProductDetailDao;
import DTO.Product;
import DTO.ProductDetail;
import util.Pager;

public class ProductService {
	public List<Product> getList(Pager page) {
		
		ProductDao productDao = new ProductDao();
		return productDao.selectProducts(page);
	}

	public List<Product> getList(Pager page, String searchOption) {
		ProductDao productDao = new ProductDao();
		return productDao.selectProducts(page,searchOption);
	}
	
	public int getTotalRow() {
		
		ProductDao productDao = new ProductDao();
		return productDao.selectCountProduct();
	}

	public Product getProductContent(String productId) {
		
		ProductDao productDao = new ProductDao();
		return productDao.selectProduct(productId);
	}

	public List<ProductDetail> getProductDetailList(String productId) {
		ProductDetailDao productDetailDao = new ProductDetailDao();
		return productDetailDao.selectProductDetails(productId);
	}

}
