package dto;

import java.util.Date;

import lombok.Data;

@Data
public class Orders {
	   private String orderId;
	   private Date orderDate;
	   private String orderStatus;
	   private int totalPrice;
	   private String userId;
	   private String receiverName;
	   private String receiverAddr;
	   private String receiverDetailAdrr;
	   private int post;
	   private String receiverPhone;
}
