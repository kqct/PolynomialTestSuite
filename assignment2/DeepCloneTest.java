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

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("polynomial with one term")
    void oneTerm() {
        expected.addTermLast(new Term(3, new BigInteger("20")));

        actual = expected.deepClone();

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("polynomial with multiple terms")
    void multiTerms() {
        expected.addTermLast(new Term(3, new BigInteger("20")));
        expected.addTermLast(new Term(4, new BigInteger("20")));
        expected.addTermLast(new Term(1, new BigInteger("20")));

        actual = expected.deepClone();

        assertTrue(actual.isDeepClone(expected));
    }
}