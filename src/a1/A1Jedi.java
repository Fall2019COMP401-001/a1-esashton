package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {	
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Input total number of items
		int numOfItems = scan.nextInt();
		
		// Create arrays for items and their prices
		String[] items = new String[numOfItems];
		double[] prices = new double[numOfItems];
		
		// Input those same items and prices into the array
		for (int i = 0; i < numOfItems; i++) {
			items[i] = scan.next();
			prices[i] = scan.nextDouble();
		}
		
		// Input number of customers
		int numOfCustomers = scan.nextInt();
		
		/* 
		 * Create name arrays and arrays for the number of items
		 * bought and how many customers bought those items
		 */
		String[] firstNames = new String[numOfCustomers];
		String[] lastNames = new String[numOfCustomers];
		int[] numBought = new int[items.length];
		int[] numOfCustomersWhoBoughtItem = new int[items.length];
		
		// Loop going through each customer
		for (int j = 0; j < numOfCustomers; j++) {
			firstNames[j] = scan.next();
			lastNames[j] = scan.next();
			int totalItems = scan.nextInt();
			int[] quantity = new int[totalItems];
			String[] customerItems = new String[totalItems];
			
			// Identifying and inputing the quantities and item names
			for (int k = 0; k < totalItems; k++) {
				quantity[k] = scan.nextInt();
				customerItems[k] = scan.next();
			}
			
			/*
			 * This is specifically for the case that an item name
			 * duplicated (hence shorthand "dupe") and will be counted
			 * in case there is to avoid miscalculations of the number of
			 * people who buy an item
			 */
			int[] dupes = new int[items.length];
						
			for (int l = 0; l < items.length; l++) {
				for (int m = 0; m < totalItems; m++) {
					if (customerItems[m].equals(items[l])) {
						
						// If any item is bought, dupes is given +1
						dupes[l] += 1;
						
						// Adds the number of an item bought depending on the quantity bought
						numBought[l] += quantity[m];
						
						/*
						 * If this is the first time the item shows up in someone's list, the
						 * number of customers will increase by one. If it is the second, third, etc.
						 * time seen, the number of customers will not increase
						 */
						if (dupes[l] == 1) {
							numOfCustomersWhoBoughtItem[l] += 1;
						}
					}
				}
			}
			
		}
		
		scan.close();
		
		// Prints each amount of an item bought by however many customers
		for (int n = 0; n < items.length; n++) {
			if (numBought[n] != 0) {
				System.out.println(numOfCustomersWhoBoughtItem[n] + " customers bought " + numBought[n] + " " + items[n]);
			} else {
				System.out.println("No customers bought " + items[n]);
			}
		
		}
		
	}
}
