package DTO;

import java.util.Date;

import lombok.Data;

@Data	
public class Subproduct {
	private String subproductId;
	private String subproductName;
	private String subproductType;
	private int subproductPrice;
	private String subproductStock;
	private Date subproductDate;
	private String subproductContent;
}
