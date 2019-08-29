package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		int numOfItems = scan.nextInt();
		
		String[] items = new String[numOfItems];
		double[] prices = new double[numOfItems];
		
		for (int i = 0; i < numOfItems; i++) {
			items[i] = scan.next();
			prices[i] = scan.nextDouble();
		}
		
		int numOfCustomers = scan.nextInt();
		
		String[] FirstNames = new String[numOfCustomers];
		String[] LastNames = new String[numOfCustomers];
		double[] totals = new double[numOfCustomers];
		
		for (int j = 0; j < numOfCustomers; j++) {
			FirstNames[j] = scan.next();
			LastNames[j] = scan.next();
			int totalItems = scan.nextInt();
			int[] quantity = new int[totalItems];
			String[] customerItems = new String[totalItems];
			
			for (int k = 0; k < totalItems; k++) {
				quantity[k] = scan.nextInt();
				customerItems[k] = scan.next();
			}
						
			for (int l = 0; l < items.length; l++) {
				for (int m = 0; m < totalItems; m++) {
					if (customerItems[m].equals(items[l])) {
						totals[j] = totals[j] + (quantity[m] * prices[l]);
					}
				}
			}
			
			
		}
		
		scan.close();
		
		double average = avg(totals);
		
		System.out.println("Biggest: " + FirstNames[biggest(totals)] + " " + LastNames[biggest(totals)] + " (" + String.format("%.2f", totals[biggest(totals)]) + ")");
		System.out.println("Smallest: " + FirstNames[smallest(totals)] + " " + LastNames[smallest(totals)] + " (" + String.format("%.2f", totals[smallest(totals)]) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
		
	}
	
	public static double avg(double[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		
		return sum / a.length;
	}
	
	public static int biggest(double[] t) {
		int biggest = 0;
		for (int i = 1; i < t.length; i++) {
			if (t[i] > t[biggest]) {
				biggest = i;
			} 
		}
		return biggest;
	}
	
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
