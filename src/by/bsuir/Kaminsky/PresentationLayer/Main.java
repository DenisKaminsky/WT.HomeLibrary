package by.bsuir.Kaminsky.PresentationLayer;

import java.util.ArrayList;

import by.bsuir.Kaminsky.Controller.Controller;
import by.bsuir.Kaminsky.ImplementationLayer.UserLogic;
import by.bsuir.Kaminsky.ModelsLayer.Book;

public class Main {
	public static void main(String ... args){
		//HomeLibraryView.authorize();
		//UserLogic.LogIn();
		while (true) {
			UserLogic.logIn();
		}
		//Object nook = new Book("aa", "bb", true);
		//System.out.println(nook.toString());
	}
}
