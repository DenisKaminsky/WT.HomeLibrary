package by.bsuir.Kaminsky.PresentationLayer;

import java.util.ArrayList;

public class HomeLibraryView {
	
	public static void showMessage(String message) {
		System.out.println(message);
	}
	
	public static ArrayList<Object> authorizeRequest(){
		boolean answer;
		ArrayList<Object> result = new ArrayList<Object>();
		String login,password;
		
		System.out.print("Do you have an account(Y/N): ");
		answer = ConsoleReader.getAnswer();
		if (answer)
			System.out.println("Authorization:");
		else {
			System.out.println("Registration:");
		}
		System.out.print("Input login: ");
		login = ConsoleReader.getString();
		System.out.print("Input password: ");
		password = ConsoleReader.getString();
		result.add(answer);
		result.add(login);
		result.add(password);		
		return result;
	}
}
