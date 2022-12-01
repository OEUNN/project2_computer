package DTO;


import lombok.Data;

@Data
public class QnaBoard {
	 private String qnaBno;
	 private String qnaBtitle;
	 private String qnaBcontent;
	 private String qnaDate;
	 private String userId;
	 private boolean isReply;
}
