package by.bsuir.Kaminsky.ImplementationLayer;

import by.bsuir.Kaminsky.DataAccessLayer.BookDao.BookDao;


public class BookLogic {
	private BookDao bookDao;
	
	public BookLogic() {
		bookDao = new BookDao();
	}
	
	public void findBookByAuthor(){

        System.out.print("Input author: ");

        ConsoleReader.getString();

        String author = ConsoleReader.getString();

        printList(bookDao.findByAuthor(author));

    }
}
