package client_server;
import Model.*;
import Util.CustomerExcpetion;
import java.net.*;
import java.io.*;
import Util.*;

public class EditOptionClient {
	final static int OPTION_PORT = 8889;
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", OPTION_PORT);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			String response;
			
			ModelSet modelSet = (ModelSet) ois.readObject();
			
			EditOption edit = new EditOption(modelSet);
			
			Thread thread = new Thread(edit,"Client");
			thread.start();
			thread.join();
			
			System.out.println("Update the option information to server.....");
			
			oos.writeObject(modelSet);
			
			oos.writeObject("Client Left");
			
			oos.close();
			ois.close();
			s.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
