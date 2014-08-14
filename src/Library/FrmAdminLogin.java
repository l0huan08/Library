package Library;


import javax.swing.*;

// Joe, 

/**
 * After Administrator sucessfully Login, Main menu  (Books, Customers and Categories)
 * @author Joe
 * add 2014.8.13
 * edit 2014.8.14 edit by Li Huang, fix complile problem from JDK 8.0 
 */
public class FrmAdminLogin extends JFrame {
	//JFrame J = new JFrame("Admin Login");
	
	private Library library;
	
	public FrmAdminLogin(Library lib){
		this.library=lib;

		this.setSize(600, 280);
		this.setLocation(250,40);
		this.setVisible(true);
		this.setLayout(null);
		
		JButton btnBooks = new JButton("Books");
		btnBooks.setBounds(140, 80, 90, 40);
		this.add(btnBooks);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.setBounds(260, 80, 110, 40);
		this.add(btnCustomers);
		
		JButton btnCategories = new JButton("Categories");
		btnCategories.setBounds(400, 80, 110, 40);
		this.add(btnCategories);
		
		JButton btnClose = new JButton("Clsoe");
		btnClose.setBounds(450, 190, 90, 40);
		this.add(btnClose);
		
		btnBooks.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	FrmBooksManagement frmBookManagement = new FrmBooksManagement(library);
		    }
		});
		
		btnCustomers.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	FrmUsersManagement frmUserManagement = new FrmUsersManagement(library);
		    }
		});
		
		btnCategories.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	FrmViewCategories N = new FrmViewCategories();
		    }
		});
		
		btnClose.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	FrmAdminLogin.this.setVisible(false);
		    }
		});
		}
	
	public FrmAdminLogin() {}
}
