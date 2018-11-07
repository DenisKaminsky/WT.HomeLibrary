package by.bsuir.Kaminsky.DataAccessLayer;

import by.bsuir.Kaminsky.DataAccessLayer.BookDao.BookDao;
import by.bsuir.Kaminsky.DataAccessLayer.UserDao.UserDao;

/**
 * DaoFactory creates different entities of Dao
 * @author DenisKaminsky
 * @version 1.1
 */
public class DaoFactory {
	
	/** UserDao entity */
	private static UserDao userDao = new UserDao();
	/** BookDao entity */
    private static BookDao bookDao = new BookDao();
    
    /**
     * Get UserDao
     * @return UserDao
     */
    public static UserDao getUserDao()
    {
    	return userDao;
    }
    
    /**
     * Get BookDao
     * @return BookDao
     */
    public static BookDao getBookDao()
    {
    	return bookDao;
    }
}
