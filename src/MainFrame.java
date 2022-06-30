import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField moneyField;
	private JTextField changeField;
	
	public static MainFrame mainFrame;
	public static ArrayList<Item> itemList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame = new MainFrame();
					mainFrame.setLocationRelativeTo(null); // make frame perfectly centered on screen
					mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);
		setTitle("Vending Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mainFrameTitle = new JLabel("Snacks Vending Machine");
		mainFrameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		mainFrameTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		mainFrameTitle.setBounds(10, 10, 596, 46);
		contentPane.add(mainFrameTitle);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Choose Item", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(38, 84, 539, 123);
		contentPane.add(panel);
		panel.setLayout(null);
		
		try {
			itemList = Item.getList();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		JRadioButton Item1Button = new JRadioButton("");
		Item1Button.setBounds(29, 40, 145, 21);
		panel.add(Item1Button);
		String item1Name = itemList.get(0).getName();
		String item1Price = itemList.get(0).getPrice();
		String item1Stock = itemList.get(0).getStock();
		Item1Button.setText(item1Name + " $" + item1Price);
		
		JRadioButton Item2Button  = new JRadioButton("");
		Item2Button.setBounds(194, 40, 145, 21);
		panel.add(Item2Button);
		String item2Name = itemList.get(1).getName();
		String item2Price = itemList.get(1).getPrice();
		String item2Stock = itemList.get(1).getStock();
		Item2Button.setText(item2Name + " $" + item2Price);
		
		JRadioButton Item3Button = new JRadioButton("");
		Item3Button.setBounds(351, 40, 145, 21);
		panel.add(Item3Button);
		String item3Name = itemList.get(2).getName();
		String item3Price = itemList.get(2).getPrice();
		String item3Stock = itemList.get(2).getStock();
		Item3Button.setText(item3Name + " $" + item3Price);
		
		JRadioButton Item4Button = new JRadioButton("");
		Item4Button.setBounds(29, 74, 145, 21);
		panel.add(Item4Button);
		String item4Name = itemList.get(3).getName();
		String item4Price = itemList.get(3).getPrice();
		String item4Stock = itemList.get(3).getStock();
		Item4Button.setText(item4Name + " $" + item4Price);
		
		JRadioButton Item5Button = new JRadioButton("");
		Item5Button.setBounds(194, 74, 145, 21);
		panel.add(Item5Button);
		String item5Name = itemList.get(4).getName();
		String item5Price = itemList.get(4).getPrice();
		String item5Stock = itemList.get(4).getStock();
		Item5Button.setText(item5Name + " $" + item5Price);
		
		JRadioButton Item6Button = new JRadioButton("");
		Item6Button.setBounds(351, 74, 145, 21);
		panel.add(Item6Button);
		String item6Name = itemList.get(5).getName();
		String item6Price = itemList.get(5).getPrice();
		String item6Stock = itemList.get(5).getStock();
		Item6Button.setText(item6Name + " $" + item6Price);
		
		// creating a button group to group all radio buttons
		ButtonGroup buttonGroup = new ButtonGroup(); 
		buttonGroup.add(Item1Button);
		buttonGroup.add(Item2Button);
		buttonGroup.add(Item3Button);
		buttonGroup.add(Item4Button);
		buttonGroup.add(Item5Button);
		buttonGroup.add(Item6Button);
		
		// set price of each item to its respective radio button
		Item1Button.setActionCommand("1");
		Item2Button.setActionCommand("2");
		Item3Button.setActionCommand("3");
		Item4Button.setActionCommand("4");
		Item5Button.setActionCommand("5");
		Item6Button.setActionCommand("6");
		

		Item1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stock = Integer.parseInt(item1Stock);
				if (stock == 0) {
					JOptionPane.showMessageDialog(null, item1Name + " is Out of Stock");
					buttonGroup.clearSelection();
				}
			}
		});
		
		Item2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stock = Integer.parseInt(item2Stock);
				if (stock == 0) {
					JOptionPane.showMessageDialog(null, item2Name + " is Out of Stock");
					buttonGroup.clearSelection();
				}
			}
		});
		
		Item3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stock = Integer.parseInt(item3Stock);
				if (stock == 0) {
					JOptionPane.showMessageDialog(null, item3Name + " is Out of Stock");
					buttonGroup.clearSelection();
				}
			}
		});

		Item4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stock = Integer.parseInt(item4Stock);
				if (stock == 0) {
					JOptionPane.showMessageDialog(null, item4Name + " is Out of Stock");
					buttonGroup.clearSelection();
				}
			}
		});

		Item5Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stock = Integer.parseInt(item5Stock);
				if (stock == 0) {
					JOptionPane.showMessageDialog(null, item5Name + " is Out of Stock");
					buttonGroup.clearSelection();
				}
			}
		});

		Item6Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stock = Integer.parseInt(item6Stock);
				if (stock == 0) {
					JOptionPane.showMessageDialog(null, item6Name + " is Out of Stock");
					buttonGroup.clearSelection();
				}
			}
		});
		
		JButton purchaseButton = new JButton("Purchase");
		purchaseButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buttonGroup.getSelection() == null) {
					JOptionPane.showMessageDialog(null, "Please choose an item");
				} else {
					String moneyInput = moneyField.getText().trim();
					if (Validation.validateMoney(moneyInput) == true) {
						Double money = Double.parseDouble(moneyInput);
						int itemIndex = Integer.parseInt(buttonGroup.getSelection().getActionCommand()) - 1; // get the item position and convert it to integer and -1 as index
						int stock = Integer.parseInt(itemList.get(itemIndex).getStock()); // get stock of the selected item
						Double price = Double.parseDouble(itemList.get(itemIndex).getPrice()); // get price of the selected item
						Double change = money - price;
						if (change < 0) {
							JOptionPane.showMessageDialog(null, "Insufficient money");
						} else { // if purchase is successful
							int newStock = stock - 1;
							try {
								Item.updateStock(itemIndex, newStock);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							changeField.setText(String.format("%.2f", change)); // limit to 2 decimal places
							JOptionPane.showMessageDialog(null, "Purchase successful");
							
							buttonGroup.clearSelection(); // clear all radio buttons
							moneyField.setText("");
							changeField.setText("");
							
							try {
								itemList = Item.getList(); // update item list after purchase has been done
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} 
						}
						
					}
				}
			}
		});
		purchaseButton.setBounds(384, 242, 115, 34);
		contentPane.add(purchaseButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonGroup.clearSelection(); // clear all radio buttons
				
				moneyField.setText("");
				changeField.setText("");
			}
		});
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		clearButton.setBounds(384, 296, 115, 34);
		contentPane.add(clearButton);
		
		JLabel moneyLabel = new JLabel("Insert Money: ");
		moneyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		moneyLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		moneyLabel.setBounds(95, 252, 78, 15);
		contentPane.add(moneyLabel);
		
		JLabel changeLabel = new JLabel("Change: ");
		changeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		changeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		changeLabel.setBounds(95, 306, 78, 15);
		contentPane.add(changeLabel);
		
		moneyField = new JTextField();
		moneyField.setBounds(194, 251, 101, 19);
		contentPane.add(moneyField);
		moneyField.setColumns(10);
		
		changeField = new JTextField();
		changeField.setEditable(false);
		changeField.setColumns(10);
		changeField.setBounds(194, 305, 101, 19);
		contentPane.add(changeField);
		
		JButton adminButton = new JButton("Admin");
		adminButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame.open(); // open login frame
				dispose(); // close current frame
			}
		});
		adminButton.setBounds(10, 354, 101, 29);
		contentPane.add(adminButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // terminate the program
			}
		});
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		exitButton.setBounds(505, 354, 101, 29);
		contentPane.add(exitButton);
	}
}
