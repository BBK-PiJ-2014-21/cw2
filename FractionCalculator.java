import java.util.Scanner;

public class FractionCalculator {
	private Fraction fraction;
	private String operation;

	public FractionCalculator() {
		fraction = new Fraction(0,1);
		operation = null;
	}

	public Fraction getStoredValue() {
		return fraction;
	}

	public String getRememberedOperation() {
		return operation;
	}

	public Fraction evaluate(Fraction fraction, String inputString) {
		String[] input = inputString.split("\\s+"); // matches one or more whitespaces
		int i=0;	// position of an element of String[] input
		int numerator = 0;
		int denominator = 0;
		for(i=0; i<input.length; i++) {	
			if(input[i].equals("")) {
				continue;		          // this should skip a '\t' input
			} else if(input[i].equals("+") || input[i].equals("-") 
				|| input[i].equals("/") || input[i].equals("*")) {					
				if (!rememberOperation(input, i)) {	// operation already in memory
					reset();
					return null;					
				} else {
					continue;
				}
			} else if(isWholeNumber(input[i])) {	// look for a whole number
				numerator = Integer.parseInt(input[i]);
				denominator = 1;
				fraction = new Fraction(numerator, denominator);
				this.fraction = calculateFraction(fraction);
				operation = null;
				fraction = null;
				continue;
			} else if (returnFraction(input[i]) != null) {	// look for a fraction
				fraction = returnFraction(input[i]);
				if(fraction.getDenominator()==0) {	// Invalid input with denominator 0
					reset();	// (error message already printed in Fraction.java class)
					return null;
				} else {
					this.fraction = calculateFraction(fraction);
					operation = null;
					fraction = null;
					continue;
				}
			} else if(input[i].equalsIgnoreCase("a") || input[i].equalsIgnoreCase("abs")) {			
				this.fraction = this.fraction.absValue();
				continue;
			} else if(input[i].equalsIgnoreCase("n") || input[i].equalsIgnoreCase("neg")) {					
				this.fraction = this.fraction.negate();
				continue;
			} else if(input[i].equalsIgnoreCase("c") || input[i].equalsIgnoreCase("clear")) {				
				this.fraction = new Fraction(0,1);
				continue;
			} else {			// any other kind of exception (apart from end of input)
				System.out.println("Error");
				reset();
				return null;
			}
		}						
		operation = null; // reset the operation in memory to null at each end of line;
		return this.fraction;	
	}
	
	public void reset() {
		this.fraction = new Fraction(0,1);
		this.operation = null;
	}
 
	public boolean rememberOperation(String[] input, int i) {
		if(operation != null) {
			System.out.println("Error: there is another operation in memory.");		
			return false;
		} else {
			operation = input[i];
			return true;
		}
	}

	public boolean isWholeNumber(String input) {
		if (input.charAt(0) != '-' && input.charAt(0) != '+' && !Character.isDigit(input.charAt(0))) {					
			return false;		
		} else {
			if(input.length()>1) {
				for(int j=1; j<input.length(); j++) {
					if(!Character.isDigit(input.charAt(j))) {
						return false;
					}
				}
			}
		}
		return true;  // inputs containing just "-" or "+" won't return here as
	}	              // they would be already into the operation routine (line 28)
	
	public Fraction returnFraction(String input) {	// returns null if it's not a fraction
		Fraction fraction = null;
		int j=0;
		if(input.length()<3) {
			return fraction;
		} else {
			boolean slash = false;
			for(j=1; j<input.length()-1; j++) {
				if(input.charAt(j) == '/') {
					slash = true;
					break;
				}
			}
			if(!slash) {
				return fraction;
			} else {
				String n = input.substring(0,j);
				String d = input.substring(j+1);
				if(n.equals("-") || n.equals("+") || !isWholeNumber(n) 
				|| d.equals("-") || d.equals("+") || !isWholeNumber(d)) {
					return fraction;
				} 
				int numerator = Integer.parseInt(n);
				int denominator = Integer.parseInt(d);
				fraction = new Fraction(numerator, denominator);
				if(denominator==0) {
					return null;
				} else {
					return fraction;	
				}			
			}
		}
	}	
	
/* precedece rules are not applied: the specs say that, if an operation is being remembered,
	it has to be performed with the value currently in the calculator as the first operand,
	and the fraction as the second operand.
*/
	public Fraction calculateFraction(Fraction newFraction) {
		if (operation != null) {
			switch (operation) {
				case "+": return fraction.add(newFraction);
				case "-": return fraction.subtract(newFraction);
				case "/": return fraction.divide(newFraction);
				default: return fraction.multiply(newFraction);
			}
		} else {
			return newFraction;
		}
	}

/* after reset (due to a second operation entered while another is being remembered -line 30-
   or from a catch-all invalid input -line 59-, the returned fraction from evaluate() is null
   as there is no valid result for that line, while this.fraction is reset to zero but it's not 
   printed. As the specs say: "[...] for each line, print just the final result of evaluating
   that line. Please note: you do not need to deal with invalid inputs". 
*/	
	public void printLineResult(String line) {
		Fraction result = evaluate(getStoredValue(), line);
		if(result!=null) {	
			System.out.println(result.toString());					   	
		}
	}	

	public static void main(String[] args) {
		FractionCalculator c = new FractionCalculator();
		printWelcomeMessage();
		Scanner scanInput = new Scanner(System.in);
		String input = "";
		boolean endOfInputException = false;
		while(true) {
			System.out.print(">>> ");
			if(scanInput.hasNextLine()) {
				input = scanInput.nextLine();
				if(input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) {
					break;
				} else {
					c.printLineResult(input);
				}
			} else {
				endOfInputException = true;
				break;
			} 
		}
		if(endOfInputException == true) {	// print "Goodbye" only for an end of input exception
			System.out.println("Goodbye");	// not for a "quit" input (as per specs)
		}
	}

	public static void printWelcomeMessage() {
		System.out.println("==============================");
		System.out.println("WELCOME TO FRACTION CALCULATOR");
		System.out.println("written by Federico Bartolomei");
		System.out.println("==============================");
	}

}