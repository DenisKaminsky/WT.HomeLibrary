package by.bsuir.Kaminsky.ImplementationLayer;

import by.bsuir.Kaminsky.Controller.Controller;
import by.bsuir.Kaminsky.DataAccessLayer.DaoFactory;
import by.bsuir.Kaminsky.ModelsLayer.User;

public class UserLogic {
	
	private static User user = null;
	
	public static void logIn(){	
		User newUser;
		Object[] answer = Controller.authorizeRequest();
		
		if (answer != null){		
			if ( !(boolean)answer[0] ){			
				newUser = new User((String)answer[1], (String)answer[2], true);
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
		String name;
		user = DaoFactory.getUserDao().getAuthorizeUser(login, password);
		
		if (user == null){
            Controller.notifyUserRequest("Wrong login or password");
        } else{   
        	name = (user.getIsAdministrator())?"Administrator ":"User ";
        	Controller.notifyUserRequest(name+user.getLogin()+" log in");
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
			}
		}		
	}
	
	private static void logOut()
	{
		String name = (user.getIsAdministrator())?"Administrator ":"User ";
		
		Controller.notifyUserRequest(name+user.getLogin()+" log out");
		user = null;
	}
}
