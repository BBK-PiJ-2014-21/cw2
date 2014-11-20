// cw2 - Fraction Calculator main method

import java.util.Scanner;
public class FractionMainTest {

	public static void main(String[] args) {
		Scanner scanInput = new Scanner(System.in);
		FractionCalculator c = new FractionCalculator();
		String input = "";
		printWelcomeMessage();
		while(true) {
			System.out.print(">>> ");
			input = scanInput.nextLine();
			if(input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) {
				System.out.println("Goodbye.");
				break;
			} else {
				System.out.println(c.evaluate(c.getStoredValue(), input).toString());
			}
		}
	}
		
	public static void printWelcomeMessage() {
		System.out.println("==============================");
		System.out.println("WELCOME TO FRACTION CALCULATOR");
		System.out.println("written by Federico Bartolomei");
		System.out.println("==============================");
	}

}
	