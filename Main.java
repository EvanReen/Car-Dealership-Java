package carDealership;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		
		//random class
		Random random = new Random();
			
			
		//instance of car showroom
		CarShowroom show = new CarShowroom(5);
		
		//declare variable
		int days = 0;
		
		//while days is less than 30 do this
		while(days<30) {
			
			//increment days 
			days++;
			
			
			System.out.println("Day " + days +" beginning. There are "+show.NumOfCars() +"cars in the showroom today");	
			
			
			int n = random.nextInt(3) + 1;


			   //Loop for random number of Thread and seller made
		        for(int j=0 ; j< n; j++) {

		        	Buyer buy = new Buyer(show);  
		        	Thread thr = new Thread(buy);
		        	
		        	//calls Buyers class Run() 
		        	thr.start();
		        	
		        }//end loop
		        
		        
		        int m = random.nextInt(3)+1; 
		        
		        //Loop for random number of Thread and seller made
		        for(int j=0 ; j< m; j++) {
		        	Seller sell = new Seller(show);
		        	Thread thr1 = new Thread(sell);
		        	
		        	//calls Buyers class Run() 
		        	thr1.start();        	
		        
		        }//end for loop
		        
		        //try catch
		        try {
		        	
					Thread.sleep(1000);
					
				} catch (InterruptedException exc) {
					
					exc.printStackTrace();
					
				}//end catch
		        
		}//end while loop	
		
	}//end main 

}//end class