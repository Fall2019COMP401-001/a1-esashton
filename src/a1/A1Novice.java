package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Allow input for number of customers
		int numOfCustomers = scan.nextInt();
		
		// Create first name, last name, and total cost arrays to store information in order to correspond to each other
		String[] firstNames = new String[numOfCustomers];
		String[] lastNames = new String[numOfCustomers];
		double[] totals = new double[numOfCustomers];
		
		// Loop each of the keyboard inputs
		for (int i = 0; i < numOfCustomers; i++) {
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			int numOfItems = scan.nextInt();
			totals[i] = 0;
			
			/* 
			*  Loop through each person's items based on how many they said they got, 
			*  then have it correspond to the quantity they got
			*/
			
			for (int j = 0; j < numOfItems; j++) {
				int quantity = scan.nextInt();
				String name = scan.next();
				double price = scan.nextDouble();
				
				// Compute the total price for each person
				totals[i] = totals[i] + (price * quantity);
			}

		}
		
		// Print each person's name and how much they spent
		for (int i = 0; i < numOfCustomers; i++) {
			System.out.println(firstNames[i].charAt(0) + ". " + lastNames[i] + ": " + String.format("%.2f", totals[i]));
		}
			
		scan.close();
		
	}
	
}
