package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrmCustomerLogin {
	private JFrame jf;
	private JLabel UserName, PassWord;
	private JTextField userName;
	private JPasswordField passWord;
	private JButton Login, Close;
	private User currentUser;
	private String pwd, user;
	FrmCustomerLogin(){
		jf = new JFrame("Customer Login");
		UserName = new JLabel();
		UserName.setText("Username:");
		PassWord = new JLabel();
		PassWord.setText("Password:");
		userName = new JTextField(20);
		passWord = new JPasswordField(20);
		Login = new JButton("Login");
		Close = new JButton("Close");
		jf.add(UserName);
		jf.add(userName);
		jf.add(PassWord);
		jf.add(passWord);
		jf.add(Login);
		jf.add(Close);
		jf.setResizable(false);
		jf.setLayout(new FlowLayout());
		jf.setSize(350, 150);
		jf.setVisible(true);
		Login.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				pwd = new String(passWord.getPassword());
				user = userName.getText();
				Library l = new Library(currentUser);
				if(l.loginCheck(user, pwd)){
					jf.setVisible(false);
					new FrmCustomerInterface();
				} else{
					JOptionPane.showMessageDialog(jf, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		Close.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				System.exit(0);
			}
		});
	}
	public static void main(String[] args){
		new FrmCustomerLogin();
	}
}
