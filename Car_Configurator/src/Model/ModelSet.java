/* ModelSets.java */

/** 
 * Set of Models(GasAutomobile) is saved using LinkedHashMap
 * @author chenkaikuang
 */
package Model;

import java.io.Serializable;
import java.util.*;

import Util.CustomerExcpetion;

public class ModelSet implements Serializable{
	private LinkedHashMap<String, GasAutomobile> modelSet;
	
	public ModelSet() {
		modelSet = new LinkedHashMap();
	}
	
	public LinkedHashMap getModelSet() {
		return modelSet;
	}
	
	public GasAutomobile getAutomobile(String name) throws CustomerExcpetion {
		try {
			GasAutomobile auto = modelSet.get(name);
			return auto;
		} catch(NullPointerException e){
			throw new CustomerExcpetion("Model " + name +" doesn't exist.", 2);
		}
	}
	
	public void addAutomobile(String name, GasAutomobile model) {
		modelSet.put(name, model);
	}
	
	public void listModel() {
		String key = "";
		int i = 1;
		Iterator iterator = modelSet.keySet().iterator();
		System.out.println("Now list all the models:");
		while(iterator.hasNext()) {
			System.out.println(i + ". " + iterator.next());
			i ++;
		}
	}
	
	public String listAllModel() {
		StringBuffer sb = new StringBuffer();
		String key = "";
		int i = 1;
		Iterator iterator = modelSet.keySet().iterator();
		while(iterator.hasNext()) {
			sb.append(i + ". " + iterator.next());
			sb.append("\n");
			i ++;
		}
		return sb.toString();
	}
	
	public GasAutomobile listOneModel(String name) {
		return modelSet.get(name);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		String key = "";
		Iterator iterator = modelSet.keySet().iterator();
		while(iterator.hasNext()) {
			key = (String) iterator.next();
			GasAutomobile auto = modelSet.get(key);
			sb.append(auto.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}