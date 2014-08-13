package Library;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*; //javax.swing.JFrame;

import com.sun.prism.paint.Color;

import java.io.*;
import java.util.Date;

public class FrmBooksManagement {
	public FrmBooksManagement(){
		JFrame L = new JFrame();
		L.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		L.setSize(1000, 800);
		L.setLocation(250,40);
		L.setVisible(true);
		L.setTitle("Books Management");	
		L.setLayout(null);

	    Object rowData[][] = { { "GBF", "SomeOne", "0032MN","", "Row1-Column1", "Row1-Column2", "Row1-Column3","" },
	    						{ "Row1-Column1", "Row1-Column2", "Row1-Column3","", "Row1-Column1", "Row1-Column2", "Row1-Column3","" },
	    };
	    
	    Object columnNames[] = { "bookName", "author", "isbn", "lastRented",
				"AddedDate", "isRented", "ownerId", "category" };
	        
	    JTable table = new JTable(rowData, columnNames);

	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(50, 50, 600, 400);
	    L.add(scrollPane);
	    
		JButton BtnAdd = new JButton("Add");
		BtnAdd.setVisible(true);
		BtnAdd.setBounds(110, 520, 120, 30);
		L.add(BtnAdd);
		
		JButton BtnUpdate = new JButton("Update");
		BtnUpdate.setVisible(true);
		BtnUpdate.setBounds(250, 520, 120, 30);
		L.add(BtnUpdate);
		
		JButton BtnDelete = new JButton("Delete");
		BtnDelete.setVisible(true);
		BtnDelete.setBounds(390, 520, 120, 30);
		L.add(BtnDelete);
		
		JButton BtnReport = new JButton("RentedBook Report");
		BtnReport.setVisible(true);
		BtnReport.setBounds(760, 520, 150, 30);
		L.add(BtnReport);
		
		JButton BtnExit = new JButton("Exit");
		BtnExit.setVisible(true);
		BtnExit.setBounds(785, 560, 100, 30);
		L.add(BtnExit);

	}
}
