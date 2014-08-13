package Library;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; //javax.swing.JFrame;
import java.io.*;
import java.util.*;

//Joe, Books Management Frame, Including Adding Updating and Deleting. 
//		Also leads to books report Frame (Rented, In Library and Overdue)

public class FrmBooksManagement {
	JFrame J = new JFrame();
	private Library L;
	
	public FrmBooksManagement(Library L){
		this.L=L;

		//In the Requirement Document, Administrator is supposed to notify all the customers about the new books arriving.
		//In this Frame, there is no certain button does that. Instead, as soon as a new book is added, all customers would
		//be able to see the new added books from book list while they are trying rent new ones.
		
		System.out.println(L.bookList.get(0).getBookName());
		J.setSize(1000, 800);
		J.setLocation(250,40);
		J.setVisible(true);
		J.setTitle("Books Management");	
		J.setLayout(null);
		
//	    Object rowData[][] = { { book1.getBookName(), book1.getAuthor(), book1.getIsbn(),book1.getLastRented(),
//	    						book1.getAddedDate(), book1.getIsbn(), book1.getOwnerId(),book1.getCategory() },
//	    						{ "WWII", "SomeTwo", "2B64B","???", "08-09-14", "NO", "001","HISTORY" },
//	    };
//	    
//	    Object columnNames[] = { "bookName", "author", "isbn", "lastRented",
//				"AddedDate", "isRented", "ownerId", "category" };
//	        
//	    JTable table = new JTable(rowData, columnNames);	    
//	    
//	    JScrollPane scrollPane = new JScrollPane(table);
//	    scrollPane.setBounds(50, 50, 600, 400);
//	    J.add(scrollPane);
	    
		JButton btnAdd = new JButton("Add");
		btnAdd.setVisible(true);
		btnAdd.setBounds(110, 520, 120, 30);
		J.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setVisible(true);
		btnUpdate.setBounds(250, 520, 120, 30);
		J.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setVisible(true);
		btnDelete.setBounds(390, 520, 120, 30);
		J.add(btnDelete);		
		
		JButton btnReport = new JButton("RentedBook Report");
		btnReport.setVisible(true);								 
		btnReport.setBounds(700, 620, 150, 30);
		J.add(btnReport);
		
		JButton btnClose = new JButton("Close");
		btnClose.setVisible(true);
		btnClose.setBounds(880, 620, 100, 30);
		J.add(btnClose);
		
//		PanelBookInfo P = new PanelBookInfo();
//		P.setBounds(650, 50, 400, 550);
//		J.add(P);
//		
//	    table.addMouseListener(new java.awt.event.MouseAdapter() {
//	        public void mouseClicked(java.awt.event.MouseEvent e) { 
//	        	int rowI  = table.rowAtPoint(e.getPoint());	        	
//	      	}
//	      });
		
		btnReport.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	FrmBookReport N = new FrmBookReport();
		    }
		});
		
		btnClose.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	J.setVisible(false);
		    }
		});
		}

	public FrmBooksManagement(){
		
	}
}
