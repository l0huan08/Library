package Library;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*; //javax.swing.JFrame;

import java.io.*;
/*
 * Joe
 * Very First Frame  Chose login Type
 * */
import java.util.Date;
public class FrmLibrary extends JFrame {
	JFrame J = new JFrame("Library");

	Library L = new Library();

	
	public FrmLibrary(){
		Book book1 = new Book();
		book1.setBookName("GVF");
		book1.setAddedDate(new Date());
		book1.setAuthor("XMQ");
		book1.setCategory(Category.CHILDREN);
		book1.setIsbn("2B64B");
		book1.setLastRented(new Date());
		book1.setOwnerId(Library.LIBRARY_OWNER_ID);
		book1.setRented(false);		
		L.bookList.add(book1);
		
		Book book2 = new Book();
		book2.setBookName("WWII");
		book2.setAddedDate(new Date());
		book2.setAuthor("SomeTwo");
		book2.setCategory(Category.HISTORY);
		book2.setIsbn("SBSBDSB");
		book2.setLastRented(new Date());
		book2.setOwnerId(Library.LIBRARY_OWNER_ID);
		book2.setRented(false);
		L.bookList.add(book2);
		
		J.setSize(600, 600);
		J.setLocation(350, 50);
		J.setVisible(true);
		J.setTitle("Library");//Optional		
		J.setLayout(null);
		
		JLabel label1 = new JLabel("Welcome to Our Library System!");
		label1.setBounds(150, -10, 400, 100);
		label1.setForeground(Color.blue);
		label1.setFont(new Font("", Font.BOLD,20));
		J.add(label1);
		
		JLabel label2 = new JLabel("Log in as a:  ");
		label2.setBounds(70, 85, 400, 100);
		J.add(label2);		
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setVisible(true);
		btnCustomer.setBounds(150, 120, 120, 30);
		J.add(btnCustomer);
		
		JButton btnAdmin = new JButton("Adminstrator");
		btnAdmin.setVisible(true);
		btnAdmin.setBounds(290, 120, 120, 30);
		J.add(btnAdmin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setVisible(true);
		btnExit.setBounds(450, 520, 120, 30);
		J.add(btnExit);
		
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
		
		btnCustomer.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		       FrmCustomerLogin CustomerLogin = new FrmCustomerLogin();
		    }
		});
	}
	
	public static void main(String[] a){
		new FrmLibrary();
	}
}
