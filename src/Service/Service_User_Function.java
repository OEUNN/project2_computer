package Service;

import java.util.ArrayList;

import DAO.DAO_Users;
import DTO.Users;
import util.Pager;

public class Service_User_Function {
	DAO_Users Du = new DAO_Users();
	String Output;
	ArrayList<String> list;
	int number;
	
	public String User_ID_Confirm(Users users) {
		Du = new DAO_Users();
		Output = Du.Select(users.getUser_Id());
		return Output;
	}
	public String User_LogIn(Users users) {
		Du = new DAO_Users();
		Output = Du.Select(users.getUser_Id(), users.getUser_Pwd());
		return Output;
	}
	public String User_Check(Users users) {
		Du = new DAO_Users();
		Output = Du.Select(users.getUser_Id(), users.getUser_Pwd());
		return Output;
	}
	
	public String User_Update(Users users) {
		Du = new DAO_Users();
		Output = Du.User_Update(users);
		return Output;
	}
	
	public Users User_Info(Users users) {
		Du = new DAO_Users();
		return Du.SelectAll(users.getUser_Id());
	}
	public String User_Delete(Users users) {
		Du = new DAO_Users();
		Output = Du.Delete(users);
		return Output;
	}
	
	public String User_Join(Users users) {
		Du = new DAO_Users();
		Output = Du.User_Join(users);
		return Output;
	}
	
	// 유저 전체 List 불러오기 ----------------------------------------
	
	public ArrayList<Users> readAllUser(Users users, Pager pager) {
		ArrayList<Users> list = new ArrayList<>();
		Du = new DAO_Users();
		list = Du.ReadAllUser(users, pager);
		return list;
	}
	
	public int getTotalUserRow() {
		Du= new DAO_Users();
		number = Du.getTotalUserRow();
		return number;
	}
	
	public String Manager_UserDelete(Users uesre) {
		Du= new DAO_Users();
		Output = Du.Manager_UserDelete(uesre);
		return Output;
	}
	
	
	
	
	
	
	
	
	
}
