package com.learning.java8.functional.pattern.factory.registry;

import java.util.function.Consumer;

import com.learning.java8.functional.pattern.factory.Circle;
import com.learning.java8.functional.pattern.factory.Factory;
import com.learning.java8.functional.pattern.factory.Shape;

public class TestRegistryBuilder {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//Builder<Circle> builder = null;
		//builder.register("Car", Circle::new);  
		//Above line extracted to register method; See method which we can convert to consumer; accept Builder/,Circle> return void
		Consumer<Builder<Shape>> consumer = (builder) -> builder.register("Circle", Circle::new);
		Registry registry = Registry.createRegistry(consumer); 
		System.out.println("registry :: "+registry);
		
		Factory<Circle> factory = (Factory<Circle>) registry.buildShapeFactory("Circle");
		System.out.println("factory :: "+factory.newInstance());
		
	}

	
	//Below method we can convert to Consumer - return void and accept T
	private static void register(Builder<Circle> builder) {
		builder.register("Car", Circle::new);
	}
}
