package com.skilldistillery.entities;

import java.text.DecimalFormat;

public class PassengerPlane extends Jet{
	private int capacity;
	
	public PassengerPlane() {
		
	}
	
	public PassengerPlane(String type, String model, Double speed, int range, long price, int capacity) {
		super(type, model, speed, range, price);
		this.capacity = capacity;
	}
//flies all passenger planes	
	public void fly() {
		DecimalFormat df = new DecimalFormat("#.#");
		double flightTime = this.getRange() / this.getSpeed();
		System.out.println("______________________________________________________________________________________");
		System.out.println("Passenger plane " + this.getModel() + " Taking Off!\n With max range of " + this.getRange() + "NM at cruising speed of " + this.getSpeed()+ " MPH, flying time is " + df.format(flightTime) + "hrs.");	System.out.println("______________________________________________________________________________________");
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Passenger Plane [Model: " + getModel() + ", Cruising Speed: " + getSpeed() + ", Range: " + getRange() + ", Price: " + getPrice() + ", Passenger Capacity: " + capacity + "]";
	}



}
