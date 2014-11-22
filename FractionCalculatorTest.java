
public class FractionCalculatorTest {
	
	public static void main(String[] args) {
		
		FractionCalculator c = new FractionCalculator();
		System.out.println();
		System.out.println("INITIAL VALUES:");
		printValues(c);
		System.out.println("TEST EXAMPLE (evaluate input ' 1/2 - 3/4 * abs	')");
		c.evaluate(c.getStoredValue(), " 1/2 - 3/4 * abs	").toString();	// test Example - in specs
		printValues(c);
		System.out.println("TEST EXAMPLE (CONTINUE) (evaluate input '	8 7/8  neg   +')");
		c.evaluate(c.getStoredValue(), "	8 7/8  neg   +").toString();	// test Example (continue) - in specs
		printValues(c);
		System.out.println("TEST 1 (evaluate input '2/2 + 4/2)");
		c.evaluate(c.getStoredValue(), "2/2 + 4/2").toString();	// test 1
		printValues(c);
		System.out.println("TEST 2 (evaluate input ' N')");
		c.evaluate(c.getStoredValue(), " N");	// test 2
		printValues(c);
		System.out.println("TEST 3 (evaluate input '1/2 - -28/13')");
		c.evaluate(c.getStoredValue(), "1/2 - -28/13");	// test 3
		printValues(c);
		System.out.println("TEST 4 (evaluate input '	12 3/-5 1/2 * 	8/-4  	/')");
		c.evaluate(c.getStoredValue(), "	12 3/-5 1/2 * 	8/-4  	/");	// test 4
		printValues(c);
	
	}
	
	public static void printValues(FractionCalculator a) {
		System.out.println("Stored value: " + a.getStoredValue().toString());
		System.out.println("Remembered operation: " + a.getRememberedOperation() + '\n');
	}
	
}