/* CustomerException.java */
package Util;
import java.io.*;

public class CustomerExcpetion extends Exception {
	private int number; //fileNotFound = 1, AumobileModelNotFound = 2, 
	//OptionSetNotFound = 3, OptionNotFound = 4
	private String message;
	
	public CustomerExcpetion() {
		super();
		printProblem();
	}
	
	public CustomerExcpetion(String message) {
		super();
		this.message = message;
		printProblem();
	}
	
	public CustomerExcpetion(String message, int number) {
		super();
		this.message = message;
		this.number = number;
		printProblem();
	}
	
	public int getErrorNum(){
		return number;
	}
	
	public void setErrorNum(int number) {
		this.number = number;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void printProblem() {
		System.out.println("Try to fix the problem [errorNum = " + number + 
				", errorMessage= " + message + "]");
	}
	
	
	//when the model name is wrong, program asks the user looply to enter a 
	//name until the file name is correct
	public String newEnterForFix(String prompt) {
		System.out.println("Please input a correct " + prompt + ":");
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		boolean enterCorrect = false;
		String newName = "";
		while(enterCorrect == false) {
			try {
				newName = keyboard.readLine();
				enterCorrect = true;
			} catch (IOException e) {
				System.out.println("Please enter a " + prompt +" name again:");
			}
		}
		return newName;
	}
}