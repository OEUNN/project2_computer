package dto;


import lombok.Data;

@Data
public class ReviewBoard {
	 private String reviewBno;
	 private String reviewBtitle;
	 private String reviewBcontent;
	 private String reviewDate;
	 private int reviewRate;
	 private String userId;
	 private String orderDetailId;
	 private String productName; 
}
