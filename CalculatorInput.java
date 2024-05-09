package assignment2;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
File name: CalculatorInput
Course: CST8284 - OOP
Assignment: Assignment02
Date:Nov 23, 2023
Professor: Islam Gomaa
@author Zachary Bernard 041073789
@version 1.0
@since JRE17
Purpose: retrieve values from user input to be calculated in CalculatorEngine and handle exceptions
*/
public class CalculatorInput {
	
	//variables
	/**
	 * num1 - stores value for first integer
	 * num2 - stores value for second integer
	 */
	int num1, num2;
	/**
	 * sign - stores a string that is checked if is a valid arithmetic operator
	 * equals - stores a string that is checked if is a equals sign ( = )
	 * buffer - String value used to store a line of user input from a scanner
	 */
	String sign, equals, buffer;
	/**
	 * keyboard - scanner used to retrieve a line of input
	 */
	Scanner keyboard;
	/**
	 * input - scanner used to check individual elements of an inputted string
	 */
	Scanner input;

	/**
	 * no argument constructor. Instantiates keyboard.
	 */
	public CalculatorInput() {
		keyboard = new Scanner(System.in);
	}

	/**
	 * Scans for user input and then handles possible exceptions.
	 */
	public void scan() {
		
		buffer = keyboard.nextLine();
		
		int tracker = 0;//used to track where the scanner is in the give line
		
		//try with resources for throwing possible errors, as well as assigning values to variables.
		try(Scanner input = new Scanner(buffer)) {
			
			tracker = 0; //reset to 0
			
			num1=input.nextInt();
			tracker++;//sets tracker to 1
			
			//exiting program if '0 =' is entered. 
			sign=input.next();
			if(num1 == 0 && sign.equals("=") == true) {
				System.out.println("\nProgram Exiting.");
				System.exit(0);
			}
			else if(sign.equals("+") == false && sign.equals("-") == false && sign.equals("/") == false && sign.equals("*") == false) 
				throw new InputMismatchException();
			tracker++;//sets tracker to 2
			
			num2=input.nextInt();
			tracker++;//sets tracker to 3
			
			equals=input.next();
			if(equals.equals("=") == false)
				throw new InputMismatchException();
			
			//based on the sign, have CalculatorEngine perform the correct arithmetic
			if(sign.equals("+"))
				System.out.println("\nThe answer is: " + CalculatorEngine.add(num1,num2)+ "\n");
			else if(sign.equals("-"))
				System.out.println("\nThe answer is: " + CalculatorEngine.subtract(num1,num2)+ "\n");
			else if(sign.equals("*"))
				System.out.println("\nThe answer is: " + CalculatorEngine.multiply(num1,num2)+ "\n");
			else { 
				if(num1 % num2 != 0) {
					throw new Exception();
				}
				else
					System.out.println("\nThe answer is: " + CalculatorEngine.divide(num1,num2)+ "\n");
			}
		}
		//prints an error message based on which point in the line an InputMismatchException is thrown 
		catch(InputMismatchException exception) {
			if(tracker == 0) 
				System.out.println("\nInputMismatchException: First number is not an integer. Caught in try/catch statement.\n");
			else if(tracker == 1)
				System.out.println("\nInputMismatchException: No valid operator. Caught in try/catch statement.\n");
			else if(tracker == 2)
				System.out.println("\nInputMismatchException: Second number is not an integer. Caught in try/catch statement.\n");
			else if(tracker == 3)
				System.out.println("\nInputMismatchException: Equation must end with =. Caught in try/catch statement.\n");
		}
		//prints an error message based on which point in the line a NoSuchElementException is thrown 
		catch(NoSuchElementException exception) {
			if(tracker == 0) 
				System.out.println("\nNoSuchElementException: Equation incomplete, first number is missing. Caught in try/catch statement.\n");
			else if(tracker == 1)
				System.out.println("\nNoSuchElementException: Equation incomplete, operator is missing. Caught in try/catch statement.\n");
			else if(tracker == 2)
				System.out.println("\nNoSuchElementException: Equation incomplete, second number is missing. Caught in try/catch statement.\n");	
			else if(tracker == 3)
				System.out.println("\nNoSuchElementException: Equation incomplete, must end with =. Caught in try/catch statement.\n");
		}
		//prints an error message if the user divides a number by 0
		catch(ArithmeticException exception) {
			System.out.println("\nArithmeticException: Cannot divide by 0. Caught in try/catch statement.\n");
		} 
		//prints an error message if the user attempts invalid division, ensures integer math gives accurate answers
		catch (Exception exception) {
			System.out.println("\nError: " + num1 + " is not cleanly divisible by " + num2 + ". Caught in try/catch statement.\n");
		}
	}
}