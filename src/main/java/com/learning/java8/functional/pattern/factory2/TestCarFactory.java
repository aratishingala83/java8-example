package com.learning.java8.functional.pattern.factory2;

public class TestCarFactory {
	
	public static void main(String[] args) {
		
		CarFactory2<Car> carFactory1 = Car::new;
		System.out.println(carFactory1.newInstance());
		
		CarFactory2<Car> carFactory = CarFactory2.createFactory(Car::new);
		System.out.println("Car from CarFactory-Supplier : "+carFactory.get());
		
		carFactory = CarFactory2.createFactory(clr->new Car(clr),"RED");
		System.out.println("Car from CarFactory-Function<String,Car>: "+carFactory.get());
		
		
	}

}
