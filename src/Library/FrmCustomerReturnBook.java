package Library;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
	private final String[] TBBookColumnTitle = {"isbn", "name","bookObj"};
	private boolean isResponseTbBooksSelecetedChanged = true;
	private final int N_Book_Table_Columns = 2;
	private final int TBBook_IsbnColIndex=0; //the column index of the book table
	private final int TBBook_BookObjColIndex=2; //the column index of the book table
	private Library library;
	private User user;
	private JFrame frmJf;
	private JLabel lblMsg;
	private JButton btnReturn, btnClose;
	private JTable tbBooks;
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
		tbBooksModel = new DefaultTableModel(
				new Object[][] { {"huangli","example",new Book()},
						{"haha","ex2",new Book()}
				},
				TBBookColumnTitle
		);
		tbBooks = new JTable();
		tbBooks.setModel(tbBooksModel);
		tbBooks.setBorder(new LineBorder(new Color(0, 0, 0)));
		tbBooks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbBooks.setBounds(20, 35, 380, 330);
		SelectionListener listener = new SelectionListener(tbBooks);
		tbBooks.getSelectionModel().addListSelectionListener(listener);
		pnlLeft.add(lblMsg);
		pnlLeft.add(tbBooks);
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
				double fine = 0;
				new DlgCustomerReturnBookFinish(fine);
				//library.returnBook(getISBN());
				refreshTable();
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
	private String getISBN(){
		int row = tbBooks.getSelectedRow();
		String isbn = (String)tbBooksModel.getValueAt(row, 1);
		return isbn;
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
	private Book getSelectedBook() {
		JTable table = this.tbBooks;
		int selRow = table.getSelectedRow();
        //String isbn = (String)table.getValueAt(selRow, TBBook_IsbnColIndex);
        Book book = (Book)table.getValueAt(selRow, TBBook_BookObjColIndex);
        return book;
	}
	private void setResponseTbBooksSelectedChanged(boolean enable) {
		isResponseTbBooksSelecetedChanged = enable;
	}
	
	private boolean getResponseTbBooksSelectedChanged() {
		return isResponseTbBooksSelecetedChanged;
	}
	private class SelectionListener implements ListSelectionListener {
        JTable table;

        SelectionListener(JTable table) {
            this.table = table;
        }
   
        public void valueChanged(ListSelectionEvent e) {
        		if (!getResponseTbBooksSelectedChanged()) {
        			return;
        		}
        		
                
                Book book = getSelectedBook();
                pnlBookInfo.ReadFrom(book);
            }
    }
	public static void main(String[] args){
		Library lib=new Library();
		Book b1 = new Book();
		Book b2 = new Book();
		b1.setIsbn("111");
		b1.setBookName("book1");
		b1.setCategory(Category.HISTORY);
		b2.setIsbn("222");
		b2.setBookName("book2");
		b2.setCategory(Category.COOKING);
		lib.addBook(b1);
		lib.addBook(b2);
		User u1 = new User();
		u1.setUserName("huangli");
		u1.setUserId(123);
		new FrmCustomerReturnBook(lib, u1);
	}
}
