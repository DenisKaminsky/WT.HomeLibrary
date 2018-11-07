package by.bsuir.Kaminsky.ImplementationLayer;

import com.sun.scenario.animation.shared.InfiniteClipEnvelope;

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
				else{				
					Controller.notifyUserRequest("User "+(String)answer[1]+" was successfully register");
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
        	Controller.notifyUserRequest("User "+user.getLogin()+" log in");
            chooseAction();
        }	
	}
	
	private static void chooseAction() {
		boolean flag = true;
		
		while (flag) {
			int action = Controller.chooseActionRequest(user.getIsAdministrator());
			switch (action) {
				case 0:			
					System.exit(0);
					break;
				case 1:	
					flag = false;
					Controller.notifyUserRequest("User "+user.getLogin()+" log out");
					user = null;
					break;
				case 2:	
					
					break;
				case 3:			
					break;
				case 4:			
					break;
				case 5:			
					break;
				case 6:			
					break;
				case 7:			
					break;
				case 8:			
					break;
				case 9:			
					break;
			}
		}		
	}
	
	
	
}
