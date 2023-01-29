package com.skilldistillery.entities;

import java.text.DecimalFormat;

public class CargoPlane extends Jet implements CargoCarrier {
	private int maxWeight;

	public CargoPlane() {

	}

	public CargoPlane(String type, String model, Double speed, int range, long price, int maxWeight) {
		super(type, model, speed, range, price);
		this.maxWeight = maxWeight;

	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public void fly() {
		DecimalFormat df = new DecimalFormat("#.#");
		double flightTime = this.getRange() / this.getSpeed();		System.out.println("______________________________________________________________________________________");
		System.out.println("Cargo plane " + this.getModel() + " Taking Off!\n With max range of " + this.getRange()
				+ "NM at cruising speed of " + this.getSpeed() + " MPH, flying time is " + df.format(flightTime)
				+ "hrs.");
		System.out.println("______________________________________________________________________________________");
	}

	public void loadCargo() {	
System.out.println("LOAD AIRCRAFT");		System.out.println("___________________________________________________________");
		System.out.println(
				"Loading Cargo Aircraft: " + this.getModel() + "\nREMINDER: MAX WEIGHT ALLOWED IS: " + this.maxWeight);
		System.out.println("___________________________________________________________");
	}

	@Override
	public String toString() {
		return "Cargo Plane [Model: " + this.getModel() + ", Crusing Speed: " + getSpeed() + ", Range: " + getRange()
				+ ", Price: " + getPrice() + ", Max Weight: " + maxWeight + "]";
	}

	
}
