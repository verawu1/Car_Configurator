package main;


import test.TestEndUser;
import test.TestMedAdmin;
import Model.ModelSet;
import Util.BuildAuto;
import Util.CustomerExcpetion;

public class Test {
	public static void main(String[] args) throws CustomerExcpetion {
		BuildAuto buildAuto = new BuildAuto();
		ModelSet modelSet = buildAuto.buildAuto();

		TestEndUser test1 = new TestEndUser();
		test1.endUserTest(modelSet);
		
		TestMedAdmin test2 = new TestMedAdmin(modelSet);
		test2.testAdd();
		test2.testUpdate();
		test2.testDelete();	
	}
}
