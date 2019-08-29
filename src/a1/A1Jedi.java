package a1;

import java.util.Scanner;

public class A1Jedi {

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
		int[] numBought = new int[items.length];
		int[] numOfItemBoughtByCustomers = new int[items.length];
		
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
						numBought[l] += quantity[m];
						numOfItemBoughtByCustomers[l] += 1;
					}
				}
			}
			
		}
		
		for (int n = 0; n < items.length; n++) {
			if (numBought[n] != 0) {
				System.out.println(numOfItemBoughtByCustomers[n] + " customers bought " + numBought[n] + " " + items[n]);
			} else {
				System.out.println("No customers bought " + items[n]);
			}
		
		}
	}
}
