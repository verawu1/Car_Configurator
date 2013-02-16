/* BuildAuto.java */

/** 
 * This class is for building different automobile model from different input files
 * All the model information is stored in a LinkHashMap
 * @author chenkaikuang
 **/

package Util;

import Model.*;

public class BuildAuto {
	
	private ReadFile readFile = new ReadFile();
	
	public ModelSet buildAuto() {
		ModelSet modelSet = new ModelSet();
		String fileName = "";
		
		// Build model 1
		fileName = "model1.txt";
		readFile(modelSet,fileName);
		System.out.println("Successfully build model");
		
//		//Build model 2
//		automobile = new GasAutomobile();
//		fileName = "model2.txt";
//		readFile(modelSet, fileName);
//		modelSet.addAutomobile(automobile.getMake() + " " + automobile.getModel(), automobile);
//		System.out.println("Successfully build model 2");
//		
//		//Build model 3
//		automobile = new GasAutomobile();
//		fileName = "model2.txt";
//		readFile(modelSet,fileName);
//		modelSet.addAutomobile(automobile.getMake() + " " + automobile.getModel(), automobile);
//		System.out.println("Successfully build model 3");
		
		return modelSet;
	}
	
	private void readFile(ModelSet modelSet, String fileName) {
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