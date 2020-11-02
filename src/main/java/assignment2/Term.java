package assignment2;

import java.math.BigInteger;

/*
 * This class Term represents a single term in the polynomial
 *
 * The terms with zero coefficients should be removed from the
 * representation.
 *
 * Under no circumstances the exponent should be negative.
 */

public class Term implements DeepClone<Term> {

    /* instance fields */
    private int exponent;
    private BigInteger coefficient;

    /* Constructors */
    public Term(int e, BigInteger c) {
        if (e < 0 || c.compareTo(new BigInteger("0")) == 0)
            throw new IllegalArgumentException("Invalid term");

        exponent = e;
        coefficient = c;
    }

    @Override
    public Term deepClone() {
        return new Term(exponent, coefficient);
    }

    /* Instance methods */
    BigInteger getCoefficient() {
        return coefficient;
    }

    void setCoefficient(BigInteger d) {
        coefficient = d;
    }

    int getExponent() {
        return exponent;
    }

    void setExponent(int a) {
        exponent = a;
    }

    // Hint: Notice that in your final submission, you are not supposed to use this
    // method for evaluating a polynomial. This method is provided for
    // validating your implementation of Horner's method.
    BigInteger eval(BigInteger x) {
        BigInteger result = BigInteger.valueOf(1);
        int n = exponent;
        while (n != 0) {
            result = result.multiply(x);
            n--;
        }
        return (result.multiply(coefficient));
    }

    @Override
    public String toString() {
        String s = "";
        if (coefficient.compareTo(new BigInteger("0")) < 0)
            s += "-";
        else if (coefficient.compareTo(new BigInteger("0")) > 0)
            s += "+";

        if (coefficient.abs().compareTo(new BigInteger("1")) != 0)
            s += coefficient.abs();

        if (exponent > 0) {
            s += "x";
            if (exponent > 1) {
                s += "^" + exponent;
            }
        } else if (coefficient.abs().compareTo(new BigInteger("1")) == 0)
            s += "1";

        return s;
    }


}
