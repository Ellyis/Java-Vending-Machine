import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Item {
	
	private String name;
	private String price;
	private String stock;
	
	private static ArrayList<Item> itemList;

	Item(String name, String price, String stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPrice() {
		return this.price;
	}
	
	public String getStock() {
		return this.stock;
	}
	
	public static ArrayList<Item> getList() throws FileNotFoundException {
			
			File itemFile = new File("items.txt");
			Scanner file = new Scanner(itemFile);
			ArrayList<Item> itemList = new ArrayList<Item>(); // an array list containing a list of all the items and its details
			
			while (file.hasNext()) {
				String item = file.nextLine(); // getting each line of the text file 
				
				String[] itemDetails = item.split(";"); // a list containing the item details like name, price and stock
				
				Item itemObject = new Item(itemDetails[0], itemDetails[1], itemDetails[2]); // creating an Item object
				itemList.add(itemObject); // add the created object into itemList
			}
			file.close();
	
			return itemList;
	}
	
	public static void addStock(int itemIndex, int currentStock, int amount) throws IOException {
		int newStock = currentStock + amount;
		if (currentStock != newStock) {
			updateStock(itemIndex, newStock);
			JOptionPane.showMessageDialog(null, "Updated stock: " + newStock);
		}
	}
	
	public static void removeStock(int itemIndex, int currentStock, int amount) throws IOException {
		int newStock = currentStock - amount;
		if (currentStock != newStock) {
			updateStock(itemIndex, newStock);
			JOptionPane.showMessageDialog(null, "Updated stock: " + newStock);
		}
	}
	
	public static void updateStock(int itemIndex, int newStock) throws IOException {
		itemList = Item.getList();
		String itemName = itemList.get(itemIndex).getName();
		String itemPrice = itemList.get(itemIndex).getPrice();
		String itemStock = itemList.get(itemIndex).getStock();

		List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("items.txt"), StandardCharsets.UTF_8));
		
		for (int i = 0; i < fileContent.size(); i++) {
		    if (fileContent.get(i).equals(itemName + ";" + itemPrice + ";" + itemStock)) {
		        fileContent.set(i, itemName + ";" + itemPrice + ";" + newStock);
		    }
		}
		Files.write(Paths.get("items.txt"), fileContent, StandardCharsets.UTF_8);
		
		itemList = Item.getList();
	}
	
	public static void updateItem(int itemIndex, String modifiedName,  String modifiedPrice, String modifiedStock) throws IOException {
		itemList = Item.getList();
		String itemName = itemList.get(itemIndex).getName();
		String itemPrice = itemList.get(itemIndex).getPrice();
		String itemStock = itemList.get(itemIndex).getStock();
		
		List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("items.txt"), StandardCharsets.UTF_8));

		for (int i = 0; i < fileContent.size(); i++) {
		    if (fileContent.get(i).equals(itemName + ";" + itemPrice + ";" + itemStock)) {
		        fileContent.set(i, modifiedName + ";" + modifiedPrice + ";" + modifiedStock);
		        break;
		    }
		}
		Files.write(Paths.get("items.txt"), fileContent, StandardCharsets.UTF_8);
		
		itemList = Item.getList();
	}
	
	
}
