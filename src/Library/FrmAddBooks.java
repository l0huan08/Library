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

public class FrmAddBooks extends JFrame {

	private JFrame jf;
	private JPanel picturePanel;
	private JButton choosePic, add, close;
	private JTextField jtf_isbn, jtf_name, jtf_author;
	private JLabel jl_isbn, jl_name, jl_author, jl_category, picLabel;
	private JComboBox cb_category;
	private String picPath;
	private ImageIcon bookPic;

	FrmAddBooks() {
		jf = new JFrame("Add book");
		choosePic = new JButton("Choose picture");
		choosePic.setBounds(300, 50, 150, 50);
		add = new JButton("Add");
		add.setBounds(75, 500, 100, 30);
		close = new JButton("Close");
		close.setBounds(325, 500, 100, 30);
		picturePanel = new JPanel();
		picturePanel.setBackground(Color.BLACK);
		picturePanel.setBounds(50, 20, 210, 280);

		picLabel = new JLabel();
		picLabel.setSize(210, 280);
		picturePanel.add(picLabel);

		jtf_isbn = new JTextField();
		jtf_isbn.setBounds(120, 330, 300, 25);
		jl_isbn = new JLabel("ISBN");
		jl_isbn.setBounds(40, 330, 100, 25);

		jtf_name = new JTextField();
		jtf_name.setBounds(120, 370, 300, 25);
		jl_name = new JLabel("Name");
		jl_name.setBounds(40, 370, 100, 25);

		jtf_author = new JTextField();
		jtf_author.setBounds(120, 410, 300, 25);
		jl_author = new JLabel("Author");
		jl_author.setBounds(40, 410, 100, 25);

		String[] categoryStrings = { "Children", "Cooking", "History", "Travel" };
		cb_category = new JComboBox(categoryStrings);
		cb_category.setBounds(120, 450, 300, 25);
		jl_category = new JLabel("Category");
		jl_category.setBounds(40, 450, 100, 25);

		jf.add(choosePic);
		jf.add(add);
		jf.add(close);
		jf.add(picturePanel);
		jf.add(jtf_isbn);
		jf.add(jtf_name);
		jf.add(jtf_author);
		jf.add(jl_isbn);
		jf.add(jl_name);
		jf.add(jl_author);
		jf.add(cb_category);
		jf.add(jl_category);

		jf.setSize(500, 600);
		jf.setLayout(null);
		jf.setVisible(true);

		choosePic.addMouseListener(new MouseAdapter() // choose a picture
				{
					public void mouseClicked(MouseEvent me) {

						// System.out.println("fffff"); //test1
						FileDialog readFD = new FileDialog(new Frame(),
								"Choose a file", FileDialog.LOAD);
						readFD.setVisible(true);
						picPath = readFD.getDirectory() + readFD.getFile();
						// System.out.println(picPath); //test
						ImageIcon bookImgIcon = CreateStretchImageIcon(picPath,
								picturePanel.getWidth(),
								picturePanel.getHeight());
						FrmAddBooks.this.picLabel.setIcon(bookImgIcon);
					}
				});

		add.addMouseListener(new MouseAdapter() // add new book
		{
			public void mouseClicked(MouseEvent me) {
				
				String currentISBN = jtf_isbn.getText();
				String currentBookName = jtf_name.getText();
				String currentAuthor = jtf_author.getText();
				String currentCategoryString = (String) cb_category
						.getSelectedItem();
				// System.out.println(currentCategory); //test1
				Category currentCategory;
				switch (currentCategoryString) {
				case "Children": {
					currentCategory = Category.CHILDREN;
					break;
				}
				case "Cooking": {
					currentCategory = Category.COOKING;
					break;
				}
				case "History": {
					currentCategory = Category.HISTORY;
					break;
				}
				case "Travel": {
					currentCategory = Category.TRAVEL;
					break;
				}//case travel
				default:
					currentCategory = null;

				}//switch
				
				Book currentNewBook = new Book();
				currentNewBook.setBookName(currentBookName);
				currentNewBook.setAuthor(currentAuthor);
				currentNewBook.setIsbn(currentISBN);
				currentNewBook.setLastRented(null);
				currentNewBook.setAddedDate(new Date());
				currentNewBook.setRented(false);
				currentNewBook.setOwnerId(Library.LIBRARY_OWNER_ID);
				currentNewBook.setCategory(currentCategory);
				
				//***************************
				new Library().addBook(currentNewBook);  //interface to other frame, set library object before use
				//***************************
				JOptionPane.showMessageDialog(FrmAddBooks.this, "New book added.");
				
			}//mouse clicked
		});

		close.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				jf.setVisible(false);
			}
		});
	}

	void loadPic(String path) {

	}

	private ImageIcon CreateStretchImageIcon(String imgPath, int width,
			int height) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(imgPath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image scaledImg = img.getScaledInstance(width, height,
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(scaledImg);
		return imageIcon;
	}

	public static void main(String[] args) {
		new FrmAddBooks();
	}

}
