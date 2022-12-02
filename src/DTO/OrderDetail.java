package DTO;

import lombok.Data;

@Data
public class OrderDetail {
	   private String orderDetailId;
	   private String productId;
	   private String orderId;
	   private int price;
	   private int productQnt;
	   private Product product;
	   
}
