package Library;

import javax.swing.*;

//Joe Simply a Frame that lists all the Categories we have for different books

public class FrmViewCategories {
	public FrmViewCategories(){
		JFrame L = new JFrame();
		L.setSize(300, 400);
		L.setLocation(250,40);
		L.setVisible(true);
		L.setTitle("View Categories");	
		L.setLayout(null);

		JTextArea TF = new JTextArea();
		TF.setVisible(true);
		TF.setBounds(20, 50, 260, 300);
		L.add(TF);
	}
}
