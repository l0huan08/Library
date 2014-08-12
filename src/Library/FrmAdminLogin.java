package Library;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.*;

public class FrmAdminLogin extends JFrame {

	public FrmAdminLogin() {
		JFrame L = new JFrame();
		L.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		L.setSize(600, 280);
		L.setLocation(250,40);
		L.setVisible(true);
		L.setTitle("Admin Login");		
		L.setLayout(null);
		
		JButton BtnBooks = new JButton("Books");
		BtnBooks.setBounds(140, 80, 90, 40);
		L.add(BtnBooks);
		
		JButton BtnCustomers = new JButton("Customers");
		BtnCustomers.setBounds(260, 80, 110, 40);
		L.add(BtnCustomers);
		
		JButton BtnCategories = new JButton("Categories");
		BtnCategories.setBounds(400, 80, 110, 40);
		L.add(BtnCategories);
		
		JButton BtnClose = new JButton("Clsoe");
		BtnClose.setBounds(450, 190, 90, 40);
		L.add(BtnClose);
		
		BtnBooks.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	FrmBooksManagement N = new FrmBooksManagement();
		    }
		});
		
		BtnCustomers.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	//F1C.setVisible(false);
		    }
		});
		
		BtnCategories.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	//F1C.setVisible(false);
		    }
		});
		
		BtnClose.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	L.setVisible(false);
		    }
		});
		
//		BtnLogin.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt){
//				
//	    	}
//	    });
	}
}



