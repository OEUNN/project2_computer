package Service;

import org.json.JSONArray;
import org.json.JSONObject;

import DAO.BasketDao;
import DAO.ProductDao;
import DTO.Basket;
import DTO.Product;

public class BasketService {
	
	String Output;

	public Basket addBasketProduct(String userId, String productId, int qnt) {
		ProductDao productDao = new ProductDao();
		Basket bd = new Basket();
		if (productId.contains("proD")) {

			Product pro = productDao.selectProductSubQuery(productId);

			if (pro.getProdcutId() != null) {
				bd = basketDao.insertBasketPro(userId, productId, qnt, pro.getProductPrice());
				if (bd.getBasketId() != null) {
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
		BasketDao basketDao = new BasketDao();
		JSONArray bdList = basketDao.selectBaskets(userId);
		root.put("data", bdList);
		return root;
	}

	public String Create_Basket(Basket basket) {
		Db = new BasketDao();
		Output = Db.Create(basket);
		return Output;
	}

	public String deleteBasketAll(Basket basket) {
		BasketDao bdd = new BasketDao();
		Output = (bdd.deleteBasket(basket.getUserId())) ? "success" : "fail";
		return Output;
	}

}
