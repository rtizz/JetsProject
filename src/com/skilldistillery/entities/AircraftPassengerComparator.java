package com.skilldistillery.entities;

import java.util.Comparator;
import java.util.Map;

public class AircraftPassengerComparator implements Comparator<Integer> {
	
	private Map<Integer, Aircraft> aircraft;
	
	public AircraftPassengerComparator(Map<Integer, Aircraft> aircraft) {
		this.aircraft = aircraft;
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		Aircraft numPassenger1 = aircraft.get(o1);
		Aircraft numPassenger2 = aircraft.get(o2);

//------------COMPARE PASSENGER CAP THEN AIRCRAFT NAME---------------
		int results = numPassenger1.getPassengerCap() - numPassenger2.getPassengerCap();
		
		if (results == 0) {
			results = numPassenger1.getName().compareTo(numPassenger2.getName());
		}
		
		return results;
//------------ONLY COMPARE PASSENGER CAP----------------		
//		if (numPassenger1.getPassengerCap() > numPassenger2.getPassengerCap()) {
//			return 1;
//		} else if (numPassenger1.getPassengerCap() < numPassenger2.getPassengerCap()) {
//			return -1;
//		}
//		return 0;
			
	}

	

}