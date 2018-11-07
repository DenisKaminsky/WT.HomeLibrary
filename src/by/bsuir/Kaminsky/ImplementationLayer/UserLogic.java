package by.bsuir.Kaminsky.ImplementationLayer;

import by.bsuir.Kaminsky.Controller.Controller;
import by.bsuir.Kaminsky.DataAccessLayer.UserDao.UserDao;
import by.bsuir.Kaminsky.ModelsLayer.User;

public class UserLogic {
	
	private UserDao userDao;
	private BookLogic bookLogic;
	private static User user = null;
	
	public static void LogIn()
	{
		Object[] answer = Controller.authorizeRequest();
		
		if (answer != null)
		{
			if ( !(boolean)answer[0] )
				user = new User((String)answer[1], (String)answer[2], false);
			System.out.println(user);
		}
	}
}
