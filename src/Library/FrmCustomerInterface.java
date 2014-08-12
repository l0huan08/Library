package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrmCustomerInterface {
	private JFrame jf;
	private JButton Borrow, Return, Close;
	FrmCustomerInterface(){
		jf = new JFrame("Customer Interface");
		Borrow = new JButton("Borrow Book");
		Return = new JButton("Return Book");
		Close = new JButton("Close");
		jf.add(Borrow);
		jf.add(Return);
		jf.add(Close);
		jf.setSize(300, 150);
		jf.setLayout(new FlowLayout());
		jf.setVisible(true);
		Close.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				jf.setVisible(false);
			}
		});
	}
	public static void main(String[] args){
		new FrmCustomerInterface();
	}
}
