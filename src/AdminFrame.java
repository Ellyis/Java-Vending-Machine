import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class AdminFrame extends JFrame {

	private JPanel contentPane;
	
	private static ArrayList<Item> itemList = MainFrame.itemList;
	private static AdminFrame adminFrame;

	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminFrame = new AdminFrame();
					adminFrame.setLocationRelativeTo(null);
					adminFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void reload() {
		try {
			itemList = Item.getList();
			adminFrame.dispose();
			AdminFrame.open();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public AdminFrame() {
		setResizable(false);
		setTitle("Vending Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel adminFrameTitle = new JLabel("Admin Panel");
		adminFrameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		adminFrameTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		adminFrameTitle.setBounds(10, 10, 596, 46);
		contentPane.add(adminFrameTitle);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Choose Item", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(35, 84, 539, 123);
		contentPane.add(panel);
			
		JRadioButton Item1Button = new JRadioButton("");
		Item1Button.setBounds(29, 40, 145, 21);
		panel.add(Item1Button);
		String item1Name = itemList.get(0).getName();
		String item1Price = itemList.get(0).getPrice();
		String item1Stock = itemList.get(0).getStock();
		Item1Button.setText(item1Name + " $" + item1Price);
		
		Item1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stock = Integer.parseInt(item1Stock);
				if (stock == 0) {
					JOptionPane.showMessageDialog(null, item1Name + " is Out of Stock");
				}
			}
		});
		
		JRadioButton Item2Button = new JRadioButton("");
		Item2Button.setBounds(194, 40, 145, 21);
		panel.add(Item2Button);
		
		String item2Name = itemList.get(1).getName();
		String item2Price = itemList.get(1).getPrice();
		String item2Stock = itemList.get(1).getStock();
		Item2Button.setText(item2Name + " $" + item2Price);
		
		Item2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stock = Integer.parseInt(item2Stock);
				if (stock == 0) {
					JOptionPane.showMessageDialog(null, item2Name + " is Out of Stock");
				}
			}
		});
		
		JRadioButton Item3Button = new JRadioButton("");
		Item3Button.setBounds(351, 40, 145, 21);
		panel.add(Item3Button);
		
		String item3Name = itemList.get(2).getName();
		String item3Price = itemList.get(2).getPrice();
		String item3Stock = itemList.get(2).getStock();
		Item3Button.setText(item3Name + " $" + item3Price);
		
		Item3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stock = Integer.parseInt(item3Stock);
				if (stock == 0) {
					JOptionPane.showMessageDialog(null, item3Name + " is Out of Stock");
				}
			}
		});
		
		JRadioButton Item4Button = new JRadioButton("");
		Item4Button.setBounds(29, 74, 145, 21);
		panel.add(Item4Button);
		
		String item4Name = itemList.get(3).getName();
		String item4Price = itemList.get(3).getPrice();
		String item4Stock = itemList.get(3).getStock();
		Item4Button.setText(item4Name + " $" + item4Price);
		
		Item4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stock = Integer.parseInt(item4Stock);
				if (stock == 0) {
					JOptionPane.showMessageDialog(null, item4Name + " is Out of Stock");
				}
			}
		});
		
		JRadioButton Item5Button = new JRadioButton("");
		Item5Button.setBounds(194, 74, 145, 21);
		panel.add(Item5Button);
		
		String item5Name = itemList.get(4).getName();
		String item5Price = itemList.get(4).getPrice();
		String item5Stock = itemList.get(4).getStock();
		Item5Button.setText(item5Name + " $" + item5Price);
		
		Item5Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stock = Integer.parseInt(item5Stock);
				if (stock == 0) {
					JOptionPane.showMessageDialog(null, item5Name + " is Out of Stock");
				}
			}
		});
		
		JRadioButton Item6Button = new JRadioButton("");
		Item6Button.setBounds(351, 74, 145, 21);
		panel.add(Item6Button);
		
		String item6Name = itemList.get(5).getName();
		String item6Price = itemList.get(5).getPrice();
		String item6Stock = itemList.get(5).getStock();
		Item6Button.setText(item6Name + " $" + item6Price);
		
		Item6Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stock = Integer.parseInt(item6Stock);
				if (stock == 0) {
					JOptionPane.showMessageDialog(null, item6Name + " is Out of Stock");
				}
			}
		});
		
		ButtonGroup buttonGroup = new ButtonGroup(); 
		buttonGroup.add(Item1Button);
		buttonGroup.add(Item2Button);
		buttonGroup.add(Item3Button);
		buttonGroup.add(Item4Button);
		buttonGroup.add(Item5Button);
		buttonGroup.add(Item6Button);
		
		Item1Button.setActionCommand("1");
		Item2Button.setActionCommand("2");
		Item3Button.setActionCommand("3");
		Item4Button.setActionCommand("4");
		Item5Button.setActionCommand("5");
		Item6Button.setActionCommand("6");		
		
		JButton removeStockButton = new JButton("Remove Stock");
		removeStockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buttonGroup.getSelection() == null) {
					JOptionPane.showMessageDialog(null, "Please choose an item");
				} else {
					int itemIndex = Integer.parseInt(buttonGroup.getSelection().getActionCommand()) - 1; // get the item position and convert it to integer and -1 as index
					int currentStock = Integer.parseInt(itemList.get(itemIndex).getStock());
					int amount = 0;

					JOptionPane.showMessageDialog(null, "Current stock: " + currentStock);
					while (true) {
						try {
							String input = JOptionPane.showInputDialog("Enter remove amount");
							if (input == null) { // if CANCEL or CLOSE button is chosen
						        break;
							} 
							amount = Integer.parseInt(input);
						    if (amount <= 0) {
						    	JOptionPane.showMessageDialog(null, "Minimum amount is 1");
								continue;
							} else if (currentStock - amount < 0) {
								JOptionPane.showMessageDialog(null, "Amount is larger than available stock");
								continue;
							} else { // if amount is valid
								break;
							}
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Please input integer");
						}
					}
										
					try {
						Item.removeStock(itemIndex, currentStock, amount);
						itemList = Item.getList();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					buttonGroup.clearSelection();	
				}
			}
		});
		removeStockButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		removeStockButton.setBounds(131, 294, 125, 34);
		contentPane.add(removeStockButton);
		
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.main(null); // re-open main frame
				dispose(); // close current frame
			}
		});
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		returnButton.setBounds(10, 354, 101, 29);
		contentPane.add(returnButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // terminate the program
			}
		});
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		exitButton.setBounds(505, 354, 101, 29);
		contentPane.add(exitButton);
		
		JButton addStockButton = new JButton("Add Stock");
		addStockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buttonGroup.getSelection() == null) {
					JOptionPane.showMessageDialog(null, "Please choose an item");
				} else {
					int itemIndex = Integer.parseInt(buttonGroup.getSelection().getActionCommand()) - 1; // get the item position and convert it to integer and -1 as index
					int currentStock = Integer.parseInt(itemList.get(itemIndex).getStock());
					int amount = 0;
					
					JOptionPane.showMessageDialog(null, "Current stock: " + currentStock);
					while (true) {
						try {
							String input = JOptionPane.showInputDialog("Enter add amount");
							if (input == null) { // if CANCEL or CLOSE button is chosen
						        break;
							} 
							amount = Integer.parseInt(input);
						    if (amount <= 0) {
						    	JOptionPane.showMessageDialog(null, "Minimum amount is 1");
								continue;
							} else { // if amount is valid
								break;
							}
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Please input integer");
						}
					}
					
					try {
						Item.addStock(itemIndex, currentStock, amount);
						itemList = Item.getList();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					buttonGroup.clearSelection();
				}
			}
		});
		addStockButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		addStockButton.setBounds(131, 238, 125, 34);
		contentPane.add(addStockButton);
		
		JButton editItemButton = new JButton("Edit Item");
		editItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buttonGroup.getSelection() == null) {
					JOptionPane.showMessageDialog(null, "Please choose an item");
				} else {
					int itemIndex = Integer.parseInt(buttonGroup.getSelection().getActionCommand()) - 1; // get the item count and -1 to access as index
					EditFrame.open(itemIndex);
				}
			}
		});
		editItemButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		editItemButton.setBounds(343, 238, 125, 34);
		contentPane.add(editItemButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonGroup.clearSelection();
			}
		});
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		clearButton.setBounds(343, 294, 125, 34);
		contentPane.add(clearButton);
		
		JButton settingsButton = new JButton("Settings");
		settingsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountFrame.open();
			}
		});
		settingsButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		settingsButton.setBounds(268, 354, 101, 29);
		contentPane.add(settingsButton);
	}
}
