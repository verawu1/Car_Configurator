package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Util.CustomerExcpetion;
import Util.Deserialize;
import Util.ReadFile;
import Util.Serialize;

public class SuperUser implements Updateble, Configurable{
	
	private ReadFile readFile = new ReadFile();
	private ModelSet modelSet;
	
	public SuperUser(ModelSet modelSet) {
		this.modelSet = modelSet;
	}
	
	public void listModels(ModelSet modelSet) {
		System.out.println(modelSet.toString());
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
	
	public GasAutomobile configureAutomobile(ModelSet modelSet) {
		String choice = chooseModel();
		while(true) {
			if(modelSet.getModelSet().containsKey(choice)) {
				break;
			} else {
				System.out.println("Please enter again:");
				choice = chooseModel();
			}
		}
		GasAutomobile automobile = (GasAutomobile) modelSet.getModelSet().get(choice);
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
	
	public void addModel() {
		String fileName = "";
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the file name:");
		try {
			fileName = keyboard.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readFile(fileName);
		
		System.out.println("Successfully build model");
	}
	
	public void updateOptionSetName(String modelName, String oldName, String newName) {
		boolean makeTheRightChoice = false;
		while(makeTheRightChoice == false) {
			try {
				GasAutomobile auto = (GasAutomobile) modelSet.getAutomobile(modelName);
				auto.updateOptionSetName(oldName, newName);
				makeTheRightChoice = true;
			} catch(CustomerExcpetion e) {
				if(e.getErrorNum() == 3) {
					oldName = e.newEnterForFix("OptionSet");
				}
				if(e.getErrorNum() == 2) {
					modelName = e.newEnterForFix("Automobile");
				}
			}
		}
		makeTheRightChoice = false;
	}
	
	public void updateOptionSetBasePrice(String modelName, String optionSetName, int price)  {
		boolean makeTheRightChoice = false;
		while(makeTheRightChoice == false) {
			try {
				GasAutomobile auto = (GasAutomobile) modelSet.getAutomobile(modelName);
				auto.updateOptionSetBasePrice(optionSetName, price);
				makeTheRightChoice = true;
			} catch(CustomerExcpetion e) {
				if(e.getErrorNum() == 3) {
					optionSetName = e.newEnterForFix("OptionSet");
				}
				if(e.getErrorNum() == 2) {
					modelName = e.newEnterForFix("Automobile");
				}
			}
		}
		makeTheRightChoice = false;
	}
	
	public void updateOptionName(String modelName, String optionSetName, String oldName, String newName)  {
		boolean makeTheRightChoice = false;
		while(makeTheRightChoice == false) {
			try {
				GasAutomobile auto = (GasAutomobile) modelSet.getAutomobile(modelName);
				auto.updateOptionName(oldName, newName, optionSetName);
				makeTheRightChoice = true;
			} catch(CustomerExcpetion e) {
				if(e.getErrorNum() == 3) {
					optionSetName = e.newEnterForFix("OptionSet");
				}
				if(e.getErrorNum() == 4) {
					oldName = e.newEnterForFix("Option");
				}
				if(e.getErrorNum() == 2) {
					modelName = e.newEnterForFix("Automobile");
				}
			}
		}
		makeTheRightChoice = false;
	}
	
	public void updateOptionPrice(String modelName, String optionSetName, String optionName, int price) {
		boolean makeTheRightChoice = false;
		while(makeTheRightChoice == false) {
			try {
				GasAutomobile auto = (GasAutomobile) modelSet.getAutomobile(modelName);
				auto.updateOptionPrice(optionName, optionSetName, price);
				makeTheRightChoice = true;
			} catch(CustomerExcpetion e) {
				if(e.getErrorNum() == 3) {
					optionSetName = e.newEnterForFix("OptionSet");
				}
				if(e.getErrorNum() == 4) {
					optionName = e.newEnterForFix("Option");
				}
				if(e.getErrorNum() == 2) {
					modelName = e.newEnterForFix("Automobile");
				}
			}
		}
		makeTheRightChoice = false;
	}
	
	public void addOptionSet(String modelName, String optionSetName, int count) {
		boolean makeTheRightChoice = false;
		while(makeTheRightChoice == false) {
			try {
				GasAutomobile auto = (GasAutomobile) modelSet.getAutomobile(modelName);
				auto.addOptionSet(optionSetName, count);
				makeTheRightChoice = true;
			} catch(CustomerExcpetion e) {
				if(e.getErrorNum() == 3) {
					optionSetName = e.newEnterForFix("OptionSet");
				}
				if(e.getErrorNum() == 2) {
					modelName = e.newEnterForFix("Automobile");
				}
			}
		}
		makeTheRightChoice = false;
	}
	
	public void addOption(String modelName, String optionSetName, String optionName, int price){
		boolean makeTheRightChoice = false;
		while(makeTheRightChoice == false) {
			try {
				GasAutomobile auto = (GasAutomobile) modelSet.getAutomobile(modelName);
				auto.addOption(optionName, optionSetName, price);
				makeTheRightChoice = true;
			} catch(CustomerExcpetion e) {
				if(e.getErrorNum() == 3) {
					optionSetName = e.newEnterForFix("OptionSet");
				}
				if(e.getErrorNum() == 4) {
					optionName = e.newEnterForFix("Option");
				}
				if(e.getErrorNum() == 2) {
					modelName = e.newEnterForFix("Automobile");
				}
			}
		}
		makeTheRightChoice = false;
	}
	
	public void deleteOptionSet(String modelName, String optionSetName) {
		boolean makeTheRightChoice = false;
		while(makeTheRightChoice == false) {
			try {
				GasAutomobile auto = (GasAutomobile) modelSet.getAutomobile(modelName);
				auto.deleteOptionSet(optionSetName);
				makeTheRightChoice = true;
			} catch(CustomerExcpetion e) {
				if(e.getErrorNum() == 3) {
					optionSetName = e.newEnterForFix("OptionSet");
				}
				if(e.getErrorNum() == 2) {
					modelName = e.newEnterForFix("Automobile");
				}
			}
		}
		makeTheRightChoice = false;
	}
	
	public void deleteOption(String modelName, String optionSetName, String optionName) {
		boolean makeTheRightChoice = false;
		while(makeTheRightChoice == false) {
			try {
				GasAutomobile auto = (GasAutomobile) modelSet.getAutomobile(modelName);
				auto.deleteOption(optionName, optionSetName);
				makeTheRightChoice = true;
			} catch(CustomerExcpetion e) {
				if(e.getErrorNum() == 3) {
					optionSetName = e.newEnterForFix("OptionSet");
				}
				if(e.getErrorNum() == 4) {
					optionName = e.newEnterForFix("Option");
				}
				if(e.getErrorNum() == 2) {
					modelName = e.newEnterForFix("Automobile");
				}
			}
		}
		makeTheRightChoice = false;
	}
	
	public void setOption(String modelName, String optionSetName, int index, String optionName, int price) {
		boolean makeTheRightChoice = false;
		while(makeTheRightChoice == false) {
			try {
				GasAutomobile auto = (GasAutomobile) modelSet.getAutomobile(modelName);
				auto.setOption(optionSetName, index, optionName, price);
				makeTheRightChoice = true;
			} catch(CustomerExcpetion e) {
				if(e.getErrorNum() == 3) {
					optionSetName = e.newEnterForFix("OptionSet");
				}
				if(e.getErrorNum() == 4) {
					optionName = e.newEnterForFix("Option");
				}
				if(e.getErrorNum() == 2) {
					modelName = e.newEnterForFix("Automobile");
				}
			}
		}
		makeTheRightChoice = false;
	}
	
	private void readFile(String fileName) {
		boolean readTheRightFile = false;
		while(readTheRightFile == false){
			try {
				readFile.readModelSetFile(modelSet, fileName);
				readTheRightFile = true;
			} catch (CustomerExcpetion e) {
				fileName = e.newEnterForFix("model file");
			}
		}		
	}
}
