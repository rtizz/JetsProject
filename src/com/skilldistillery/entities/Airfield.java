package com.skilldistillery.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Airfield {
	private List<Jet> fleet = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	private Jet j;

	public Airfield() {

	}

	public List<Jet> readJets(String fileName) {
		Jet j = null;
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] lineSplit = line.split(",");
				String type = lineSplit[0];
				String model = lineSplit[1];
				double speed = Double.parseDouble(lineSplit[2]);
				int range = Integer.parseInt(lineSplit[3]);
				long price = Long.parseLong(lineSplit[4]);
				switch (type) {
				case "Fighter":
					j = new FighterJet(type, model, speed, range, price, lineSplit[5], lineSplit[6]);
					break;
				case "Cargo":
					j = new CargoPlane(type, model, speed, range, price, Integer.parseInt(lineSplit[5]));
					break;
				case "Passenger":
					j = new PassengerPlane(type, model, speed, range, price, Integer.parseInt(lineSplit[5]));
					break;
				default:
					System.out.println("NOT VALID");
					break;
				}
				fleet.add(j);
			}

		} catch (IOException e) {
			System.err.println(e);
		}
		return fleet;
	}

	public List<Jet> getFleet() {
		return fleet;

	}

	public void showFastedJet() {
//	for (Jet jet : fleet) {
		Jet fastest = null;
		double fastestJet = 0.0;
		for (int jet = 0; jet < fleet.size(); jet++) {
			if (fleet.get(jet).getSpeed() > fastestJet) {
				fastestJet = fleet.get(jet).getSpeed();
				fastest = fleet.get(jet);
			}
		}
		System.out.println("The fastest aircraft is " + fastest);
		System.out.println();

	}

	public void showLongestRange() {
		Jet longest = null;
		int longestRange = 0;
		for (int jet = 0; jet < fleet.size(); jet++) {
			if (fleet.get(jet).getRange() > longestRange) {
				longestRange = fleet.get(jet).getRange();
				longest = fleet.get(jet);
			}
		}
		System.out.println("The aircraft with the longest range is " + longest);
		System.out.println();

	}

	public void loadingCargo() {
		for (Jet jet : fleet) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargo();

			}
		}
	}
	
	public void dogFight() {
		for (Jet jet : fleet) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();

			}
		}
	}

	public void addNewJet(Jet jet) {
		fleet.add(jet);
		
	}

	public void removeJet(Jet jet) {
		fleet.remove(jet);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fleet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airfield other = (Airfield) obj;
		return Objects.equals(fleet, other.fleet);
	}



}
