package Service;

import org.json.JSONArray;
import org.json.JSONObject;

import DAO.BasketDao;
import DAO.BasketDetailDao;
import DAO.ProductDao;
import DTO.Basket;
import DTO.BasketDetail;
import DTO.Product;

public class BasketService {
	BasketDao Db = new BasketDao();
	String Output;

	public BasketDetail addBasketProduct(String userId, String productDetailId, int qnt) {
		BasketDetailDao basketDetailDao = new BasketDetailDao();

		ProductDao productDao = new ProductDao();
		BasketDetail bd = new BasketDetail();
		if (productDetailId.contains("proD")) {

			Product pro = productDao.selectProductSubQuery(productDetailId);

			if (pro.getProdcutId() != null) {
				bd = basketDetailDao.insertBasketPro(userId, productDetailId, qnt, pro.getProductPrice());
				if (bd.getBasketDetailId() != null) {
					BasketDao basketDao = new BasketDao();
					basketDao.updateBasket(userId, bd);
				}
			}

		} else {

		}

		return bd;
	}

//상품명, 옵션1,옵션2, 수량,가격,주문가격
	public JSONObject printBasket(String userId) {
		JSONObject root = new JSONObject();
		BasketDetailDao basketDao = new BasketDetailDao();
		JSONArray bdList = basketDao.selectBasketDetails(userId);
		root.put("data", bdList);
		return root;
	}

	public String Create_Basket(Basket basket) {
		Db = new BasketDao();
		Output = Db.Create(basket);
		return Output;
	}

	public String deleteBasketDetailAll(Basket basket) {
		BasketDetailDao bdd = new BasketDetailDao();
		Output = (bdd.deleteBasketDetail(basket.getUserId())) ? "success" : "fail";
		return Output;
	}

}
