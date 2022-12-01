package Service;

import java.util.ArrayList;

import DAO.UsersDao;
import DTO.Users;
import util.Pager;

public class ServiceUserFunction {
	UsersDao Du = new UsersDao();
	String Output;
	ArrayList<String> list;
	int number;
	
	public String UserIDConfirm(Users users) {
		Du = new UsersDao();
		Output = Du.Select(users.getUserId());
		return Output;
	}
	public String UserLogIn(Users users) {
		Du = new UsersDao();
		Output = Du.Select(users.getUserId(), users.getUserPwd());
		return Output;
	}
	public String UserCheck(Users users) {
		Du = new UsersDao();
		Output = Du.Select(users.getUserId(), users.getUserPwd());
		return Output;
	}
	
	public String UserUpdate(Users users) {
		Du = new UsersDao();
		Output = Du.UserUpdate(users);
		return Output;
	}
	
	public Users UserInfo(Users users) {
		Du = new UsersDao();
		return Du.SelectAll(users.getUserId());
	}
	public String UserDelete(Users users) {
		Du = new UsersDao();
		Output = Du.Delete(users);
		return Output;
	}
	
	public String UserJoin(Users users) {
		Du = new UsersDao();
		Output = Du.UserJoin(users);
		return Output;
	}
	
	// 유저 전체 List 불러오기 ----------------------------------------
	
	public ArrayList<Users> readAllUser(Users users, Pager pager) {
		ArrayList<Users> list = new ArrayList<>();
		Du = new UsersDao();
		list = Du.ReadAllUser(users, pager);
		return list;
	}
	
	public int getTotalUserRow() {
		Du= new UsersDao();
		number = Du.getTotalUserRow();
		return number;
	}
	
	public String ManagerUserDelete(Users uesre) {
		Du= new UsersDao();
		Output = Du.ManagerUserDelete(uesre);
		return Output;
	}
	
	
	
	
	
	
	
	
	
}
