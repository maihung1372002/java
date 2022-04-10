package hw3.ex1;

public class Fraction {
    
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            try {
                throw new Exception ("invalid denominator");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if( denominator < 0) {
            denominator *= -1;
            numerator *= -1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction c) {
        int newNumerator = this.numerator * c.denominator + c.numerator * this.denominator;
        int newDenominator = this.denominator * c.denominator;

        return normalize(new Fraction(newNumerator, newDenominator));
    }

    public Fraction minus(Fraction c) {
        int newNumerator = this.numerator * c.denominator - c.numerator * this.denominator;
        int newDenominator = this.denominator * c.denominator;

        return normalize(new Fraction(newNumerator, newDenominator));
    }

    public Fraction multi(Fraction c) {
        int newNumerator = this.numerator * c.numerator;
        int newDenominator = this.denominator * c.denominator;

        return normalize(new Fraction(newNumerator, newDenominator));
    }

    public Fraction divi(Fraction c) {
        int newNumerator = this.numerator * c.denominator;
        int newDenominator = this.denominator * c.numerator;

        return normalize(new Fraction(newNumerator, newDenominator));
    }

    public Fraction normalize(Fraction o) {

        int numb1 = o.getNumerator();
        int numb2 = o.getDenominator();
        int r = numb1 % numb2;
        while (r != 0) {
            numb1 = numb2;
            numb2 = r;
            r = numb1 % numb2;
        }
        int numer = o.getNumerator();
        int deno = o.getDenominator();

        return new Fraction(numer / numb2, deno / numb2);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
   
}
