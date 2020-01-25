package com.learning.java8.functional.pattern.factory;

public class TestFactory {
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		ShapeFactory shapeFactory = new ShapeFactory();		
		Factory<? extends Shape> factory = shapeFactory.buildShapeFactory("Circle");
		System.out.println(factory.newInstance().get());
		
		factory = shapeFactory.buildShapeFactory("Square");
		System.out.println(factory.newInstance().get());
		
		factory = shapeFactory.buildShapeFactory("Triangle");
		System.out.println(factory.newInstance().get());
		
	}

}
