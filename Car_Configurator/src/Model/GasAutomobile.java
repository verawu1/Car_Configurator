/* UserAutomobile.java */
package Model;

import Util.CustomerExcpetion;

public class GasAutomobile extends Automobile {
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getMake() + " " + getModel() + ": " + getBasePrice());
		sb.append("\n");
		for(int i = 0; i < getOptionSets().size(); i ++) {
			sb.append(getOptionSets().get(i).toString());
		}
		return sb.toString();
	}
	
	public String choice() {	
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < getOptionSets().size(); i ++) {
			try {
				sb.append(getOptionSets().get(i).getName());
				sb.append(":");
				sb.append("\n");
				sb.append(getOptionChoice(getOptionSets().get(i).getName()));
				sb.append(": ");
				sb.append(getOptionChoicePrice(getOptionSets().get(i).getName()));
				sb.append("\n");
			} catch (CustomerExcpetion e) {
				System.out.println("Impossible thing happens....");
			}
		}
		sb.append("The total price is:");
		sb.append(getTotalPirce());
		sb.append("\n");
		return sb.toString();
	}
}