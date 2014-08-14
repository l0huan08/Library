package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The message shown to the customer when the customer complete return books.
 * @author Run Yan
 * add 8/12/2014
*/
@SuppressWarnings("serial")
public class DlgCustomerReturnBookFinish extends JFrame{
	private JDialog dlgJd;
	private JButton btnOK;
	private JLabel lblMsg, lblFine;
	DlgCustomerReturnBookFinish(){

	}
	DlgCustomerReturnBookFinish(double fine){
		dlgJd = new JDialog();
		dlgJd.setLocation(350, 50);
		btnOK = new JButton("OK");
		lblMsg = new JLabel();
		lblFine = new JLabel();
		dlgJd.setLayout(null);
		dlgJd.add(lblMsg);
		dlgJd.add(lblFine);
		lblMsg.setBounds(115, 20, 220, 20);
		lblMsg.setText("Book Returned!");
		lblMsg.setFont(new Font("Arial", Font.BOLD, 28));
		if(fine != 0){
			lblFine.setText("Please pay late fee: $" + fine);
		} else{
			lblFine.setText("");
		}
		lblFine.setBounds(70, 50, 300, 30);
		lblFine.setFont(new Font("Arial", Font.PLAIN, 24));
		lblFine.setForeground(Color.red);
		dlgJd.add(btnOK);
		btnOK.setBounds(195, 100, 60, 30);
		dlgJd.setTitle("Book Returned");
		dlgJd.setSize(450,210);
		dlgJd.setResizable(false);
		dlgJd.setVisible(true);
		btnOK.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
				dlgJd.setVisible(false);
			}
		});
	}
	public static void main(String[] args){
		new DlgCustomerReturnBookFinish();
	}
}
