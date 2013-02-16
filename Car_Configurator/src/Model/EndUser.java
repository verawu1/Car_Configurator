package Model;
import Util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EndUser implements Configurable{
	
	public void listModels(ModelSet modelSet) {
		modelSet.listModel();
	}
	
	public String chooseModel() {
		System.out.println("Please choose a model: ");
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		boolean enterCorrect = false;
		String choice = "";
		while(enterCorrect == false) {
			try {
				choice = keyboard.readLine();
				enterCorrect = true;
			} catch (IOException e) {
				System.out.println("Please enter again:");
			}
		}
		return choice;
	}
	
	
	//this function is for the user to configure a car
	public GasAutomobile configureAutomobile(ModelSet modelSet) {
		String choice = chooseModel();
		while(true) {
			if(modelSet.getModelSet().containsKey(choice)) {
				break;
			} else {
				System.out.println("No such model, Please enter again:");
				choice = chooseModel();
			}
		}
		GasAutomobile automobile = (GasAutomobile) modelSet.getModelSet().get(choice);
		System.out.println(automobile.toString());
		Serialize.serialize(choice, automobile);
		GasAutomobile userCar = (GasAutomobile) Deserialize.deserialize(choice);
		
		String optionSetName = "";
		String optionName = "";
		System.out.println("User begins to configure a automobile.");
		
		//read a optionSetName and a optionName to set the choice
		for(int i = 0; i < userCar.getOptionSets().size(); i ++) {
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
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
					userCar.setOptionChoice(optionSetName,optionName);
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
		return userCar;
	}
}