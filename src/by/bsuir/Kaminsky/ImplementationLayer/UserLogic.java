package by.bsuir.Kaminsky.ImplementationLayer;

import java.util.ArrayList;
import by.bsuir.Kaminsky.Controller.Controller;
import by.bsuir.Kaminsky.DataAccessLayer.DaoFactory;
import by.bsuir.Kaminsky.ModelsLayer.User;

/**
 * Provides a set of methods for working with users
 * @author DenisKaminsky
 * @version 1.1
 */
public class UserLogic {
	
	/** Current user */
	private static User user = null;
	
	/** Log in */
	public static void logIn(){	
		User newUser;
		Object[] answer = Controller.authorizeRequest();
		
		if (answer != null){		
			if ( !(boolean)answer[0] ){			
				newUser = new User((String)answer[1], MD5.getHash((String)answer[2]), false);
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
	
	/** Authorize */
	private static void setAuthorizeUser(String login,String password) {
		String name;
		user = DaoFactory.getUserDao().getAuthorizeUser(login, MD5.getHash(password));
		
		if (user == null){
            Controller.notifyUserRequest("Wrong login or password");
        } else{   
        	name = (user.getIsAdministrator())?"Administrator ":"User ";
        	Controller.notifyUserRequest(name+user.getLogin()+" log in");
            chooseAction();
        }	
	}
	
	/** Choose action */
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
					logOut();
					break;
				case 2:	
					BookLogic.getBooks();
					break;
				case 3:		
					BookLogic.findBooksByTitle();
					break;
				case 4:	
					BookLogic.findBooksByAuthor();
					break;
				case 5:	
					BookLogic.findElectonicBooks();
					break;
				case 6:
					BookLogic.findPaperBooks();
					break;
				case 7:	
					BookLogic.modifyBook();
					break;
				case 8:		
					BookLogic.addBook();
					break;
				case 9:		
					BookLogic.deleteBook();
					break;
				case 10:		
					showUsers();
					break;
				case 11:		
					deleteUser();
					break;
			}
		}		
	}
	
	/** Log out */
	private static void logOut(){	
		String name = (user.getIsAdministrator())?"Administrator ":"User ";
		
		Controller.notifyUserRequest(name+user.getLogin()+" log out");
		user = null;
	}
	
	/** Show all users */
	private static void showUsers() {
		ArrayList<Object> users = new ArrayList<Object>(DaoFactory.getUserDao().getUsers());
		
		Controller.printListRequest(users);	
	}
	
	/** Delete user */
	private static void deleteUser() {
		String answer = Controller.getParameterRequest("login of user, you want to delete");
		
		if (answer != null) {
			if (!DaoFactory.getUserDao().delete(answer)) {
				Controller.notifyUserRequest("User not found or administrator");
			}else {
				Controller.notifyUserRequest("User "+answer+" was deleted");
			}
		}		
	}
}
