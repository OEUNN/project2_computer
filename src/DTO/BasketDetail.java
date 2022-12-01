package DTO;

import lombok.Data;

@Data
public class BasketDetail {
	private String basketDetailId;
	private String subproductId;
	private String productDetailId;
	private String userId;
	private int price;
	private int productQnt;
	private int subproductQnt;
}
