package Library;

/**
 * The class to validate User and Book
 * @author Sen Li
 * add 2014.8.13
 * edit by Li Huang 2014.8.14: add isUserValid(), isBookValid()
 *   use some Constant, e.g. SpecialCharactersRegex
 *   change the rule of valid PhoneNo, can allow (+86)502-445-0333
 */
public class Validator {

	private static final String SpecialCharsRegex = "[@#$%^&*=+~`|\\/?!.,\';:\"]";
	private static final String SpecialReplaceChar = ":";
	/**
	 * The chars cannot occurs in phone number
	 */
	private static final String PhoneNumberInvalidCharsRegex = "[a-zA-Z@#$%^&*=~`|\\/?!.,\';:\"]";
	
	/**
	 * If str is null, or str=" ", or str="", or str contains
	 * "@#$%^&*-_=+~`|\/?.,';:\"" it is not vailid;
	 * 
	 * @param str
	 * @return
	 */
	public boolean isBookIsbnValid(String str) {
		final String invalidChars = SpecialCharsRegex;

		if (str == null)
			return false;

		str = str.trim();
		if (str.length() == 0)
			return false;

		str = str.replaceAll(invalidChars, SpecialReplaceChar);

		if (str.contains(SpecialReplaceChar))
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
		final String invalidChars = SpecialCharsRegex;

		if (str == null)
			return false;

		str = str.trim();
		if (str.length() == 0)
			return false;

		str = str.replaceAll(invalidChars, SpecialReplaceChar);

		if (str.contains(SpecialReplaceChar))
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

		//edit by Li Huang 2014.8.14. Can allow  (+86)502-445-03 33
//		try {
//			@SuppressWarnings("unused")
//			int checkInt = Integer.parseInt(str);
//		} catch (NumberFormatException e) {
//			return false;
//		}
		
		str = str.replaceAll(PhoneNumberInvalidCharsRegex, SpecialReplaceChar);
		if (str.contains(SpecialReplaceChar))
			return false;
		
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
		boolean bPhoneNo = isUserPhoneNoValid(user.getPhoneNo());
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
