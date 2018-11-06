package by.bsuir.Kaminsky.ModelsLayer;

import java.io.Serializable;

public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
	
	@Override
	public String toString() {
		String type = (isElectronic)?"Electronic":"Paper";
		return  "Title: " + title +
                ",\nAuthor: " + author +
                ",\nType: "+ type;
	}
}
