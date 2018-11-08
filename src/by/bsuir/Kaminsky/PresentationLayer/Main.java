package by.bsuir.Kaminsky.PresentationLayer;

import by.bsuir.Kaminsky.ImplementationLayer.UserLogic;

/**
 * Main class, which start program
 * @author DenisKaminsky
 * @version 1.1
 */
public class Main {
	
	/**
	 * Start program
	 * @param args - command line arguments
	 */
	public static void main(String ... args){
		while (true) {
			UserLogic.logIn();
		}
	}
}
