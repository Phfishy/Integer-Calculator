package assignment2;

/**
File name: Calculator
Course: CST8284 - OOP
Assignment: Assignment02
Date:Nov 23, 2023
Professor: Islam Gomaa
@author Zachary Bernard 041073789
@version 1.0
@since JRE17
Purpose: Do integer math using user input through a scanner, handle exceptions. Uses CalculatorInput and CalculatorEngine classes.
*/
public class Calculator {

	/**
	 * main method for using the calculator
	 * @param args
	 */
	public static void main(String[] args) {
		
		//variables
		boolean running = true;
		CalculatorInput input = new CalculatorInput();
		
		//comments and instructions
		System.out.println("Welcome to Assignment 2 CST8284 calculator."
				+ "\nWritten by Zachary Bernard, 041073789."
				+ "\n"
				+ "\nEquations are in the form [num1] [operator] [num2] [equals sign] (i.e: 1 + 2 =)"
				+ "\nWhere num1 and num2 must be integer values,"
				+ "\noperator is one of: +, -, / or *."
				+ "\n"
				+ "Enter '0 =' to quit.\n");
		
		//retrieving equation
		while(running) {
			System.out.print("Enter your equation:");
			input.scan();
		}
	}
}
