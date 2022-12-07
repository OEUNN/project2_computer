package dto;

import lombok.Data;

@Data
public class ProductDetail {
	private String detailId;
	private String detailColor;
	private String detailCapacity;
	private String productId;
	private int detailQnt;
	private String detailFileName;
	private String detailSavedName;
	private String detailContentType;
}
