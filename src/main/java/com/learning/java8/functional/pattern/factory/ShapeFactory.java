package com.learning.java8.functional.pattern.factory;

import java.util.Objects;

public class ShapeFactory {
	
	
	public Factory<? extends Shape> buildShapeFactory(String shape) {
		Objects.requireNonNull(shape);
		switch (shape) {
		case "Circle": return ()->new Circle();
		case "Square": return ()->new Square();
		case "Triangle": return ()->new Triangle();
		default:
			throw new IllegalArgumentException("Unknow shape provided : "+shape);
		}
	}

}
