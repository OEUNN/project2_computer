package Service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import DAO.UsersDao;
import DTO.Users;
import util.Pager;

public class UserService {
	private DataSource ds;
	private ServletContext application;
	
	//connection연결 
	public UserService(ServletContext application) {
		this.application=application;
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/team3");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//로그인, 로그아웃이 없음
	public Users userLogin(String id, String pwd) {
		Connection conn = null;
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		Users usersDto= new Users();
		try {
			conn=ds.getConnection();
			boolean result=userDao.compareIdLoginSelect(id, conn);
			if(result==true) {
				usersDto= userDao.loginSelect(id, conn);
				if(usersDto.getUserId().equals(id) &&usersDto.getUserPwd().equals(pwd)) {
					result=true;
				}else {
					result=false;
				}
			}
			else {
				result=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return usersDto;
	}
	
	//개인 정보 수정
	public boolean UserUpdate(Users usersDto) {
		Connection conn = null;
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		boolean result=false;
		try {
			conn=ds.getConnection();
			result = userDao.UserUpdate(usersDto,conn);
		} catch (Exception e) {
			e.printStackTrace();
			result=false;
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return result;
	}
	
	public Users UserInfo(Users usersDto) {
		Connection conn = null;
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		try {
			conn=ds.getConnection();
			usersDto = userDao.SelectAll(usersDto.getUserId(),conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return usersDto;
	}
	
	//유저 삭제
	public boolean UserDelete(Users usersDto) {
		Connection conn = null;
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		boolean result=false;
		try {
			conn=ds.getConnection();
			result = userDao.Delete(usersDto,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return result;
	}
	
	public boolean UserJoin(Users usersDto) {
		Connection conn = null;
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		boolean result=false;
		try {
			conn=ds.getConnection();
			result = userDao.UserJoin(usersDto,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return result;
	}
	
	// 유저 전체 List 불러오기 ----------------------------------------
	
	public ArrayList<Users> readAllUser(Users usersDto, Pager pager) {
		Connection conn = null;
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		ArrayList<Users> list = new ArrayList<>();
		try {
			conn=ds.getConnection();
			list = userDao.ReadAllUser(pager,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return list;
	}
	
	public int getTotalUserRow() {
		Connection conn = null;
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		int number=0;
		try {
			conn=ds.getConnection();
			number = userDao.getTotalUserRow(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return number;
	}
	
	//매니저가 유저 삭제하기
	public boolean ManagerUserDelete(Users usersDto) {
		Connection conn = null;
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		boolean result=false;
		try {
			conn=ds.getConnection();
			result = userDao.ManagerUserDelete(usersDto,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return result;
	}
	
	
}
