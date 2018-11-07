package by.bsuir.Kaminsky.ImplementationLayer;

import java.util.ArrayList;

import by.bsuir.Kaminsky.Controller.Controller;
import by.bsuir.Kaminsky.DataAccessLayer.DaoFactory;
import by.bsuir.Kaminsky.ModelsLayer.Book;

public class BookLogic {
		
	public static void findBooksByAuthor(){
		 ArrayList<Object> books;
		 String answer = Controller.getParameterRequest("author");
		 
		 if (answer != null) {			 
			 books = new ArrayList<Object>(DaoFactory.getBookDao().getBooksByAuthor(answer));				
			 Controller.printListRequest(books);	
		 }			 
    }
	
	public static void findBooksByTitle(){
		 ArrayList<Object> books;
		 String answer = Controller.getParameterRequest("title");
		 
		 if (answer != null) {			 
			 books = new ArrayList<Object>(DaoFactory.getBookDao().getBooksByTitle(answer));				
			 Controller.printListRequest(books);	
		 }			 
   }
	
	public static void findPaperBooks(){
		ArrayList<Object> books = new ArrayList<Object>(DaoFactory.getBookDao().getPaperBooks());
		
		Controller.printListRequest(books);	
    }
	
	public static void findElectonicBooks(){
		ArrayList<Object> books = new ArrayList<Object>(DaoFactory.getBookDao().getElectonicBooks());
		
		Controller.printListRequest(books);	
    }
	
	public static void getBooks(){	
		ArrayList<Object> books = new ArrayList<Object>(DaoFactory.getBookDao().getBooks());
		
		Controller.printListRequest(books);		
	}
	
	public static void addBook() {
		Book book;
		Object[] answer = Controller.getBookRequest();
		
		if (answer != null) {
			book = new Book((String)answer[0],(String)answer[1],(Boolean)answer[2]);
			if (!DaoFactory.getBookDao().save(book))
				Controller.notifyUserRequest("Book already exists");
			else
				Controller.notifyUserRequest("Book was added");
		}			
		
	}
	
	public static void deleteBook() {
		Book book;
		Object[] answer = Controller.getBookRequest();
		
		if (answer != null) {
			book = new Book((String)answer[0],(String)answer[1],(Boolean)answer[2]);
			if (!DaoFactory.getBookDao().delete(book))
				Controller.notifyUserRequest("Book not found");
			else
				Controller.notifyUserRequest("Book was deleted");
		}			
	}
	
}
