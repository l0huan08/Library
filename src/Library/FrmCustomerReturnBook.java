package Library;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

/**
 * @author Run Yan
 * add 8/12/2014
 */

@SuppressWarnings("serial")
public class FrmCustomerReturnBook extends JFrame{
	private final String[] tbBookColumnTitle = {"isbn", "name"};
	private JFrame frmJf;
	private JLabel lblMsg;
	private JButton btnReturn, btnClose;
	private JTable tblBooks;
	private JPanel pnlLeft, pnlRight;
	private PanelBookInfo pnlBookInfo;
	private DefaultTableModel tbBooksModel;
	
	FrmCustomerReturnBook(){
		frmJf = new JFrame();
		frmJf.setLayout(null);
		frmJf.setLocation(350, 50);
		pnlLeft = new JPanel();
		pnlRight = new JPanel();
		pnlBookInfo = new PanelBookInfo();
		pnlLeft.setLayout(null);
		lblMsg = new JLabel();
		lblMsg.setText("Rented Books:");
		lblMsg.setBounds(20, 20, 90, 10);
		btnReturn = new JButton("Return");
		btnReturn.setBounds(80, 400, 75, 30);
		btnClose = new JButton("Close");
		btnClose.setBounds(220, 400, 75, 30);
		tblBooks = new JTable();
		tblBooks.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblBooks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbBooksModel = new DefaultTableModel(
				new Object[][] {
				},
				tbBookColumnTitle
		);
		tblBooks.setModel(tbBooksModel);
		tblBooks.setBounds(20, 35, 1000, 330);
		pnlLeft.add(lblMsg);
		pnlLeft.add(tblBooks);
		pnlLeft.add(btnReturn);
		pnlLeft.add(btnClose);
		pnlLeft.setSize(600, 500);
		pnlLeft.setBounds(5, 5, 400, 600);
		pnlRight.setSize(500, 500);
		pnlRight.setBounds(450, 20, 400, 400);
		pnlRight.setLayout(new BorderLayout());
		pnlRight.add(pnlBookInfo,BorderLayout.CENTER);
		frmJf.setTitle("Return Book");
		frmJf.add(pnlLeft);
		frmJf.add(pnlRight);
		frmJf.setSize(900, 500);
		frmJf.setResizable(false);
		frmJf.setVisible(true);
		btnClose.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				frmJf.setVisible(false);
				new FrmCustomerLogin();
			}
		});
	}
	public static void main(String[] args){
		new FrmCustomerReturnBook();
	}
}
