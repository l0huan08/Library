package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class DlgCustomerReturnBookFinish extends JFrame{
	private JDialog jd;
	private JButton OK;
	private JLabel msg, fine;
	DlgCustomerReturnBookFinish(){
		jd = new JDialog();
		jd.setLocation(350, 50);
		OK = new JButton("OK");
		msg = new JLabel();
		fine = new JLabel();
		jd.setLayout(null);
		jd.add(msg);
		msg.setBounds(115, 10, 220, 20);
		msg.setText("Book Returned!");
		msg.setFont(new Font("Arial", Font.BOLD, 28));
		jd.add(fine);
		fine.setBounds(70, 40, 300, 30);
		fine.setText("Please pay late fee: $99.99");
		fine.setFont(new Font("Arial", Font.PLAIN, 24));
		fine.setForeground(Color.red);
		jd.add(OK);
		OK.setBounds(195, 100, 60, 30);
		jd.setTitle("Book Returned");
		jd.setSize(450,210);
		jd.setResizable(false);
		jd.setVisible(true);
		OK.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
				jd.setVisible(false);
			}
		});
	}
	public static void main(String[] args){
		new DlgCustomerReturnBookFinish();
	}
}
