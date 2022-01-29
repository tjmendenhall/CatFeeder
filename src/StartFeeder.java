import java.text.DecimalFormat;
import java.util.Scanner;

import model.Feeder;

/**
 * @author dynob - tjmendenhall2@dmacc.edu CIS175 - Fall 2021 Jan 26, 2022
 */
public class StartFeeder {
	//Asks for values that are used to create a Feeder and then displays the Feeder with its toString to print the entered values and a printFeeder function which displays the results as well
	public static void main(String[] args) {
		//Variables set up
		int numCats;
		int cansPerCat;
		int cansPerDay;
		String enterPrice;
		double canPrice;
		double tax;
		
		//Start Scanner for input
		Scanner in = new Scanner(System.in);

		//Get input for number of cats to feed
		System.out.print("How many cats to feed: ");
		numCats = in.nextInt();
		//Number of cats must be at least 1. Otherwise, there is no point in using the program at the moment. Uses while loop if value is less than one
		while (numCats < 1) {
			System.out.print("Not possible. How many cats to feed (must be at least 1): ");
			numCats = in.nextInt();
		}

		//Get input for the amount of cans per cat for each feeding
		System.out.print("How many cans per cat: ");
		cansPerCat = in.nextInt();
		//Number of cans per cat must be at least one. May add the ability to put partial cans later. Uses while loop if value is less than one
		while (cansPerCat < 1) {
			System.out.print("Not possible. How many cans (must be at least 1): ");
			cansPerCat = in.nextInt();
		}

		//Get input for how many times you will feed them a day
		System.out.print("How many times fed a day: ");
		cansPerDay = in.nextInt();
		//Number of times fed a day must be at least one. Uses while loop if value is less than one
		while (cansPerDay < 1) {
			System.out.print("Not possible. How many times fed a day (must be at least 1): ");
			cansPerDay = in.nextInt();
		}
	
		//Asks if user would like to enter the price of a can and the tax for their area
		System.out.print("Would you like to enter the price per can and the tax? ([y]es or [n]o): ");
		enterPrice = in.next();
		//If user put y, ye, or yes; gets values for each and creates Feeder with said values. If user put n or no, creates a Feeder with default values for canPrice and tax
		if (enterPrice.equalsIgnoreCase("y") || enterPrice.equalsIgnoreCase("ye") || enterPrice.equalsIgnoreCase("yes")) {
			System.out.print("Enter the price per can: ");
			canPrice = in.nextDouble();
			//canPrice must be above 0. This program is to calculate cost so without any cost there is no need to use it
			while (canPrice < 0) {
				System.out.print("Not possible. Cat food is not free. Try again: ");
				canPrice = in.nextDouble();
			}
			System.out.print("What is the tax (enter as a decimal): ");
			tax = in.nextDouble();
			//Tax must be above 0. Could add tax exempt option later.
			while (tax < 0) {
				System.out.print("Not possible. There must be tax. Try again: ");
				tax = in.nextDouble();
			}
			//Creates Feeder with entered price and tax values
			Feeder test = new Feeder(numCats, cansPerCat, cansPerDay, canPrice, tax);
			//Prints the toString
			System.out.println(test.toString());
			//Prints all information entered and the results of those values
			System.out.println(test.printCatFeeder());
		} else if (enterPrice.equalsIgnoreCase("n") || enterPrice.equalsIgnoreCase("no")) {
			//Creates Feeder with the only values entered and uses default values for price and tax
			Feeder test = new Feeder(numCats, cansPerCat, cansPerDay);
			//Prints the toString
			System.out.println(test.toString());
			//Prints all information entered and the results of those values
			System.out.println(test.printCatFeeder());
		} else {
			//If user fails to put yes or no, the program simply closes and you must start again.
			System.out.println("You must answer [y]es or [n]o. Please start again.");
		}
		
		System.out.println("Goodbye");
		
		in.close();
	}
}
