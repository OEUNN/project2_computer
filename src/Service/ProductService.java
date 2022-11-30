package Service;

import java.util.List;

import DAO.ProductDao;
import DAO.ProductDetailDao;
import DTO.Product;
import DTO.Product_Detail;
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

	public Product getProductContent(String product_Id) {
		
		ProductDao productDao = new ProductDao();
		return productDao.selectProduct(product_Id);
	}

	public List<Product_Detail> getProductDetailList(String product_Id) {
		ProductDetailDao productDetailDao = new ProductDetailDao();
		return productDetailDao.selectProductDetails(product_Id);
	}

}
