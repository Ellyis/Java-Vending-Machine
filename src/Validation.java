import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

public class Validation {
	public static boolean validateMoney(String money) {
		if (money.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please insert money");
			return false;
		} else if (!money.matches("^\\d+(?:\\.\\d[0,5]?)?")) {
			JOptionPane.showMessageDialog(null, "Invalid money input");
			return false;
		}
		return true;
	}
	
	public static boolean validateCredentials(String username, String password) throws FileNotFoundException {
		if (username.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please enter username");
			return false;
		} else if (password.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please enter password");
			return false;
		} else {
			String correctUsername = Admin.getCredentials()[0];
			String correctPassword = Admin.getCredentials()[1];
			
			if (!username.equals(correctUsername)) {
				JOptionPane.showMessageDialog(null, "Wrong username");
				return false;
			} else if (!password.equals(correctPassword)) {
				JOptionPane.showMessageDialog(null, "Wrong password");
				return false;
			}
			return true;
		}
	}
	
	public static boolean validateItemName(String name) {
		if (name.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please enter item name");
			return false;
		} else if (!name.matches("^[a-zA-Z-]+")) {
			JOptionPane.showMessageDialog(null, "Only letters and hyphens are allowed", "Item Name", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (!name.matches("^[A-Z][A-Za-z\\-]+")) {
			JOptionPane.showMessageDialog(null, "First letter must be upper case", "Item Name", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		JOptionPane.showMessageDialog(null, "Item name successfully changed");
		return true;
	}
	
	public static boolean validateItemPrice(String price) {
		if (price.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please enter price");
			return false;
		} else if (!price.matches("^\\d+(?:\\.\\d[0,5]?)?")) {
			JOptionPane.showMessageDialog(null, "Invalid input", "Item Price", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		JOptionPane.showMessageDialog(null, "Item price successfully changed");
		return true;
	}
	
	public static boolean validateItemStock(String stock) {
		if (stock.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please enter stock");
			return false;
		} else if (!stock.matches("^[0-9]+")) {
			JOptionPane.showMessageDialog(null, "Please insert integer", "Item Stock", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		JOptionPane.showMessageDialog(null, "Item stock successfully changed");
		return true;
	}
	
	public static boolean validateUsername(String username) {
		if (username.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please enter username");
			return false;
		} else if (!username.matches("^[a-zA-z]\\w{4,19}")) {
			if (!username.matches("^[a-zA-Z].+")) {
				JOptionPane.showMessageDialog(null, "Username must start with a letter");
				return false;
			} else if (username.length() < 5 || username.length() > 20) {
				JOptionPane.showMessageDialog(null, "Username must be 5-20 characters long");
				return false;
			} else {
				JOptionPane.showMessageDialog(null, "Username should not contain special characters except underscore");
				return false;
			}
		}
		JOptionPane.showMessageDialog(null, "Username successfully changed");
		return true;
	}
	
	public static boolean validatePassword(String password) {
		if (password.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please enter username");
			return false;
		} else if (password.length() < 5 || password.length() > 20) {
			JOptionPane.showMessageDialog(null, "Username must be 5-20 characters long");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Password successfully changed");
		return true;
	}	
}
