package client_server;

import java.io.*;
import java.net.Socket;
import java.util.*;
import Model.*;
import Util.CustomerExcpetion;
import Util.ReadFile;
import Util.Serialize;

public class CarModelOptionsIO {
	
	private static ReadFile readFile = new ReadFile();
	
	public static void main(String[] args){
		final int CAR_PORT = 8888;
		try {
			Socket s  = new Socket("localhost", CAR_PORT);
			GasAutomobile auto;
			InputStream instream = s.getInputStream();
			OutputStream outstream =s.getOutputStream();
			
			System.out.println("Please enter the file name to build a model");		
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			String fileName = keyboard.readLine();
			auto = readFile(fileName);
			System.out.println("read file");
			
			ObjectOutputStream oos = new ObjectOutputStream(outstream);
			ObjectInputStream ois = new ObjectInputStream(instream);
			oos.writeObject(auto);
			outstream.flush();
			oos.flush();
			System.out.println("finish object");
			
			oos.writeObject("Client left");
			System.out.println((String)ois.readObject());

			ois.close();
			oos.close();
			s.close();
		} catch(IOException e) {
			System.out.println("ex");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static GasAutomobile readFile(String fileName) {
		boolean readTheRightFile = false;
		GasAutomobile auto = null;
		while(readTheRightFile == false){
			try {
				auto = readFile.readModelSetFile(fileName);
				readTheRightFile = true;
			} catch (CustomerExcpetion e) {
				fileName = e.newEnterForFix("model file");
			}
		}
		return auto;
	}
}
