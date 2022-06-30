import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Admin {
	
	
	public static String[] getCredentials() throws FileNotFoundException {
		File adminFile = new File("admin.txt");
		Scanner file = new Scanner(adminFile);
		String username = file.nextLine();
		String password = file.nextLine();
		String[] arr = {username, password};
		
		file.close();
		return arr;
	}
	
	public static void updateCredentials(String modifiedUsername, String modifiedPassword) throws IOException {
		FileWriter file = new FileWriter("admin.txt");
		file.write(modifiedUsername + "\n" + modifiedPassword);
		file.close();
	}
}
