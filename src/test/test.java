package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test{
	/**
	 * @param args
	 * @throws Exception 
	 */
	JButton b1;
	JFrame jf; 
	String name = "123"; //ISBN
	test() throws Exception{
		jf = new JFrame();
		b1 = new JButton("open");
		jf.setLayout(new FlowLayout());
		jf.add(b1);
		jf.setSize(200,200);
		jf.setVisible(true);
		b1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
				FileDialog fd = new FileDialog(jf,"open",FileDialog.LOAD);
				fd.setVisible(true);
				String dir = fd.getDirectory();
				String file = fd.getFile();
				reName r = new reName();
				try {
					if(dir == null){
						
					} else{
						file = file.toLowerCase();
						r.rename(dir, file, name);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new test();
	}
}

