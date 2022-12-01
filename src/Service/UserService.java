package Service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import DAO.UsersDao;
import DTO.Users;
import util.Pager;

public class UserService {
	String Output;
	ArrayList<String> list;
	int number;
	private ServletContext application;
	
	public UserService(ServletContext application) {
		this.application=application;
	}
	
	public String UserIDConfirm(Users users) {
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		Output = userDao.Select(users.getUserId());
		return Output;
	}
	public String UserLogIn(Users users) {
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		Output = userDao.Select(users.getUserId(), users.getUserPwd());
		return Output;
	}
	public String UserCheck(Users users) {
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		Output = userDao.Select(users.getUserId(), users.getUserPwd());
		return Output;
	}
	
	public String UserUpdate(Users users) {
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		Output = userDao.UserUpdate(users);
		return Output;
	}
	
	public Users UserInfo(Users users) {
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		return userDao.SelectAll(users.getUserId());
	}
	public String UserDelete(Users users) {
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		Output = userDao.Delete(users);
		return Output;
	}
	
	public String UserJoin(Users users) {
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		Output = userDao.UserJoin(users);
		return Output;
	}
	
	// 유저 전체 List 불러오기 ----------------------------------------
	
	public ArrayList<Users> readAllUser(Users users, Pager pager) {
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		ArrayList<Users> list = new ArrayList<>();
		list = userDao.ReadAllUser(users, pager);
		return list;
	}
	
	public int getTotalUserRow() {
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		number = userDao.getTotalUserRow();
		return number;
	}
	
	public String ManagerUserDelete(Users uesre) {
		UsersDao userDao= (UsersDao)application.getAttribute("usersDao");
		Output = userDao.ManagerUserDelete(uesre);
		return Output;
	}
	
	
	
	
	
	
	
	
	
}
