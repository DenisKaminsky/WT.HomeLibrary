package by.bsuir.Kaminsky.Controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.bsuir.Kaminsky.PresentationLayer.HomeLibraryView;

public class Controller {
	
	public static Object[] authorizeRequest(){
		Object[] result  = HomeLibraryView.getPersonalData();
		
		result[1] = ((String)result[1]).trim();
		result[2] = ((String)result[2]).trim();
		if ( isValidEmailAddress((String)result[1]) && isValidPassword((String)result[2]) )
			return result;
		else{		
			notifyUserRequest("Uncorrect login or password!");
			return null;		
		}
	}
	
	public static int chooseActionRequest(boolean isAdmin){
		int result  = -1;
		String action = HomeLibraryView.getAction().toLowerCase().trim();
		
		//string switch available from java8
		switch (action) {
			case "/exit":	
				result=0;
				break;
			case "/logout":	
				result=1;
				break;
			case "/show":	
				result=2;
				break;
			case "/findt":	
				result=3;
				break;
			case "/finda":	
				result=4;
				break;
			case "/finde":	
				result=5;
				break;
			case "/findp":	
				result=6;
				break;
			case "/mod":	
				result=7;
				break;
			case "/add":	
				result=8;
				break;
			case "/delete":	
				result=9;
				break;
			case "/help":
				HomeLibraryView.printAvailableActions();
				break;
			default:
				notifyUserRequest("Unknown command!");
				break;
		}
		if (!isAdmin && result>6) {
			notifyUserRequest("You dont have enough root!");
			result = -1;
		}
		return result;
	}
	
	public static void notifyUserRequest(String message) {
		HomeLibraryView.showMessage("<"+message+">");
	}
	
	public static void printListRequest(ArrayList<Object> list) {
		int counter = 1;
		
		for (Object object : list) {
			HomeLibraryView.showMessage(counter+":\n"+object.toString());
			counter++;
		}
	}
	
	private static boolean isValidEmailAddress(String email) {
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		
		return matcher.find();		
    }
	
	private static boolean isValidPassword(String password) {
		if (password.length() < 5)
			return false;
		else {
			return true;			
		}
	}
}
