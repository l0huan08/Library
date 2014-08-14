package Library;

/**
 * The class to validate User and Book
 * @author Sen Li
 * add 2014.8.13
 * edit by Li Huang 2014.8.14: add isUserValid(), isBookValid()
 */
public class Validator {

	/**
	 * If str is null, or str=" ", or str="", or str contains
	 * "@#$%^&*-_=+~`|\/?.,';:\"" it is not vailid;
	 * 
	 * @param str
	 * @return
	 */
	public boolean isBookIsbnValid(String str) {
		final String invalidChars = "[ @#$%^&*=+~`|\\/?.,\';:\"]";

		if (str == null)
			return false;

		str = str.trim();
		if (str.length() == 0)
			return false;

		str = str.replaceAll(invalidChars, ":");

		if (str.contains(":"))
			return false;

		return true;
	}

	public boolean isBookNameValid(String str) {
		if (str == null)
			return false;

		str = str.trim();
		if (str.length() == 0)
			return false;

		return true;
	}
	
	public boolean isBookAuthorValid(String str) {
		if (str == null)
			return false;

		str = str.trim();
		if (str.length() == 0)
			return false;

		return true;
	}
	
	
	public boolean isContentValid(String str) {
		if (str == null)
			return false;

		str = str.trim();
		if (str.length() == 0)
			return false;

		return true;
	}

	public boolean isUserIdValid(String str) {

		if (str == null)
			return false;

		str = str.trim();
		if (str.length() == 0)
			return false;

		try {
			@SuppressWarnings("unused")
			int checkInt = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;

	}

	public boolean isUserNameValid(String str) {
		final String invalidChars = "[ @#$%^&*=+~`|\\/?.,\';:\"]";

		if (str == null)
			return false;

		str = str.trim();
		if (str.length() == 0)
			return false;

		str = str.replaceAll(invalidChars, ":");

		if (str.contains(":"))
			return false;

		return true;
	}

	public boolean isUserPasswordValid(String str) {
		if (str == null)
			return false;

		str = str.trim();
		if (str.length() == 0)
			return false;

		return true;
	}

	public boolean isUserPhoneNoValid(String str) {
		if (str == null)
			return false;

		str = str.trim();
		if (str.length() == 0)
			return false;

		try {
			@SuppressWarnings("unused")
			int checkInt = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * whether the user is valid. used in Adding user.
	 * @return
	 */
	public boolean isUserValid(User user) {
		if (user==null)
			return false;
		
		boolean bId = isUserIdValid(String.valueOf(user.getUserId()));
		boolean bName = isUserNameValid(user.getUserName());
		boolean bPassword = isUserPasswordValid(user.getPassword());
		boolean bPhoneNo = isUserPhoneNoValid(user.getPassword());
		return (bId && bName && bPassword && bPhoneNo);
	}
	
	public boolean isBookValid(Book book) {
		if (book==null)
			return false;
		
		boolean bIsbn = isBookIsbnValid(book.getIsbn());
		boolean bName = isBookNameValid(book.getBookName());
		boolean bAuthor = isBookAuthorValid(book.getAuthor());
		return (bIsbn && bName && bAuthor );
	}
	
	/*
	 * static public void main(String[] args) { Test t = new Test();
	 * 
	 * System.out.println( t.isIsbnValid("ha*ha") ); System.out.println(
	 * t.isIsbnValid("haha12332-3232") ); }
	 */
}
