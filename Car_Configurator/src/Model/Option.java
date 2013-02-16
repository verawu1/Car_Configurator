/* Option.java */
/**
 * The Option class is the abstraction of the Option of a optionset.
 * @author chenkaikuang
 */

package Model;

import java.io.Serializable;

public class Option implements Serializable{
		private String _name;
		private int _price;
		
		public Option() {}
		
		public Option(String name, int price) {
			_name = name;
			_price = price;
		}
		
		public Option(Option option) {
			_name = option.getName();
			_price = option.getPrice();
		}
		
		public String getName() {
			return _name;
		}
		
		public void setName(String name) {
			_name = name;
		}
		
		public int getPrice() {
			return _price;
		}
		
		public synchronized void setPrice(int price) {
			_price = price;
		}
		
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(_name);
			sb.append(": ");
			sb.append(_price);
			return sb.toString();
		}
	}