package by.bsuir.Kaminsky.DataAccessLayer.BookDao;

import java.util.ArrayList;
import by.bsuir.Kaminsky.ModelsLayer.Book;

public class MainCl {
	public static void main(String ... args){
		BookDao dao = new BookDao();
		ArrayList<Book> books = new ArrayList<Book>();
		
		books = dao.getBooks();
		System.out.println(books.size());
		for (Book book : books) {
			System.out.println(book);
		}

	}
}
