package carDealership;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

//Buyer class should implement the Runnable interface
public class Buyer implements Runnable{
	
	//instance of car
	Car c;
	
	//instance of CarShowroom
	CarShowroom carshowroom;
	
	//number of buyers
	int buyers;
	
	//make instance of class random 
	Random random = new Random();
	
	//instances of AtomicInteger should be used to count the total number of buyers 
	// created, and the total number of purchases successfully completed.
	private AtomicInteger atomic  = new AtomicInteger(1);

	
	//The Buyer constructor should accept an instance of CarShowroom as an argument
	public Buyer() {

	    this.carshowroom = new CarShowroom();
	}
	
	public Buyer(CarShowroom c) {

	    this.carshowroom = c;
	}
	

	//method run 
	public void run() {
		
		try {
			buyCar();
			Thread.sleep(1000);
			
		}catch(Exception exc) {
	            exc.printStackTrace();
	        }

	 }//end method run

	
	//method buyCar
	public Car buyCar() {
		
		
	    synchronized(carshowroom.cars){
	       
	    	buyers = atomic.getAndIncrement();
	    	
	    	//while loop
	        while(carshowroom.isEmpty()) {
	        	
	        	try {
	        		
	        		carshowroom.cars.wait();

	                }catch (InterruptedException exc) {

	                    exc.printStackTrace();
	                }

	            }//end while loop
	        
	        //call takeCar method
	        c = carshowroom.takeCar();
	        
	        //clear
	        carshowroom.cars.clear();
	        
	        //notifyAll method
	        carshowroom.cars.notifyAll();
	        
	        //if the buyers are greater than 1 
	        if(buyers >1) {
	        	
	        	System.out.println(buyers + " buyers bought this car.");
	        	
	        }
	        
	        else {
	        	
	        	System.out.println(buyers + " buyer bought this car.");
	        	
	        }
	        
	        return c;
	        
	    }//end synchronized


	}//end buyCar method
	
	
}//end class