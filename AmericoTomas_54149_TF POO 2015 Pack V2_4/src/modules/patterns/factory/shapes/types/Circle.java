package modules.patterns.factory.shapes.types;

import modules.patterns.factory.shapes.interfaces.Shape;

public class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");		
	}

}
