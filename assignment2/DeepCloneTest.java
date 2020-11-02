package assignment2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class DeepCloneTest {
    Polynomial expected;
    Polynomial actual;

    @BeforeEach
    void createNewPolynomial() {
        expected = new Polynomial();
    }

    @Test
    @Tag("Original")
    @DisplayName("polynomial with no terms")
    void noTerms() {
        actual = expected.deepClone();

        assertAll(
                () -> assertEquals(expected.size(), actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("polynomial with one term")
    void oneTerm() {
        expected.addTermLast(new Term(3, new BigInteger("20")));

        actual = expected.deepClone();

        assertAll(
                () -> assertEquals(expected.size(), actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("polynomial with multiple terms")
    void multiTerms() {
        expected.addTermLast(new Term(3, new BigInteger("20")));
        expected.addTermLast(new Term(4, new BigInteger("20")));
        expected.addTermLast(new Term(1, new BigInteger("20")));

        actual = expected.deepClone();

        assertAll(
                () -> assertEquals(expected.size(), actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("tests basic functioning of deepClone()")
    void generalDeepClone() {
        expected.addTerm(new Term(9, new BigInteger("3")));
        expected.addTerm(new Term(4, new BigInteger("5")));
        expected.addTerm(new Term(3, new BigInteger("4")));
        expected.addTerm(new Term(2, new BigInteger("3")));
        expected.addTerm(new Term(1, new BigInteger("2")));
        expected.addTerm(new Term(0, new BigInteger("1")));

        actual = expected.deepClone();

        assertAll(
                () -> assertNotEquals(expected, actual),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("compares a deep clone to an identical polynomial")
    void compareToIdentical() {
        Polynomial pNotCopy = new Polynomial();

        expected.addTerm(new Term(9, new BigInteger("3")));
        expected.addTerm(new Term(4, new BigInteger("5")));
        expected.addTerm(new Term(3, new BigInteger("4")));

        pNotCopy.addTermLast(new Term(9, new BigInteger("3")));
        pNotCopy.addTermLast(new Term(4, new BigInteger("5")));
        pNotCopy.addTermLast(new Term(3, new BigInteger("4")));

        actual = expected.deepClone();

        assertAll(
                () -> assertNotEquals(expected, actual),
                () -> assertNotEquals(expected, pNotCopy),
                () -> assertEquals(3, expected.size()),
                () -> assertTrue(actual.isDeepClone(pNotCopy)),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("tests deepClone() on an empty polynomial")
    void compareToEmpty() {
        actual = expected.deepClone();

        assertAll(
                () -> assertEquals(0, expected.size()),
                () -> assertEquals(0, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("changes term in copy, to see if terms are indeed deepclones")
    void changeTerms() {
        expected.addTerm(new Term(9, new BigInteger("3")));
        expected.addTerm(new Term(4, new BigInteger("5")));
        expected.addTerm(new Term(3, new BigInteger("4")));
        expected.addTerm(new Term(2, new BigInteger("3")));
        expected.addTerm(new Term(1, new BigInteger("2")));
        expected.addTerm(new Term(0, new BigInteger("1")));

        actual = expected.deepClone();
        actual.getTerm(0).setExponent(10);

        assertFalse(actual.isDeepClone(expected));
    }
}