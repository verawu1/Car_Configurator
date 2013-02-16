package client_server;
import Model.*;
import Util.CustomerExcpetion;

import java.net.*;
import java.io.*;

public class SelectCarOption {
	final static int OPTION_PORT = 5000;
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", OPTION_PORT);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			String response;
			
			while((response = (String)ois.readObject()) != null) {
				System.out.println(response);
				if(response.equals("Please choose a model(enter the model name)")) break;
			}
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				String choice = keyboard.readLine();
				//write the choice to server
				oos.writeObject(choice);
				response = (String) ois.readObject();
				System.out.println(response);
				if(response.equals("Right")) break;
			}
			
			//get the model serialization file
			GasAutomobile automobile = (GasAutomobile)ois.readObject();
			System.out.println("Model information is:");
			System.out.println(automobile.toString());
			
			String optionSetName = "";
			String optionName = "";
			System.out.println("User begins to configure a automobile.");
			
			//read a optionSetName and a optionName to set the choice
			for(int i = 0; i < automobile.getOptionSets().size(); i ++) {
				keyboard = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please enter the optionSet name:");
				try {
					optionSetName = keyboard.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				System.out.println("Please enter the option name:");
				try {
					optionName = keyboard.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				boolean makeTheRightChoice = false;
		
				while(makeTheRightChoice == false) {
					try {
						automobile.setOptionChoice(optionSetName,optionName);
						makeTheRightChoice = true;
					} catch(CustomerExcpetion e) {
						if(e.getErrorNum() == 3) {
							optionSetName = e.newEnterForFix("OptionSet");
						}
						if(e.getErrorNum() == 4) {
							optionName = e.newEnterForFix("Option");
						}
					}
				}
				makeTheRightChoice = false;
			}
			
			System.out.println("");
			System.out.println("Your configure is:");
			System.out.println(automobile.choice());
			
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
		}
		
	}
}
