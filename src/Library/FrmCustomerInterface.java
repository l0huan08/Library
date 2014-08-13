package Library;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author Run Yan
 * add 8/12/2014
 */

@SuppressWarnings("serial")
public class FrmCustomerInterface extends JFrame{
	private JFrame frmJf;
	private JButton btnBorrow, btnReturn, btnClose;
	FrmCustomerInterface(){
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
				new FrmCustomerReturnBook();
			}
		});
		btnClose.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				frmJf.setVisible(false);
				new FrmCustomerLogin();
			}
		});
	}
	public static void main(String[] args){
		new FrmCustomerInterface();
	}
}
