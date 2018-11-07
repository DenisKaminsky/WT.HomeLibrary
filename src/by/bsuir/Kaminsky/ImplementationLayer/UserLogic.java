package by.bsuir.Kaminsky.ImplementationLayer;

import by.bsuir.Kaminsky.Controller.Controller;
import by.bsuir.Kaminsky.DataAccessLayer.DaoFactory;
import by.bsuir.Kaminsky.DataAccessLayer.UserDao.UserDao;
import by.bsuir.Kaminsky.ModelsLayer.User;

public class UserLogic {
	
	private UserDao userDao;
	private BookLogic bookLogic;
	private static User user = null;
	
	public static void logIn(){	
		User newUser;
		Object[] answer = Controller.authorizeRequest();
		
		if (answer != null){		
			if ( !(boolean)answer[0] ){			
				newUser = new User((String)answer[1], (String)answer[2], false);
				if ( ! DaoFactory.getUserDao().save(newUser) ){				
					Controller.notifyUserRequest("User with this login already exist!");
					return;
				}				
			}
			setAuthorizeUser((String)answer[1],(String)answer[2]);
		}
	}
	
	private static void setAuthorizeUser(String login,String password) {
		user = DaoFactory.getUserDao().getAuthorizeUser(login, password);
		if (user == null){
            Controller.notifyUserRequest("Wrong login or password");
        } else{
            //showOpportunities();
        }	
	}
	
}
