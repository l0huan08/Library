package Library;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*; //javax.swing.JFrame;

import com.sun.prism.paint.Color;

import java.io.*;
import java.util.Date;

//Joe, Books Management Frame, Including Adding Updating and Deleting. 
//		Also leads to books report Frame (Rented, In Library and Overdue)

public class FrmBooksManagement {
	public FrmBooksManagement(){
		
		//In the Requirement Document, Administrator is supposed to notify all the customers about the new books arriving.
		//In this Frame, there is no certain button does that. Instead, as soon as a new book is added, all customers would
		//be able to see the new added books from book list while they are trying rent new ones.
		
		JFrame L = new JFrame();
		L.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		L.setSize(1000, 800);
		L.setLocation(250,40);
		L.setVisible(true);
		L.setTitle("Books Management");	
		L.setLayout(null);

	    Object rowData[][] = { { "GBF", "SomeOne", "0032MN","08-12-14", "08-11-14", "YES", "004","???" },
	    						{ "WWII", "SomeTwo", "2B64B","???", "08-09-14", "NO", "001","M" },
	    };
	    
	    Object columnNames[] = { "bookName", "author", "isbn", "lastRented",
				"AddedDate", "isRented", "ownerId", "category" };
	        
	    JTable table = new JTable(rowData, columnNames);

	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(50, 50, 600, 400);
	    L.add(scrollPane);
	    
		JButton btnAdd = new JButton("Add");
		btnAdd.setVisible(true);
		btnAdd.setBounds(110, 520, 120, 30);
		L.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setVisible(true);
		btnUpdate.setBounds(250, 520, 120, 30);
		L.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setVisible(true);
		btnDelete.setBounds(390, 520, 120, 30);
		L.add(btnDelete);		
		
		JButton btnReport = new JButton("RentedBook Report");
		btnReport.setVisible(true);								 
		btnReport.setBounds(760, 520, 150, 30);
		L.add(btnReport);
		
		JButton btnClose = new JButton("Close");
		btnClose.setVisible(true);
		btnClose.setBounds(785, 560, 100, 30);
		L.add(btnClose);
		
		btnReport.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	FrmBookReport N = new FrmBookReport();
		    }
		});
		
		btnClose.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	L.setVisible(false);
		    }
		});
		
	}
}
