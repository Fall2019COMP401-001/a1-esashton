package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		int numOfCustomers = scan.nextInt();
		
		String[] FirstNames = new String[numOfCustomers];
		String[] LastNames = new String[numOfCustomers];
		double[] totals = new double[numOfCustomers];
		
		
		for (int i = 0; i < numOfCustomers; i++) {
			FirstNames[i] = scan.next();
			LastNames[i] = scan.next();
			int numOfItems = scan.nextInt();
			totals[i] = 0;
			
			for (int j = 0; j < numOfItems; j++) {
				int quantity = scan.nextInt();
				String name = scan.next();
				double price = scan.nextDouble();
				
				totals[i] = totals[i] + (price * quantity);
			}

		}
		
		for (int i = 0; i < numOfCustomers; i++) {
			System.out.println(FirstNames[i].charAt(0) + ". " + LastNames[i] + ": " + String.format("%.2f", totals[i]));
		}
			
		scan.close();
		
	}
	
}
