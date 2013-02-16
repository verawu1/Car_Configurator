package Model;

public class HybridAutomobile extends Automobile {
	private int rangePerFillup;
	
	public int getRangePerFillup(){
		return rangePerFillup;
	}
	
	public void setRangePerFillup(int rangePerFillup) {
		this.rangePerFillup = rangePerFillup;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < getOptionSets().size(); i ++) {
			sb.append(getOptionSets().get(i).toString());
		}
		return sb.toString();
	}
}
