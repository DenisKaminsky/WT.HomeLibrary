package by.bsuir.Kaminsky.PresentationLayer;

import java.util.ArrayList;

public class HomeLibraryView {
	
	public static void showMessage(String message) {
		System.out.println(message);
	}
	
	public static Object[] getPersonalData(){
		boolean answer;
		String login,password,attribute="";
		
		System.out.print("Do you have an account(Y/N): ");
		answer = ConsoleReader.getAnswer();
		if (answer)
			System.out.println("<Authorization>");
		else {
			attribute = "(minimum 5 character)";
			System.out.println("<Registration>");			
		}
		System.out.print("Input login: ");
		login = ConsoleReader.getString();
		System.out.print("Input password"+attribute+": ");
		password = ConsoleReader.getString();		
		return new Object[] {answer,login,password};
	}
}
