package Library;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.*;
//
//Joe, Admin Login   Name:____________
//				   PassWord:__________

public class FrmAdministratorLog extends JFrame {
	
	public FrmAdministratorLog() {
		JFrame L = new JFrame();
		L.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		L.setSize(600, 280);
		L.setLocation(250,40);
		L.setVisible(true);
		L.setTitle("Admin Login");		
		L.setLayout(null);
		
		JLabel label1 = new JLabel("Administrator Name: ");
		label1.setBounds(50, 54, 120, 120);
		L.add(label1);
		
		JLabel label2 = new JLabel("PassWord: ");
		label2.setBounds(100, 85, 120, 120);
		L.add(label2);
		
		// Administrator Log Name
		JTextField LoginName = new JTextField();
		LoginName.setBounds(180, 100, 290, 25);
		L.add(LoginName);
		
		// Administrator Log PassWord
		JTextField LoginPassWord = new JTextField();
		LoginPassWord.setBounds(180, 131, 290, 25);
		L.add(LoginPassWord);
		
		JButton BtnLogin = new JButton("Login");
		BtnLogin.setBounds(380, 190, 90, 25);
		L.add(BtnLogin);
		
		BtnLogin.addActionListener(new java.awt.event.ActionListener() {
	    public void actionPerformed(java.awt.event.ActionEvent evt) {
	    	// Correct Info. provided
	    	if(LoginName.getText().equals("a") && LoginPassWord.getText().equals("1")){
				JFrame F1C = new JFrame();
				F1C.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				F1C.setSize(350, 200);
				F1C.setLocation(450, 300);
				F1C.setVisible(true);
				F1C.setTitle("Login Confirmed");
				F1C.setLayout(null);
				   			
				JLabel label3 = new JLabel("Hi Administrator, Welcome back!");
				label3.setBounds(70, 20, 200, 120);
				F1C.add(label3);
				   			
				JButton BtnConfirm = new JButton("OK");
				BtnConfirm.setBounds(120, 110, 90, 25);
				F1C.add(BtnConfirm);
				
				BtnConfirm.addActionListener(new java.awt.event.ActionListener() {
				    public void actionPerformed(java.awt.event.ActionEvent evt) {
				    	FrmAdminLogin AdministratorLog = new FrmAdminLogin();
				    	F1C.setVisible(false);
				    	L.setVisible(false);
				    }
				});
	    	}else {	
	    		// Wrong info. provided
				JFrame F1C = new JFrame();
				F1C.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				F1C.setSize(350, 200);
				F1C.setLocation(450, 300);
				F1C.setVisible(true);
				F1C.setTitle("Login Confirmed");
				F1C.setLayout(null);
				   			
				JLabel label3 = new JLabel("Sorry, Worng Input!");
				label3.setBounds(100, 20, 200, 120);
				F1C.add(label3);
				   			
				JButton BtnConfirm = new JButton("OK");
				BtnConfirm.setBounds(120, 110, 90, 25);
				F1C.add(BtnConfirm);
				
				BtnConfirm.addActionListener(new java.awt.event.ActionListener() {
				    public void actionPerformed(java.awt.event.ActionEvent evt) {
				    	F1C.setVisible(false);
				    }
				});
	    	}
	    }
		});
	    

		}
	}

