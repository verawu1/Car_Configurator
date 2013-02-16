package Util;


import java.io.*;
import java.util.*;

import Model.*;

public class EditOption implements Runnable {
	private ModelSet modelSet;
	private Automobile model;
	private Random random;
	private MedAdmin user;
	private String modelName;
	
	public EditOption(ModelSet modelSet) {
		this.modelSet = modelSet;
		random = new Random();
		user = new MedAdmin(modelSet);
		try {
			model = modelSet.getAutomobile("Audi Q7");
		} catch (CustomerExcpetion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		modelSet.listModel();
		System.out.println(Thread.currentThread().getName() + " Please choose a model(use the number)");
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String choice = "";
		int c = 0;
		String optionName = "";
		String optionSetName = "";
		String oldName = "";
		String newName = "";
		String priceS = "";
		boolean isChoice = false;
		int price = 0;
		synchronized (model) {
			
		//choose a model
		while(true) {
	
			
			while(isChoice == false)
			try {
				choice = keyboard.readLine();
				c = Integer.parseInt(choice);
				isChoice = true;
			} catch(NumberFormatException e) {
				System.out.println(Thread.currentThread().getName() + " Please enter a number and choose again!");
				continue;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			isChoice = false;
			
			if(c == 1) {
				try {
					model = modelSet.getAutomobile("BMW X5");
				} catch (CustomerExcpetion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				modelName = "BMW X5";
				break;
			} else if(c == 2) {
				try {
					model = modelSet.getAutomobile("Audi Q7");
				} catch (CustomerExcpetion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				modelName = "Audi Q7";
				break;
			} else if(c == 3) {
				try {
					model = modelSet.getAutomobile("Ford Wagon ZTW");
				} catch (CustomerExcpetion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				modelName = "Ford Wagon ZTW";
				break;
			} else {
				System.out.println(Thread.currentThread().getName() + " Please enter a number and choose again!");
				continue;
			}
		}
		
		System.out.print(model.toString());
		
		System.out.println(Thread.currentThread().getName() + " Please choose what you want to do:");
		System.out.println("1. edit OptionSet");
		System.out.println("2. edit Option in a given OptionSet");
		
		while(true) {
			
			while(isChoice == false)
				try {
					choice = keyboard.readLine();
					c = Integer.parseInt(choice);
					isChoice = true;
				} catch(NumberFormatException e) {
					System.out.println(Thread.currentThread().getName() + " Please enter a number and choose again!");
					continue;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				isChoice = false;
			
			//the user wants to edit the optionSet
			if(c == 1) {
				
				while(true) {
					System.out.println(Thread.currentThread().getName() + " Please choose what you want to do:");
					System.out.println("1. Add an OptionSet");
					System.out.println("2. Delete a given OptionSet");
					System.out.println("3. Change the OptionSet name");
					while(isChoice == false)
						try {
							choice = keyboard.readLine();
							c = Integer.parseInt(choice);
							isChoice = true;
						} catch(NumberFormatException e) {
							System.out.println(Thread.currentThread().getName() + " Please enter a number and choose again!");
							continue;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						isChoice = true;
					
					//if the user wants to add an optionSet
					if(c == 1) {
						System.out.println(Thread.currentThread().getName() + " Please enter the OptionSet name you want to add");
						try {
							optionSetName = keyboard.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						user.addOptionSet(modelName, optionSetName, 0);
						break;
					} else if(c == 2) {
						//the user wants to delete an optionSet
						System.out.println(Thread.currentThread().getName() + " Please enter the OptionSet name you want to delete");
						try {
							optionSetName = keyboard.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						user.deleteOptionSet(modelName, optionSetName);
						break;
					} else if(c == 3) {
						//the user wants to change the optionSet name
						System.out.println(Thread.currentThread().getName() + " Please enter the old name you want to change");
						try {
							oldName = keyboard.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						System.out.println(Thread.currentThread().getName() + " Please enter the new name you want to change");
						try {
							newName = keyboard.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						user.updateOptionSetName(modelName, oldName, newName);
						break;
					} else {
						System.out.println(Thread.currentThread().getName() + " Please enter a number and choose again!");
						continue;
					}
				}
				break;
			} else if(c == 2) {
				System.out.println(Thread.currentThread().getName() + " Please indicated which OptionSet you want to change");
				//the user wants to edit the option
				try {
					optionSetName = keyboard.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + " Please choose what you want to do:");
				System.out.println("1. Add a new Option");
				System.out.println("2. Delete a given Option");
				System.out.println("3. Change the Option name");
				System.out.println("4. Change the Option price");
				
				while(true) {
					while(isChoice == false)
						try {
							choice = keyboard.readLine();
							c = Integer.parseInt(choice);
							isChoice = true;
						} catch(NumberFormatException e) {
							System.out.println(Thread.currentThread().getName() + " Please enter a number and choose again!");
							continue;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						isChoice = true;
					
					if(c ==1) {
						System.out.println(Thread.currentThread().getName() + " Please enter the option name you want to add");
						try {
							optionName = keyboard.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " Please enter the price");
						while(isChoice == false)
							try {
								priceS = keyboard.readLine();
								price = Integer.parseInt(priceS);
								isChoice = true;
							} catch(NumberFormatException e) {
								System.out.println(Thread.currentThread().getName() + " Please enter a number and choose again!");
								continue;
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							isChoice = true;
						user.addOption(modelName, optionSetName, optionName, price);
						break;
						
					} else if(c == 2) {
						System.out.println(Thread.currentThread().getName() + " Please enter the option name you want to delete");
						
						try {
							optionName = keyboard.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						user.deleteOption(modelName, optionSetName, optionName);
						break;
						
					} else if(c == 3) {
						System.out.println(Thread.currentThread().getName() + " Please enter the old name");
						
						try {
							oldName = keyboard.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						System.out.println(Thread.currentThread().getName() + " Please enter the new name");
						
						try {
							newName = keyboard.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						user.updateOptionName(modelName, optionSetName, oldName, newName);
						
						break;
					} else if(c == 4) {
						System.out.println(Thread.currentThread().getName() + " Please enter the option name you want to change price");
						try {
							optionName = keyboard.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " Please enter the price you want to change");
						while(isChoice == false)
							try {
								priceS = keyboard.readLine();
								price = Integer.parseInt(priceS);
								isChoice = true;
							} catch(NumberFormatException e) {
								System.out.println(Thread.currentThread().getName() + " Please enter a number and choose again!");
								continue;
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							isChoice = true;
						user.updateOptionPrice(modelName, optionSetName, optionName, price);
						break;
					} else {
						System.out.println(Thread.currentThread().getName() + " Please enter a number and choose again!");
						continue;
					}
				}
				break;
			} else {
				System.out.println(Thread.currentThread().getName() + " Please enter a number and choose again!");
				continue;
			}
		}
		System.out.println(model.toString());
	}
}
}
