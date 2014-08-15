package Library;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*; //javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.io.*;
import java.util.*;
import java.util.List;

//Joe, Books Management Frame, Including Adding Updating and Deleting. 
//		Also leads to books report Frame (Rented, In Library and Overdue)

public class FrmBooksManagement extends JFrame {
	private Library library;

	private int row;

	private final String[] cb_Status = { "Rented", "Not rented" };
	private JComboBox tStatus = new JComboBox(cb_Status);

	private JLabel lStatus;
	JLabel lISBN;
	JTextField tISBN;
	JLabel lName;
	JTextField tName;
	JLabel lAuthor;
	JTextField tAuthor;
	JTable table;
	DefaultTableModel dtm;
	JButton btnAdd;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnClose;
	JButton btnRented;
	JButton btnNotRented;
	JButton btnOverDue;
	JButton btnRefresh;
	
	public void Refresh(){
		int j = table.getRowCount();
		for (int i = 0; i < j; i++) {
			dtm.removeRow(0);
		}
		ArrayList<Book> books = FrmBooksManagement.this.library
				.showBookList_all();
		int nBook = books.size();

		for (int i = 0; i < nBook; i++) {
			dtm.addRow(createBookTableRowData(books.get(i)));
		}
	}
	
	public FrmBooksManagement(Library lib) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.library = lib;

		// In the Requirement Document, Administrator is supposed to notify all
		// the customers about the new books arriving.
		// In this Frame, there is no certain button does that. Instead, as soon
		// as a new book is added, all customers would
		// be able to see the new added books from book list while they are
		// trying rent new ones.

		this.setSize(1000, 800);
		this.setLocation(250, 40);
		this.setVisible(true);
		this.setTitle("Books Management");
		this.setLayout(null);

		Object rowData[][] = getAllBookTableData(lib);

		String columnNames[] = { "bookName", "author", "isbn", "lastRented",
				"AddedDate", "isRented", "ownerId", "category" };

