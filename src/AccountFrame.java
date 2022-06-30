import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AccountFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;
	
	private static String username;
	private static String password;

	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					username = Admin.getCredentials()[0];
					password = Admin.getCredentials()[1];
					AccountFrame accountFrame = new AccountFrame();
					accountFrame.setLocationRelativeTo(null);
					accountFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public AccountFrame() {
		setTitle("Vending Machine");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountSettingsPanel = new JLabel("Settings Panel");
		lblAccountSettingsPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountSettingsPanel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblAccountSettingsPanel.setBounds(10, 10, 396, 46);
		contentPane.add(lblAccountSettingsPanel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(65, 71, 293, 120);
		contentPane.add(panel);
		
		JLabel usernameLabel = new JLabel("Username: ");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usernameLabel.setBounds(45, 25, 82, 23);
		panel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordLabel.setBounds(45, 69, 82, 23);
		panel.add(passwordLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usernameField.setColumns(10);
		usernameField.setBounds(127, 27, 134, 19);
		panel.add(usernameField);
		usernameField.setText(username);
		
		passwordField = new JTextField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setColumns(10);
		passwordField.setBounds(127, 71, 134, 19);
		panel.add(passwordField);
		passwordField.setText(password);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean update = true;
				
				String modifiedUsername = usernameField.getText();
				String modifiedPassword = passwordField.getText();
				
				if (modifiedUsername.equals(username) && modifiedPassword.equals(password)) {
					dispose();
				}
				if (!modifiedUsername.equals(username)) {
					if (Validation.validateUsername(modifiedUsername) == false) {
						update = false;
					}
				}
				if (!modifiedPassword.equals(password)) {
					if (Validation.validatePassword(modifiedPassword) == false) {
						update = false;
					}
				}
				if (update == true) {
					try {
						Admin.updateCredentials(modifiedUsername, modifiedPassword);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					dispose();
				}
			}
		});
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		saveButton.setBounds(147, 220, 125, 34);
		contentPane.add(saveButton);
	}
}
