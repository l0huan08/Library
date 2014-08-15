package Library;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.*;
//
//Joe, Admin Login   Name:____________
//				   PassWord:__________

public class FrmAdministratorLog extends JFrame {

	// FrmAdministratorLog frmAdminLog = new FrmAdministratorLog();

	private Library library;
	private JTextField loginName;
	private JPasswordField loginPassWord;

	public FrmAdministratorLog() {
		this(null);
	}

	public FrmAdministratorLog(Library lib) {
		this.library = lib;
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 280);
		this.setLocation(250, 40);
		this.setVisible(true);
		this.setTitle("Admin Login");
		this.setLayout(null);

		JLabel label1 = new JLabel("Administrator Name: ");
		label1.setBounds(50, 54, 120, 120);
		this.add(label1);

		JLabel label2 = new JLabel("PassWord: ");
		label2.setBounds(100, 85, 120, 120);
		this.add(label2);

		// Administrator Log Name
		loginName = new JTextField();
		loginName.setBounds(180, 100, 290, 25);
		this.add(loginName);

		// Administrator Log PassWord
		loginPassWord = new JPasswordField();
		loginPassWord.setBounds(180, 131, 290, 25);
		this.add(loginPassWord);

		JButton BtnLogin = new JButton("Login");
		BtnLogin.setBounds(380, 190, 90, 25);
		this.add(BtnLogin);
		

		BtnLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// Correct Info. provided
				if (loginName.getText().equals("a")
						&& new String(loginPassWord.getPassword()).equals("1")) {
					JOptionPane.showMessageDialog(FrmAdministratorLog.this, "Login Confirmed");
					FrmAdministratorLog.this.dispose();
					FrmAdminLogin n = new FrmAdminLogin(FrmAdministratorLog.this.library);
				} else {
					// Wrong info. provided
					JOptionPane.showMessageDialog(FrmAdministratorLog.this, "Sorry, Worng Input!");
					
//					
//					JFrame F1C = new JFrame();
//					F1C.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					F1C.setSize(350, 200);
//					F1C.setLocation(450, 300);
//					F1C.setVisible(true);
//					F1C.setTitle("Login Confirmed");
//					F1C.setLayout(null);
//
//					JLabel label3 = new JLabel("Sorry, Worng Input!");
//					label3.setBounds(100, 20, 200, 120);
//					F1C.add(label3);
//
//					JButton BtnConfirm = new JButton("OK");
//					BtnConfirm.setBounds(120, 110, 90, 25);
//					F1C.add(BtnConfirm);
//
//					BtnConfirm
//							.addActionListener(new java.awt.event.ActionListener() {
//								public void actionPerformed(
//										java.awt.event.ActionEvent evt) {
//									F1C.setVisible(false);
//								}
//							});
				}
			}
		});
	}

}
