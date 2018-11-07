package by.bsuir.Kaminsky.PresentationLayer;

import java.util.ArrayList;

import by.bsuir.Kaminsky.Controller.Controller;
import by.bsuir.Kaminsky.ImplementationLayer.UserLogic;

public class Main {
	public static void main(String ... args){
		//HomeLibraryView.authorize();
		//UserLogic.LogIn();
		while (true) {
			System.out.println(Controller.chooseActionRequest(false));	
			
		}
	}
}
