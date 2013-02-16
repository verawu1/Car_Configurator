package client_server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import Model.GasAutomobile;
import Model.ModelSet;
import Util.CustomerExcpetion;

public class EditOptionServer implements Runnable{
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ModelSet modelSet;
	private GasAutomobile automobile;
	private Socket s = null;
	
	public EditOptionServer(ModelSet modelSet) {
		this.modelSet = modelSet;
	}
	
	public void run() {
		ServerSocket server = null;
		try {
			server = new ServerSocket(8889);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Edit Option waiting for clients to connect...");
		
		while(true) {
			try {
				s = server.accept();
				System.out.println("Client connected, task: EditOption");
				oos = new ObjectOutputStream(s.getOutputStream());
				ois = new ObjectInputStream(s.getInputStream());
				
				oos.writeObject(modelSet);
				System.out.println("Client begins to edit option");
				
				modelSet = (ModelSet) ois.readObject();
				System.out.println("Edit option finished. The new modelSet info:");
				System.out.println(modelSet.toString());
				System.out.println((String)ois.readObject());
				
				ois.close();
				oos.close();
				s.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
