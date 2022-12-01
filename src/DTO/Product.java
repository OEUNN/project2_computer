package DTO;

import java.util.Date;

import lombok.Data;

@Data
public class Product {
	   private String prodcutId;
	   private String productName;
	   private int productPrice;
	   private String productContent;
	   private Date productDate;
	   private String productGraphicCard;
	   private String CPU;
	   private String mainboard;
	   private String os;
	   private String memory;
}
