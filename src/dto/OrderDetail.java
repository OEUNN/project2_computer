package dto;

import lombok.Data;

@Data
public class OrderDetail {
	   private int orderDetailId;
	   private Product product;
	   private int orderId;
	   private int price;
	   private int productQnt;
	   private Color color;
	   private Capacity capacity;
	   
}
