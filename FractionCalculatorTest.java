
public class FractionCalculatorTest {
	
	public static void main(String[] args) {
		
		FractionCalculator c = new FractionCalculator();
		System.out.println("Initial value: " + c.getStoredValue().toString());
		System.out.println("Remembered operation at start: " + c.getRememberedOperation() + '\n');
		System.out.println("TEST 1 (evaluate input '2/2 + 4/2	+')");
		c.evaluate(c.getStoredValue(), "2/2 + 4/2	+");	// test 1
		System.out.println("operation after test1 (should be +): " + c.getRememberedOperation());
		System.out.println("Stored value after test1 (should be 3): " + c.getStoredValue().toString() + '\n');
		System.out.println("TEST 2 (evaluate input '0/2')");
		c.evaluate(c.getStoredValue(), "0/2");	// test 2
		System.out.println("operation after test2 (should be null): " + c.getRememberedOperation());
		System.out.println("Stored value after test2 (should be 3): " + c.getStoredValue().toString() + '\n');
		System.out.println("TEST 3 (evaluate input '1/2 - -28/13')");
		c.evaluate(c.getStoredValue(), "1/2 - -28/13");	// test 3
		System.out.println("operation after test3 (should be null): " + c.getRememberedOperation());
		System.out.println("Stored value after test3 (should be 69/26): " + c.getStoredValue().toString() + '\n');
		System.out.println("TEST 4 (evaluate input '	12 3/-5 1/2 * 	8/-4  	/')");
		c.evaluate(c.getStoredValue(), "	12 3/-5 1/2 * 	8/-4  	/");	// test 4
		System.out.println("operation after test4 (should be /): " + c.getRememberedOperation());
		System.out.println("Stored value after test3 (should be -1): " + c.getStoredValue().toString() + '\n');
	
	}

}