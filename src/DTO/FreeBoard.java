package DTO;


import lombok.Data;

@Data
public class FreeBoard {
	 private String freeBno;
	 private String freeBtitle;
	 private String freeBcontent;
	 
	 private String freeDate;
	 private String userId;
	 private int freeCommentNum;
}
