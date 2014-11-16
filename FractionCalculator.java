
public class FractionCalculator {
	private Fraction fraction;
	private String operation;
	
	public FractionCalculator() {
		fraction = new Fraction(6,1);
		operation = null;
	}
	
	public Fraction getStoredValue() {
		return fraction;
	}
	
	public String getRememberedOperation() {
		return operation;
	}
	
	public Fraction evaluate(Fraction fraction, String inputString) {
			String[] input = inputString.split("\\s+");	// matches one or more whitespaces
			int i=0;	// position of an element of String[] input
			int j=0;	// position of a char in a specific element of String[] input
			int numerator = 0;
			int denominator = 0;
			scanInput: for(i=0; i<input.length; i++) {	
				boolean whole = true;
				System.out.println("input at position " + i + " = " + input[i]);  // just for testing
				if(input[i].equals("")) {
					continue scanInput;		// this should skip a '\t' input
				}
				if(input[i].equals("+") || input[i].equals("-") 
				|| input[i].equals("/") || input[i].equals("*")) {
					if (!rememberOperation(input, i)) {
						reset();
						return fraction;
					}
				} else { 
					w: for(j=1; j<input[i].length(); j++) { // look for a whole number
						if (input[i].charAt(0) != '-'
						&& !Character.isDigit(input[i].charAt(0))) {					
							whole = false;
							break w;
						} else {
							if(!Character.isDigit(input[i].charAt(j))) {
								whole = false;								
								break w;
							}
						}
					}
					if(whole == true) {
						numerator = Integer.parseInt(input[i]);
						denominator = 1;
						System.out.println("numerator = " + numerator);	
						System.out.println("denominator = " + denominator);
						continue scanInput;
					} else {		
						for(j=0; j<input[i].length(); j++) {	// look for a fraction
							if(input[i].charAt(j) == '/') {
								numerator = Integer.parseInt(input[i].substring(0,j));
								denominator = Integer.parseInt(input[i].substring(j+1));
							}
						}	
					}
				}
				System.out.println("numerator = " + numerator);	
				System.out.println("denominator = " + denominator);
			}						
			return fraction;
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

	public void reset() {
		System.out.println("resetting...");			// just for testing, to be deleted
		fraction = new Fraction(0,1);
		operation = null;
	}
	
}	