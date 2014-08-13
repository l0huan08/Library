//TODO: borrow book table, when select one row, update the book's info to the right part
//Click "Close" this frame close
//Click "Borrow" show FrmBookBorrowFinish window
package Library;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import java.awt.event.*;

import javax.swing.GroupLayout.*;
import javax.swing.LayoutStyle.*;

import java.util.*;
import java.util.List;


/**
 * Borrow Books Frame
 * @author Li Huang
 * add: 2014/8/12
 */
public class FrmBorrowBook extends JFrame {

	private enum BookViewType {
		New,
		Available,
		All,
	}
	private final int N_Book_Table_Columns = 3;
	private final String[] TBBookColumnTitle = {"isbn", "name","bookObj"};
	private final int TBBook_IsbnColIndex=0; //the column index of the book table
	private final int TBBook_BookObjColIndex=2; //the column index of the book table
	private final String Msg_PleaseSelectedABookToBorrow="Please select a book to borrow!";
	
	
	private Library library;
	private User customer;
	
	private boolean isResponseTbBooksSelecetedChanged=true;
	
	private JPanel contentPane;
	private JPanel pnlLeft;
	private JPanel pnlBooks;
	private JRadioButton rdNew;
	private JRadioButton rdAvailable;
	private JRadioButton rdAll;
	private ButtonGroup btngrpViewBooks;
	private JButton btnView;
	private JPanel pnlNewBookCategory;
	private JCheckBox chkChildren;
	private JCheckBox chkCooking;
	private JCheckBox chkHistory;
	private JCheckBox chkTravel;
	private PanelBookInfo pnlBookInfo;
	private JButton btnBorrow;
	private JButton btnClose;
	
	private JTable tbBooks;
	private DefaultTableModel tbBooksModel;
	
	
	/**
	 * Test
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Library lib=new Library();
//					Book b1 = new Book();
//					Book b2 = new Book();
//					
//					b1.setIsbn("111");
//					b1.setBookName("book1");
//					b1.setCategory(Category.HISTORY);
//					
//					b2.setIsbn("222");
//					b2.setBookName("book2");
//					b2.setCategory(Category.COOKING);
//					
//					lib.addBook(b1);
//					lib.addBook(b2);
//					
//					User u1 = new User();
//					u1.setUserName("huangli");
//					u1.setUserId(123);
//					
//					FrmBorrowBook frame = new FrmBorrowBook(lib,u1);
//					
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FrmBorrowBook(Library library, User customer) {
		this.library=library;
		this.customer=customer;
		
		setTitle("Borrow Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		pnlLeft = new JPanel();
		contentPane.add(pnlLeft);
		
		pnlBooks = new JPanel();
		pnlBooks.setBorder(new TitledBorder(null, "Books", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		rdNew = new JRadioButton("New");
		pnlBooks.add(rdNew);
		
		rdAvailable = new JRadioButton("Available");
		pnlBooks.add(rdAvailable);
		
		rdAll = new JRadioButton("All");
		rdAll.setSelected(true);
		pnlBooks.add(rdAll);
		
		btngrpViewBooks = new ButtonGroup();
		btngrpViewBooks.add(rdNew);
		btngrpViewBooks.add(rdAvailable);
		btngrpViewBooks.add(rdAll);
		
		pnlNewBookCategory = new JPanel();
		pnlNewBookCategory.setBorder(new TitledBorder(null, "New Book Subscribed Category", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlNewBookCategory.setLayout(new GridLayout(2, 2, 0, 0));
		
		chkChildren = new JCheckBox("Children");
		pnlNewBookCategory.add(chkChildren);
		
		chkCooking = new JCheckBox("Cooking");
		pnlNewBookCategory.add(chkCooking);
		
		chkHistory = new JCheckBox("History");
		pnlNewBookCategory.add(chkHistory);
		
		chkTravel = new JCheckBox("Travel");
		pnlNewBookCategory.add(chkTravel);
		

		tbBooksModel = new DefaultTableModel(
				new Object[][] { {"huangli","example",new Book()},
						{"haha","ex2",new Book()}
				},
				TBBookColumnTitle
		);
		
		
		tbBooks = new JTable();
		tbBooks.setBorder(new LineBorder(new Color(0, 0, 0)));
		tbBooks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbBooks.setModel(tbBooksModel);
		
		btnView = new JButton("View");
		
		GroupLayout gl_pnlLeft = new GroupLayout(pnlLeft);
		gl_pnlLeft.setHorizontalGroup(
			gl_pnlLeft.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlLeft.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlLeft.createParallelGroup(Alignment.LEADING)
						.addComponent(tbBooks, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
						.addComponent(pnlBooks, 0, 0, Short.MAX_VALUE)
						.addGroup(gl_pnlLeft.createSequentialGroup()
							.addComponent(pnlNewBookCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(btnView)))
					.addContainerGap())
		);
		gl_pnlLeft.setVerticalGroup(
			gl_pnlLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLeft.createSequentialGroup()
					.addComponent(pnlBooks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_pnlLeft.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlLeft.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnlNewBookCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlLeft.createSequentialGroup()
							.addGap(28)
							.addComponent(btnView)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tbBooks, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlLeft.setLayout(gl_pnlLeft);
		
		JPanel pnlRight = new JPanel();
		contentPane.add(pnlRight);
		pnlRight.setLayout(new BorderLayout(0, 0));
		
		//--------------- add by Huang Li ----------------
		pnlBookInfo = new PanelBookInfo(this.library);
		pnlBookInfo.setEditable(false);
		pnlRight.add(pnlBookInfo,BorderLayout.CENTER);
		//------------------------------------------------
		
		JPanel pnlBorrowCloseBtns = new JPanel();
		pnlRight.add(pnlBorrowCloseBtns, BorderLayout.SOUTH);
		
		btnBorrow = new JButton("Borrow");
		pnlBorrowCloseBtns.add(btnBorrow);
		
		btnClose = new JButton("Close");
		pnlBorrowCloseBtns.add(btnClose);
		
		
		//---------------- Event Handlers -------------------------
		///btnView
		this.btnView.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				refreshBookTableUI();
			}
			
		});
		
		///tbBooks
		SelectionListener listener = new SelectionListener(tbBooks);
		tbBooks.getSelectionModel().addListSelectionListener(listener);
		
		///btnClose
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrmBorrowBook.this.dispose();
			}	
		});
		
		///btnBorrow
		btnBorrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (FrmBorrowBook.this.library==null)
					return;
				
				//Borrow  selected book 
				Book book = getSelectedBook();
				if (book==null) {
					JOptionPane.showMessageDialog(null, Msg_PleaseSelectedABookToBorrow);
					return;
				}
				
				boolean suc = FrmBorrowBook.this.library.rentBook(FrmBorrowBook.this.customer.getUserId(), book.getIsbn());
				DlgBorrowBookFinish dlgBorrowFinish = new DlgBorrowBookFinish(suc,book);
				dlgBorrowFinish.setVisible(true);
				FrmBorrowBook.this.refreshBookTableUI();
			}	
		});
		
	}
	
	public FrmBorrowBook(){
		this(null,null);
	}
	
	/**
	 * Set whether will the TbBooksSelectedChanged envent handler will be triggered
	 */
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
        
