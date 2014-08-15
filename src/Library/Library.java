package Library;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * Library class, manage books and users
 * @author Sen Li
 * add 2014.8.11
 * edit by Run Yan 2014.8.14: fix bug at fine()
 * make all the member variables private
 * add copyBookImage() and addBook(book,srcBookImgPath,srcBookImgFilename) methods
 */
public class Library {
	
	public static final int LIBRARY_OWNER_ID = 0; // ownerId of the library is 0. i.e. not rented.  
	private final String BookListURL = "./books.dat";
	private final String UserListURL = "./users.dat";
	private final long OverdueTimeLimit = 60*1000; // in millisecond
	private final long NewbookTimeLimit = 60*1000; // in millisecond
	private final int FINE_PER_SECOND = 1;
	private final String DEFAULT_BOOK_IMAGE_PATH =  "./images/";
	
	private ArrayList<Book> bookList;
	private ArrayList<User> userList;
	
	Library(){ //constructor
		bookList = new ArrayList<Book>();
		userList = new ArrayList<User>();
	}
	
	
	void saveBooks() throws IOException{
		
		FileOutputStream fout = new FileOutputStream(BookListURL);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(bookList);

	}
	
	void saveUsers() throws IOException{
		
		FileOutputStream fout = new FileOutputStream(UserListURL);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(userList);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	void loadBooks() throws Exception{
		
		FileInputStream fis = new FileInputStream(BookListURL);
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    bookList = (ArrayList<Book>)ois.readObject();
	    ois.close();
	    
	 
	}
	
	@SuppressWarnings("unchecked")
	void loadUsers() throws Exception{
		
		FileInputStream fis = new FileInputStream(UserListURL);
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
		return DEFAULT_BOOK_IMAGE_PATH+isbn + ".jpg"; //Extension .jpg
	}
	
	/**
	 * Copy the book image file into the default Book Image folder.
	 * @param srcImgPath  original image file path e.g. D:/img1
	 * @param srcImgFileName original image filename,  e.g. abc.jpg
	 * @param newImgFilename new image filename, without extension,  e.g.  1234
	 * @return if success copy the file, return true; else return false;
	 * e.g. Will copy D:/img1/abc.jpg into DEFAULT_BOOK_IMG_PATH/1234.jpg. 
	 * @throws Exception
	 */
	public boolean copyBookImage(String srcImgPath, String srcImgFileName, String newImgFilename)
	{
		String srcPath = srcImgPath + srcImgFileName;
		FileInputStream fi;
		try {
			fi = new FileInputStream(srcPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		BufferedInputStream in = new BufferedInputStream(fi);
		newImgFilename = srcImgFileName.replaceAll(srcImgFileName,
				newImgFilename) + ".jpg";
		File destDir = new File(DEFAULT_BOOK_IMAGE_PATH);
		if (!destDir.exists()) {
			destDir.mkdir();
		}
		String destPath = destDir.toString() + "\\" + newImgFilename;
		FileOutputStream fo;
		try {
			fo = new FileOutputStream(destPath);

			BufferedOutputStream out = new BufferedOutputStream(fo);
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			while (len != -1) {
				out.write(buf, 0, len);
				len = in.read(buf);
			}
			out.close();
			fo.close();
			in.close();
			fi.close();
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	void addBook(Book b){
		b.setAddedDate(new Date());
		bookList.add(b);
		
	}//add book
	
	/**
	 * add a book into library, and also copy its image file into the default book image folder.
	 * add by Li Huang 2014.8.14
	 * @param b Book
	 * @param srcBookImgPath original book image file path e.g. D:/img1
	 * @param srcBookImgFileName original image filename,  e.g. abc.jpg
	 */
	void addBook(Book b, String srcBookImgPath, String srcBookImgFileName){
		b.setAddedDate(new Date());
		copyBookImage(srcBookImgPath,srcBookImgFileName,b.getIsbn());
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
	
	boolean addUser(User user){
		return userList.add(user);
	}
	
	boolean updateUser(int userId, User user){
		if(user == null){
			return false;
		}
		Iterator<User> userItr = userList.iterator();
		int index = -1;
		while(userItr.hasNext()){
			User tempUser = userItr.next();
			index++;
			if(tempUser.getUserId()==userId){
				userList.set(index, user);
				return true;
			}//end if
		}//end while
		
		return false;
	}//update user
	
	boolean deleteUser(int userId){
		
		Iterator<User> userItr = userList.iterator();
		int index = -1;
		while(userItr.hasNext()){
			User tempUser = userItr.next();
			index++;
			if(tempUser.getUserId()==userId){
				userList.remove(index);
				return true;
			}//end if
		}//end while
		return false;
				
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
	
	ArrayList<Book> showBookList_BorrowedByCustomer(int customerId){
	
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
				
				if(new Date().getTime() - tempBook.getLastRented().getTime() >=  OverdueTimeLimit)
				tempBookList.add(tempBook);
				
				
			}//end if
		}//end while
		
		return tempBookList;
	}
	
	
	boolean rentBook(int customerId, String isbn){
		
		Iterator<Book> bookItr = bookList.iterator();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.getIsbn().equals(isbn) && tempBook.isRented()==false){
				tempBook.setLastRented(new Date());
				tempBook.setRented(true);
				tempBook.setOwnerId(customerId);
				return true;
			}//end if
		}//end while
		return false;
	}
	
	void returnBook(String isbn){
		

		Iterator<Book> bookItr = bookList.iterator();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.getIsbn().equals(isbn)){
				tempBook.setRented(false);
				tempBook.setOwnerId(LIBRARY_OWNER_ID);
				
			}//end if
		}//end while

	}
	
	ArrayList<Book> showBookList_preferedCategory(Category[] ctgList){
		
		ArrayList<Book> tempBookList = new ArrayList<Book>();
		Category currentCtg = null;
		for(int i =0;i<ctgList.length;i++){//for each category
			currentCtg = ctgList[i];
			Iterator<Book> bookItr = bookList.iterator();
			while(bookItr.hasNext()){
				Book tempBook = bookItr.next();
				if(tempBook.getCategory()==currentCtg){
					tempBookList.add(tempBook);
					
				}//end if
			}//end while
			
		}//end for
		return tempBookList;
		
	}
	
	ArrayList<Book> showBookList_new(Category[] ctgList){
		
		Date currentDate = new Date(); 
		ArrayList<Book> tempBookList = new ArrayList<Book>();
		Category currentCtg = null;
		for(int i =0;i<ctgList.length;i++){//for each category
			currentCtg = ctgList[i];
			Iterator<Book> bookItr = bookList.iterator();
			while(bookItr.hasNext()){
				Book tempBook = bookItr.next();
				if(tempBook.getCategory()==currentCtg){
					
					if(currentDate.getTime() - tempBook.getAddedDate().getTime() < NewbookTimeLimit)
					tempBookList.add(tempBook);
					
				}//end if
			}//end while
			
		}//end for
		return tempBookList;
		
	}
	
	public double fine(String isbn, Date returnDate){
		
		Iterator<Book> bookItr = bookList.iterator();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.getIsbn().equals(isbn)){
				//this book found
				int overdue_time_seconds = (int)(returnDate.getTime() - tempBook.getLastRented().getTime() - OverdueTimeLimit )/1000;
				if (overdue_time_seconds<0)
					overdue_time_seconds=0;
				double fine_amount = overdue_time_seconds*FINE_PER_SECOND;
				return fine_amount;
			}//end if
		}//end while
		
		return 0.0;
	}
	
	public Book getBookByISBN(String isbn){
		
		Iterator<Book> bookItr = bookList.iterator();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.getIsbn().equals(isbn)){
				return tempBook;
			}//end if
			
		}//end while
		
		return new Book();
	}
	
		
}
