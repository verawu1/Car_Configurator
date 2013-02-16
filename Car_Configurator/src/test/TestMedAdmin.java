package test;
import Model.*;
import Util.*;

public class TestMedAdmin {
	private ModelSet modelSet;
	
	public TestMedAdmin(ModelSet modelSet) {
		this.modelSet = modelSet;
	}
	
	public void testAdd() {
		System.out.println("Now test the addOption and addOptionSet functionality of MedAdmin.");
		MedAdmin medAdmin = new MedAdmin(modelSet);
		System.out.println("Now test addModel.");
		System.out.println("Before addModel:");
		medAdmin.listModels();
		System.out.println("Please enter model2.txt, otherwise the system will ask the user to enter again.");
		medAdmin.addModel();
		System.out.println("After addModel:");
		medAdmin.listModels();
		
		System.out.println(" ");
		System.out.println("Now test addOptionSet.");
		
		GasAutomobile auto = null;
		try {
			auto = modelSet.getAutomobile("Honda Accord");
		} catch (CustomerExcpetion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Add Color into Honda Accord with option: Red, Green, Black.");
		medAdmin.addOptionSet("Honda Accord", "Color", 2);
		medAdmin.setOption("Honda Accord", "Color",0, "Red", 0);
		medAdmin.setOption("Honda Accord", "Color",1, "Green", 30);
		medAdmin.addOption("Honda Accord", "Color", "Black", 0);
		System.out.println(auto.toString());
		
		System.out.println("Please enter model3.txt");
		medAdmin.addModel();
		System.out.println("Now addOptionSet, there is a typo in modelName, the system will let the user to enter a right model Name");
		medAdmin.addOptionSet("Toyot Matrix", "Color", 1);
		System.out.println("When set option, typo Colo instead Color.");
		medAdmin.setOption("Toyota Matrix", "Colo", 0, "Red", 0);
		try {
			auto = modelSet.getAutomobile("Toyota Matrix");
		} catch (CustomerExcpetion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(auto.toString());
	}
	
	public void testUpdate() {
		System.out.println("");
		MedAdmin medAdmin = new MedAdmin(modelSet);
		GasAutomobile auto = null;
		System.out.println("Now test the update(Audi Q7).");
		
		try {
			auto = modelSet.getAutomobile("Audi Q7");
		} catch (CustomerExcpetion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Before update Color to ColorSet.");
		System.out.println(auto.toString());
		medAdmin.updateOptionSetName( "Audi Q7", "Color", "ColorSet");
		System.out.println("After update Color to ColorSet");
		System.out.println(auto.toString());
		
		System.out.println("Update ABS in Brakes to ABS normal, ABS's price to 2000");
		medAdmin.updateOptionName("Audi Q7", "Brakes", "ABS", "ABS normal");
		System.out.println("Please enter ABS normal");
		medAdmin.updateOptionPrice("Audi Q7", "Brakes","ABS" , 2000);
		System.out.println(auto.toString());
	}
	
	public void testDelete( ) throws CustomerExcpetion {
		System.out.println("");
		MedAdmin medAdmin = new MedAdmin(modelSet);
		GasAutomobile auto = null;
		System.out.println("Now test the delete(BMW).");
		
		try {
			auto = modelSet.getAutomobile("BMW X5");
		} catch (CustomerExcpetion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Before delete Color.");
		System.out.println(auto.toString());
		System.out.println("Now delete Color.");
		System.out.println("typo Colo, please type Color.");
		medAdmin.deleteOptionSet("BMW X5", "Colo");
		System.out.println("After delete Color");
		System.out.println(auto.toString());
		
		System.out.println("Before delete Standard.");
		System.out.println("Typo Standa for Standard and Transmiss for Transmission.");
		medAdmin.deleteOption("BMW X5", "Tranmiss", "Standa");
		System.out.println("After delete Standard in Transmission");
		System.out.println(auto.toString());
	}
}