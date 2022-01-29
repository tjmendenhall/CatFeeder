package model;

import java.text.DecimalFormat;

/**
 * @author dynob - tjmendenhall2@dmacc.edu CIS175 - Fall 2021 Jan 26, 2022
 */
public class Feeder {
	private int numCats;
	private int cansPerCat;
	private int cansADay;
	private double canPrice;
	private double tax;
	private int totalCans;

	/**
	 * @param numCats
	 * @param cansPerCat
	 * @param cansADay
	 */
	public Feeder(int numCats, int cansPerCat, int cansADay, double canPrice, double tax) {
		super();
		this.numCats = numCats;
		this.cansPerCat = cansPerCat;
		this.cansADay = cansADay;
		this.canPrice = canPrice;
		this.tax = tax;
		setTotalCans(numCats, cansPerCat);
	}
	
	public Feeder(int numCats, int cansPerCat, int cansADay) {
		this.numCats = numCats;
		this.cansPerCat = cansPerCat;
		this.cansADay = cansADay;
		this.canPrice = .60;
		this.tax = .07;
		setTotalCans(numCats, cansPerCat);
	}
	
	public Feeder() {
		this.numCats = 1;
		this.cansPerCat = 1;
		this.cansADay = 2;
		this.canPrice = .60;
		this.tax = .07;
		setTotalCans(numCats, cansPerCat);
	}
	
	/**
	 * @return the numCats
	 */
	public int getNumCats() {
		return numCats;
	}

	/**
	 * @param numCats the numCats to set
	 */
	public void setNumCats(int numCats) {
		this.numCats = numCats;
	}

	/**
	 * @return the cansPerCat
	 */
	public int getCansPerCat() {
		return cansPerCat;
	}

	/**
	 * @param cansPerCat the cansPerCat to set
	 */
	public void setCansPerCat(int cansPerCat) {
		this.cansPerCat = cansPerCat;
	}

	/**
	 * @return the cansADay
	 */
	public int getCansADay() {
		return cansADay;
	}

	/**
	 * @param cansADay the cansADay to set
	 */
	public void setCansADay(int cansADay) {
		this.cansADay = cansADay;
	}

	/**
	 * @return the canPrice
	 */
	public double getCanPrice() {
		return canPrice;
	}

	/**
	 * @param canPrice the canPrice to set
	 */
	public void setCanPrice(double canPrice) {
		this.canPrice = canPrice;
	}

	/**
	 * @return the tax
	 */
	public double getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(double tax) {
		this.tax = tax;
	}

	/**
	 * @return the totalCans
	 */
	public int getTotalCans() {
		return totalCans;
	}

	/**
	 * @param totalCans the totalCans to set
	 */
	public void setTotalCans(int numCats, int cansPerCat) {
		this.totalCans = numCats * cansPerCat;
	}

	@Override
	public String toString() {
		return "Feeder [numCats=" + numCats + ", cansPerCat=" + cansPerCat + ", cansADay=" + cansADay + ", canPrice="
				+ canPrice + ", tax=" + tax + ", totalCans=" + totalCans + "]";
	}

	//Prints the entered values and then the results
	public String printCatFeeder() {
		DecimalFormat df = new DecimalFormat("$###, ###.00");
		double feedingPrice = returnFeedingPrice(canPrice, tax);
		double dailyFeedingPrice = returnDailyPrice(cansADay);
		double weeklyFeedingPrice = returnWeeklyPrice(dailyFeedingPrice);
		return "-Feeder-\n" + "Number of Cats: " + numCats + "\nCans Per Cat: " + cansPerCat + "\nCans a Day: "
				+ cansADay + "\nTotal Cans: " + totalCans + "\n-Results-" + "\nTotal Price of Feeding: "
				+ df.format(feedingPrice) + "\nDaily Price of Feeding: " + df.format(dailyFeedingPrice)
				+ "\nWeekly Price of Feeding: " + df.format(weeklyFeedingPrice);
	}
	//Calculates price of one feeding
	public double returnFeedingPrice(double canPrice, double tax) {
		int numCats = this.numCats;
		int canPerCat = this.cansPerCat;
		int totalCans = numCats * canPerCat;
		double price = totalCans * canPrice;
		double salesTax = price * tax;
		double totalPrice = price + salesTax;
		return totalPrice;
	}
	//Calculates the price of feeding for a whole day
	public double returnDailyPrice(double cansADay) {
		double feedingPrice = returnFeedingPrice(this.canPrice, this.tax);
		double dailyFeedingPrice = (double) feedingPrice * cansADay;
		return dailyFeedingPrice;	
	}
	//Calculates the price of feeding for a whole week
	public double returnWeeklyPrice(double dailyFeedingPrice) {
		final int WEEK = 7;
		double weeklyFeedingPrice = dailyFeedingPrice * WEEK;
		return weeklyFeedingPrice;
	}

}
