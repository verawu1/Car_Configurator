/* OptionSet.java */

/**
 * The OptionSet class represents one set of options for a car, 
 * and has an ArrayList of Option and many APIs for further usage.
 * @author chenkaikuang
 */
package Model;

import java.io.Serializable;
import java.util.*;

import Util.CustomerExcpetion;


public class OptionSet implements Serializable{
	
	//private instance variables
	private String _name;
	private int _basePrice = 0;
	private Option optionChoice;
	private ArrayList<Option> options;
	
	public OptionSet() {
		options = new ArrayList<Option>();	
	}
	
	public OptionSet(String name) {
		_name = name;
		options = new ArrayList<Option>();
	}
	
	public OptionSet(String name, int count) {
		_name = name;
		options = new ArrayList<Option>();
		for(int i = 0; i < count; i ++) {
			Option tempOption = new Option();
			options.add(tempOption);
		}
	}
	
	public OptionSet(String name, ArrayList<Option> options) {
		_name = name;	
		this.options = options;
	}
	
	public OptionSet(OptionSet optionSet) {
		_name = optionSet.getName();
		_basePrice = optionSet.getBasePrice();
		optionChoice = optionSet.getOptionChoice();
		options = new ArrayList<Option>();
		options = optionSet.getOptions();
		
	}
	
	public String getName() {
		return _name;
	}
	
	public  void setName(String s) {
		_name = s;
	}
	
	public int getBasePrice() {
		return _basePrice;
	}
	
	public  void setBasePrice(int price) {
		_basePrice = price;
	}
	
	public int getPrice(){
		return (_basePrice + optionChoice.getPrice());
	}
	
	public Option getOptionChoice() {
		return optionChoice;
	}
	
	public  void setOptionChoice(String optionName) throws CustomerExcpetion {
			Option option = getOption(optionName);
			optionChoice = option;
	}
	
	public ArrayList<Option> getOptions() {
		return options;
	}
	
	public  void setOptions(ArrayList<Option> options) {
		this.options = options;
	}
	
	public  void addOption(String name, int price) {
		Option newOption = new Option(name, price);
		options.add(newOption);
	}
	
	public  void setOption(int i, String name, int price) {
		options.get(i).setName(name);
		options.get(i).setPrice(price);
	}
	
	public void updateOptionName(String oldName, String newName) throws CustomerExcpetion {
		getOption(oldName).setName(newName);
	}
	
	public void updateOptionPrice(String optionName, int newPrice) throws CustomerExcpetion {
		getOption(optionName).setPrice(newPrice);
	}
	
	public void updateOption(String oldName, String newName, int newPrice) throws CustomerExcpetion {
		getOption(oldName).setName(newName);
		getOption(oldName).setPrice(newPrice);
	}
	
	public void updateOption(String oldName, Option option) throws CustomerExcpetion{
		getOption(oldName).setName(option.getName());
		getOption(oldName).setPrice(option.getPrice());
	}
	
	public int getOptionPrice(String name) throws CustomerExcpetion {
			return getOption(name).getPrice();
	}
	
	public String getOptionName(String name) throws CustomerExcpetion {
			return getOption(name).getName();
	}
	
	public  void deleteOption(String name) throws CustomerExcpetion {
			options.remove(getOption(name));
	}
	
	public Option getOption(String name) throws CustomerExcpetion {
		int index = -1; //initial value -1
		for(int i = 0; i < options.size(); i ++) {
			if(options.get(i).getName().equals(name)) {
				index = i;
			} 
		}
		
		//if successfully find the Option correspond to name,return that option
		//else throw new CustomerException with a certain message
		try {
			Option option = options.get(index);
			return option;
		} catch(IndexOutOfBoundsException e) {
			throw new CustomerExcpetion("Option " + name +" doesn't exist.", 4);
		}
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(_name);
		sb.append(":");
		sb.append("\n");
		for(int i = 0; i < options.size(); i ++) {
			sb.append(options.get(i).toString());
			sb.append("\n");
		}
		sb.append("\n");
		return sb.toString();
	}
}