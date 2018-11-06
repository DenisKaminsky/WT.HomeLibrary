package by.bsuir.Kaminsky.DataAccessLayer.UserDao;

import java.util.ArrayList;
import by.bsuir.Kaminsky.DataAccessLayer.UserDao.UserDao;
import by.bsuir.Kaminsky.ModelsLayer.User;

public class MainCl {
	
	public static void main(String ... args){
		UserDao dao = new UserDao();
		ArrayList<User> users = new ArrayList<User>();
		
		//System.out.println(dao.save(new User("egor@gmail.com", "password3", false)));
		//System.out.println(dao.delete(new User("egor@gmail.com", "password3", false)));
		users = dao.getUsers();
		System.out.println(users.size());
		for (User user : users) {
			System.out.println(user);
		}
	}
}
