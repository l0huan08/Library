package Library;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*; //javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import java.io.*;
import java.util.*;
import java.util.List;

//Joe, Books Management Frame, Including Adding Updating and Deleting. 
//		Also leads to books report Frame (Rented, In Library and Overdue)

public class FrmBooksManagement extends JFrame {
	private Library L;
	String [] cb_Status = {"Rented", "Not rented"};
	JComboBox tStatus = new JComboBox(cb_Status);
	int row;
	
	public FrmBooksManagement(Library L){
		this.L=L;

		//In the Requirement Document, Administrator is supposed to notify all the customers about the new books arriving.
		//In this Frame, there is no certain button does that. Instead, as soon as a new book is added, all customers would
		//be able to see the new added books from book list while they are trying rent new ones.

		this.setSize(1000, 800);
		this.setLocation(250,40);
		this.setVisible(true);
		this.setTitle("Books Management");	
		this.setLayout(null);
	
	    Object rowData[][] =getAllBookTableData(L);
		
	    String columnNames[] = { "bookName", "author", "isbn",
	    						 "lastRented", "AddedDate", "isRented",
	    						 "ownerId", "category" };
	    
	    DefaultTableModel dtm = new DefaultTableModel(rowData, columnNames);
	    JTable table = new JTable(dtm);
	    
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(50, 50, 600, 400);
	    this.add(scrollPane);
	    
		JButton btnAdd = new JButton("Add");
		btnAdd.setVisible(true);
		btnAdd.setBounds(110, 520, 120, 30);
		this.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setVisible(true);
		btnUpdate.setBounds(250, 520, 120, 30);
		this.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setVisible(true);
		btnDelete.setBounds(390, 520, 120, 30);
		this.add(btnDelete);		
		
		JButton btnReport = new JButton("RentedBook Report");
		btnReport.setVisible(true);								 
		btnReport.setBounds(700, 620, 150, 30);
		this.add(btnReport);
		
		JButton btnClose = new JButton("Close");
		btnClose.setVisible(true);
		btnClose.setBounds(880, 620, 100, 30);
		this.add(btnClose);
		
		JLabel lStatus = new JLabel();
		lStatus.setVisible(true);
		lStatus.setText("Status:");
		lStatus.setBounds(705, 103, 50, 25);
		this.add(lStatus);
		
		
		tStatus.setVisible(true);
		tStatus.setBounds(750, 100, 200, 25);
		this.add(tStatus);
		
		JLabel lISBN = new JLabel();
		lISBN.setVisible(true);
		lISBN.setText("ISBN:");
		lISBN.setBounds(709, 143, 50, 25);
		this.add(lISBN);
		
		JTextField tISBN = new JTextField();
		tISBN.setVisible(true);
		tISBN.setBounds(750, 140, 200, 25);
		this.add(tISBN);
		
		JLabel lName = new JLabel();
		lName.setVisible(true);
		lName.setText("Book Name:");
		lName.setBounds(675, 182, 70, 30);
		this.add(lName);
		
		JTextField tName = new JTextField();
		tName.setVisible(true);
		tName.setBounds(750, 180, 200, 25);
		this.add(tName);
		
		JLabel lAuthor = new JLabel();
		lAuthor.setVisible(true);
		lAuthor.setText("Author Name:");
		lAuthor.setBounds(665, 222, 80, 25);
		this.add(lAuthor);
		
		JTextField tAuthor = new JTextField();
		tAuthor.setVisible(true);
		tAuthor.setBounds(750, 220, 200, 25);
		this.add(tAuthor);
		
		btnReport.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	FrmBookReport N = new FrmBookReport();		    	
		    }
		});
		
		btnClose.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	FrmBooksManagement.this.setVisible(false);
		    	
		    }
		});
		
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
	    	FrmAddBooks N = new FrmAddBooks(L); 
		    }
		});
		
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
			      lStatus.setVisible(false);
			      tStatus.setVisible(false);
			      lISBN.setVisible(false);
			      tISBN.setVisible(false);
				  lName.setVisible(false);
				  tName.setVisible(false);
				  lAuthor.setVisible(false);
				  tAuthor.setVisible(false);
				  JLabel lDelete = new JLabel();
				  lDelete.setVisible(true);
				  lDelete.setText("Click the book you want to delete");
				  lDelete.setBounds(665, 222, 300, 25);
				  FrmBooksManagement.this.add(lDelete);
				  
				table.addMouseListener(new MouseAdapter() {
				  public void mouseClicked(MouseEvent e) {
				      JTable target = (JTable)e.getSource();
				      
				      int row = target.getSelectedRow();   
				      int column = target.getSelectedColumn();	// useless here
				      dtm.removeRow(row);
				      L.deleteBook(table.getValueAt(row, 2).toString());
	
				  }
				});
		    }
		});
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setVisible(true);
		btnRefresh.setBounds(250, 470, 120, 30);
		this.add(btnRefresh);
		btnRefresh.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	int j = table.getRowCount();
		    	for (int i = 0 ; i < j; i++){
			    	dtm.removeRow(0);			    	
		    	}
		    	for (int i = 0 ; i < L.showBookList_all().size(); i++){
		    		dtm.addRow(createBookTableRowData(L.showBookList_all().get(i)));
		    	}
		    }
		});
		
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
					      String oldISBN = table.getValueAt(row, 2).toString();
					      Book tempBook = L.getBookByISBN(oldISBN);				      
					      tempBook.setBookName(tName.getText());
					      tempBook.setAuthor(tAuthor.getText());
					      tempBook.setIsbn(tISBN.getText());
					      tempBook.setRented(tStatus.getSelectedIndex()==0? true:false);
					      L.updateBook(oldISBN, tempBook);
		    }
		});

		
		table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			      JTable target = (JTable)e.getSource();
			      row = target.getSelectedRow();   
			      
			      // Status
			      if(table.getValueAt(row, 6) == "0"){
			    	  tStatus.setSelectedIndex(1);
			      }else{ tStatus.setSelectedIndex(0); }
			      
			      // ISBN (ID Number)
			      tISBN.setText(table.getValueAt(row, 2).toString());
			      
			      // Book Name
			      tName.setText(table.getValueAt(row, 0).toString());
			      
			      // Book Author
			      tAuthor.setText(table.getValueAt(row, 1).toString());
			      
			      

			  }
			});

		}		
	
	private Object[][] getAllBookTableData(Library library) {
		if (library==null)
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

	private Object[] createBookTableRowData(Book book) {
		Object[] row = new Object[8];
 
		row[0]=book.getBookName();
		row[1]=book.getAuthor();
		row[2]=book.getIsbn();
		row[3]=book.getLastRented();
		row[4]=book.getAddedDate();
		row[5]=book.isRented();
		row[6]=book.getOwnerId();
		row[7]=book.getCategory();
		
		return row;
	}
	
	public FrmBooksManagement(){
		
	}
}
