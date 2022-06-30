import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EditFrame extends JFrame {

	private JPanel contentPane;
	private JTextField itemNameField;
	private JTextField itemPriceField;
	private JTextField itemStockField;
	
	private static int itemIndex;
	private static ArrayList<Item> itemList;

	/**
	 * Launch the application.
	 */
	public static void open(int index) {
		itemIndex = index;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itemList = Item.getList();
					EditFrame editFrame = new EditFrame();
					editFrame.setLocationRelativeTo(null);
					editFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				AdminFrame.reload();
			}
		});
		setResizable(false);
		setTitle("Vending Machine");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel adminFrameTitle = new JLabel("Edit Item Panel");
		adminFrameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		adminFrameTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		adminFrameTitle.setBounds(10, 10, 396, 46);
		contentPane.add(adminFrameTitle);
		
		JLabel itemNameLabel = new JLabel("Item Name: ");
		itemNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		itemNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itemNameLabel.setBounds(71, 89, 82, 23);
		contentPane.add(itemNameLabel);
		
		JLabel itemPriceLabel = new JLabel("Item Price: ");
		itemPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		itemPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itemPriceLabel.setBounds(71, 134, 82, 23);
		contentPane.add(itemPriceLabel);
		
		JLabel itemStockLabel = new JLabel("Item Stock: ");
		itemStockLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		itemStockLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itemStockLabel.setBounds(71, 182, 82, 23);
		contentPane.add(itemStockLabel);
		
		itemNameField = new JTextField();
		itemNameField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itemNameField.setBounds(191, 91, 143, 19);
		contentPane.add(itemNameField);
		itemNameField.setColumns(10);
		
		String itemName = itemList.get(itemIndex).getName();
		itemNameField.setText(itemName);
		
		itemPriceField = new JTextField();
		itemPriceField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itemPriceField.setColumns(10);
		itemPriceField.setBounds(191, 137, 143, 19);
		contentPane.add(itemPriceField);
		
		String itemPrice = itemList.get(itemIndex).getPrice();
		itemPriceField.setText(itemPrice);
		
		itemStockField = new JTextField();
		itemStockField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itemStockField.setColumns(10);
		itemStockField.setBounds(191, 185, 143, 19);
		contentPane.add(itemStockField);
		
		String itemStock = itemList.get(itemIndex).getStock();
		itemStockField.setText(itemStock);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean update = true;
				
				String modifiedName = itemNameField.getText();
				String modifiedPrice = itemPriceField.getText();
				String modifiedStock = itemStockField.getText();
				
				if (modifiedName.equals(itemName) && modifiedPrice.equals(itemPrice) && modifiedStock.equals(itemStock)) {
					dispose();
				} 
				if (!modifiedName.equals(itemName)) {
					if (Validation.validateItemName(modifiedName) == false) {
						update = false;
					}
				} 
				if (!modifiedPrice.equals(itemPrice)) {
					if (Validation.validateItemPrice(modifiedPrice) == false) {
						update = false;
					}
				} 
				if (!modifiedStock.equals(itemStock)) {
					if (Validation.validateItemStock(modifiedStock) == false) {
						update = false;
					}
				}
				if (update == true) {
					try {
						Item.updateItem(itemIndex, modifiedName, modifiedPrice, modifiedStock);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					dispose();
				}
				
			}
		});
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		saveButton.setBounds(150, 233, 125, 34);
		contentPane.add(saveButton);
	}
}
