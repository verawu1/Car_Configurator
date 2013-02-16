package client_server;
import Model.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/** Using existing Car to build a model **/

public class BuildCarModelOptions implements Runnable {
	/* private instance variables */
	private Socket s = null;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ModelSet modelSet;
	private GasAutomobile automobile;
	
	/**
	 * Construct service object that processes commamds from
	 * a socket for a modelSet
	 */
	public BuildCarModelOptions(ModelSet modelSet) {
		this.modelSet = modelSet;
	}
	
	public void run() {
		final int CAR_PORT = 8888;
		ServerSocket server = null;
		
		//set server socket
		try {
			server = new ServerSocket(CAR_PORT);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("CarModel server waiting for clients to connect...");
		
		// server continues to work 
		while(true) {
			
			try {
				s = server.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Client connected, task: build a car model");		
			//build the model
			try {
				buildModel();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void buildModel() throws IOException, ClassNotFoundException {
		ois = new ObjectInputStream(s.getInputStream());
		oos = new ObjectOutputStream(s.getOutputStream());
		automobile = (GasAutomobile) ois.readObject();
	
		String name = automobile.getMake() + " " + automobile.getModel();
		System.out.println(automobile.toString());
		modelSet.addAutomobile(name, automobile);
		
		System.out.println((String)ois.readObject());
	
		oos.writeObject("Model " + name + " is created successfully");
		
		oos.close();
		ois.close();
		s.close();
		
		
	}
}
