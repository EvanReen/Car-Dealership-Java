package carDealership;

import java.util.ArrayList;
import java.util.List;

public class CarShowroom {
	
	//setting capacity to 5
	private static int capacity= 5; 
	
	//instance of car
	Car c; 
	
	//creating private ArrayList cars
	List<Car> cars = new ArrayList<Car>();
	
	// Constructor
	public CarShowroom(int ca) {
		CarShowroom.capacity = ca;
		}
		
	public CarShowroom() {
	    cars = new ArrayList<Car>();
	    this.c = new Car();
	}
	
	//method isEmpty(), returns true if ArrayList cars is empty
	public boolean isEmpty() {
		if (this.cars.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//method isFull(), returns true if the Showroom is full (==capacity)
	public boolean isFull() {
		if(cars.size()==capacity) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//method addCar()
	public void addCar(Car car) {
		cars.add(car);
		}
	
	//method takeCar()
	public Car takeCar() {
		
		//gets the first(oldest) car in the ArrayList
		c= cars.get(0);
		
		//remove the first(oldest) car in the list 
		cars.remove(cars.get(0));
		
		//returns  first available Car in the ArrayList.
		return c; 
	}
	
	//method for printing list of cars
	public int NumOfCars() {
		return cars.size();
	}
	
}//end class
