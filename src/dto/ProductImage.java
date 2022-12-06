package dto;

import lombok.Data;

@Data
public class ProductImage {
	private int imageId;
	private String fileName;
	private String savedName;
	private String contentType;
	private String productId;

}
