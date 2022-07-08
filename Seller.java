package carDealership;

import java.util.Random;

public class Seller implements Runnable {
	
	//instance of carsowrrom
	CarShowroom carshowroom;
	
	//insatnce of car
	Car c;
	
	//random class
	Random random= new Random();
	
	//constructor
	public Seller () {
		this.c=new Car();
		this.carshowroom = new CarShowroom();
	}
	
	//overloaded constructor
	public Seller(CarShowroom show) {
	    this.carshowroom = show;
	}


	//method update stock 
	public void UpdateStock(Car c){
		
	    synchronized(carshowroom.cars) {

	    	//while loop
	        while(carshowroom.isFull()) {
	        	
	        	//try catch
	            try {

	                carshowroom.cars.wait();

	            } catch (InterruptedException exc) {

	                exc.printStackTrace();
	            }

	        }//end while

	       //add car
	       carshowroom.addCar(c);
	       
	       //call notify method
	       carshowroom.cars.notify();
	        
	    }//end synchronized
	    
	} //end method



	//method run 
	public void run() {
		
		//try catch
		try{
			
			//call method
			UpdateStock(c);
			
			//sleep
			Thread.sleep(1000);
			
		} catch (Exception exc) {

	            exc.printStackTrace();
	            
		}//end catch 


	}//end method run 

}//end class