package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import DTO.Users;
import util.Pager;

public class UsersDao {
	Map<String, String> map;

	
	//아이디 비교하기
	public boolean compareIdLoginSelect(String id, Connection conn) {
		boolean result = false;
		String sql = "select user_Id, from users where user_Id= ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}else {
				result=false;
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//로그인
	public Users loginSelect(String id, Connection conn) {
		Users usersDto = new Users();
		String sql = "select user_Id, user_Pwd, is_admin from users where user_Id= ? ";
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersDto;
	}
	
	// Modify(update)
	public boolean UserUpdate(Users users, Connection conn) {
		boolean result=false;
		String sql = "update users set user_pwd = ? , user_phone = ? , user_email= ?  , user_nickname = ? , user_address = ? "
				+ " where user_id = ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, users.getUserPwd());
			pstmt.setString(2, users.getUserPhone());
			pstmt.setString(3, users.getUserEmail());
			pstmt.setString(4, users.getUserNickname());
			pstmt.setString(5, users.getUserAddress());
			pstmt.setString(6, users.getUserId());
			result=true;
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}

	// User info 전체 조회
	public Users SelectAll(String id, Connection conn) {
		Users users = new Users();
		String sql = "select user_id, user_name, user_phone, user_email, user_nickname, user_insertdate, user_address "
				+ " from users " + " where user_id = ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				users.setUserId(rs.getString(1));
				users.setUserName(rs.getString(2));
				users.setUserPhone(rs.getString(3));
				users.setUserEmail(rs.getString(4));
				users.setUserNickname(rs.getString(5));
				users.setUserInsertdate(rs.getString(6));
				users.setUserAddress(rs.getString(7));
			}
			// 정보 없는 경우 처리
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return users;
	}

	// User Delete
	public boolean Delete(Users users, Connection conn) {
		boolean result=false;
		String sql = "select  user_id, user_pwd from users where user_id =? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, users.getUserId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String password = rs.getString("user_pwd");
				String ID = rs.getString("user_id");
				if (users.getUserPwd().equals(password) && users.getUserId().equals(ID)) {
					String sql2 = "delete from users where user_id = ? ";

					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, users.getUserId());
					pstmt.executeUpdate();
					result=true;
				} else {
					result=false;
				}

			} else {
				result=false;
			}
			pstmt.close();
		} catch (SQLException e) {
			result=false;
		}
		return result;
	}

	// User Join
	public boolean UserJoin(Users users, Connection conn) {
		boolean result=false;
		String sql = "insert into users (user_id, user_pwd, user_name, user_phone, user_email, user_nickname, user_address) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, users.getUserId());
			pstmt.setString(2, users.getUserPwd());
			pstmt.setString(3, users.getUserName());
			pstmt.setString(4, users.getUserPhone());
			pstmt.setString(5, users.getUserEmail());
			pstmt.setString(6, users.getUserNickname());
			pstmt.setString(7, users.getUserAddress());
			pstmt.executeUpdate();
			pstmt.close();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
			result=false;
		}
		return result;
	}

	public ArrayList<Users> ReadAllUser(Users users, Pager pager, Connection conn) {
		ArrayList<Users> list = new ArrayList<>();
		String sql = "select user_id, user_pwd, user_name, user_phone, user_email, user_nickname, user_insertdate, user_address "
				+ "from (select rownum as rnum, user_id, user_pwd, user_name, user_phone, user_email, user_nickname, user_insertdate, user_address "
				+ " from users where rownum<= ? )" + "where rnum >= ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pager.getEndRowNo());
			pstmt.setInt(2, pager.getStartRowNo());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Users usersDto = new Users();
				usersDto.setUserId(rs.getString(1));
				usersDto.setUserPwd(rs.getString(2));
				usersDto.setUserName(rs.getString(3));
				usersDto.setUserPhone(rs.getString(4));
				usersDto.setUserEmail(rs.getString(5));
				usersDto.setUserNickname(rs.getString(6));
				usersDto.setUserInsertdate(rs.getString(7));
				usersDto.setUserAddress(rs.getString(8));
				list.add(usersDto);
			}
			pstmt.close();
			rs.close();

		} catch (Exception e) {
			e.getStackTrace();
		}
		return list;
	}

	public int getTotalUserRow(Connection conn) {
		String sql = "select count (*) as count from users";
		int countRow = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				countRow = rs.getInt("count");
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return countRow;
	}

	public boolean ManagerUserDelete(Users users, Connection conn) {
		boolean result=false;
		String sql = "select  user_id, user_pwd from users where user_id =? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, users.getUserId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				sql = "Delete from users where user_id = ? and user_pwd = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, users.getUserId());
				pstmt.setString(2, users.getUserPwd());
				result=true;
				pstmt.executeUpdate();
			} else {
				result=false;
			}
			pstmt.close();
		} catch (SQLException e) {
			result=false;
		}
		return result;
	}

}
