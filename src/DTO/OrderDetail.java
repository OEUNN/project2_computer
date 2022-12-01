package DTO;

import lombok.Data;

@Data
public class OrderDetail {
	   private String orderDetailId;
	   private String productDetailId;
	   private String orderId;
	   private String subproductId;
	   private int price;
	   private int productQnt;
	   private int subproductQnt;
}
