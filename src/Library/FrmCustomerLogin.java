package Library;

import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class FrmCustomerLogin extends JFrame{
	private JFrame jf;
	private JLabel UserName, PassWord;
	private JTextField userName;
	private JPasswordField passWord;
	private JButton Login, Close;
	private String pwd, user;
	FrmCustomerLogin(){
		jf = new JFrame("Customer Login");
		jf.setLayout(null);
		jf.setLocation(250, 40);
		UserName = new JLabel();
		UserName.setText("Username:");
		UserName.setBounds(170, 40, 70, 30);
		PassWord = new JLabel();
		PassWord.setText("Password:");
		PassWord.setBounds(170, 100, 70, 30);
		userName = new JTextField(20);
		userName.setBounds(240, 40, 200, 30);
		passWord = new JPasswordField(20);
		passWord.setBounds(240, 100, 200, 30);
		Login = new JButton("Login");
		Login.setBounds(230, 160, 75, 30);
		Close = new JButton("Close");
		Close.setBounds(340, 160, 75, 30);
		jf.add(UserName);
		jf.add(userName);
		jf.add(PassWord);
		jf.add(passWord);
		jf.add(Login);
		jf.add(Close);
		jf.setResizable(false);
		jf.setSize(600, 280);
		jf.setVisible(true);
		Login.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				pwd = new String(passWord.getPassword());
				user = userName.getText();
				if(user.length() == 0){
					JOptionPane.showMessageDialog(jf, "Please enter your username.", "Login Failed", JOptionPane.ERROR_MESSAGE);
				} else{
					if(pwd.length() == 0){
						JOptionPane.showMessageDialog(jf, "Please enter your password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
					} else{
						Library l = new Library();
						if(l.loginCheck(user, pwd)){
							User currentUser = l.login(user, pwd);
							if(!currentUser.isAdmin()){
								jf.setVisible(false);
								new FrmCustomerInterface();
							} else{
								JOptionPane.showMessageDialog(jf, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
							}
						} else{
							JOptionPane.showMessageDialog(jf, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});   
		Close.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				jf.setVisible(false);
				new FrmLibrary();
			}
		});
	}
	public static void main(String[] args){
		new FrmCustomerLogin();
	}
}
