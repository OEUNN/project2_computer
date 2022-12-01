package DTO;

import java.util.Date;

import lombok.Data;

@Data

public class QnA_Comment {
	   private String qnaConum;
	   private String qnaCocontent;
	   private Date qnaCodate;
	   private String qnaBno;
	   private String userId;
}
