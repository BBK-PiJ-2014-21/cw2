/**
 * Created by keith for the second coursework assignment.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); 
	    // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
        if(numerator>0 && denominator <0) {		// normalize fraction moving negative
        	setNumerator(-numerator);			// sign over the numerator
        	setDenominator(-denominator);
        }
    }

    @Override
    public String toString() {
    	if(numerator==0) {
    		return "" + 0;
    	} else if(denominator==1) {
			return "" + getNumerator();
		} else {
			return "" + getNumerator() + '/' + getDenominator();
		}   
   }

    public int getNumerator() {
        return numerator;
    }

    private void setNumerator(int num) {	// set to private to state immutability
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    private void setDenominator(int num) {		// set to private to state immutability
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Fraction multiply(Fraction other) {
        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }
	
	public Fraction divide(Fraction other) {
		int num = this.getNumerator() * other.getDenominator();
		int denom = this.getDenominator() * other.getNumerator();
		return new Fraction(num, denom);
	}
	
	public Fraction add(Fraction other) {
		int denom = this.getDenominator()*other.getDenominator();
		int num = (denom/this.getDenominator()) * this.getNumerator() + (denom/other.getDenominator()) * other.getNumerator();
		return new Fraction(num, denom);
	
	}
	
	public Fraction subtract(Fraction other) {
		int denom = this.getDenominator()*other.getDenominator();
		int num = (denom/this.getDenominator()) * this.getNumerator() - (denom/other.getDenominator()) * other.getNumerator();
		return new Fraction(num, denom);
	}
		

    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
