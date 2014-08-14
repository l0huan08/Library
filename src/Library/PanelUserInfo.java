//TODO: put txtAddress into scrAddress
package Library;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.*;
import javax.swing.LayoutStyle.*;
import javax.swing.border.*;


/**
 * Panel to show Customer Info
 * @author Li Huang
 * add 2014.8.13
 * edit by Li Huang 2014.8.14   add text fields Getters for validation.
 */
public class PanelUserInfo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private final String[] strUserType = {
			"Customer",
			"Admin"
	};
	
	
	private JLabel lblUserType;
	private JComboBox cmbUserType;
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblPassword;
	private JTextField txtPassword;
	private JLabel lblPhoneNo;
	private JTextField txtPhoneNo;
	private JLabel lblAddress;
	private JTextArea txtAddress;
		
	//---------- Getters ---------------------
	public boolean isAdmin() {
		return getIsAdminFromCmbIndex(cmbUserType.getSelectedIndex());
	}
	
	public String getIdText() {
		return txtId.getText();
	}
	
	public String getNameText() {
		return txtName.getText();
	}
	
	public String getPasswordText() {
		return txtPassword.getText();
	}
	
	public String getPhoneNoText() {
		return txtPhoneNo.getText();
	}
	
	public String getAddressText() {
		return txtAddress.getText();
	}
	
	/**
	 * Create the panel.
	 */
	public PanelUserInfo() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "UserInfo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblId = new JLabel("ID");
		panel_1.add(lblId);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblName = new JLabel("Name");
		panel_2.add(lblName);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblPassword = new JLabel("Password");
		panel_3.add(lblPassword);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblAddress = new JLabel("Address");
		panel_4.add(lblAddress);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblPhoneNo = new JLabel("Phone");
		panel_5.add(lblPhoneNo);
		
		txtPhoneNo = new JTextField();
		txtPhoneNo.setColumns(10);
		panel_5.add(txtPhoneNo);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		txtAddress = new JTextArea();
		txtAddress.setRows(4);
		txtAddress.setColumns(25);
		
		JScrollPane scrAddress = new JScrollPane(txtAddress);
		panel_4.add(scrAddress);
		
		txtPassword = new JTextField();
		panel_3.add(txtPassword);
		txtPassword.setColumns(10);
		
		txtName = new JTextField();
		panel_2.add(txtName);
		txtName.setColumns(10);
		
		txtId = new JTextField();
		panel_1.add(txtId);
		txtId.setColumns(10);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblUserType = new JLabel("User Type");
		panel.add(lblUserType);
		
		cmbUserType = new JComboBox(strUserType);
		panel.add(cmbUserType);
		setLayout(groupLayout);
	}
	
	
	
	/**
	 * Set whether this panel information is editable or read only
	 */
	public void setEditable(boolean editable) {
		//cmbUserType.setEditable(editable); //default cannot editable
		txtId.setEditable(editable);
		txtName.setEditable(editable);
		txtPassword.setEditable(editable);
		txtPhoneNo.setEditable(editable);
		txtAddress.setEditable(editable);
	}
	
	/**
	 * Clear the entries of the book info
	 */
	public void clear() {
		this.cmbUserType.setSelectedIndex(0);
		this.txtId.setText("");
		this.txtName.setText("");
		this.txtPassword.setText("");
		this.txtPhoneNo.setText("");
		this.txtAddress.setText("");
	}
	
	/**
	 * Load information from book, fill the attribute boxes.
	 * @param user
	 */
	public void ReadFrom(User user) {
		if (user==null)
			return;
		
		this.cmbUserType.setSelectedIndex(getCmbUserTypeIndex(user.isAdmin()));
		this.txtId.setText(String.valueOf(user.getUserId()));
		this.txtName.setText(user.getUserName());
		this.txtPassword.setText(user.getPassword());
		this.txtPhoneNo.setText(user.getPhoneNo());
		this.txtAddress.setText(user.getAddress());
	}
	
	/**
	 * Write back the attributes from this panel to the book object
	 * @param book
	 */
	public void WriteTo(User user) {
		if (user==null)
			return;
		
		user.setAdmin(getIsAdminFromCmbIndex(cmbUserType.getSelectedIndex()));
		
		int userId = -1;
		try {
			userId = Integer.parseInt(txtId.getText());
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Please enter valid user id.");
			userId=0;
		}
		
		user.setUserId(userId);
		user.setUserName(txtName.getText());
		user.setPassword(txtPassword.getText());
		user.setPhoneNo(txtPhoneNo.getText());
		user.setAddress(txtAddress.getText());
	}
	
	
	/**
	 * Get Combox item index of Category
	 * @param cat  category
	 * @return return the index of corresponding category. If cat==null, return 0
	 */
	private int getCmbUserTypeIndex(boolean isAdmin) {
		if (isAdmin) 
			return 1;
		else 
			return 0;
	}
	
	private boolean getIsAdminFromCmbIndex(int cmbCategoryIndex) {
		switch (cmbCategoryIndex)
		{
		case 0:
			return false;
			//break;
		case 1:
			return true;
			//break;
		}
		
		return false;
	}
}