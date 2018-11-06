package by.bsuir.Kaminsky.DataAccessLayer.BookDao;

import java.io.*;
import java.util.ArrayList;
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
	
	public ArrayList<Book> getBooks2(){
		File f = new File(fileName);
		ArrayList<Book> books = new ArrayList<Book>();
		
		books.add(new Book("Булгаков А.В.", "Книга 1", true));
		books.add(new Book("Пушкин А.В.", "Книга 2", false));				
		if(f.exists() && !f.isDirectory()) {
			try {
				SerializeBooks(books, fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		return books;
	}
	
	public ArrayList<Book> getBooks(){
		File f = new File(fileName);
		ArrayList<Book> books = new ArrayList<Book>();
					
		if(f.exists() && !f.isDirectory()) {			
			try {
				books = DeserializeBooks(fileName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}		
		return books;
	}
	
	public ArrayList<Book> getBooksByTitle(String title){
		ArrayList<Book> books = getBooks();
		ArrayList<Book> result= new ArrayList<Book>();
		
		for (Book book : books) {
			//if (book.getTitle())
		}
		return null;
	}
	
	public ArrayList<Book> getBooksByAuthor(String author){
		return null;
	}
	
	private void SerializeBooks(ArrayList<Book> books,String fileName) throws IOException {
		FileOutputStream fileStream = new FileOutputStream(fileName);
	    ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
	    
	    objectStream.writeObject(books);
	    objectStream.close();
	    fileStream.close();
	}
	
	
	private ArrayList<Book> DeserializeBooks(String fileName) throws IOException, ClassNotFoundException{
		ArrayList<Book> result;
		FileInputStream fileStream = new FileInputStream(fileName);
		ObjectInputStream objectStream;
		
		try {
			objectStream = new ObjectInputStream(fileStream);	    
	    
			result = (ArrayList<Book>)objectStream.readObject();
			objectStream.close();
		}
		catch (EOFException e) {
			result = new ArrayList<Book>(); 
		}
	    fileStream.close();
	    return result;
	}

	private String getDatabasePath(){
		return new File("").getAbsolutePath()+"\\database\\BooksDatabase.dat";
	}	
}
