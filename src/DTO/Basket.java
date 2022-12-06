package DTO;

import java.util.List;
import lombok.Data;

@Data
public class Basket {
	private String userId;
	private int totalPrice;
	private List<BasketDetail> basketDetail;

}
