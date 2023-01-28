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

	public static void main(String[] args) {
		JetsApp ja = new JetsApp();
		boolean isTrue = true;
		
		ja.launch();
		while (isTrue) {
		ja.displayUserMenu(ja.sc);
		}
	}

	private void launch() {
		airF.readJets(fileName);
//		List<Jet> output = airF.readJets(fileName);
//		System.out.println(output);

	}

	private boolean displayUserMenu(Scanner sc) {

		System.out.println("Main Menu:");
		System.out.println("Select the corresponding number from the menu below.");
		System.out.println();
		System.out.println("1. List Fleet\n2. Fly all Jets\n3. View fastest jet\n4. View jet with longest range\n5. Load all Cargo Jets\n6. Dogfight!\n7. Add a jet to Fleet\n8. Remove a jet from Fleet\n9. Quit\n");					
		int numSelection = sc.nextInt();
		switch (numSelection) {
		case 1:
			for (Jet jet : airF.getFleet()) {
				System.out.println(jet);
				System.out.println("__________________________________________________________________________________________________________________________");
			}
			break;
		case 2:
			System.out.println("Cleared for takeoff");
			for (Jet jetToFly : airF.getFleet()) {
				jetToFly.fly();
			} 
			break;
		case 3:
			airF.showFastedJet();
			break;
		case 4:
			airF.showLongestRange();
			break;
		case 5:
			airF.loadingCargo();
			break;
		case 6:		
			airF.dogFight();
			break;
		case 7:
			addNewJet(sc);
			break;
		case 8:
			//addNewJet(sc);
			break;
		case 9:
			System.out.println("Quitting Program");
			sc.close();
			return false;
		default:
			if (numSelection < 1 || numSelection > 9) {
			System.err.println("Invalid Entry: Please select numbers 1-9.\nEnter any number and select enter to return to menu");
			sc.nextLine();
			numSelection = sc.nextInt();
			}
			break;
			
		}
		return true;
	}
	
	public void addNewJet(Scanner sc) {
		String newType, newModel, newGuns, newMissiles;
		Double newSpeed;
		int newRange,newMaxWeight, newCapacity, selection ;
		long newPrice;
		
		System.out.println("Please follow the prompts to enter a new plane");
		System.out.println("Enter the type of aircraft you wish to add\n1.Fighter\n2.Cargo\n3.Passenger");
		
		selection = sc.nextInt();
		switch (selection) {
		case 1 :
			newType = "Fighter";
			System.out.println("Enter the model");
			newModel = sc.nextLine();
			sc.nextLine();
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
			System.out.println("New aircraft added to airfield");
			break;
		case 2 :
			newType = "Cargo";
			System.out.println("Enter the model");
			newModel = sc.nextLine();
			sc.nextLine();
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
			System.out.println("New aircraft added to airfield");
			break;
		case 3 :
			newType = "Passenger";
			System.out.println("Enter the model");
			newModel = sc.nextLine();
			sc.nextLine();
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
			System.out.println("New aircraft added to airfield");
			break;
		}
	}

	public void removeJet(Scanner sc) {
	
	}

}
