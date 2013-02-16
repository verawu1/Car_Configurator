package test;
import Model.*;


public class TestEndUser {
	public void endUserTest(ModelSet modelSet) {
		System.out.println("This test is for EndUser. EndUser lists all the models and choose" +
				"one model by name, then configure it");
		EndUser endUser = new EndUser();
		endUser.listModels(modelSet);
		GasAutomobile userCar = endUser.configureAutomobile(modelSet);
		System.out.println(userCar.choice());
	}
}