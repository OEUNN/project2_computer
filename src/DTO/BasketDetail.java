package DTO;

import lombok.Data;

@Data
public class BasketDetail {
	private String basketDetailId;
	private String productId;
	private String userId;
	private int price;
	private int productQnt;

}