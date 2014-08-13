package Library;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.*;

// Joe, After Administrator sucessfully Login, Main menu  (Books, Customers and Categories)

public class FrmAdminLogin extends JFrame {
	JFrame J = new JFrame("Admin Login");
	private Library L;
	
	public FrmAdminLogin(Library L){
		this.L=L;

		J.setSize(600, 280);
		J.setLocation(250,40);
		J.setVisible(true);
		J.setLayout(null);
		
		JButton btnBooks = new JButton("Books");
		btnBooks.setBounds(140, 80, 90, 40);
		J.add(btnBooks);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.setBounds(260, 80, 110, 40);
		J.add(btnCustomers);
		
		JButton btnCategories = new JButton("Categories");
		btnCategories.setBounds(400, 80, 110, 40);
		J.add(btnCategories);
		
		JButton btnClose = new JButton("Clsoe");
		btnClose.setBounds(450, 190, 90, 40);
		J.add(btnClose);
		
		btnBooks.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	FrmBooksManagement N = new FrmBooksManagement(L);
		    }
		});
		
		btnCustomers.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	FrmCustomersManagement N = new FrmCustomersManagement();
		    }
		});
		
		btnCategories.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	FrmViewCategories N = new FrmViewCategories();
		    }
		});
		
		btnClose.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	J.setVisible(false);
		    }
		});
		}
	
	public FrmAdminLogin() {}
}



