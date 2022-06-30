import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame loginFrame = new LoginFrame();
					loginFrame.setLocationRelativeTo(null);
					loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setResizable(false);
		setTitle("Vending Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loginFrameTitle = new JLabel("Admin Login");
		loginFrameTitle.setBounds(5, 5, 606, 89);
		loginFrameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		loginFrameTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(loginFrameTitle);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(56, 97, 505, 220);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		usernameLabel.setBounds(90, 41, 65, 22);
		panel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordLabel.setBounds(90, 99, 65, 22);
		panel.add(passwordLabel);
		
		JTextField usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		usernameField.setBounds(200, 44, 204, 19);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setBounds(200, 102, 204, 19);
		panel.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usernameInput = usernameField.getText().trim();
				String passwordInput = String.valueOf(passwordField.getPassword()); // convert password which is an array of characters to a string
						
				try {
					if (Validation.validateCredentials(usernameInput, passwordInput)) {
						AdminFrame.open();
						dispose();
					}
				} catch (HeadlessException | FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
			}
		});
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginButton.setBounds(221, 154, 85, 41);
		panel.add(loginButton);
		
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.mainFrame.setVisible(true); // re-open main frame
				dispose(); // close current frame
			}
		});
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		returnButton.setBounds(514, 353, 92, 30);
		contentPane.add(returnButton);
	}
}
