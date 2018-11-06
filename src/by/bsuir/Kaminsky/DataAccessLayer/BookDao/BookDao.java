package by.bsuir.Kaminsky.DataAccessLayer.BookDao;

import java.io.*;
import java.util.List;
import by.bsuir.Kaminsky.ModelsLayer.Book;

public class BookDao implements IBookDao{
	
	private String fileName;
	
	public BookDao()
	{
		fileName = getDatabasePath();
	}
	
	public boolean delete(Book book) {
		
		return false;
	}
	
	public boolean save(Book book) {
		return false;
	}
	
	public List<Book> getBooks(){
		
		return null;
	}
	
	public List<Book> getBooksByTitle(String title){
		return null;
	}
	
	public List<Book> getBooksByAuthor(String author){
		return null;
	}
	
	private void SerializeBooks(List<Book> books,String fileName) throws IOException {
		FileOutputStream fileStream = new FileOutputStream(fileName);
	    ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
	    
	    objectStream.writeObject(books);
	    objectStream.close();
	    fileStream.close();
	}

	private String getDatabasePath(){
		return new File("").getAbsolutePath()+"\\database\\BooksDatabase.dat";
	}
	
}
