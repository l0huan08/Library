package Library;

import java.io.*;
import java.text.*;
import java.util.*;

public class Library {
	
	ArrayList<Book> bookList;
	ArrayList<User> userList;
	final String bookListURL = "c:\\BookList.dat";
	final String userListURL = "c:\\userList.dat";
	final long timeLimit = 60*1000; // in millisecond
	
	
	void saveBooks() throws IOException{
		
		FileOutputStream fout = new FileOutputStream(bookListURL);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(bookList);

	}
	
	void saveUsers() throws IOException{
		
		FileOutputStream fout = new FileOutputStream(userListURL);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(userList);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	void loadBooks() throws Exception{
		
		FileInputStream fis = new FileInputStream(bookListURL);
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    bookList = (ArrayList<Book>)ois.readObject();
	    ois.close();
	    
	 
	}
	
	@SuppressWarnings("unchecked")
	void loadUsers() throws Exception{
		
		FileInputStream fis = new FileInputStream(userListURL);
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    userList = (ArrayList<User>)ois.readObject();
	    ois.close();
	}
	 
	
	
	boolean loginCheck(String userName, String password){
		Iterator<User> userItr = userList.iterator();
		while(userItr.hasNext()){
			User tempUser = userItr.next();
			if(userName.equals(tempUser.getUserName()) && password.equals(tempUser.getPassword())){
				return true;
			}//end if
		}//end while
		return false;
		
	}//login check  - old version
	
	
	User login(String userName, String password){
		
		User currentUser = null; //initialize
		Iterator<User> userItr = userList.iterator();
		while(userItr.hasNext()){
			User tempUser = userItr.next();
			if(tempUser.getUserName().equals(userName) && tempUser.getPassword().equals(password)){
				currentUser = tempUser;
				break;
			}//if login successful
		}//while
		return currentUser; //return null if login failed.
	}
	
	String getBookImgFileFullName(String isbn){
		
		return isbn + ".jpg"; //Extension .jpg
		
	}
	
	
	void addBook(Book b){
		b.setAddedDate(new Date());
		bookList.add(b);
		
	}//add book
	
	void updateBook(String isbn, Book b){
		Iterator<Book> bookItr = bookList.iterator();
		int index = -1;
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			index++;
			if(tempBook.getIsbn().equals(isbn)){
				bookList.set(index, b);
				break;
			}//end if
		}//end while
	}//update book
	
	void deleteBook(String isbn){
		Iterator<Book> bookItr = bookList.iterator();
		int index = -1;
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			index++;
			if(tempBook.getIsbn().equals(isbn)){
				bookList.remove(index);
				break;
			}//end if
		}//end while
	}//delete book
	
	void addUser(User user){
		userList.add(user);
	}
	
	void updateUser(int userId, User user){
		Iterator<User> userItr = userList.iterator();
		int index = -1;
		while(userItr.hasNext()){
			User tempUser = userItr.next();
			index++;
			if(tempUser.getUserId()==userId){
				userList.set(index, user);
				break;
			}//end if
		}//end while
	}//update user
	
	void deleteUser(int userId){
		
		Iterator<User> userItr = userList.iterator();
		int index = -1;
		while(userItr.hasNext()){
			User tempUser = userItr.next();
			index++;
			if(tempUser.getUserId()==userId){
				userList.remove(index);
				break;
			}//end if
		}//end while
				
	}//delete user
	

	ArrayList<User> showUserList(){
		
		return userList;
	}//show all user
	
	ArrayList<Book> showBookList_all(){
		
		return bookList;
	}//show all books
	
	ArrayList<Book> showBookList_rented(){
		
		Iterator<Book> bookItr = bookList.iterator();
		ArrayList<Book> tempBookList = new ArrayList<Book>();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.isRented() == true){
				tempBookList.add(tempBook);
			}//end if
		}//end while
		
		return tempBookList;
		
	}//
	
	ArrayList<Book> showBookList_remainder(){
		
		Iterator<Book> bookItr = bookList.iterator();
		ArrayList<Book> tempBookList = new ArrayList<Book>();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.isRented() != true){
				tempBookList.add(tempBook);
			}//end if
		}//end while
		
		return tempBookList;
	}
	
	ArrayList<Book> getBorrowedBooks(int customerId){
	
		Iterator<Book> bookItr = bookList.iterator();
		ArrayList<Book> tempBookList = new ArrayList<Book>();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.getOwnerId()==customerId){
				tempBookList.add(tempBook);
				
			}//end if
		}//end while
		return tempBookList;	
	}
	
	
	ArrayList<Book> showBookList_overdue(){
		
		Iterator<Book> bookItr = bookList.iterator();
		ArrayList<Book> tempBookList = new ArrayList<Book>();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.isRented()==true){
				
				if(new Date().getTime() - tempBook.getLastRented().getTime() >=  timeLimit)
				tempBookList.add(tempBook);
				
				
			}//end if
		}//end while
		
		return tempBookList;
	}
	
	
	void rentBook(int customerId, String isbn){
		
		Iterator<Book> bookItr = bookList.iterator();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.getIsbn().equals(isbn)){
				tempBook.setLastRented(new Date());
				tempBook.setRented(true);
				tempBook.setOwnerId(customerId);
				
			}//end if
		}//end while
		
	}
	
	void returnBook(String isbn){
		

		Iterator<Book> bookItr = bookList.iterator();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.getIsbn().equals(isbn)){
				tempBook.setRented(false);
				tempBook.setOwnerId(0);
				
			}//end if
		}//end while

	}

	
}
