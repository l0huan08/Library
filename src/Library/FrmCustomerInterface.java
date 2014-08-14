package Library;

import javax.swing.*;
import java.awt.event.*;

/**
 * Frame to guide customer
 * @author Run Yan
 * add 8/12/2014
 */

@SuppressWarnings("serial")
public class FrmCustomerInterface extends JFrame{
	private JFrame frmJf;
	private JButton btnBorrow, btnReturn, btnClose;
	private Library library;
	private User user;
	FrmCustomerInterface(){
		this(null, null);
	}
	FrmCustomerInterface(Library l, User u){
		this.library = l;
		this.user = u;
		frmJf = new JFrame("Customer Interface");
		frmJf.setLocation(350, 50);
		btnBorrow = new JButton("Borrow Book");
		btnBorrow.setBounds(20, 20, 130, 30);
		btnReturn = new JButton("Return Book");
		btnReturn.setBounds(230, 20, 130, 30);
		btnClose = new JButton("Close");
		btnClose.setBounds(125, 80, 130, 30);
		frmJf.setLayout(null);
		frmJf.add(btnBorrow);
		frmJf.add(btnReturn);
		frmJf.add(btnClose);
		frmJf.setSize(400, 200);
		frmJf.setResizable(false);
		frmJf.setVisible(true);
		btnReturn.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				frmJf.setVisible(false);
				new FrmCustomerReturnBook(library, user);
			}
		});
		btnClose.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				frmJf.setVisible(false);
				new FrmCustomerLogin(library, user);
			}
		});
		btnBorrow.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				frmJf.setVisible(false);
				new FrmBorrowBook(library, user);
			}
		});
	}
	public static void main(String[] args){
		new FrmCustomerInterface();
	}
}