		dtm = new DefaultTableModel(rowData, columnNames);
		table = new JTable(dtm);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 50, 600, 400);
		this.add(scrollPane);

		btnAdd = new JButton("Add");
		btnAdd.setVisible(true);
		btnAdd.setBounds(110, 520, 120, 30);
		this.add(btnAdd);

		btnUpdate = new JButton("Update");
		btnUpdate.setVisible(true);
		btnUpdate.setBounds(250, 520, 120, 30);
		this.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.setVisible(true);
		btnDelete.setBounds(390, 520, 120, 30);
		this.add(btnDelete);

		btnClose = new JButton("Close");
		btnClose.setVisible(true);
		btnClose.setBounds(880, 620, 100, 30);
		this.add(btnClose);
		
		btnRented = new JButton("Rented");
		btnRented.setVisible(true);
		btnRented.setBounds(110, 15, 120, 30);
		this.add(btnRented);
		
		btnNotRented = new JButton("Not Rented");
		btnNotRented.setVisible(true);
		btnNotRented.setBounds(270, 15, 120, 30);
		this.add(btnNotRented);
		
		btnOverDue = new JButton("OverDue");
		btnOverDue.setVisible(true);
		btnOverDue.setBounds(430, 15, 120, 30);
		this.add(btnOverDue);

		lStatus = new JLabel();
		lStatus.setVisible(true);
		lStatus.setText("Status:");
		lStatus.setBounds(705, 103, 50, 25);
		this.add(lStatus);

		tStatus.setVisible(true);
		tStatus.setBounds(750, 100, 200, 25);
		this.add(tStatus);

		lISBN = new JLabel();
		lISBN.setVisible(true);
		lISBN.setText("ISBN:");
		lISBN.setBounds(709, 143, 50, 25);
		this.add(lISBN);

		tISBN = new JTextField();
		tISBN.setVisible(true);
		tISBN.setBounds(750, 140, 200, 25);
		this.add(tISBN);

		lName = new JLabel();
		lName.setVisible(true);
		lName.setText("Book Name:");
		lName.setBounds(675, 182, 70, 30);
		this.add(lName);

		tName = new JTextField();
		tName.setVisible(true);
		tName.setBounds(750, 180, 200, 25);
		this.add(tName);

		lAuthor = new JLabel();
		lAuthor.setVisible(true);
		lAuthor.setText("Author Name:");
		lAuthor.setBounds(665, 222, 80, 25);
		this.add(lAuthor);

		tAuthor = new JTextField();
		tAuthor.setVisible(true);
		tAuthor.setBounds(750, 220, 200, 25);
		this.add(tAuthor);
		
		SelectionListener listener = new SelectionListener(table);
		table.getSelectionModel().addListSelectionListener(listener);

		btnClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				FrmBooksManagement.this.setVisible(false);

			}
		});

		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DlgAddBooks n = new DlgAddBooks(FrmBooksManagement.this.library);
				n.setModal(true);
				n.setVisible(true); 
				Refresh();
			}
		});

		btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				FrmBooksManagement.this.library.deleteBook(table.getValueAt(
						row, 2).toString());
				Refresh();
			}
		});

		btnRefresh = new JButton("Refresh");
		btnRefresh.setVisible(true);
		btnRefresh.setBounds(250, 470, 120, 30);
		this.add(btnRefresh);
		
		

		btnRefresh.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int j = table.getRowCount();
				for (int i = 0; i < j; i++) {
					dtm.removeRow(0);
				}
				ArrayList<Book> books = FrmBooksManagement.this.library
						.showBookList_all();
				int nBook = books.size();

				for (int i = 0; i < nBook; i++) {
					dtm.addRow(createBookTableRowData(books.get(i)));
				}
			}
		});
		

		
		btnRented.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int j = table.getRowCount();
				for (int i = 0; i < j; i++) {
					dtm.removeRow(0);
				}
				ArrayList<Book> books = FrmBooksManagement.this.library
						.showBookList_all();
				int nBook = books.size();

				for (int i = 0; i < nBook; i++) {
					if(!books.get(i).isRented()){continue;}
					dtm.addRow(createBookTableRowData(books.get(i)));
				}
			}
		});		
		
		btnNotRented.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int j = table.getRowCount();
				for (int i = 0; i < j; i++) {
					dtm.removeRow(0);
				}
				ArrayList<Book> books = FrmBooksManagement.this.library
						.showBookList_all();
				int nBook = books.size();

				for (int i = 0; i < nBook; i++) {
					if(books.get(i).isRented()){continue;}
					dtm.addRow(createBookTableRowData(books.get(i)));
				}
			}
			
		});
		
		btnOverDue.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int j = table.getRowCount();
				for (int i = 0; i < j; i++) {
					dtm.removeRow(0);
				}
				ArrayList<Book> books = FrmBooksManagement.this.library
						.showBookList_all();
				int nBook = books.size();
				int o_size = library.showBookList_overdue().size();
				for (int i = 0; i < o_size; i++) {
//					if(books.get(i).isRented()){continue;}
					dtm.addRow(createBookTableRowData(library.showBookList_overdue().get(i)));
				}
			}
		});

		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String oldISBN = table.getValueAt(row, 2).toString();
				Book tempBook = FrmBooksManagement.this.library
						.getBookByISBN(oldISBN);
				tempBook.setBookName(tName.getText());
				tempBook.setAuthor(tAuthor.getText());
				tempBook.setIsbn(tISBN.getText());
				tempBook.setRented(tStatus.getSelectedIndex() == 0 ? true
						: false);
				if (tempBook.isRented()) {
					table.setValueAt("1", row, 6);
					table.setValueAt("true", row, 5);
					tempBook.setOwnerId(1);
				} else {
					table.setValueAt("0", row, 6);
					table.setValueAt("false", row, 5);
					tempBook.setOwnerId(0);
				}
				FrmBooksManagement.this.library.updateBook(oldISBN, tempBook);
				Refresh();
			}
		});

	}

	private Object[][] getAllBookTableData(Library library) {
		if (library == null)
			return null;
		else {
			List<Book> books = library.showBookList_all();
			int nBooks = books.size();// number of books
			Object[][] booksData = new Object[nBooks][];
			for (int i = 0; i < nBooks; i++) {
				booksData[i] = createBookTableRowData(books.get(i));
			}

			return booksData;
		}
	}

	private Object[] createBookTableRowData(Book book) {
		Object[] row = new Object[8];

		row[0] = book.getBookName();
		row[1] = book.getAuthor();
		row[2] = book.getIsbn();
		row[3] = book.getLastRented();
		row[4] = book.getAddedDate();
		row[5] = book.isRented();
		row[6] = book.getOwnerId();
		row[7] = book.getCategory();

		return row;
	}
	
	private class SelectionListener implements ListSelectionListener {
		private JTable target;
		
		public SelectionListener(JTable target){
			this.target=target;
		}
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if (target==null)
				return;
			//target = (JTable)e.getSource();
			row = target.getSelectedRow();
			if(row < 0)
				return;
			// Status
			if (target.getValueAt(row, 6) == "0") {
				tStatus.setSelectedIndex(1);
			} else {
				tStatus.setSelectedIndex(0);
			}

			// ISBN (ID Number)
			tISBN.setText(target.getValueAt(row, 2).toString());

			// Book Name
			tName.setText(target.getValueAt(row, 0).toString());

			// Book Author
			tAuthor.setText(target.getValueAt(row, 1).toString());
			
			// Book Rented or not
			if(target.getValueAt(row, 5).toString()=="false"){
				tStatus.setSelectedIndex(1);// not rented
			}else{tStatus.setSelectedIndex(0);}
		}
		
	}

	public FrmBooksManagement() {

	}
}
