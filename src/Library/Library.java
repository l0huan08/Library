package Library;

import java.io.*;
import java.text.*;
import java.util.*;

public class Library {
	
	ArrayList<Book> bookList;
	//ArrayList<Book> newBookList;
	ArrayList<User> userList;
	final String bookListURL = "c:\\BookList.ser";
	final String userListURL = "c:\\userList.ser";
	
	Library(User currentUser){
		
		
	}//constructor
	
	void saveBooks(){
		
		FileOutputStream fout = new FileOutputStream(bookListURL);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject();

		
	}
	
	void loadBooks(){
		
	}
	
	void loadUsers(){
		
	}
	 
	void saveUsers(){
		
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
		
	}//login check
	
	User login(String userName, String password){
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(bookListURL));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	void addBook(Book b){
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
	
	//ArrayList<Book> showBookList_overdue(){}
	
	boolean rentBook(Book b){
		
		
		
		return false;
	}
	
	boolean returnBook(Book b){
		return false;
	}

	
}
