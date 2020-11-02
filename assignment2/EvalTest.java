package assignment2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class EvalTest {
    Polynomial actual;
    BigInteger expected;

    @BeforeEach
    void createNewPolynomial() {
        actual = new Polynomial();
    }

    @Test
    @Tag("Minitester")
    @DisplayName("polynomial of stricly zero-value exponent")
    void constantTerm() {
        actual.addTermLast(new Term(0, new BigInteger("465")));
        expected = new BigInteger("465");

        BigInteger result1 = actual.eval(BigInteger.ONE);
        BigInteger result2 = actual.eval(BigInteger.ZERO);

        assertAll(
                () -> assertEquals(expected, result1),
                () -> assertEquals(expected, result2)

        );
    }

    @Test
    @Tag("Minitester")
    @DisplayName("descending order of coefficients and exponents")
    void descendingTerms() {
        int nTerms = 10;
        for (int i = nTerms - 1; i >= 0; i--)
            actual.addTermLast(new Term(i, new BigInteger(Integer.toString(i + 1))));

        expected = new BigInteger("9217");

        BigInteger result = actual.eval(BigInteger.TWO);

        assertEquals(expected, result);
    }

    @Test
    @Tag("Minitester")
    @DisplayName("random non-iterative coefficients and exponents")
    void randomTerms() {
        actual.addTermLast(new Term(12, new BigInteger(Integer.toString(1))));
        actual.addTermLast(new Term(3, new BigInteger(Integer.toString(-4))));
        actual.addTermLast(new Term(2, new BigInteger(Integer.toString(2))));
        actual.addTermLast(new Term(1, new BigInteger(Integer.toString(-1))));

        expected = new BigInteger("531348");

        BigInteger result = actual.eval(new BigInteger("3"));

        assertEquals(expected, result);
    }

    @Test
    @Tag("Minitester")
    @DisplayName("evaluate on negative number")
    void evalNegative() {
        actual.addTermLast(new Term(11, new BigInteger(Integer.toString(1))));
        actual.addTermLast(new Term(3, new BigInteger(Integer.toString(-4))));
        actual.addTermLast(new Term(2, new BigInteger(Integer.toString(2))));
        actual.addTermLast(new Term(1, new BigInteger(Integer.toString(-1))));

        expected = new BigInteger("-2006");

        BigInteger result = actual.eval(new BigInteger("-2"));

        assertEquals(expected, result);
    }

    @Test
    @Tag("Megatester")
    @DisplayName("tests basic functioning of eval on a polynomial where not every exponent is present")
    void basicEval() {
        actual.addTerm(new Term(3, new BigInteger("2")));
        actual.addTerm(new Term(1, new BigInteger("5")));
        actual.addTerm(new Term(0, new BigInteger("2")));

        expected = new BigInteger("277");

        BigInteger result = actual.eval(new BigInteger("5"));

        assertEquals(expected, result);
    }

    @Test
    @Tag("Megatester")
    @DisplayName("tests eval by evaluating it with x = 0")
    void evalAtZero() {
        actual.addTerm(new Term(3, new BigInteger("2")));
        actual.addTerm(new Term(1, new BigInteger("5")));
        actual.addTerm(new Term(0, new BigInteger("2")));

        expected = new BigInteger("2");

        BigInteger result = actual.eval(new BigInteger("0"));

        assertEquals(expected, result);
    }

    @Test
    @Tag("Megatester")
    @DisplayName("tests evaluating an empty polynomial")
    void evaluateEmpty() {
        expected = new BigInteger("0");

        BigInteger result = actual.eval(new BigInteger("129"));

        assertEquals(expected, result);
    }

    @Test
    @Tag("Megatester")
    @DisplayName("tests evaluating an empty polynomial with x = 0")
    void evaluateEmptyAtEmpty() {
        expected = new BigInteger("0");

        BigInteger result = actual.eval(new BigInteger("0"));

        assertEquals(expected, result);
    }
}