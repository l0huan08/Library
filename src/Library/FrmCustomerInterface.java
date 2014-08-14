package Library;

import javax.swing.*;

import java.awt.event.*;

/**
 * Frame to guide customer
 * @author Run Yan
 * add 8/12/2014
 */

public class FrmCustomerInterface extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Library library;
	private User user;
	
	//private JFrame this;
	private JButton btnBorrow, btnReturn, btnClose;
	
	FrmCustomerInterface(){
		this(null, null);
	}
	FrmCustomerInterface(Library l, User u){
		this.library = l;
		this.user = u;
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Customer Interface");
		this.setLocation(350, 50);
		
		btnBorrow = new JButton("Borrow Book");
		btnBorrow.setBounds(20, 20, 130, 30);
		
		btnReturn = new JButton("Return Book");
		btnReturn.setBounds(230, 20, 130, 30);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(125, 80, 130, 30);
		
		this.setLayout(null);
		this.add(btnBorrow);
		this.add(btnReturn);
		this.add(btnClose);
		this.setSize(400, 200);
		this.setResizable(false);
		this.setVisible(true);
		
		btnReturn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				new FrmCustomerReturnBook(library, user);
			}
		});
		
		btnClose.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				FrmCustomerInterface.this.dispose();
				new FrmCustomerLogin();
			}
		});
		
		btnBorrow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				FrmBorrowBook borrow = new FrmBorrowBook(library, user);
				borrow.setVisible(true);
			}
		});
	}
}
