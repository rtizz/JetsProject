package com.skilldistillery.entities;

import java.text.DecimalFormat;

public class FighterJet extends Jet implements CombatReady {
	private String guns;
	private String missiles;
	
	public FighterJet() {
		
	}
	
	public FighterJet(String type, String model, Double speed, int range, long price, String guns, String missiles) {
	super(type, model, speed, range, price);
	this.guns = guns;
	this.missiles = missiles;
	}
	
//flies all fighters	
	public void fly() {
		DecimalFormat df = new DecimalFormat("#.#");	
		double flightTime = this.getRange() / this.getSpeed();
		System.out.println("______________________________________________________________________________________");
		System.out.println("Fighter jet " + this.getModel() + " Taking Off!\nWith max range of " + this.getRange() + "NM at cruising speed of " + this.getSpeed()+ " MPH, flying time is " + df.format(flightTime) + "hrs.");
		System.out.println("______________________________________________________________________________________");
	}
//implementation of interface	
	public void fight() {
		System.out.println("Fight!");
		if(this.getModel().equals("A-10")) {
System.out.println("_______________________________________________________________");
			System.out.println(this.getModel() + " Requesting gunrun! Final attack heading 070 degrees mag!");
			System.out.println("Using " + this.guns  + " guns");
			System.out.println("BRRRRRRRRRRRRRRRRRRR");
			System.out.println("Target Destroyed!");
			System.out.println("_______________________________________________________________");
		} else if (this.getModel().equals("F-15")) {
			System.out.println("_______________________________________________________________");
			System.out.println(this.getModel() + " Requesting 30 sec time on target with " + this.missiles);
			System.out.println("Cleared Hot! Weapons away! 30 seconds to impact");
			System.out.println("Target Destroyed!");
			System.out.println("_______________________________________________________________");
		}
	}
	
	
	public String getGuns() {
		return guns;
	}

	public void setGuns(String guns) {
		this.guns = guns;
	}

	public String getMissiles() {
		return missiles;
	}

	public void setMissiles(String missiles) {
		this.missiles = missiles;
	}

	@Override
	public String toString() {
		return "FighterJet [Model: " + getModel() + ", Cruising Speed: " + getSpeed() + ", Range: " + getRange() + ", Price: " + getPrice() + ", Weapons: Guns: " + guns + ", Missiles: " + missiles + "]";
	}

	


	
}
