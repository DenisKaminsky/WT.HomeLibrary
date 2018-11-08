package by.bsuir.Kaminsky.PresentationLayer;

import java.util.Scanner;

/**
 * Read data from console
 * @author DenisKaminsky
 * @version 1.1
 */
public class ConsoleReader {
	
	/** Console scanner */
	private static Scanner in = new Scanner(System.in);
	
	/**
	 * Get boolean data from console
	 * @return entered data
	 */
	public static boolean getBoolean()	{
		while (!in.hasNextBoolean())  {
			in.next();
		}
		return in.nextBoolean();
	}
	
	/**
	 * Get answer for question in format: (Y/N)
	 * @return entered answer
	 */
	public static boolean getAnswer() {
		char answer;
		do {
			answer = in.nextLine().toLowerCase().charAt(0);
		} while (answer != 'y' && answer != 'n');
		if (answer == 'y')
			return true;
		else {
			return false;
		}
	}
	
	/** Flush the output buffer*/
	public static void fflush() {
		in.nextLine();
	}
		
	/**
	 * Get string data from console
	 * @return entered string
	 */
	public static String getString() {
		return in.nextLine();
	}
	
}
