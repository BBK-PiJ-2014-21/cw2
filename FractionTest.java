/**
 * Created by keith for the second coursework assignment.
 */
public class FractionTest {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        // test multiply
	Fraction f = new Fraction(3,10);
	Fraction g = new Fraction(1,2);
	Fraction h = new Fraction(3,5);
	if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");
        // test equals
	test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
	test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
	test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
	test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
	System.out.println();
	test(new Fraction(4, -8),new Fraction(1, 2),"error test 5 (this should be printed, as -1/2 !equals 1/2)");

        // extend with extra tests
	
	// test getters, toString() and normalization
	System.out.println();
	Fraction x = new Fraction(-4,-4);
	System.out.println("Fraction -4/-4");
	System.out.println("numerator: " + x.getNumerator());
	System.out.println("denominator: " + x.getDenominator());
	System.out.println("fraction: " + x.toString() + '\n');
	Fraction y = new Fraction(-4,3);
	System.out.println("Fraction -4/3");
	System.out.println("numerator: " + y.getNumerator());
	System.out.println("denominator: " + y.getDenominator());
	System.out.println("fraction: " + y.toString() + '\n');
	// test add(), subtract() and divide()
	System.out.println("Testing add() method (-4/-4 + -4/3)");
	System.out.println((x.add(y)).toString() + '\n');
	System.out.println("Testing subtract() method (-4/-4 - -4/3)");
	System.out.println((x.subtract(y)).toString() + '\n');
	System.out.println("Testing divide() method (-4/-4 / -4/3)");
	System.out.println((x.divide(y)).toString() + '\n');
	Fraction z = new Fraction(0,-2);
	System.out.println("Fraction 0/-2");
	System.out.println(z.toString());
	// test negate() and absValue()
	System.out.println("negate() Fraction 0/-2");
	System.out.println((z.negate()).toString() + '\n');
	System.out.println("negate() Fraction -4/3");
	System.out.println((y.negate()).toString() + '\n');
	System.out.println("abs() Fraction -4/-4");
	System.out.println((x.absValue()).toString() + '\n');
	System.out.println("negate() Fraction -4/-4");
	System.out.println((x.negate()).toString());
	
    }

    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
}
