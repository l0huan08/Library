package Library;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*; //javax.swing.JFrame;

import java.io.*;

public class FrmLibrary extends JFrame {
	public FrmLibrary(){
		JFrame L = new JFrame("Library");
		L.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		L.setSize(600, 600);
		L.setLocation(350, 50);
		L.setVisible(true);
		L.setTitle("Library");//Optional		
		L.setLayout(null);
		
		JLabel label1 = new JLabel("Welcome to Our Library System!");
		label1.setBounds(150, -10, 400, 100);
		label1.setForeground(Color.blue);
		label1.setFont(new Font("", Font.BOLD,20));
		L.add(label1);
		
		JLabel label2 = new JLabel("Log in as a:  ");
		label2.setBounds(70, 85, 400, 100);
		L.add(label2);		
		
		JButton BtnCustomer = new JButton("Customer");
		BtnCustomer.setVisible(true);
		BtnCustomer.setBounds(150, 120, 120, 30);
		L.add(BtnCustomer);
		
		JButton BtnAdmin = new JButton("Adminstrator");
		BtnAdmin.setVisible(true);
		BtnAdmin.setBounds(290, 120, 120, 30);
		L.add(BtnAdmin);
		
		JButton BtnExit = new JButton("Exit");
		BtnExit.setVisible(true);
		BtnExit.setBounds(450, 520, 120, 30);
		L.add(BtnExit);
		
		BtnAdmin.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setSize(600, 280);
				setLocation(250,40);
				setVisible(true);
				//setBounds(0, 0, 2000, 1000);
				//setLayout(null);
				setTitle("Admin Login");//Optional		
				setLayout(null);
				
				JLabel label1 = new JLabel("Administrator Name: ");
				label1.setBounds(50, 54, 120, 120);
				add(label1);
				
				JLabel label2 = new JLabel("PassWord: ");
				label2.setBounds(100, 85, 120, 120);
				add(label2);
				
				JTextField LoginName = new JTextField();
				LoginName.setBounds(180, 100, 290, 25);
				add(LoginName);
				
				JTextField LoginPassWord = new JTextField();
				LoginPassWord.setBounds(180, 131, 290, 25);
				add(LoginPassWord);
				
				JButton BtnLogin = new JButton("Login");
				BtnLogin.setBounds(380, 190, 90, 25);
				add(BtnLogin);
				
				BtnLogin.addActionListener(new java.awt.event.ActionListener() {
				    public void actionPerformed(java.awt.event.ActionEvent evt) {
				    	String st1 = LoginName.getText();
				    	String st2 = LoginPassWord.getText();
				       if((LoginName.getText()).equals("a") && (LoginPassWord.getText()).equals("1")){ 
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
				   			
//				   			F1C.addActionListener(new java.awt.event.ActionListener() {
//				   			    public void actionPerformed(java.awt.event.ActionEvent evt) {
//				   					//eLogin Log = new eLogin();	
//				   					//BtnLogin.addActionListener(Log);
//				   				}
//				   			});
				       }
				    }
				});
		    }
		});
		
		
//		eCustomerLog CustomerLog = new eCustomerLog();
//		eAdministratorLog AdministratorLog = new eAdministratorLog();
		
//		BtnAdmin.addActionListener(AdministratorLog);	
//		BtnCustomer.addActionListener(CustomerLog);	
		 
//		BtnAdmin.addActionListener(new java.awt.event.ActionListener() {
//		    public void actionPerformed(java.awt.event.ActionEvent evt) {
//		       L.setVisible(false);
//		    }
//		});
		
//		BtnAdmin.addActionListener(new java.awt.event.ActionListener() {
//	    public void actionPerformed(java.awt.event.ActionEvent evt) {
//	    	eAdministratorLog AdministratorLog = new eAdministratorLog();
//	    	AdministratorLog.setVisible(true);
//	        L.setVisible(false);
//	    }
//	});
		
		BtnExit.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		       System.exit(0);
		    }
		});
		 
	}
	
	public static void main(String[] a){
		new FrmLibrary();
	}
}
