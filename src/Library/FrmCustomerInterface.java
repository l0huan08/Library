package Library;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class FrmCustomerInterface extends JFrame{
	private JFrame jf;
	private JButton Borrow, Return, Close;
	FrmCustomerInterface(){
		jf = new JFrame("Customer Interface");
		Borrow = new JButton("Borrow Book");
		Borrow.setBounds(20, 20, 130, 30);
		Return = new JButton("Return Book");
		Return.setBounds(230, 20, 130, 30);
		Close = new JButton("Close");
		Close.setBounds(125, 80, 130, 30);
		jf.setLayout(null);
		jf.add(Borrow);
		jf.add(Return);
		jf.add(Close);
		jf.setSize(400, 200);
		jf.setResizable(false);
		jf.setVisible(true);
		Return.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				jf.setVisible(false);
				new FrmCustomerReturnBook();
			}
		});
		Close.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				jf.setVisible(false);
				new FrmCustomerLogin();
			}
		});
	}
	public static void main(String[] args){
		new FrmCustomerInterface();
	}
}
