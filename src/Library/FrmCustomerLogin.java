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
