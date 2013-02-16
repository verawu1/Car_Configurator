package client_server;
import Model.*;
import Util.CustomerExcpetion;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class CarOptionServer implements Runnable{
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ModelSet modelSet;
	private GasAutomobile automobile;
	private Socket s = null;
	
	public CarOptionServer(ModelSet modelSet) {
		this.modelSet = modelSet;
	}
	
	public void run() {
		ServerSocket server = null;
		try {
			server = new ServerSocket(5000);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Car option server waiting for clients to connect...");
		
		while(true) {
			try {
				s = server.accept();
				System.out.println("Client connected, task:Configure a model");
				carOption();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CustomerExcpetion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void carOption() throws IOException, ClassNotFoundException, CustomerExcpetion {
		oos = new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());
		
		oos.writeObject("List of the models");
		oos.writeObject(modelSet.listAllModel());
		oos.writeObject("Please choose a model(enter the model name)");
		oos.flush();
		
		System.out.println("Client begins to configure a model");
		GasAutomobile  automobile = null;
		
		while(true) {
	 		String clientResponse = (String)ois.readObject();
			automobile = modelSet.getAutomobile(clientResponse);
			if(automobile != null) {
				oos.writeObject("Right");
				break;
			}
			oos.writeObject("please enter the right model name");
		}
		
		System.out.println(automobile.toString());
		oos.writeObject(automobile);
		
		System.out.println((String)ois.readObject());
		
		ois.close();
		oos.close();
		s.close();
		
	}
}
