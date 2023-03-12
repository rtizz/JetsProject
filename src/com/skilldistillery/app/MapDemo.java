package com.skilldistillery.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.skilldistillery.entities.Aircraft;
import com.skilldistillery.entities.AircraftPassengerComparator;

public class MapDemo {
	private List<Aircraft> demo = new ArrayList<Aircraft>();
	private Map<Integer, Aircraft> airCraftMap = new TreeMap<>();
	public static void main(String[] args) {
		MapDemo md = new MapDemo();
		md.run();
	}
	
	public void run() {
		displayAircraft();
		
	}	
	public void displayAircraft() {
		demo.add(new Aircraft("B757","Heavy", "Cargo", 425, 43152, true));
		demo.add(new Aircraft("Cessna", "Small", "Passenger", 10, 2314, true));
		demo.add(new Aircraft("Leer", "Small+", "Passenger", 20, 7643, true));
		demo.add(new Aircraft("Commuter", "Large", "Passenger", 300, 6541, true));
		demo.add(new Aircraft("Caravan", "Small", "Passenger", 25, 12254, true));
		demo.add(new Aircraft("C5", "Heavy", "Cargo", 300, 7633, false));
		demo.add(new Aircraft("KC-10", "Heavy", "Fueler", 300, 7645, false));
		demo.add(new Aircraft("G5", "Medium", "Passenger", 300, 54226, true));
		
		for (Aircraft aircraft : demo) {
			airCraftMap.put(aircraft.getTailNumber(), aircraft);
		}
		//defaultPrint(airCraftMap);
		compareAircraftByPassengerCap(airCraftMap);
			
		}
		
	public void defaultPrint(Map<Integer, Aircraft> airCraft) {
		Set<Integer> tailNumKey = airCraft.keySet();
		Iterator<Integer> it = tailNumKey.iterator();
		while (it.hasNext()) {
		Integer showTailNumber = it.next();
		System.out.println(showTailNumber + " " + airCraft.get(showTailNumber));
		}
	}
		
		
	public void compareAircraftByPassengerCap(Map<Integer, Aircraft> airCraft) {
		Set<Integer> tailKey = airCraft.keySet();
		List<Integer> keys = new ArrayList<>(tailKey);
		Comparator<Integer> passComp = new AircraftPassengerComparator(airCraft);
		keys.sort(passComp);
		
		System.out.println("-------Sorted by Passenger Capacity-------");
		for (Integer key : keys) {
			Aircraft plane = airCraft.get(key);
			System.out.println(plane.getTailNumber() + " Aircraft Name: " + plane.getName() + ", Max Passengers " + plane.getPassengerCap() + ", [Weight class: " + plane.getWeightClass() + ", Type: " + plane.getAirCraftType() +  ", Commercial: " + plane.isCommercial() + "]");
			
		}
				
	}
	
}
