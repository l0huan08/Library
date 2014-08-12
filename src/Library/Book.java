package Library;

import java.util.*;

public class Book {
	
	private String bookName;
	private String author;
	private String isbn;
	private Calendar lastRented;
	private boolean isRented;
	private int ownerId;
	private Category category;
	
	
	//getters & setters
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Calendar getLastRented() {
		return lastRented;
	}
	public void setLastRented(Calendar lastRented) {
		this.lastRented = lastRented;
	}
	public boolean isRented() {
		return isRented;
	}
	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public Category getCtg() {
		return category;
	}
	public void setCtg(Category ctg) {
		this.category = ctg;
	}
	
	
	
	
}
