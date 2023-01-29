package com.skilldistillery.app;

import java.util.Scanner;

import com.skilldistillery.entities.Airfield;
import com.skilldistillery.entities.CargoPlane;
import com.skilldistillery.entities.FighterJet;
import com.skilldistillery.entities.Jet;
import com.skilldistillery.entities.PassengerPlane;

public class JetsApp {

	private Airfield airF = new Airfield();
	private Scanner sc = new Scanner(System.in);
	private String fileName = "jets.txt";
//main method
	public static void main(String[] args) {
		JetsApp ja = new JetsApp();
		boolean isTrue = true; //controlling variable for displayUserMenu loop.

		ja.launch();
		while (isTrue) {
		isTrue = ja.displayUserMenu(ja.sc);
		}
		ja.sc.close();
	}
//launch method - calls airfield
	private void launch() {
		airF.readJets(fileName);
	}
//diplayUserMenu - calls on all other classes through switch statement
	private boolean displayUserMenu(Scanner sc) {
//long lines are annoying in code but cleans up output significantly
		System.out.println("Main Menu:");
		System.out.println("Select the corresponding number from the menu below.");
		System.out.println();
		System.out.println(
				"1. List fleet\n2. Fly all aircraft\n3. View fastest aircraft\n4. View aircraft with longest range\n5. Load all Cargo Planes\n6. Dogfight!\n7. Add an aircraft to fleet\n8. Remove an aircraft from fleet\n9. Quit\n");
		int numSelection = sc.nextInt();
		switch (numSelection) {
		case 1: //Lists all aircraft
			for (Jet jet : airF.getFleet()) {
				System.out.println(jet);
				System.out.println(
						"__________________________________________________________________________________________________________________________");
			}
			break;
		case 2:// calls fly method in each aircraft
			System.out.println("Cleared for takeoff");
			for (Jet jetToFly : airF.getFleet()) {
				jetToFly.fly();
			}
			break;
		case 3://calls airfield to display fastest aircraft
			airF.showFastedJet();
			break;
		case 4://calls airfield to display aircraft with longest range
			airF.showLongestRange();
			break;
		case 5://calls airfield which partially implements and calls CargoPlane 
			airF.loadingCargo();
			break;
		case 6://calls airfield which partially implements and calls FighterJet.
			airF.dogFight();
			break;
		case 7: //called method below and allows new menu to prompt user to add to fleet.
			addNewJet(sc);
			break;
		case 8://called additional method below and allows new menu to prompt user to remove from fleet.
			removeJet(sc);
			break;
		case 9://quits program and returns false for boolean value to end while loop.
			System.out.println("Quitting Program");
			return false;
		default://corrects user if number other than 1-9 entered
			if (numSelection < 1 || numSelection > 9) {
				System.err.println(
						"Invalid Entry: Please select numbers 1-9.\nEnter any number and select enter to return to menu");
				sc.nextLine();
				numSelection = sc.nextInt();
			}
			break;
		}
		return true;
	}

	private void addNewJet(Scanner sc) {
		String newType, newModel, newGuns, newMissiles;
		Double newSpeed;
		int newRange, newMaxWeight, newCapacity, selection;
		long newPrice;

		System.out.println("Please follow the prompts to enter a new plane");
		System.out.println("Enter the number corresponding to the type of aircraft you wish to add\n1.Fighter\n2.Cargo\n3.Passenger");

		selection = sc.nextInt();
		switch (selection) {
		case 1:
			newType = "Fighter";
			System.out.println("Enter the model");
			newModel = sc.next();
			System.out.println("Enter the cruising speed");
			newSpeed = sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter the max range");
			newRange = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the price");
			newPrice = sc.nextLong();
			sc.nextLine();
			System.out.println("Time for weapons!\nEnter guns");
			newGuns = sc.nextLine();
			System.out.println("Enter missiles");
			newMissiles = sc.nextLine();
			FighterJet newJet = new FighterJet(newType, newModel, newSpeed, newRange, newPrice, newGuns, newMissiles);
			airF.addNewJet(newJet);
			System.out.println("New aircraft added to fleet");
			break;
		case 2:
			newType = "Cargo";
			System.out.println("Enter the model");
			newModel = sc.next();
			System.out.println("Enter the cruising speed");
			newSpeed = sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter the max range");
			newRange = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the price");
			newPrice = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter maximum weight capacity");
			newMaxWeight = sc.nextInt();
			sc.nextLine();
			CargoPlane newCargo = new CargoPlane(newType, newModel, newSpeed, newRange, newPrice, newMaxWeight);
			airF.addNewJet(newCargo);
			System.out.println("New aircraft added to fleet");
			break;
		case 3:
			newType = "Passenger";
			System.out.println("Enter the model");
			newModel = sc.next();
			System.out.println("Enter the cruising speed");
			newSpeed = sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter the max range");
			newRange = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the price");
			newPrice = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter maximum passenger capacity");
			newCapacity = sc.nextInt();
			sc.nextLine();
			PassengerPlane newPlane = new PassengerPlane(newType, newModel, newSpeed, newRange, newPrice, newCapacity);
			airF.addNewJet(newPlane);
			System.out.println("New aircraft added to fleet");
			break;
		}
	}
//Provides list of models for user to remove.
	private void removeJet(Scanner sc) {
	String jetToRemove = null;
	System.out.println("Choose which aircraft to remove by typing in the model as it is written");
	for (Jet jet : airF.getFleet()) {
		System.out.println(jet.getModel());
	}
	
	jetToRemove = sc.next();
	sc.nextLine();
	try {//For some reason, compiler didn't like the additional foreach loop, had to put trycatch in to sweep under rug.
	for (Jet rmJet : airF.getFleet()) {
		if(jetToRemove.equalsIgnoreCase(rmJet.getModel())) {
			airF.removeJet(rmJet);
	} 
	}

}catch(Exception e) {
}
	System.out.println("Aircraft removed from fleet");
}
}

