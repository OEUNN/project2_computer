package dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Product {
	//다른 곳에서도 필요한 정보
	   private String productId;
	   private String productName;
	   private int productPrice;
	   //상세페이지에 넣는용 
	   private Date productDate;
	   private String productGraphicCard;
	   //카테고리 분류용
	   private String CPU;
	   private String mainboard;
	   private String os;
	   private String memory;
	   private List<String> graphcCardList;
	   private List<String> cpuList;
	   private List<String> mainboardList;
	   private List<String> osList;
	   private List<String> memoryList;
	   
	   //다른 곳에도 필요한 정보
	   private List<ProductImage> productImageList;
	   private List<Color> colorList;
	   private List<Capacity> capacityList;
	
}
