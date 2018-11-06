package by.bsuir.Kaminsky.BusinessLayer;

public class Book {
	
	private String author;
	private String title;
	private boolean isElectronic;
	
	public Book(String author,String title,boolean isElectronic){
		this.author = author;
		this.title = title;
		this.isElectronic = isElectronic;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public void setAuthor(String value) {
		author = value;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String value) {
		title = value;
	}
	
	public boolean getIsElectronic(){
		return isElectronic;
	}
	
	public void setIsElectronic(Boolean value) {
		isElectronic = value;
	}
}
