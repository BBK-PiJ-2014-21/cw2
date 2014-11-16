
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
			int i=0;
			for(; i<input.length; i++) {	
				System.out.println("input at position " + i + " = " + input[i]);	// just for testing, to be deleted
				if(input[i].equals("+")) {
					if (!rememberOperation(input, i)) {
						System.out.println("reloading...");		// just for testing, to be deleted
						reset();
						return fraction;
					}
				}
			}
			return fraction;
	}
	
	public boolean rememberOperation(String[] input, int i) {
		if(operation != null) {
			System.out.println("Error: there is another operation in memory.");		
			return false;
		} else {
			operation = input[i];
			System.out.println("stored +");		// just for testing, to be deleted
			return true;
		}
	}

	public void reset() {
		System.out.println("resetting...");			// just for testing, to be deleted
		fraction = new Fraction(0,1);
		operation = null;
	}
	
}	