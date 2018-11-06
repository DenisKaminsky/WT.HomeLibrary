package by.bsuir.Kaminsky.DataAccessLayer.BookDao;

import java.util.List;
import by.bsuir.Kaminsky.ModelsLayer.Book;

public interface IBookDao {
	
	boolean delete(Book book);
    boolean save(Book book);
    List<Book> getBooks();
    List<Book> getBooksByTitle(String title);
    List<Book> getBooksByAuthor(String author);
}
