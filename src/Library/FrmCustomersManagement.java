package Library;

import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//Joe, Customers Management Frame, Including Adding Updating and Deleting. 

public class FrmCustomersManagement {
	public FrmCustomersManagement(){
		JFrame L = new JFrame();
		L.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		L.setSize(800, 800);
		L.setLocation(250,40);
		L.setVisible(true);
		L.setTitle("Customers Management");	
		L.setLayout(null);
		
		Object rowData[][] = { { "004", "SomeOne" },
							   { "002", "SomeTwo" },
		};

		Object columnNames[] = { "userId", "userName" };	
		
		JTable table = new JTable(rowData, columnNames);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 50, 400, 400);
		L.add(scrollPane);
		
		// No reports of customers are expected in this Frame
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setVisible(true);
		btnAdd.setBounds(60, 520, 100, 30);
		L.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setVisible(true);
		btnUpdate.setBounds(200, 520, 100, 30);
		L.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setVisible(true);
		btnDelete.setBounds(340, 520, 100, 30);
		L.add(btnDelete);
		
		JButton btnClose = new JButton("Close");
		btnClose.setVisible(true);
		btnClose.setBounds(635, 560, 100, 30);
		L.add(btnClose);
		
		btnClose.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		       L.setVisible(false);
		    }
		});	
	}
}
