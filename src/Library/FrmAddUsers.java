package Library;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

//Sen Li

public class FrmAddUsers extends JFrame {

	private JFrame jf;

	private JButton addUser, close;
	private ImageIcon bookPic;
	private PanelUserInfo infoPanel;
	Library library;

	FrmAddUsers(Library lib) {
		this.library = lib;
		jf = new JFrame("Add user");

		addUser = new JButton("Add");
		addUser.setBounds(75, 500, 100, 30);
		close = new JButton("Close");
		close.setBounds(325, 500, 100, 30);
		infoPanel = new PanelUserInfo();
		infoPanel.setBounds(20, 20, 400, 400 );
		

		jf.add(addUser);
		jf.add(close);
		jf.add(infoPanel);
	

		jf.setSize(500, 600);
		jf.setLayout(null);
		jf.setVisible(true);

		addUser.addMouseListener(new MouseAdapter() // add new user
		{
			public void mouseClicked(MouseEvent me) {

			
			}// mouse clicked
		});

		close.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				jf.setVisible(false);
			}
		});
	}

	public static void main(String[] args) {
		new FrmAddUsers(new Library());
	}

}
