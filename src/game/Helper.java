package game;

import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * <h1>Helper</h1>
 * <br>
 * This interface provides helper methods
 *
 * @author Shaun Dashjian
 * @version 1.0
 * @year 2017
 */
public interface Helper {
	public static Scanner kb = new Scanner(System.in);

	/**
	 * helper method to ensure input is int
	 *
	 * @param prompt
	 * @return int
	 */
	static int getInt(String prompt) {
		System.out.print(prompt);
		while (!kb.hasNextInt()) {
			System.out.print(prompt);
			kb.next();
		}
		return kb.nextInt();
	}

	/**
	 * helper method to ensure input is double
	 *
	 * @param prompt
	 * @return double
	 */
	static double getDouble(String prompt) {
		System.out.print(prompt);
		while (!kb.hasNextDouble()) {
			System.out.print(prompt);
			kb.next();
		}
		return kb.nextDouble();
	}

	/**
	 * helper method to ensure input is String
	 *
	 * @param prompt
	 * @return String
	 */
	static String getString(String prompt) {
		System.out.print(prompt);
		return kb.next();
	}

	/**
	 * helper method to return a number in monetary format "#.00"
	 * @param amount
	 * @return amount in monetary format
	 */
	static String toMoney(double amount) {
		return new DecimalFormat("#.00").format(amount);

	}

}