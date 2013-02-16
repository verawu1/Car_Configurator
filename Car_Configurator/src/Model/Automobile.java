/* Automobile.java */

/**
 * The Automobile class is the abstraction of a automobile, it has an ArrayList of OptionSet
 * @author chenkaikuang
 */

package Model;
import java.io.Serializable;
import java.util.*;

import Util.CustomerExcpetion;
import Util.ReadFile;

public abstract class Automobile implements Serializable{
	private int _basePrice;
	private String _make;
	private String _model;
	private ArrayList<OptionSet> optionSets;
	
	public Automobile() {
		optionSets = new ArrayList<OptionSet>();
	}
	
	public String getMake() {
		return _make;
	}
	
	public  void  setMake(String make) {
		_make = make;
	}
	
	public String getModel() {
		return _model;
	}

	public  void setModel(String model) {
		_model = model;
	}

	public int getBasePrice() {
		return _basePrice;
	}
	
	public  void setBasePrice(int price) {
		_basePrice = price;
	}
	
	public ArrayList<OptionSet> getOptionSets() {
		return optionSets;
	}
	
	public  void setOptionSets(ArrayList<OptionSet> optionSets) {
		this.optionSets = optionSets;
	}
	
	public  void addOptionSet(String name, int count) {
		optionSets.add(new OptionSet(name, count));
	}
	
	public void updateOptionSet(String optionSetName, OptionSet optionSet) throws CustomerExcpetion{
		getOptionSet(optionSetName).setBasePrice(optionSet.getBasePrice());
		getOptionSet(optionSetName).setName(optionSet.getName());
		getOptionSet(optionSetName).setOptions(optionSet.getOptions());
	}
	
	public void updateOptionSetName(String oldName, String newName) throws CustomerExcpetion{
		getOptionSet(oldName).setName(newName);
	}
	
	public void updateOptionSetBasePrice(String optionSetName, int price) throws CustomerExcpetion{
		getOptionSet(optionSetName).setBasePrice(price);
	}
	
	public OptionSet getOptionSet(String name) throws CustomerExcpetion {
		try {
			return optionSets.get(findOptionSet(name));
		} catch(IndexOutOfBoundsException e) {
			throw new CustomerExcpetion("optionSet " + name + " doesn't exsit.", 3);
		}
	}

	public Option getOption(String setName, String optionName) throws CustomerExcpetion {
		return getOptionSet(setName).getOption(optionName);
	}
	
	public void setOption(String setName, int index, String optionName, int price) throws CustomerExcpetion {
		getOptionSet(setName).setOption(index, optionName, price);
	}
	
	public void addOption(String optionName, String optionSetName, int price) throws CustomerExcpetion {
		getOptionSet(optionSetName).addOption(optionName, price);
	}
	
	public void deleteOptionSet(String name) throws CustomerExcpetion {
		try {
			optionSets.remove(findOptionSet(name));
		} catch(IndexOutOfBoundsException e) {
			throw new CustomerExcpetion("optionSet " + name + " doesn't exsit.", 3);
		}
	}
	
	public void deleteOption(String optionName, String optionSetName) throws CustomerExcpetion {
		getOptionSet(optionSetName).deleteOption(optionName);
	}
	
	public void updateOptionName(String oldOptionName, String newOptionName, String optionSetName) throws CustomerExcpetion {
		getOptionSet(optionSetName).updateOptionName(oldOptionName, newOptionName);
	}
	
	public void updateOptionPrice(String optionName, String optionSetName, int newPrice) throws CustomerExcpetion {
		getOptionSet(optionSetName).updateOptionPrice(optionName, newPrice);
	}
	
	private int findOptionSet(String name) {
		for(int i = 0; i < optionSets.size(); i ++) {
			if(optionSets.get(i).getName().equals(name)) {
				return i;
			} 
		}
		return -1;
	}
	
	public String getOptionChoice(String setName) throws CustomerExcpetion {
		return getOptionSet(setName).getOptionChoice().getName();
	}
	
	public int getOptionChoicePrice(String setName) throws CustomerExcpetion {
		return getOptionSet(setName).getOptionChoice().getPrice();
	}
	
	public  void setOptionChoice(String setName, String optionName) throws CustomerExcpetion {
		getOptionSet(setName).setOptionChoice(optionName);
	}
	
	public int getTotalPirce() {
		int sum = _basePrice;
		for(int i = 0; i < optionSets.size(); i ++) {
			sum += optionSets.get(i).getOptionChoice().getPrice();
		}
		return sum;
	}
	
	public abstract String toString() ;
}

