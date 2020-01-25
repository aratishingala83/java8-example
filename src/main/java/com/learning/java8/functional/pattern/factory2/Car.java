package com.learning.java8.functional.pattern.factory2;

public class Car {

	String color;
	
	public Car() {
		this.color="Grey";
	}
	
	public Car(String color) {
		this.color=color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Car color is "+color;
	}
	
}
