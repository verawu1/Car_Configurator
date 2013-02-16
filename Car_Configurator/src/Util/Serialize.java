package Util;
import Model.*;
import java.io.*;

public class Serialize {
	
	public static void serialize(String fileName, Automobile model) {
		try {
			FileOutputStream fs = new FileOutputStream(fileName);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(model);
			os.close();
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
}