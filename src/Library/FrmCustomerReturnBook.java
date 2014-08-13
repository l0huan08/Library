package Library;

import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class FrmCustomerReturnBook extends JFrame{
	private JFrame jf;
	private JLabel msg;
	private JButton Return, close;
	private JTable books;
	FrmCustomerReturnBook(){
		jf = new JFrame();
		jf.setLayout(null);
		jf.setLocation(350, 50);
		msg = new JLabel();
		msg.setText("Rented Books");
		msg.setBounds(20, 20, 80, 10);
		Return = new JButton("Return");
		Return.setBounds(60, 550, 75, 30);
		close = new JButton("Close");
		close.setBounds(180, 550, 75, 30);
		books = new JTable();
		books.setBounds(20, 35, 300, 500);
		jf.add(msg);
		jf.add(books);
		jf.add(Return);
		jf.add(close);
		jf.setTitle("Return Book");
		jf.setSize(650, 650);
		jf.setResizable(false);
		jf.setVisible(true);
		close.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				jf.setVisible(false);
				new FrmCustomerLogin();
			}
		});
	}
	public static void main(String[] args){
		new FrmCustomerReturnBook();
	}
}
