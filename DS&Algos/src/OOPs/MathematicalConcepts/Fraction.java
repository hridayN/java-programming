package OOPs.MathematicalConcepts;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = (denominator == 0) ? 1 : denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /*Function to convert given fraction into simplified(minimal fraction) form
    * We'll find the Greatest Common Divisor(GCD), and divide the fraction's part with it*/
    public void simplifyFraction() {
        int min = (numerator >= denominator) ? denominator : numerator;
        int gcd = 1;

        // Starting from 2, we'll check which no. divides both the numerator and the denominator
        for (int i = 2; i <= min; i++) {
            if (numerator % i == 0 && denominator % i ==0) gcd = i;
        }

        numerator /= gcd;
        denominator /= gcd;

        printFraction("Updated");
    }

    /*Function to convert given fraction into simplified(minimal fraction) form
     * We'll find the Greatest Common Divisor(GCD), and divide the fraction's part with it*/
    public void simplifyFraction(int numerator, int denominator) {
        int min = (numerator >= denominator) ? denominator : numerator;
        int gcd = 1;

        // Starting from 2, we'll check which no. divides both the numerator and the denominator
        for (int i = 2; i <= min; i++) {
            if (numerator % i == 0 && denominator % i ==0) gcd = i;
        }

        numerator /= gcd;
        denominator /= gcd;

        System.out.println(String.format("Updated Fraction: (%d/%d)", numerator, denominator));
    }

    /* Increment the fraction by a given number */
    public void incrementFraction(int incrementBy) {
        int newNumerator = numerator + (denominator * incrementBy);
        numerator = newNumerator;
        printFraction("Updated");
    }

    /* Print fraction */
    public void printFraction(String fractionUpdated) {
        System.out.println(String.format("%s Fraction: %d/%d", fractionUpdated, numerator, denominator));
    }

    public Fraction addFractions(Fraction f1, Fraction f2) {
        int numerator = (f1.numerator * f2.denominator) + (f2.numerator * f1.denominator);
        int denominator = f1.denominator * f2.denominator;
        return new Fraction(numerator, denominator);
    }
}
