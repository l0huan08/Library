package Library;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Sen Li

@SuppressWarnings("serial")
public class FrmAddUsers extends JFrame {

	private JButton addUser, close;
	private PanelUserInfo infoPanel;
	private boolean bool_isActionAdd;

	FrmAddUsers() {
		
		this.setTitle("Add Users");

		addUser = new JButton("Add");
		addUser.setBounds(75, 500, 100, 30);
		close = new JButton("Cancel");
		close.setBounds(325, 500, 100, 30);
		infoPanel = new PanelUserInfo();
		infoPanel.setBounds(20, 20, 400, 400);
	
		this.add(addUser);
		this.add(close);
		this.add(infoPanel);

		this.setSize(500, 600);
		this.setLayout(null);
		this.setVisible(true);

		addUser.addMouseListener(new MouseAdapter() // add new user
		{
			public void mouseClicked(MouseEvent me) {

				Validator validator = new Validator();
				if (validator.isUserIdValid(infoPanel.getIdText())
						&& validator.isUserNameValid(infoPanel.getNameText())
						&& validator.isUserPasswordValid(infoPanel.getPasswordText())
						&& validator.isUserPhoneNoValid(infoPanel.getPhoneNoText())

				) {
					bool_isActionAdd = true;
					JOptionPane.showMessageDialog(FrmAddUsers.this,
							"New user added.", "OK", JOptionPane.PLAIN_MESSAGE);
					FrmAddUsers.this.dispose();

				}

				else {
					JOptionPane.showMessageDialog(FrmAddUsers.this,
							"Invaild user information!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}// mouse clicked
		});

		close.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				bool_isActionAdd = false;
				FrmAddUsers.this.setVisible(false);

			}
		});
	}

	public static void main(String[] args) {
		new FrmAddUsers();
	}

	public boolean isActionAdd() {

		return bool_isActionAdd;

	}

	public User getUser() { //return a user with info in the panel.
		User tempUser = new User();
		infoPanel.WriteTo(tempUser);
		return tempUser;
	}

}
