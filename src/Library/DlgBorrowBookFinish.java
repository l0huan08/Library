package Library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

/**
 * Show result information of "Borrow a book"
 * @author Li Huang
 * add 2014.8.13
 */
public class DlgBorrowBookFinish extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblMessage;
	private JTextField txtIsbn;
	private JTextField txtName;
	private JTextArea txtReason;
	private JButton btnOk;

	/**
	 * Create the dialog.
	 */
	public DlgBorrowBookFinish(boolean isSuccess, Book book) {
		setTitle("Borrow Book Finish");
		setBounds(100, 100, 357, 336);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblMessage = new JLabel("Success Borrowed!");
			lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		}
		
		JLabel lblIsbn = new JLabel("ISBN");
		
		JLabel lblName = new JLabel("Name");
		
		txtIsbn = new JTextField();
		txtIsbn.setEditable(false);
		txtIsbn.setText("123");
		txtIsbn.setColumns(10);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setText("Book1");
		txtName.setColumns(10);
		
		txtReason = new JTextArea();
		txtReason.setEditable(false);
		txtReason.setWrapStyleWord(true);
		txtReason.setLineWrap(true);
		txtReason.setForeground(Color.RED);
		txtReason.setText("We are sorry you cannot borrow this book, because this book is not in our library or has already been rented by other users. Please call our customer service 123-456-789.");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(42)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtReason, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMessage)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(78)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblName)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblIsbn)
									.addGap(11)
									.addComponent(txtIsbn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMessage)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtReason)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsbn)
						.addComponent(txtIsbn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("OK");
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
		}
		
		//event handler
		///btnOk
		this.btnOk.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DlgBorrowBookFinish.this.dispose();
			}
		});
		
		//----------------------- init -------------------------
		if (isSuccess) {
			setSuccess(book);
		} else {
			setFailed(book);
		}
	}
	
	
	
	public void setSuccess(Book book) {
		if (book!=null){
			this.lblMessage.setForeground(Color.BLACK);
			this.lblMessage.setText("Success Borrowed!");
			this.txtIsbn.setText(book.getIsbn());
			this.txtName.setText(book.getBookName());
			this.txtReason.setVisible(false);
		}
	}
	
	public void setFailed(Book book) {
		this.lblMessage.setForeground(Color.RED);
		this.lblMessage.setText("Borrow Failed!");
		this.txtReason.setVisible(true);
		
		if (book!=null){
			this.txtIsbn.setText(book.getIsbn());
			this.txtName.setText(book.getBookName());
		} else	{
			this.txtIsbn.setText("");
			this.txtName.setText("");
		}
	}
}
