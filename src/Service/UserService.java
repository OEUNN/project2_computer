package Service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.UsersDao;
import dto.Users;
import util.Pager;

public class UserService {
	private DataSource ds;
	private ServletContext application;
	private UsersDao usersDao;
	
	//connection연결 
	public UserService(ServletContext application) {
		this.application=application;
		usersDao = (UsersDao)application.getAttribute("usersDao");
		ds=(DataSource)application.getAttribute("dataSource");
	}
	
	//로그인, 로그아웃이 없음
	public Users userLogin(String id, String pwd) {
		Connection conn = null;
		Users usersDto= new Users();
		try {
			conn=ds.getConnection();
			boolean result=usersDao.compareIdLoginSelect(id, conn);
			if(result==true) {
				usersDto= usersDao.loginSelect(id, conn);
				if(usersDto.getUserId().equals(id) &&usersDto.getUserPwd().equals(pwd)) {
					result=true;
				}else {
					result=false;
				}
			}
			else {
				result=false;
			}
			if(!result) {
				usersDto.setUserId("");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		return usersDto;
	}
	
	public boolean check(String check, String value){
		Connection conn = null;
		boolean result=false;
		try {
			conn=ds.getConnection();
			switch(check) {
			case "id" :
				result = usersDao.compareIdLoginSelect(value, conn);
				break;
			case "phone" :
				result = usersDao.phoneSelect(value, conn);
				break;
			case "email" :
				result = usersDao.emailSelect(value, conn);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return result;
	}
	
	public boolean userJoin(Users usersDto) {
		Connection conn = null;
		boolean result=false;
		try {
			conn=ds.getConnection();
			result = usersDao.UserJoin(usersDto,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return result;
	}
	
	//개인 정보 수정
	public boolean userUpdate(Users usersDto) {
		Connection conn = null;
		boolean result=false;
		try {
			conn=ds.getConnection();
			result = usersDao.UserUpdate(usersDto,conn);
		} catch (Exception e) {
			e.printStackTrace();
			result=false;
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return result;
	}
	
	public Users userInfo(Users usersDto) {
		Connection conn = null;
		try {
			conn=ds.getConnection();
			usersDto = usersDao.SelectAll(usersDto.getUserId(),conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return usersDto;
	}
	
	//유저 삭제
	public boolean userDelete(Users usersDto) {
		Connection conn = null;
		boolean result=false;
		try {
			conn=ds.getConnection();
			result = usersDao.Delete(usersDto,conn);
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
		ArrayList<Users> list = new ArrayList<>();
		try {
			conn=ds.getConnection();
			list = usersDao.ReadAllUser(pager,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return list;
	}
	
	public int getTotalUserRow() {
		Connection conn = null;
		int number=0;
		try {
			conn=ds.getConnection();
			number = usersDao.getTotalUserRow(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return number;
	}
	
	//매니저가 유저 삭제하기
	public boolean managerUserDelete(Users usersDto) {
		Connection conn = null;
		boolean result=false;
		try {
			conn=ds.getConnection();
			result = usersDao.ManagerUserDelete(usersDto,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return result;
	}
	
	
}
