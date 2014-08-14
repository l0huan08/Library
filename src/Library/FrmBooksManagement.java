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
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setVisible(true);
		btnClose.setBounds(880, 620, 100, 30);
		this.add(btnClose);
		
		btnRefresh.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
	    	FrmAddBooks N = new FrmAddBooks(L); 
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
