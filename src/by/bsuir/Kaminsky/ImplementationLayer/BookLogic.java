package by.bsuir.Kaminsky.ImplementationLayer;

import java.util.ArrayList;

import by.bsuir.Kaminsky.Controller.Controller;
import by.bsuir.Kaminsky.DataAccessLayer.DaoFactory;
import by.bsuir.Kaminsky.ModelsLayer.Book;

public class BookLogic {
		
	public void findBookByAuthor(){
		

    }
	
	public static void getBooks(){	
		ArrayList<Object> books = new ArrayList<Object>(DaoFactory.getBookDao().getBooks());
		
		Controller.printListRequest(books);		
	}
	
	public static void addBook() {
		Book book;
		Object[] answer = Controller.addBookRequest();
		
		if (answer != null) {
			book = new Book((String)answer[0],(String)answer[1],(Boolean)answer[2]);
			DaoFactory.getBookDao().save(book);
		}			
	}
	
}
