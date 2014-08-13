package Library;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * @author Run Yan
 * add 8/12/2014
 */

@SuppressWarnings("serial")
public class FrmCustomerReturnBook extends JFrame{
	private final int N_Book_Table_Columns = 2;
	private final String[] tbBookColumnTitle = {"isbn", "name"};
	private Library library;
	private User user;
	private JFrame frmJf;
	private JLabel lblMsg;
	private JButton btnReturn, btnClose;
	private JTable tblBooks;
	private JPanel pnlLeft, pnlRight;
	private PanelBookInfo pnlBookInfo;
	private DefaultTableModel tbBooksModel;
	
	FrmCustomerReturnBook(Library l, User u){
		this();
		this.library = l;
		this.user = u;
	}
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
		tblBooks = new JTable(null,tbBookColumnTitle);
		tblBooks.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblBooks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbBooksModel = new DefaultTableModel(
				new Object[][] {
				},
				tbBookColumnTitle
		);
		tblBooks.setModel(tbBooksModel);
		tblBooks.setBounds(20, 35, 380, 330);
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
		btnReturn.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me){
				//new DlgCustomerReturnBookFinish();
				double fine = 20;
				new DlgCustomerReturnBookFinish(fine);
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
	private void refreshTable(){
		int n = tbBooksModel.getRowCount();
		for(int i = 0;i < n;i++){
			tbBooksModel.removeRow(0);
		}
		Object[][] data = getRentedBookTableData();
		this.tbBooksModel.addRow(data);;
	}
	private void returnBook(){
		int columns = tblBooks.getColumnCount();
		
	}
	private Object[] createBookTableRowData(Book book){
		Object[] row = new Object[N_Book_Table_Columns];
		row[0] = book.getIsbn();
		row[1] = book.getBookName();
		return row;
	}
	private Object[][] getRentedBookTableData(){
		if(this.library == null){
			return null;
		} else{
			if(this.user == null){
				return null;
			} else{
				ArrayList<Book> books = library.showBookList_BorrowedByCustomer(user.getUserId());
				int nBooks = books.size();
				Object[][] booksData = new Object[nBooks][];
				for(int i = 0;i < nBooks;i++){
					booksData[i] = createBookTableRowData(books.get(i));
				}
				return booksData;
			}
		}
	}
	public static void main(String[] args){
		FrmCustomerReturnBook Return = new FrmCustomerReturnBook();
		//Return.tblBooks = new JTable(null, tbBookColumnTitle);
	}
}
