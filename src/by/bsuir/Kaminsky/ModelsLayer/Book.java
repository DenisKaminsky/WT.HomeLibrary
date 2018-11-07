package by.bsuir.Kaminsky.ModelsLayer;

import java.io.Serializable;

/**
 * Book entity
 * @author DenisKaminsky
 * @version 1.1
 */
public class Book implements Serializable{
	
	/** The unique version ID of the serialized class */
	private static final long serialVersionUID = 1L;
	
	/** Book author */
	private String author;
	
	/** Book title */
	private String title;
	
	/** Type of book */
	private boolean isElectronic;
	
	/** Constructor set book's author,title and type */
	public Book(String author,String title,boolean isElectronic){
		this.author = author;
		this.title = title;
		this.isElectronic = isElectronic;
	}
	
	/**
	 * Get book's author
	 * @return return book's author
	 */
	public String getAuthor(){
		return author;
	}
	
	/**
	 * Set book's author
	 * @param value - Book's author
	 */
	public void setAuthor(String value) {
		author = value;
	}
	
	/**
	 * Get book's title
	 * @return return book's title
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * Set book's title
	 * @param value - Book's title
	 */
	public void setTitle(String value) {
		title = value;
	}
	
	/**
	 * Get book's type
	 * @return return book's type
	 */
	public boolean getIsElectronic(){
		return isElectronic;
	}
	
	/**
	 * Set book's type
	 * @param value - Book's type
	 */
	public void setIsElectronic(Boolean value) {
		isElectronic = value;
	}
	
	/**
	 * Override equals method to compare books
	 * @param obj - Book entity
	 */
	@Override
	public boolean equals(Object obj) {
		Book book;
		
		if (obj == this) 
			return true;
		if (obj == null || obj.getClass() != this.getClass())
            return false;
		book = (Book)obj;
        return (isElectronic == book.isElectronic) && (title == book.title ||
            (title != null && (title.toLowerCase()).equals(book.getTitle().toLowerCase())))
                && (author == book.author || (author != null && (author.toLowerCase()).equals(book.getAuthor().toLowerCase())));
	}
	
	/**
	 * Override toString method to print books
	 * @return return string representation of object
	 */
	@Override
	public String toString() {
		String type = (isElectronic)?"Electronic":"Paper";
		return  "Title: " + title +
                "\nAuthor: " + author +
                "\nType: "+ type;
	}
}
