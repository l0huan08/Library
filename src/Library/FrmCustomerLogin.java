package Library;

import javax.swing.*;

import java.awt.event.*;

/**
 * Frame for the customer to login
 * @author Run Yan
 * add 8/12/2014
 */

public class FrmCustomerLogin extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Library library;
	private User currentUser;
	
	private JFrame frmJf;
	private JLabel lblUserName, lblPassWord;
	private JTextField txtUserName;
	private JPasswordField pwdPassWord;
	private JButton btnLogin, btnClose;
	private String pwd, user;
	
	FrmCustomerLogin(Library l, User u){
		this();
		this.library = l;
		this.currentUser = u;
	}
	
	FrmCustomerLogin(){
		frmJf = new JFrame("Customer Login");
		frmJf.setLayout(null);
		frmJf.setLocation(250, 40);
		
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
		
		frmJf.add(lblUserName);
		frmJf.add(txtUserName);
		frmJf.add(lblPassWord);
		frmJf.add(pwdPassWord);
		frmJf.add(btnLogin);
		frmJf.add(btnClose);
		frmJf.setResizable(false);
		frmJf.setSize(600, 280);
		frmJf.setVisible(true);
		
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				pwd = new String(pwdPassWord.getPassword());
				user = txtUserName.getText();
				if(user.length() == 0){
					JOptionPane.showMessageDialog(frmJf, "Please enter your username.", "Login Failed", JOptionPane.ERROR_MESSAGE);
				} else{
					if(pwd.length() == 0){
						JOptionPane.showMessageDialog(frmJf, "Please enter your password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
					} else{
						if(library.login(user, pwd) != null){
							currentUser = library.login(user, pwd);
							if(!currentUser.isAdmin()){
								JOptionPane.showMessageDialog(frmJf, "Welcome, " + currentUser.getUserName() + "!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
								frmJf.setVisible(false);
								new FrmCustomerInterface(library, currentUser);
							} else{
								JOptionPane.showMessageDialog(frmJf, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
								pwdPassWord.setText("");
							}
						} else{
							JOptionPane.showMessageDialog(frmJf, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
							pwdPassWord.setText("");
						}
					}
				}
			}
		});   
		
		btnClose.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				frmJf.setVisible(false);
				FrmCustomerLogin.this.dispose();
			}
		});
	}
	
	public static void main(String[] args){
		Library l = new Library();
		User u1 = new User();
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		b1.setIsbn("111");
		b1.setBookName("book1");
		b1.setCategory(Category.HISTORY);
		b2.setIsbn("222");
		b2.setBookName("book2");
		b2.setCategory(Category.CHILDREN);
		b3.setIsbn("333");
		b3.setBookName("book3");
		b3.setCategory(Category.CHILDREN);
		u1.setUserId(1);
		u1.setPassword("123");
		u1.setUserName("user");
		u1.setAdmin(false);
		l.addUser(u1);
		l.addBook(b1);
		l.addBook(b2);
		l.addBook(b3);
		l.rentBook(u1.getUserId(), b1.getIsbn());
		new FrmCustomerLogin(l,u1);
	}
}
