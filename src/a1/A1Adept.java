package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Input number of items
		int numOfItems = scan.nextInt();
		
		// Create arrays for products' names and prices
		String[] items = new String[numOfItems];
		double[] prices = new double[numOfItems];
		
		// Input names and products and have them correspond to each other
		for (int i = 0; i < numOfItems; i++) {
			items[i] = scan.next();
			prices[i] = scan.nextDouble();
		}
		
		// Input number of customers
		int numOfCustomers = scan.nextInt();
		
		// Create arrays for names of customers and their eventual total cost
		String[] firstNames = new String[numOfCustomers];
		String[] lastNames = new String[numOfCustomers];
		double[] totals = new double[numOfCustomers];
		
		// Inputs going through each customer
		for (int j = 0; j < numOfCustomers; j++) {
			firstNames[j] = scan.next();
			lastNames[j] = scan.next();
			int totalItems = scan.nextInt();
			int[] quantity = new int[totalItems];
			String[] customerItems = new String[totalItems];
			
			// Input telling how many of what item bought
			for (int k = 0; k < totalItems; k++) {
				quantity[k] = scan.nextInt();
				customerItems[k] = scan.next();
			}
					
			/*
			 * Going through each item first and then checking each person's "cart"
			 * to see if they have such item. If so, add the total cost after multiplying
			 * the item cost by how many the customer bought.
			 */
			for (int l = 0; l < items.length; l++) {
				for (int m = 0; m < totalItems; m++) {
					if (customerItems[m].equals(items[l])) {
						totals[j] = totals[j] + (quantity[m] * prices[l]);
					}
				}
			}
			
			
		}
		
		scan.close();
		
		// Calculate the average using the avg method
		double average = avg(totals);
		
		// Print each of the lines with each method outputting the array index needed
		System.out.println("Biggest: " + firstNames[biggest(totals)] + " " + lastNames[biggest(totals)] + " (" + String.format("%.2f", totals[biggest(totals)]) + ")");
		System.out.println("Smallest: " + firstNames[smallest(totals)] + " " + lastNames[smallest(totals)] + " (" + String.format("%.2f", totals[smallest(totals)]) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
		
	}
	
	// Basic method for calculating the average of an array of doubles
	public static double avg(double[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		
		return sum / a.length;
	}
	
	/*
	 * The output will find the max of the array and 
	 * return the corresponding index number of the array.
	 */
	public static int biggest(double[] t) {
		int biggest = 0;
		for (int i = 1; i < t.length; i++) {
			if (t[i] > t[biggest]) {
				biggest = i;
			} 
		}
		return biggest;
	}
	
	// Same as previous method but for the minimum
	public static int smallest(double[] t) {
		int smallest = 0;
		for (int i = 1; i < t.length; i++) {
			if (t[i] < t[smallest]) {
				smallest = i;
			} 
		}
		return smallest;
	}
}
