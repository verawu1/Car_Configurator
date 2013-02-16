package Util;
import Model.*;
import java.io.*;

public class Deserialize {
	public static Automobile deserialize(String fileName) {
		try {
			FileInputStream fs = new FileInputStream(fileName);
			ObjectInputStream os = new ObjectInputStream(fs);
			try {
				Automobile automobile = (Automobile) os.readObject();
				os.close();
				return automobile;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				os.close();
				return null;
			}
		} catch(IOException e) {
			System.out.println("No such serialization file!");
			return null;
		}
	}
}