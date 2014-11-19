
public class FractionCalculatorTest {
	
	public static void main(String[] args) {
		
		FractionCalculator c = new FractionCalculator();
		System.out.println();
		printInitialValues(c);
		System.out.println("TEST EXAMPLE (evaluate input ' 1/2 - 3/4 * abs '\n' 8 7/8 neg +')");
		System.out.println(c.evaluate(c.getStoredValue(), " 1/2 - 3/4 * abs '\n' 8 7/8 neg +").toString());	// test 0
		System.out.println("Stored value after test1 (should be -7/8): " + c.getStoredValue().toString() + '\n');
		System.out.println("TEST 1 (evaluate input '2/2 + 4/2	+  n')");
		System.out.println(c.evaluate(c.getStoredValue(), "2/2 + 4/2	+  n").toString());	// test 1
		System.out.println("Stored value after test1 (should be -3): " + c.getStoredValue().toString() + '\n');
		System.out.println("TEST 2 (evaluate input ' a')");
		printInitialValues(c);
		c.evaluate(c.getStoredValue(), " a");	// test 2
		System.out.println("Stored value after test2 (should be 3): " + c.getStoredValue().toString() + '\n');
		System.out.println("TEST 3 (evaluate input '1/2 - -28/13')");
		printInitialValues(c);
		c.evaluate(c.getStoredValue(), "1/2 - -28/13");	// test 3
		System.out.println("Stored value after test3 (should be 69/26): " + c.getStoredValue().toString() + '\n');
		System.out.println("TEST 4 (evaluate input '	12 3/-5 1/2 * 	8/-4  	/')");
		printInitialValues(c);
		c.evaluate(c.getStoredValue(), "	12 3/-5 1/2 * 	8/-4  	/");	// test 4
		System.out.println("Stored value after test3 (should be -1): " + c.getStoredValue().toString() + '\n');
	
	}
	
	public static void printInitialValues(FractionCalculator a) {
		System.out.println("Initial value: " + a.getStoredValue().toString());
		System.out.println("Remembered operation at start (should be null): " + a.getRememberedOperation() + '\n');

	}
	
}