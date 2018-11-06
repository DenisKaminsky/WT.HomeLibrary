package by.bsuir.Kaminsky.DataAccessLayer.BookDao;


public class MainCl {
	public static void main(String ... args){
		BookDao dao = new BookDao();
		System.out.println(dao.getDatabasePath());
	}
}
