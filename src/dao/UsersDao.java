package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import dto.Users;

public class UsersDao {
	Map<String, String> map; 
	// 아이디 비교하기
	public boolean compareIdLoginSelect(String id, Connection conn) throws Exception {
		boolean result = false;
		String sql = "select user_Id from users where user_Id= ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			result = true;
		} else {
			result = false;
		}
		rs.close();
		pstmt.close();
		
		return result;
	}

	// 로그인
	public Users loginSelect(String id, Connection conn) throws Exception {
		Users usersDto = new Users();
		String sql = "select user_Id, user_Pwd, is_admin from users where user_Id= ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			usersDto.setUserId(rs.getString("user_Id"));
			usersDto.setUserPwd(rs.getString("user_Pwd"));
			usersDto.setAdmin(rs.getBoolean("is_admin"));
		}
		rs.close();
		pstmt.close();

		return usersDto;
	}
	
	//전화번호 검사
	public boolean phoneSelect(String value, Connection conn) throws Exception {
		boolean result = false;
		String sql = "select user_phone from users where user_phone=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, value);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			//있는 전화번호
			result = true;
		} else {
			result = false;
		}
		rs.close();
		pstmt.close();

		return result;
	}
	
	//이메일 검사
	public boolean emailSelect(String value, Connection conn) throws Exception {
		boolean result = false;
		String sql = "select user_email from users where user_email= ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, value);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			//있는 email
			result = true;
		} else {
			result = false;
		}
		rs.close();
		pstmt.close();

		return result;
	}

	//유저 회원가입
	public void userJoin(Users usersDto, Connection conn) throws Exception {
		String sql = "insert into users (user_id, user_pwd, user_name, "
				+ "user_phone, user_email, user_nickname, user_insertdate, is_admin, user_addr,"
				+ " user_post, user_detail_addr, file_name, saved_name, content_type) "
				+ "values(?,?,?,?,?,?,sysdate,default,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usersDto.getUserId());
		pstmt.setString(2, usersDto.getUserPwd());
		pstmt.setString(3, usersDto.getUserName());
		pstmt.setString(4, usersDto.getUserPhone());
		pstmt.setString(5, usersDto.getUserEmail());
		pstmt.setString(6, usersDto.getUserNickname());
		pstmt.setString(7, usersDto.getUserAddr());
		pstmt.setInt(8, usersDto.getUserPost());
		pstmt.setString(9, usersDto.getUserDetailAddr());
		pstmt.setString(10, usersDto.getUserFileName());
		pstmt.setString(11, usersDto.getUserSavedName());
		pstmt.setString(12, usersDto.getUserContentType());
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	//특정 유저 정보 가져오기
	public Users selectUserInfo(String userId, Connection conn) throws Exception{
		Users usersDto = new Users();
		String sql = "select user_pwd, user_name, user_phone, user_email, user_nickname, user_insertdate, "
				+ "user_addr, user_post, user_detail_addr, file_name, saved_name, content_type "
				+ "from users where user_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			usersDto.setUserPwd(rs.getString("user_pwd"));
			usersDto.setUserName(rs.getString("user_name"));
			usersDto.setUserPhone(rs.getString("user_phone"));
			usersDto.setUserEmail(rs.getString("user_email"));
			usersDto.setUserNickname(rs.getString("user_nickname"));
			usersDto.setUserInsertdate(rs.getDate("user_insertdate").toString());
			usersDto.setUserAddr(rs.getString("user_addr"));
			usersDto.setUserPost(rs.getInt("user_post"));
			usersDto.setUserDetailAddr(rs.getString("user_detail_addr"));
			usersDto.setUserFileName(rs.getString("file_name"));
			usersDto.setUserSavedName(rs.getString("saved_name"));
			usersDto.setUserContentType(rs.getString("content_type"));
		}
		rs.close();
		pstmt.close();
		
		return usersDto;
	}
	
	
	// 개인 정보 수정 (값이 잘못들어오면 예외처리를 해야함)
	public boolean UserUpdate(Users usersDto, Connection conn) throws Exception {
		boolean result = false;
		int index=1;
		String sql = "update users set ";
		if(usersDto.getUserPwd().length()>3) {
			sql+= "user_pwd=? ";
			
		}
		sql+= "user_name=?, user_phone=?,user_email=?,user_nickname=?,USER_ADDR=?,USER_POST=?,USER_DETAIL_ADDR=?";
		if(usersDto.getUserFileName()!=null) {
			sql+= ",FILE_NAME=?, SAVED_NAME=?, CONTENT_TYPE=? ";
		}
		sql+= " where user_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if(usersDto.getUserPwd().length()>3) {
			pstmt.setString(index++, usersDto.getUserPwd());
		}
		//System.out.println( usersDto);
		pstmt.setString(index++, usersDto.getUserName());
		pstmt.setString(index++, usersDto.getUserPhone());
		pstmt.setString(index++, usersDto.getUserEmail());
		pstmt.setString(index++, usersDto.getUserNickname());
		pstmt.setString(index++, usersDto.getUserAddr());
		pstmt.setInt(index++, usersDto.getUserPost());
		pstmt.setString(index++, usersDto.getUserDetailAddr());
		if(usersDto.getUserFileName()!=null) {
			pstmt.setString(index++, usersDto.getUserFileName());
			pstmt.setString(index++, usersDto.getUserSavedName());
			pstmt.setString(index++, usersDto.getUserContentType());
		}
		pstmt.setString(index++, usersDto.getUserId());
		if(pstmt.executeUpdate()==1) {
			result=true;
		}
		pstmt.close();
		
		return result;
	}


}
