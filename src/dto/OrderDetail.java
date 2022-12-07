package dto;

import lombok.Data;

@Data
public class OrderDetail {
	   private String orderDetailId;
	   private String productDetailId;
	   private String orderId;
	   private int price;
	   private int productQnt;
	   
}
