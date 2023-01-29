package com.skilldistillery.entities;

import java.util.Objects;

public abstract class Jet {
	private String type;
	private String model;
	private Double speed;
	private int range;
	private long price;
	
	
	public Jet() {
		
	}
	
	public Jet(String type, String model, Double speed, int range, long price) {
		this.type = type;
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	public void getSpeedInMach() {
		
	}
	
	public abstract void fly();


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public Double getSpeed() {
		return speed;
	}


	public void setSpeed(Double speed) {
		this.speed = speed;
	}


	public int getRange() {
		return range;
	}


	public void setRange(int range) {
		this.range = range;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Jet [Model= " + model + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(model);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model);
	}




}
