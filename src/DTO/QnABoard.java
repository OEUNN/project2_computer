package DTO;

import java.util.Date;

import lombok.Data;

@Data

public class QnABoard {
	   private String qnaBno;
	   private String qnaBtitle;
	   private String qnaBcontent;
	   private Date qnaBdate;
	   private String productId;
	   private String subproductId;
	   private String userId;
	   private Boolean qnaContentExist;
}