        @Override
        public void valueChanged(ListSelectionEvent e) {
            	//if (e.getSource() == table.getColumnModel().getSelectionModel() ){
                //&& table.getColumnSelectionAllowed() ){
        	
        		if (!getResponseTbBooksSelectedChanged()) {
        			return;
        		}
        		
                //Event handling
                Book book = getSelectedBook();
                pnlBookInfo.ReadFrom(book);
            }
        //} //if
        
    }
	
	
	/**
	 * Get current selected book
	 * @return current selected book in the Book Table,if no book is selected, return null
	 */
	private Book getSelectedBook() {
		JTable table = this.tbBooks;
		int selRow = table.getSelectedRow();
        //String isbn = (String)table.getValueAt(selRow, TBBook_IsbnColIndex);
        Book book = (Book)table.getValueAt(selRow, TBBook_BookObjColIndex);
        return book;
	}
	
	/**
	 * Fill the table with books according to the UI options
	 */
	private void refreshBookTableUI() {

		BookViewType viewType = BookViewType.All;
		
		if (this.rdAll.isSelected()) {
			viewType=BookViewType.All;
		} else if (this.rdAvailable.isSelected()) {
			viewType=BookViewType.Available;
		} else if (this.rdNew.isSelected()) {
			viewType=BookViewType.New;
		}
		
		ArrayList<Category> subscribeCategories = new ArrayList<Category>();
		if (this.chkChildren.isSelected()){
			subscribeCategories.add(Category.CHILDREN);
		}
		if (this.chkCooking.isSelected()){
			subscribeCategories.add(Category.COOKING);
		}
		if (this.chkHistory.isSelected()){
			subscribeCategories.add(Category.HISTORY);
		}
		if (this.chkTravel.isSelected()){
			subscribeCategories.add(Category.TRAVEL);
		}
		
		Category[] categories = subscribeCategories.toArray(new Category[0]);
		
		this.setResponseTbBooksSelectedChanged(false);
		this.pnlBookInfo.clear();
		refreshBookTable(viewType,categories);
		this.setResponseTbBooksSelectedChanged(true);
		
	}
	
	private void refreshBookTable(BookViewType viewType,Category[] subscribeNewBookCategories) {
		// clear the table
		int n = tbBooksModel.getRowCount();
		for (int i=0;i<n;i++)
			tbBooksModel.removeRow(0);
		
		Object[][] data = null;
		
		switch (viewType)
		{
		case New:
			data = getNewBookTableData(subscribeNewBookCategories);
			break;
		case Available:
			data = getAvailableBookTableData();
			break;
		case All:
			data = getAllBookTableData();
			break;
		}
		
		int nDataRows = data.length;
		for (int i=0;i<nDataRows;i++){
			this.tbBooksModel.addRow(data[i]);
		}
	}
	

	
	private Object[] createBookTableRowData(Book book) {
		Object[] row = new Object[N_Book_Table_Columns];
		row[0]=book.getIsbn();
		row[1]=book.getBookName();
		row[2]=book;
		return row;
	}
	
	private Object[][] getAvailableBookTableData() {
		if (this.library==null)
			return null;
		else {
			List<Book> books =library.showBookList_remainder();
			int nBooks = books.size();//number of books
			Object[][] booksData = new Object[nBooks][];
			for (int i=0;i<nBooks;i++) {
				booksData[i]=createBookTableRowData(books.get(i));
			}

			return booksData;
		}
	}
	
	private Object[][] getNewBookTableData(Category[] subScribeCategories) {
		if (this.library==null)
			return null;
		else {
			List<Book> books =library.showBookList_new(subScribeCategories);
			int nBooks = books.size();//number of books
			Object[][] booksData = new Object[nBooks][];
			for (int i=0;i<nBooks;i++) {
				booksData[i]=createBookTableRowData(books.get(i));
			}

			return booksData;
		}
	}
	
	private Object[][] getAllBookTableData() {
		if (this.library==null)
			return null;
		else {
			List<Book> books =library.showBookList_all();
			int nBooks = books.size();//number of books
			Object[][] booksData = new Object[nBooks][];
			for (int i=0;i<nBooks;i++) {
				booksData[i]=createBookTableRowData(books.get(i));
			}

			return booksData;
		}
	}

	
}
