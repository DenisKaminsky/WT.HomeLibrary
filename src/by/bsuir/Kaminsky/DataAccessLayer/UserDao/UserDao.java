package by.bsuir.Kaminsky.DataAccessLayer.UserDao;

import java.util.ArrayList;
import by.bsuir.Kaminsky.ModelsLayer.User;

public class UserDao implements IUserDao {
	
	boolean delete(User user);
    boolean save(User user);
    User getAuthorizeUser(String login, String password);
    ArrayList<User> getUsers();
}
