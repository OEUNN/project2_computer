package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import DTO.Users;
import util.Pager;

public class UsersDao {
	Map<String, String> map;

	// 아이디 비교하기
	public boolean compareIdLoginSelect(String id, Connection conn) throws Exception {
		boolean result = false;
		String sql = "select user_Id, from users where user_Id= ? ";
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

	// 개인 정보 수정 (값이 잘못들어오면 예외처리를 해야함)
	public boolean UserUpdate(Users usersDto, Connection conn) throws Exception {
		boolean result = false;
		String sql = "update users set (user_pwd=?,user_phone=?,user_email=?,user_nickname=?,user_address=?) "
				+ "where user_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usersDto.getUserPwd());
		pstmt.setString(2, usersDto.getUserPhone());
		pstmt.setString(3, usersDto.getUserEmail());
		pstmt.setString(4, usersDto.getUserNickname());
		pstmt.setString(5, usersDto.getUserAddress());
		pstmt.setString(6, usersDto.getUserId());
		pstmt.executeUpdate();
		pstmt.close();

		return result;
	}

	// User info 전체 조회 - 이미지도 가져와야됨
	public Users SelectAll(String id, Connection conn) throws Exception {
		Users usersDto = new Users();
		String sql = "select user_id, user_name, user_phone, user_email, user_nickname, user_insertdate, user_address "
				+ " from users where user_id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			usersDto.setUserId(rs.getString(1));
			usersDto.setUserName(rs.getString(2));
			usersDto.setUserPhone(rs.getString(3));
			usersDto.setUserEmail(rs.getString(4));
			usersDto.setUserNickname(rs.getString(5));
			usersDto.setUserInsertdate(rs.getString(6));
			usersDto.setUserAddress(rs.getString(7));
		}
		pstmt.close();
		rs.close();

		return usersDto;
	}

	// User Delete
	public boolean Delete(Users usersDto, Connection conn) throws Exception {
		boolean result = false;
		String sql = "select user_id,user_pwd from users where user_id =? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usersDto.getUserId());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			String password = rs.getString("user_pwd");
			String ID = rs.getString("user_id");
			if (usersDto.getUserPwd().equals(password) && usersDto.getUserId().equals(ID)) {
				String sql2 = "delete from users where user_id = ? ";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, usersDto.getUserId());
				pstmt.executeUpdate();
				result = true;
			} else {
				result = false;
			}

		} else {
			result = false;
		}
		pstmt.close();

		return result;
	}

	// User Join
	public boolean UserJoin(Users usersDto, Connection conn) throws Exception {
		boolean result = false;
		String sql = "insert into users (user_id, user_pwd, user_name, user_phone, user_email, user_nickname, user_address) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usersDto.getUserId());
		pstmt.setString(2, usersDto.getUserPwd());
		pstmt.setString(3, usersDto.getUserName());
		pstmt.setString(4, usersDto.getUserPhone());
		pstmt.setString(5, usersDto.getUserEmail());
		pstmt.setString(6, usersDto.getUserNickname());
		pstmt.setString(7, usersDto.getUserAddress());
		pstmt.executeUpdate();
		pstmt.close();
		result = true;

		return result;
	}

	public ArrayList<Users> ReadAllUser(Pager pager, Connection conn) throws Exception {
		ArrayList<Users> list = new ArrayList<>();
		String sql = "select user_id, user_pwd, user_name, user_phone, user_email, user_nickname, user_insertdate, user_address "
				+ "from (select rownum as rnum, user_id, user_pwd, user_name, user_phone, user_email, user_nickname, user_insertdate, user_address "
				+ " from users where rownum<= ? )" + "where rnum >= ? ";
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

		return list;
	}

	public int getTotalUserRow(Connection conn) throws Exception {
		String sql = "select count (*) as count from users";
		int countRow = 0;
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			countRow = rs.getInt("count");
		}
		pstmt.close();
		rs.close();

		return countRow;
	}

	public boolean ManagerUserDelete(Users usersDto, Connection conn) throws Exception {
		boolean result = false;
		String sql = "select  user_id, user_pwd from users where user_id =? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usersDto.getUserId());

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			sql = "Delete from users where user_id = ? and user_pwd = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usersDto.getUserId());
			pstmt.setString(2, usersDto.getUserPwd());
			result = true;
			pstmt.executeUpdate();
		} else {
			result = false;
		}
		pstmt.close();

		return result;
	}

}
