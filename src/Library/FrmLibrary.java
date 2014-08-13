package Library;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*; //javax.swing.JFrame;

import java.io.*;
/*
 * Joe
 * Very First Frame  Chose login Type
 * */
public class FrmLibrary extends JFrame {
	public FrmLibrary(){
		JFrame L = new JFrame("Library");
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
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setVisible(true);
		btnCustomer.setBounds(150, 120, 120, 30);
		L.add(btnCustomer);
		
		JButton btnAdmin = new JButton("Adminstrator");
		btnAdmin.setVisible(true);
		btnAdmin.setBounds(290, 120, 120, 30);
		L.add(btnAdmin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setVisible(true);
		btnExit.setBounds(450, 520, 120, 30);
		L.add(btnExit);
		
		btnAdmin.addActionListener(new java.awt.event.ActionListener() {
	    public void actionPerformed(java.awt.event.ActionEvent evt) {
	    	FrmAdministratorLog AdministratorLog = new FrmAdministratorLog();
	    	}
		});
		
		btnExit.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		       System.exit(0);
		    }
		});		 
	}
	
	public static void main(String[] a){
		new FrmLibrary();
	}
}
