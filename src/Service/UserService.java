package Service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import DAO.UsersDao;
import DTO.Users;
import util.ConnectionProvider;
import util.Pager;

public class UserService {
	int number;
	private ServletContext application;
	
	public UserService(ServletContext application) {
		this.application=application;
	}
	
	//로그인
	public Users userLogin(String id, String pwd) {
		Connection conn=ConnectionProvider.getConnection();
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		Users usersDto= new Users();
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
		return usersDto;
	}
	
	public boolean UserUpdate(Users users) {
		Connection conn=ConnectionProvider.getConnection();
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		boolean result = userDao.UserUpdate(users,conn);
		return result;
	}
	
	public Users UserInfo(Users users) {
		Connection conn=ConnectionProvider.getConnection();
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		return userDao.SelectAll(users.getUserId(),conn);
	}
	
	public boolean UserDelete(Users users) {
		Connection conn=ConnectionProvider.getConnection();
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		boolean result = userDao.Delete(users,conn);
		return result;
	}
	
	public boolean UserJoin(Users users) {
		Connection conn=ConnectionProvider.getConnection();
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		boolean result= userDao.UserJoin(users,conn);
		return result;
	}
	
	// 유저 전체 List 불러오기 ----------------------------------------
	
	public ArrayList<Users> readAllUser(Users users, Pager pager) {
		Connection conn=ConnectionProvider.getConnection();
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		ArrayList<Users> list = new ArrayList<>();
		list = userDao.ReadAllUser(users, pager,conn);
		return list;
	}
	
	public int getTotalUserRow() {
		Connection conn=ConnectionProvider.getConnection();
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		number = userDao.getTotalUserRow(conn);
		return number;
	}
	
	public boolean ManagerUserDelete(Users uesre) {
		Connection conn=ConnectionProvider.getConnection();
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		boolean result = userDao.ManagerUserDelete(uesre,conn);
		return result;
	}
	
	
	
	
	
	
	
	
	
}
