package DTO;

import lombok.Data;

@Data
public class Users {
	private String userId;
	private String userPwd;
	private String userName;
	private String userPhone;
	private String userEmail;
	private String userNickname;
	private String userInsertdate;
	private String userAddress;
	private boolean isAdmin;
	private String userFileName;
	private String userSavedName;
	private String userContentType;
}
