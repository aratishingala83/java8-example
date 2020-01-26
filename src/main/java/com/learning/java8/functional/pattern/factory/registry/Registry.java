package com.learning.java8.functional.pattern.factory.registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.learning.java8.functional.pattern.factory.Circle;
import com.learning.java8.functional.pattern.factory.Factory;
import com.learning.java8.functional.pattern.factory.Shape;

public interface Registry {
	
	public Factory<? extends Shape> buildShapeFactory(String shape);
	
	static Registry createRegistry(Consumer<Builder<Shape>> consumer) {
		//consumer = (builder) -> builder.register("Circle", Circle::new); That we have passed from caller
		Map<String, Factory<Shape>> map = new HashMap<String, Factory<Shape>>( );
		
		Builder<Shape> builder = (key,factory) -> map.put(key, factory);
		consumer.accept(builder);
		System.out.println(map);
		return shape->map.get(shape); // To achieve this we convert class to interface and declare method as abstract buildShapeFactory
	}
	
	
	/**
	 * How above work
	 * 
	 * 
	 * consumer.accept(builder);
	 * 
	 * Note : 
	 * 	Consumer Implementation of accept method is  : builder.register("Circle", Circle::new); That we have passed from caller; builder mention below
	 * 
	 * 	Builder  Implementation of register method is : (key,factory) -> map.put(key, factory) ;  map.put("Circle", Circle::new) ;
	 * 
	 * Function calling Function
	 * 
	 * 
	 * 
	 * 
	
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}
