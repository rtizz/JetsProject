package com.skilldistillery.entities;

import java.util.Objects;

public class Aircraft {
	private String name;
	private String weightClass;
	private String airCraftType;
	private int passengerCap;
	private int tailNumber;
	private boolean isCommercial;
	
public Aircraft(String name, String weightClass, String airCraftType, int passengerCap, int tailNumber, boolean isCommercial) {
	this.name = name;
	this.weightClass = weightClass;
	this.airCraftType = airCraftType;
	this.passengerCap = passengerCap;
	this.tailNumber = tailNumber;
	this.isCommercial = isCommercial;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getWeightClass() {
	return weightClass;
}

public void setWeightClass(String weightClass) {
	this.weightClass = weightClass;
}

public String getAirCraftType() {
	return airCraftType;
}

public void setAirCraftType(String airCraftType) {
	this.airCraftType = airCraftType;
}

public int getPassengerCap() {
	return passengerCap;
}

public void setPassengerCap(int passengerCap) {
	this.passengerCap = passengerCap;
}

public int getTailNumber() {
	return tailNumber;
}

public void setTailNumber(int tailNumber) {
	this.tailNumber = tailNumber;
}

public boolean isCommercial() {
	return isCommercial;
}

public void setCommercial(boolean isCommercial) {
	this.isCommercial = isCommercial;
}

@Override
public String toString() {
	return "Aircraft Name: " + name + ", Weight class: " + weightClass + ", Type: " + airCraftType + ", Max Passengers " + passengerCap
			+ ", Commercial: " + isCommercial + "]";
}

@Override
public int hashCode() {
	return Objects.hash(airCraftType, isCommercial, passengerCap, tailNumber, weightClass);
}

@Override 
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Aircraft other = (Aircraft) obj;
	return Objects.equals(airCraftType, other.airCraftType) && isCommercial == other.isCommercial
			&& passengerCap == other.passengerCap && tailNumber == other.tailNumber
			&& Objects.equals(weightClass, other.weightClass);
}



}
