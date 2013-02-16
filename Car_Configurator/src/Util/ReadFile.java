package Util;
import java.io.*;
import java.util.ArrayList;

import Model.*;

public class ReadFile { 
public void readModelSetFile(ModelSet modelSet, String fileName) throws CustomerExcpetion{
		BufferedReader buff;
		ArrayList<OptionSet> optionSets = null;
		GasAutomobile automobile = null;
		int optionSetIndex = 0;
		boolean readTheCorrectFile = false;
		while(readTheCorrectFile == false) {
			try {
				buff = new BufferedReader(new FileReader(fileName));
				readTheCorrectFile = true;
				while(true) {
					String line = buff.readLine();
					if(line == null) {
						break;
					}
				
					if(line.length() > 1) {
						//if this line is the information of the car make, model and price
						if(line.indexOf(":") == -1 && line.indexOf(",") != -1) {
							if(automobile != null) {
								modelSet.addAutomobile(automobile.getMake() + " " + automobile.getModel(), automobile);
							}
							automobile = new GasAutomobile();
							optionSets = automobile.getOptionSets();
							optionSetIndex = -1;
							String make = line.substring(0, line.indexOf(","));
							String model = line.substring(line.indexOf(",") + 1, line.indexOf(",", line.indexOf(",") + 1) ).trim();
							String priceString = line.substring(line.indexOf(",",line.indexOf(",") + 1 ) + 1).trim();
							int price = Integer.parseInt(priceString);
							automobile.setMake(make);
							automobile.setModel(model);
							automobile.setBasePrice(price);
						}
						//If this line is the OptionSet's name, create a new OptionSet object with 
						//the name and add it into the ArrayList optionSets
						else {
							if(line.indexOf(":") != -1) {
								if(line.substring(line.indexOf(":")).trim().equals(":")) {
								optionSetIndex ++;
								String optionSetName = line.substring(0, line.indexOf(":"));
								optionSets.add(new OptionSet(optionSetName));
								} else {
									//If this line is the option name and price,create a new Option object with 
									//the name and the price and add it into the ArrayList options in 
									//the corresponding OptionSet object
									String optionName = line.substring(0, line.indexOf(":"));
									int optionPrice = Integer.parseInt((line.substring(line.indexOf(":") + 1)).trim());
									optionSets.get(optionSetIndex).addOption(optionName, optionPrice);
								}
							}
						}
					}
				}
				modelSet.addAutomobile(automobile.getMake() + " " + automobile.getModel(), automobile);
				buff.close();
			} catch(IOException e) {
				throw new CustomerExcpetion("No such model file " + fileName + " exiest!", 1);
			}
		}
		readTheCorrectFile = false;
	}

public GasAutomobile readModelSetFile(String fileName) throws CustomerExcpetion{
	BufferedReader buff;
	ArrayList<OptionSet> optionSets = null;
	GasAutomobile automobile = null;
	int optionSetIndex = 0;
	boolean readTheCorrectFile = false;
	while(readTheCorrectFile == false) {
		try {
			buff = new BufferedReader(new FileReader(fileName));
			readTheCorrectFile = true;
			while(true) {
				String line = buff.readLine();
				if(line == null) {
					break;
				}
			
				if(line.length() > 1) {
					//if this line is the information of the car make, model and price
					if(line.indexOf(":") == -1 && line.indexOf(",") != -1) {
						automobile = new GasAutomobile();
						optionSets = automobile.getOptionSets();
						optionSetIndex = -1;
						String make = line.substring(0, line.indexOf(","));
						String model = line.substring(line.indexOf(",") + 1, line.indexOf(",", line.indexOf(",") + 1) ).trim();
						String priceString = line.substring(line.indexOf(",",line.indexOf(",") + 1 ) + 1).trim();
						int price = Integer.parseInt(priceString);
						automobile.setMake(make);
						automobile.setModel(model);
						automobile.setBasePrice(price);
					}
					//If this line is the OptionSet's name, create a new OptionSet object with 
					//the name and add it into the ArrayList optionSets
					else {
						if(line.indexOf(":") != -1) {
							if(line.substring(line.indexOf(":")).trim().equals(":")) {
							optionSetIndex ++;
							String optionSetName = line.substring(0, line.indexOf(":"));
							optionSets.add(new OptionSet(optionSetName));
							} else {
								//If this line is the option name and price,create a new Option object with 
								//the name and the price and add it into the ArrayList options in 
								//the corresponding OptionSet object
								String optionName = line.substring(0, line.indexOf(":"));
								int optionPrice = Integer.parseInt((line.substring(line.indexOf(":") + 1)).trim());
								optionSets.get(optionSetIndex).addOption(optionName, optionPrice);
							}
						}
					}
				}
			}
			buff.close();
		} catch(IOException e) {
			throw new CustomerExcpetion("No such model file " + fileName + " exiest!", 1);
		}
	}
	readTheCorrectFile = false;
	return automobile;
}
}