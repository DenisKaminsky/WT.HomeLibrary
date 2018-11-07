package by.bsuir.Kaminsky.PresentationLayer;

import java.util.Scanner;

public class ConsoleReader {
	
	private static Scanner in = new Scanner(System.in);
	
	public static boolean getBoolean()	{
		while (!in.hasNextBoolean())  {
			in.next();
		}
		return in.nextBoolean();
	}
	
	public static void fflush() {
		in.nextLine();
	}
		
	public static String getString() {
		return in.nextLine();
	}
	
}
