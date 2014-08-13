package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.util.List;

import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelListener;

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
	private final int N_Book_Table_Columns = 2;
	private final String[] tbBookColumnTitle = {"isbn", "name"};
	
	private Library library;
	private User customer;
	
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
	
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmBorrowBook frame = new FrmBorrowBook();
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
	public FrmBorrowBook() {
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
		pnlBooks.add(rdAll);
		
		btngrpViewBooks = new ButtonGroup();
		btngrpViewBooks.add(rdNew);
		btngrpViewBooks.add(rdAvailable);
		btngrpViewBooks.add(rdAll);
		
		btnView = new JButton("View");
		pnlBooks.add(btnView);
		
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
				new Object[][] {
				},
				tbBookColumnTitle
		);
		
		
		tbBooks = new JTable();
		tbBooks.setBorder(new LineBorder(new Color(0, 0, 0)));
		tbBooks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbBooks.setModel(tbBooksModel);
		
		GroupLayout gl_pnlLeft = new GroupLayout(pnlLeft);
		gl_pnlLeft.setHorizontalGroup(
			gl_pnlLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlLeft.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlLeft.createParallelGroup(Alignment.TRAILING)
						.addComponent(tbBooks, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
						.addComponent(pnlBooks, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(pnlNewBookCategory, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_pnlLeft.setVerticalGroup(
			gl_pnlLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLeft.createSequentialGroup()
					.addComponent(pnlBooks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlNewBookCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tbBooks, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlLeft.setLayout(gl_pnlLeft);
		
		JPanel pnlRight = new JPanel();
		contentPane.add(pnlRight);
		pnlRight.setLayout(new BorderLayout(0, 0));
		
		//--------------- add by Huang Li ----------------
		pnlBookInfo = new PanelBookInfo();
		pnlRight.add(pnlBookInfo,BorderLayout.CENTER);
		//------------------------------------------------
		
		JPanel pnlBorrowCloseBtns = new JPanel();
		pnlRight.add(pnlBorrowCloseBtns, BorderLayout.SOUTH);
		
		btnBorrow = new JButton("Borrow");
		pnlBorrowCloseBtns.add(btnBorrow);
		
		btnClose = new JButton("Close");
		pnlBorrowCloseBtns.add(btnClose);
	}
	
	public FrmBorrowBook(Library library, User customer){
		this();
		this.library=library;
		this.customer=customer;
	}
	
	private void refreshBookTable(BookViewType viewType,Category[] subScribeCategories) {
		// clear the table
		int n = tbBooksModel.getRowCount();
		for (int i=0;i<n;i++)
			tbBooksModel.removeRow(0);
		
		Object[][] data = null;
		
		switch (viewType)
		{
		case New:
			data = getNewBookTableData(subScribeCategories);
			break;
		case Available:
			data = getAvailableBookTableData();
			break;
		case All:
			data = getAllBookTableData();
			break;
		}
		
		this.tbBooksModel.addRow(data);
	}
	

	
	private Object[] createBookTableRowData(Book book) {
		Object[] row = new Object[N_Book_Table_Columns];
		row[0]=book.getIsbn();
		row[1]=book.getBookName();
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
		//TODO: need library.getNewBooks(Category[] subScribeCategories) method.
		
		
		return null;
//		if (this.library==null)
//			return null;
//		else {
//			List<Book> books =library.();
//			int nBooks = books.size();//number of books
//			Object[][] booksData = new Object[nBooks][];
//			for (int i=0;i<nBooks;i++) {
//				booksData[i]=createBookTableRowData(books.get(i));
//			}
//
//			return booksData;
//		}
	}
	
	private Object[][] getAllBookTableData() {
		if (this.library==null)
			return null;
		else {
			List<Book> books =library.getBorrowedBooks(customer.getUserId());
			int nBooks = books.size();//number of books
			Object[][] booksData = new Object[nBooks][];
			for (int i=0;i<nBooks;i++) {
				booksData[i]=createBookTableRowData(books.get(i));
			}

			return booksData;
		}
	}
}

class BookTableModel implements TableModel {

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
}
