package Model;

import Util.CustomerExcpetion;

public interface Updateble {
	public void addModel();
	public void updateOptionSetName(String modelName,String oldName, String newName) ;
	public void updateOptionSetBasePrice(String modelName, String optionSetName, int price)  ;
	public void updateOptionName(String modelName, String optionSetName, String oldName, String newName) ;
	public void updateOptionPrice(String modelName, String optionSetName, String optionName, int price);
	public void addOptionSet(String modelName, String optionSetName, int count);
	public void addOption(String modelName, String optionSetName, String optionName, int price);
	public void setOption(String modelName, String optionSetName, int index, String optionName, int price);
	public void deleteOptionSet(String modelName, String optionSetName) throws CustomerExcpetion;
	public void deleteOption(String modelName, String optionSetName, String optionName) throws CustomerExcpetion;
}
