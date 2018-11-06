package by.bsuir.Kaminsky.ModelsLayer;

public class User {
	
	private String login;
	private String password;
	private boolean isAdministrator;
	
	public User(String login,String password,boolean isAdministrator){
		this.login = login;
		this.password = password;
		this.isAdministrator = isAdministrator;
	}
	
	public String getLogin(){
		return login;
	}
	
	public void setLogin(String value) {
		login = value;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String value) {
		password = value;
	}
	
	public boolean getIsAdministrator(){
		return isAdministrator;
	}
	
	public void setIsAdministrator(Boolean value) {
		isAdministrator = value;
	}
}
