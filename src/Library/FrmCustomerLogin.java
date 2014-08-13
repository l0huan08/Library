package Library;

import javax.swing.*;

import java.awt.event.*;

/**
 * @author Run Yan
 * add 8/12/2014
 */

@SuppressWarnings("serial")
public class FrmCustomerLogin extends JFrame{
	private JFrame frmJf;
	private JLabel lblUserName, lblPassWord;
	private JTextField txtUserName;
	private JPasswordField pwdPassWord;
	private JButton btnLogin, btnClose;
	private String pwd, user;
	private Library library;
	private User currentUser;

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
		btnLogin.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				pwd = new String(pwdPassWord.getPassword());
				user = txtUserName.getText();
				if(user.length() == 0){
					JOptionPane.showMessageDialog(frmJf, "Please enter your username.", "Login Failed", JOptionPane.ERROR_MESSAGE);
				} else{
					if(pwd.length() == 0){
						JOptionPane.showMessageDialog(frmJf, "Please enter your password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
					} else{
						if(library.loginCheck(user, pwd)){
							currentUser = library.login(user, pwd);
							if(!currentUser.isAdmin()){
								frmJf.setVisible(false);
								new FrmCustomerInterface();
							} else{
								JOptionPane.showMessageDialog(frmJf, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
							}
						} else{
							JOptionPane.showMessageDialog(frmJf, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});   
		btnClose.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				frmJf.setVisible(false);
				new FrmLibrary();
			}
		});
	}
	public static void main(String[] args){
		new FrmCustomerLogin();
	}
}
