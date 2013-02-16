package main;
import Model.*;
import Util.*;

public class Driver {
	public static void main(String[] argv) {
		BuildAuto buildAuto = new BuildAuto();
		ModelSet modelSet = buildAuto.buildAuto();
	
		EditOption editOne = new EditOption(modelSet);
		EditOption editTwo = new EditOption(modelSet);
		Thread one = new Thread(editOne, "one");
		Thread two = new Thread(editTwo, "two");
		one.start();
		two.start();
	}
}
