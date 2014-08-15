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
/**
 * Add Book Frame
 * @author Sen Li
 * add 2014.8.11
 * edit by Li Huang 2014.8.15 Change base class to JDialog to allow showing in Modal way 
 *    Default is not visible, need to use frmAddBooks.setVisible(true) to show it
 */
public class DlgAddBooks extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JFrame jf;
	private JPanel picturePanel;
	private JButton choosePic, add, close;
	private JTextField jtf_isbn, jtf_name, jtf_author;
	private JLabel jl_isbn, jl_name, jl_author, jl_category, picLabel;
	private JComboBox cb_category;
	private String picPath, picDirectory, picFileName;
	//private ImageIcon bookPic;
	private Library library;
	
	DlgAddBooks(Library lib) {
		this.library = lib;
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Add book");
		
		choosePic = new JButton("Choose picture");
		choosePic.setBounds(300, 50, 150, 50);
		add = new JButton("Add");
		add.setBounds(75, 500, 100, 30);
		close = new JButton("Cancel");
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

		this.add(choosePic);
		this.add(add);
		this.add(close);
		this.add(picturePanel);
		this.add(jtf_isbn);
		this.add(jtf_name);
		this.add(jtf_author);
		this.add(jl_isbn);
		this.add(jl_name);
		this.add(jl_author);
		this.add(cb_category);
		this.add(jl_category);

		this.setSize(500, 600);
		this.setLayout(null);
		//this.setVisible(true); //remove by Li Huang 2014.8.15 to make it can be shown in Modal way

		choosePic.addMouseListener(new MouseAdapter() // choose a picture
				{
					public void mouseClicked(MouseEvent me) {

						// System.out.println("fffff"); //test1
						FileDialog readFD = new FileDialog(new Frame(),
								"Choose a file", FileDialog.LOAD);
						readFD.setVisible(true);
						picDirectory = readFD.getDirectory();
						picFileName = readFD.getFile();
						picPath = picDirectory + picFileName;
						// System.out.println(picPath); //test
						ImageIcon bookImgIcon = CreateStretchImageIcon(picPath,
								picturePanel.getWidth(),
								picturePanel.getHeight());
						DlgAddBooks.this.picLabel.setIcon(bookImgIcon);
					}
				});

		add.addMouseListener(new MouseAdapter() // add new book
		{
			public void mouseClicked(MouseEvent me) {

				Validator test = new Validator();

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
				}// case travel
				default:
					currentCategory = null;

				}// switch

				if (test.isBookIsbnValid(currentISBN)
						&& test.isContentValid(currentBookName)
						&& test.isContentValid(currentAuthor)) {

					Book currentNewBook = new Book();
					currentNewBook.setBookName(currentBookName);
					currentNewBook.setAuthor(currentAuthor);
					currentNewBook.setIsbn(currentISBN);
					currentNewBook.setLastRented(null);
					currentNewBook.setAddedDate(new Date());
					currentNewBook.setRented(false);
					currentNewBook.setOwnerId(Library.LIBRARY_OWNER_ID);
					currentNewBook.setCategory(currentCategory);

					// ***************************
					library.addBook(currentNewBook); // interface to other
															// frame, set
															// library object
															// before use

					// ***************************
					try {
						// del by Li Huang 2014.8.14 not use reName.
//						new reName().rename(picDirectory, picFileName,
//								currentISBN); 
						library.copyBookImage(picDirectory, picFileName, currentISBN);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("No picture selected.");
					} finally {
						JOptionPane.showMessageDialog(DlgAddBooks.this,
								"New book added.", "OK",
								JOptionPane.PLAIN_MESSAGE);
						DlgAddBooks.this.dispose(); // add by Li Huang 2014.8.15
					}

				}

				else {
					JOptionPane.showMessageDialog(DlgAddBooks.this,
							"Invaild book information!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}// mouse clicked
		});

		close.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				//FrmAddBooks.this.setVisible(false); //modify by Li Huang. use dispose() to totally dispose this window 
				DlgAddBooks.this.dispose();
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
			//e.printStackTrace();
			System.out.print("cannot read file");
			return null;
		}

		Image scaledImg = img.getScaledInstance(width, height,
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(scaledImg);
		
		return imageIcon;
	}

//	public static void main(String[] args) {
//		new FrmAddBooks(new Library());
//	}

}
