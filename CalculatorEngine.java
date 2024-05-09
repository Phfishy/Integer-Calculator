package assignment2;

/**
File name: CalculatorEngine
Course: CST8284 - OOP
Assignment: Assignment02
Date:Nov 23, 2023
Professor: Islam Gomaa
@author Zachary Bernard 041073789
@version 1.0
@since JRE17
Purpose: do simple arithmetic
*/
public class CalculatorEngine {
	
	/**
	 * Adds two numbers
	 * @param num1 - first integer
	 * @param num2 - second integer
	 * @return - returns solution
	 */
	public static int add(int num1, int num2) {
		return num1 + num2;
	}
	
	/**
	 * Subtracts two numbers
	 * @param num1 - first integer
	 * @param num2 - second integer
	 * @return - returns solution
	 */
	public static int subtract(int num1, int num2) {
		return num1 - num2;
	}
	
	/**
	 * Multiplies two numbers
	 * @param num1 - first integer
	 * @param num2 - second integer
	 * @return - returns solution
	 */
	public static int multiply(int num1, int num2) {
		return num1 * num2;
	}
	
	/**
	 * Divides two numbers
	 * @param num1 - first integer
	 * @param num2 - second integer
	 * @return - returns solution
	 */
	public static int divide(int num1, int num2) {
		return num1 / num2;
	}
	
}
