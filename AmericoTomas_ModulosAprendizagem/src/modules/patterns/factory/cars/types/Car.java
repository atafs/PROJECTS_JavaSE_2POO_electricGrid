package modules.patterns.factory.cars.types;

import modules.patterns.factory.cars.enums.CarType;

public abstract class Car {

	// ATTRIBUTES
	private CarType model;

	// CONSTRUCTOR
	public Car(CarType model) {
		this.model = model;
		arrangeParts();
	}

	// ABSTRACT METHODS
	public abstract void construct();

	// METHODS
	private void arrangeParts() {
		// ...
	}

	// GETTERS AND SETTERS
	public CarType getModel() {
		return model;
	}

	public void setModel(CarType model) {
		this.model = model;
	}
	
	

}
