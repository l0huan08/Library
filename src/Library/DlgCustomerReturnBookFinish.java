package Library;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.*;

/**
 * The message shown to the customer when the customer complete return books.
 * @author Run Yan
 * add 8/12/2014
*/

public class DlgCustomerReturnBookFinish extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnOK;
	private JLabel lblMsg, lblFine;
	
	DlgCustomerReturnBookFinish(){

	}
	
	DlgCustomerReturnBookFinish(double fine){
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(350, 50);
		
		btnOK = new JButton("OK");
		btnOK.setBounds(195, 100, 60, 30);
		
		lblMsg = new JLabel();
		lblFine = new JLabel();
		
		this.setLayout(null);
		this.add(lblMsg);
		this.add(lblFine);
		this.add(btnOK);
		this.setTitle("Book Returned");
		this.setSize(450,210);
		this.setResizable(false);
		
		lblMsg.setBounds(115, 20, 220, 20);
		lblMsg.setText("Book Returned!");
		lblMsg.setFont(new Font("Arial", Font.BOLD, 28));
		
		if(fine != 0){
			lblFine.setText("Please pay late fee: $" + new DecimalFormat("#.00").format(fine) + ".");
		} else{
			lblFine.setText("");
		}
		
		lblFine.setBounds(70, 50, 500, 30);
		lblFine.setFont(new Font("Arial", Font.PLAIN, 24));
		lblFine.setForeground(Color.red);
		
		btnOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				DlgCustomerReturnBookFinish.this.dispose();
			}
		});
	}
}
