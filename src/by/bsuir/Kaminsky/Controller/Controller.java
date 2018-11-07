package by.bsuir.Kaminsky.Controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.bsuir.Kaminsky.PresentationLayer.HomeLibraryView;

public class Controller {
	
	public static Object[] authorizeRequest(){
		Object[] result  = HomeLibraryView.getPersonalData();
		
		((String)result[1]).trim();
		((String)result[2]).trim();
		if ( isValidEmailAddress((String)result[1]) && isValidPassword((String)result[2]) )
			return result;
		else
		{
			HomeLibraryView.showMessage("Uncorrect login or password!");
			return null;		
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
