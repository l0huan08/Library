package Library;

import javax.swing.*;

import java.awt.event.*;

/**
 * Frame for the customer to login
 * @author Run Yan
 * add 8/12/2014
 * edit by Li Huang 2014.8.14 fix bug
 */

public class FrmCustomerLogin extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Library library;
	private User currentUser;
	
	private JLabel lblUserName, lblPassWord;
	private JTextField txtUserName;
	private JPasswordField pwdPassWord;
	private JButton btnLogin, btnClose;
	private String pwd, user;
	
	private FrmCustomerLogin(){
		this(null);
	}
	
	FrmCustomerLogin(Library l){
		this.library=l;
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Customer Login");
		this.setLayout(null);
		this.setLocation(250, 40);
		
		lblUserName = new JLabel();
		lblUserName.setText("Username:");
		lblUserName.setBounds(170, 40, 70, 30);
		
		lblPassWord = new JLabel();
		lblPassWord.setText("Password:");
		lblPassWord.setBounds(170, 100, 70, 30);
		
		txtUserName = new JTextField(20);
		txtUserName.setBounds(240, 40, 200, 30);
		
		pwdPassWord = new JPasswordField(20);
		pwdPassWord.setBounds(240, 100, 200, 30);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(230, 160, 75, 30);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(340, 160, 75, 30);
		
		this.add(lblUserName);
		this.add(txtUserName);
		this.add(lblPassWord);
		this.add(pwdPassWord);
		this.add(btnLogin);
		this.add(btnClose);
		this.setResizable(false);
		this.setSize(600, 280);
		this.setVisible(true);
		
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				pwd = new String(pwdPassWord.getPassword());
				user = txtUserName.getText();
				if(user.length() == 0){
					JOptionPane.showMessageDialog(FrmCustomerLogin.this, "Please enter your username.", "Login Failed", JOptionPane.ERROR_MESSAGE);
				} else{
					if(pwd.length() == 0){
						JOptionPane.showMessageDialog(FrmCustomerLogin.this, "Please enter your password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
					} else{
						currentUser = library.login(user, pwd);
						if(currentUser != null){
							if(!currentUser.isAdmin()){
								JOptionPane.showMessageDialog(FrmCustomerLogin.this, "Welcome, " + currentUser.getUserName() + "!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
								FrmCustomerLogin.this.dispose();
								new FrmCustomerInterface(library, currentUser);
							} else{
								JOptionPane.showMessageDialog(FrmCustomerLogin.this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
								pwdPassWord.setText("");
							}
						} else{
							JOptionPane.showMessageDialog(FrmCustomerLogin.this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
							pwdPassWord.setText("");
						}
					}
				}
			}
		});   
		
		btnClose.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				FrmCustomerLogin.this.dispose();
			}
		});
	}
	
	public static void main(String[] args){
		Library l = new Library();
		User u1 = new User();
		User u2 = new User();
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		b1.setIsbn("0778801314");
		b1.setBookName("Ball Complete Book of Home Preserving");
		b1.setAuthor("Judi Kingry");
		b1.setCategory(Category.COOKING);
		b2.setIsbn("0736430512");
		b2.setBookName("Frozen Little Golden Book");
		b2.setAuthor("RH Disney");
		b2.setCategory(Category.CHILDREN);
		b3.setIsbn("1476751447");
		b3.setBookName("Hard Choices");
		b3.setAuthor("Hillary Rodham Clinton");
		b3.setCategory(Category.HISTORY);
		u1.setUserId(1);
		u1.setPassword("123");
		u1.setUserName("user");
		u1.setAdmin(false);
		
		u2.setUserId(2);
		u2.setPassword("123");
		u2.setUserName("admin");
		u2.setAdmin(true);
		
		l.addUser(u1);
		l.addUser(u2);
		l.addBook(b1);
		l.addBook(b2);
		l.addBook(b3);
		l.rentBook(u1.getUserId(), b1.getIsbn());
		
		new FrmCustomerLogin(l);
	}
}
