package by.bsuir.Kaminsky.DataAccessLayer.UserDao;

import java.io.*;
import java.util.ArrayList;
import by.bsuir.Kaminsky.ModelsLayer.User;

public class UserDao implements IUserDao {
	
	private String fileName;
	
	public UserDao()
	{
		fileName = getDatabasePath();
	}
	
	public boolean delete(User user){
		return true;
	}
	
    public boolean save(User user) {
    	return true;
    }
    
    public User getAuthorizeUser(String login, String password) {
    	ArrayList<User> users = getUsers();
		User result = null;
		
		for (User user : users) {
			if ( (user.getPassword().equals(password)) && (user.getLogin().equals(login)) )
			{
				result = user;
				break;
			}
		}
		return result;
    }
    
    public ArrayList<User> getUsers(){
    	File f = new File(fileName);
		ArrayList<User> users = new ArrayList<User>();
					
		if(f.exists() && !f.isDirectory()) {			
			try {
				users = DeserializeUsers(fileName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}		
		
    	return null;
    }
    
    private void SerializeUsers(ArrayList<User> users,String fileName) throws IOException {
		FileOutputStream fileStream = new FileOutputStream(fileName);
	    ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
	    
	    objectStream.writeObject(users);
	    objectStream.close();
	    fileStream.close();
	}	
	
	@SuppressWarnings("unchecked")
	private ArrayList<User> DeserializeUsers(String fileName) throws IOException, ClassNotFoundException{
		ArrayList<User> result;
		FileInputStream fileStream = new FileInputStream(fileName);
		ObjectInputStream objectStream;
		
		try {
			objectStream = new ObjectInputStream(fileStream);	    
	    
			result = (ArrayList<User>)objectStream.readObject();
			objectStream.close();
		}
		catch (EOFException e) {
			result = new ArrayList<User>(); 
		}
	    fileStream.close();
	    return result;
	}
    
    private String getDatabasePath(){
		return new File("").getAbsolutePath()+"\\database\\UsersDatabase.dat";
	}    
}
