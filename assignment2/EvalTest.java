package assignment2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class EvalTest {
    Polynomial term;
    BigInteger expected;

    @BeforeEach
    void createNewPolynomial() {
        term = new Polynomial();
    }

    @Test
    @Tag("Minitester")
    @DisplayName("polynomial of stricly zero-value exponent")
    void constantTerm() {
        term.addTermLast(new Term(0, new BigInteger("465")));
        expected = new BigInteger("465");

        BigInteger result1 = term.eval(BigInteger.ONE);
        BigInteger result2 = term.eval(BigInteger.ZERO);

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
            term.addTermLast(new Term(i, new BigInteger(Integer.toString(i + 1))));

        expected = new BigInteger("9217");

        BigInteger result = term.eval(BigInteger.TWO);

        assertEquals(expected, result);
    }

    @Test
    @Tag("Minitester")
    @DisplayName("random non-iterative coefficients and exponents")
    void randomTerms() {
        term.addTermLast(new Term(12, new BigInteger(Integer.toString(1))));
        term.addTermLast(new Term(3, new BigInteger(Integer.toString(-4))));
        term.addTermLast(new Term(2, new BigInteger(Integer.toString(2))));
        term.addTermLast(new Term(1, new BigInteger(Integer.toString(-1))));

        expected = new BigInteger("531348");

        BigInteger result = term.eval(new BigInteger("3"));

        assertEquals(expected, result);
    }

    @Test
    @Tag("Minitester")
    @DisplayName("evaluate on negative number")
    void evalNegative() {
        term.addTermLast(new Term(11, new BigInteger(Integer.toString(1))));
        term.addTermLast(new Term(3, new BigInteger(Integer.toString(-4))));
        term.addTermLast(new Term(2, new BigInteger(Integer.toString(2))));
        term.addTermLast(new Term(1, new BigInteger(Integer.toString(-1))));

        expected = new BigInteger("-2006");

        BigInteger result = term.eval(new BigInteger("-2"));

        assertEquals(expected, result);
    }
}