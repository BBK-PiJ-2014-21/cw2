
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
					if (!rememberOperation(input, i)) {
						this.fraction = new Fraction(0,1);
						break;
					} else {
						continue;
					}
				} else if(isWholeNumber(input[i])) {
					numerator = Integer.parseInt(input[i]);
					denominator = 1;
					fraction = new Fraction(numerator, denominator);
					this.fraction = calculateFraction(fraction);
					operation = null;
					fraction = null;
					continue;
				} else if (returnFraction(input[i]) != null) {			// look for a fraction
					fraction = returnFraction(input[i]);
					this.fraction = calculateFraction(fraction);
					operation = null;
					fraction = null;
					continue;
				} else if(input[i].equalsIgnoreCase("a") || input[i].equalsIgnoreCase("abs")) {			
					this.fraction = this.fraction.absValue();
					continue;
				} else if(input[i].equalsIgnoreCase("n") || input[i].equalsIgnoreCase("neg")) {					
					this.fraction = this.fraction.negate();
					continue;
				} else if(input[i].equalsIgnoreCase("c") || input[i].equalsIgnoreCase("clear")) {				
					this.fraction = new Fraction(0,1);
					continue;
				} else {			// input error
					this.fraction = new Fraction(0,1);
					System.out.println("Error");
					break;
				}
			}						
			operation = null; // reset the operation in memory to null;
			return this.fraction;	
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
		if (input.charAt(0) != '-' && !Character.isDigit(input.charAt(0))) {					
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
		return true;  // input '-' won't happen as already going into the operation routine
	}
	
	public Fraction returnFraction(String input) {	// returns null if it's not a fraction
		Fraction fraction = null;
		int j=0;
		if(input.length()<3) {
			return fraction;
		} else {
			boolean slash = false;
			for(j=1; j<input.length(); j++) {
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
				if(n.equals("-") || !isWholeNumber(n) || !isWholeNumber(d)) {
					return fraction;
				} 
				int numerator = Integer.parseInt(n);
				int denominator = Integer.parseInt(d);
				fraction = new Fraction(numerator, denominator);
				return fraction;
			}
		}
	}	
	
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
	
	public void prinTest(String input) {	// TO DELETE
		System.out.println("After this input: " + input);
		System.out.println("Value in calculator: " + getStoredValue());
		System.out.println("Remembered operation: " + getRememberedOperation());
	}
	
}	