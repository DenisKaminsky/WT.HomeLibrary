package by.bsuir.Kaminsky.DataAccessLayer;

import by.bsuir.Kaminsky.DataAccessLayer.BookDao.BookDao;
import by.bsuir.Kaminsky.DataAccessLayer.UserDao.UserDao;

public class DaoFactory {
	private static UserDao userDao = new UserDao();
    private static BookDao bookDao = new BookDao();
    
    public static UserDao getUserDao()
    {
    	return userDao;
    }
    
    public static BookDao getBookDao()
    {
    	return bookDao;
    }
}
