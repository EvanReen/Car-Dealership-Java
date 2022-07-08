package carDealership;

import java.util.Random;

public class Car {
	
	//variables
	private String registration;
	private int saleValue;
	private String colour; 
	
	//colour choices for random selection 
	private static final String [] colours= {"Khaki Green", "Midnight Blue", "Chrome", "Red", "Matte Black", "Brown",
			"Purple", "Yellow", "White", "Navy", "Orange"};
	
	//county registration letters for random selection
	private static final String[] countiesReg = {"C","CE","CW","D","DL","G","KE","KK","KY",
	        "L","LD","LH","LM","LS","MH","MN","MO","OY","RN","SO","T","TS","W","WH","WX","WW"};
	
	//make instance of class random 
	Random random = new Random();
	
	//constructor of this class is called, it should create a new instance of the Car class that has 
	//randomly generated values for these details.
	public Car() {
		
		//random registration
		this.registration= String.valueOf(random.nextInt(100)+ "-" + countiesReg[random.nextInt(countiesReg.length)]
				+ "-" + String.valueOf(random.nextInt(20000)));
		
		//random colour
		colour= colours[random.nextInt(colours.length)]; 
		
		//random saleValue limited at 150000
		saleValue=Integer.valueOf(random.nextInt(150000)); 
			
	}

	//Getters
	public String getRegistration() {
		return registration;
	}

	public int getSaleValue() {
		return saleValue;
	}

	public String getColour() {
		return colour;
	}

	@Override
	public String toString() {
		return "Car: Registration=" + registration + ", with a saleValue of £" + saleValue + ", and is " + colour + "in Colour. " ; 
	}
	
}//end class