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
public class FrmLibrary extends JFrame{
	FrmLibrary frmLibrary = new FrmLibrary();

	Library L = new Library();
	
	JLabel label1 = new JLabel("Welcome to Our Library System!");
	JLabel label2 = new JLabel("Log in as a:  ");
	JButton btnCustomer = new JButton("Customer");
	JButton btnAdmin = new JButton("Adminstrator");
	JButton btnExit = new JButton("Exit");
	
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
		
		this.setSize(600, 600);
		this.setLocation(350, 50);
		this.setVisible(true);
		this.setTitle("Library");//Optional		
		this.setLayout(null);

		
		label1.setBounds(150, -10, 400, 100);
		label1.setForeground(Color.blue);
		label1.setFont(new Font("", Font.BOLD,20));
		this.add(label1);
		
		label2.setBounds(70, 85, 400, 100);
		this.add(label2);		

		btnCustomer.setVisible(true);
		btnCustomer.setBounds(150, 120, 120, 30);
		this.add(btnCustomer);

		btnAdmin.setVisible(true);
		btnAdmin.setBounds(290, 120, 120, 30);
		this.add(btnAdmin);

		btnExit.setVisible(true);
		btnExit.setBounds(450, 520, 120, 30);
		this.add(btnExit);
		
		btnAdmin.addActionListener(new java.awt.event.ActionListener() {
	    public void actionPerformed(java.awt.event.ActionEvent evt) {
	    	FrmAdministratorLog AdministratorLog = new FrmAdministratorLog(L);
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
