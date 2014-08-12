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
		
//		eCustomerLog CustomerLog = new eCustomerLog();
//		eAdministratorLog AdministratorLog = new eAdministratorLog();
		
//		BtnAdmin.addActionListener(AdministratorLog);	
//		BtnCustomer.addActionListener(CustomerLog);	
		 
//		BtnAdmin.addActionListener(new java.awt.event.ActionListener() {
//		    public void actionPerformed(java.awt.event.ActionEvent evt) {
//		       L.setVisible(false);
//		    }
//		});
		
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
