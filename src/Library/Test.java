package Library;

public class Test {

	/**
	 * If str is null, or str=" ", or str="", or str contains "@#$%^&*-_=+~`|\/?.,';:\"" it is not vailid;
	 * @param str
	 * @return
	 */
	public boolean isIsbnValid(String str) {
		final String invalidChars = "[ @#$%^&*=+~`|\\/?.,\';:\"]";
		
		if (str==null)
			return false;
		
		str = str.trim();
		if (str.length()==0)
			return false;
		
		str=str.replaceAll(invalidChars, ":");
		
		if (str.contains(":"))
			return false;
		
		return true;
	}
	
	public boolean isContentValid(String str) {
		if (str==null)
			return false;
		
		str = str.trim();
		if (str.length()==0)
			return false;
		
		return true;
	}
	
	
	
	
	
	/*
	static public void main(String[] args) {
		Test t = new Test();
		
		System.out.println(		t.isIsbnValid("ha*ha") );
		System.out.println(		t.isIsbnValid("haha12332-3232") );
	}
	*/
}
