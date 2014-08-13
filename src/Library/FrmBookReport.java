package Library;

import javax.swing.*;

/**
 * Joe, Frame lists the info. of books
 * Search by Rented, In Library and Overdue *
 */
public class FrmBookReport {
	JFrame L = new JFrame();
	public FrmBookReport(){
		//L.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		L.setSize(600, 400);
		L.setLocation(250,40);
		L.setVisible(true);
		L.setTitle("Rent Books Report");	
		L.setLayout(null);
		
		JButton btnShow = new JButton("Show");
		btnShow.setVisible(true);								 
		btnShow.setBounds(310, 30, 80, 25);
		L.add(btnShow);
		
		JButton btnClose = new JButton("Close");
		btnClose.setVisible(true);
		btnClose.setBounds(500, 340, 80, 25);
		L.add(btnClose);

		
		JRadioButton RB1 = new JRadioButton("Rented");
		RB1.setVisible(true);
		RB1.setBounds(70, 30, 70, 25);
		L.add(RB1);
		
		JRadioButton RB2 = new JRadioButton("In Library");
		RB2.setVisible(true);
		RB2.setBounds(137, 30, 80, 25);
		L.add(RB2);
		
		JRadioButton RB3 = new JRadioButton("Overdue");
		RB3.setVisible(true);
		RB3.setBounds(220, 30, 80, 25);
		L.add(RB3);
		
		ButtonGroup bg = new ButtonGroup(); // Only one JRadioButton could be selected in this group
		bg.add(RB1);
		bg.add(RB2);
		bg.add(RB3);
		
		Object rowData[][] = { { "004", "SomeOne" },
				   { "002", "SomeTwo" },
		};
		
		Object columnNames[] = { "ISBN", "Name" };	
		
		JTable table = new JTable(rowData, columnNames);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(70, 70, 280, 300);
		L.add(scrollPane);
		
		btnClose.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		       L.setVisible(false);
		    }
		});	
	}
}
