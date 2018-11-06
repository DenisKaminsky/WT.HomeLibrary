package by.bsuir.Kaminsky.DataAccessLayer.BookDao;

import java.util.ArrayList;
import by.bsuir.Kaminsky.ModelsLayer.Book;

public interface IBookDao {
	
	boolean delete(Book book);
    boolean save(Book book);
    ArrayList<Book> getBooks();
    ArrayList<Book> getBooksByTitle(String title);
    ArrayList<Book> getBooksByAuthor(String author);
}
