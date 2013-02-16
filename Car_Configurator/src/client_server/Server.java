package client_server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import Model.*;
import Util.*;


public class Server {
	public static void main(String[] args) throws IOException {
		BuildAuto buildAuto = new BuildAuto();
		ModelSet modelSet = buildAuto.buildAuto();
		BuildCarModelOptions buildCarModel = new BuildCarModelOptions(modelSet);
		CarOptionServer carOption = new CarOptionServer(modelSet);
		EditOptionServer editOption = new EditOptionServer(modelSet);
		
		Thread one = new Thread(buildCarModel);
		Thread two = new Thread(carOption);
		Thread three = new Thread(editOption);
		one.start();
		System.out.println("one starts");
		two.start();
		System.out.println("two starts");
		three.start();
		System.out.println("three starts");
	}
}
