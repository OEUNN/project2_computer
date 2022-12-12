package dto;

import lombok.Data;

@Data
public class BasketDetail {
	private String basketId;
	private String basketDetailId;
	private Product product;
	
	private int price;
	private int productQnt;
	private Capacity capacity;
	private Color color;
}
