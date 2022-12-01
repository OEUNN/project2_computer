package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import DTO.Users;
import util.ConnectionProvider;
import util.Pager;

public class UsersDao {
	String Output;
	
	//ID 유무 확인
	public String Select(String id) {
		String sql = "select user_id from users where user_id = ? ";
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Output = "success";
			} else {
				Output = "fail";
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			Output = e.getMessage();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Output;
	}

	// Login
	public String Select(String id, String pwd) {
		String sql = "select user_Id, user_Pwd from users where user_Id= ? ";
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("user_pwd").equals(pwd)) {
					if (rs.getString("user_id").equals("Manager")) {
						Output = "manager";
					} else {
						Output = "normal";
					} 
				} else {
					Output = "fail";
				}
			} else {
				Output = "fail";
			}
			
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Output;
	}
	
	//Modify (update)
	public String UserUpdate(Users users) {
			String sql = "update users set user_pwd = ? , user_phone = ? , user_email= ?  , user_nickname = ? , user_address = ? "
					+ " where user_id = ? ";
			Connection conn = ConnectionProvider.getConnection();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, users.getUserPwd());
				pstmt.setString(2, users.getUserPhone());
				pstmt.setString(3, users.getUserEmail());
				pstmt.setString(4, users.getUserNickname());
				pstmt.setString(5, users.getUserAddress());
				pstmt.setString(6, users.getUserId());
				Output = "success";
				pstmt.executeUpdate();
				pstmt.close();
				
			} catch (Exception e) {
				Output = "fail";
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return Output;
		}
	
	//User info 전체 조회
	public  Users SelectAll(String id) {
			Users users = new Users();
			String sql = "select user_id, user_name, user_phone, user_email, user_nickname, user_insertdate, user_address "
					+ " from users "
					+ " where user_id = ? ";
			Connection conn = ConnectionProvider.getConnection();
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
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return users;
		}
	
	//User Delete
	public String Delete(Users users) {
		String sql = "select  user_id, user_pwd from users where user_id =? ";
		Connection conn = ConnectionProvider.getConnection();
		try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, users.getUserId());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			String password = rs.getString("user_pwd");
			String ID = rs.getString("user_id");
			if (users.getUserPwd().equals(password) && users.getUserId().equals(ID))  { 
				String sql2 = "delete from users where user_id = ? ";
				
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, users.getUserId());
				pstmt.executeUpdate();
				Output = "success";
			} else {
				Output = "fail";
			}

		} else {
			Output = "else";
		}
		pstmt.close();
		} catch (SQLException e) {
			Output= "else";
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return Output;
	}
	
	//User Join
	public String UserJoin(Users users) {
		String sql = "insert into users (user_id, user_pwd, user_name, user_phone, user_email, user_nickname, user_address) " +
				"values(?, ?, ?, ?, ?, ?, ?)";
		Connection conn = ConnectionProvider.getConnection();
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
			Output = "success";
		} catch (Exception e) {
			e.printStackTrace();
			Output = "fail";
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		
		
		return Output;
	}
	
public ArrayList<Users> ReadAllUser(Users users, Pager pager) {
		
		ArrayList<Users> list1 = new ArrayList<>();
		String sql = "select user_id, user_pwd, user_name, user_phone, user_email, user_nickname, user_insertdate, user_address "
				+ "from (select rownum as rnum, user_id, user_pwd, user_name, user_phone, user_email, user_nickname, user_insertdate, user_address "
				+ " from users where rownum<= ? )"
				+ "where rnum >= ? ";
		
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			
			
			pstmt.setInt(1, pager.getEndRowNo());
			pstmt.setInt(2, pager.getStartRowNo());
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Users users1 = new Users();
				
				users1.setUserId(rs.getString(1));
				users1.setUserPwd(rs.getString(2));
				users1.setUserName(rs.getString(3));
				users1.setUserPhone(rs.getString(4));
				users1.setUserEmail(rs.getString(5));
				users1.setUserNickname(rs.getString(6));
				users1.setUserInsertdate(rs.getString(7));
				users1.setUserAddress(rs.getString(8));

				list1.add(users1);
			}
			
			pstmt.close();
			rs.close();
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list1;
	}
	
	
	
	public int getTotalUserRow() {
		String sql = "select count (*) as count from users";
		Connection conn = ConnectionProvider.getConnection();
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
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return countRow;
	}
	public String ManagerUserDelete(Users users) {
	      String sql = "select  user_id, user_pwd from users where user_id =? ";
	         
	      Connection conn = ConnectionProvider.getConnection();
	      try {
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, users.getUserId());
	         ResultSet rs = pstmt.executeQuery();
	         
	         if (rs.next())  { 
	            sql = "Delete from users where user_id = ? and user_pwd = ? ";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, users.getUserId());
	            pstmt.setString(2, users.getUserPwd());
	            
	            Output = "success";
	            pstmt.executeUpdate();
	         } else {
	            Output= "fail";
	         }
	         pstmt.close();
	      } catch (SQLException e) {
	         Output= "fail";
	         
	      }finally {
	         try {
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      
	      return Output;
	   }
		
	
}
