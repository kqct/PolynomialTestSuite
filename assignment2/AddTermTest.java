package assignment2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class AddTermTest {
    Polynomial expected;
    Polynomial actual;

    @BeforeEach
    void createNewPolynomials() {
        expected = new Polynomial();
        actual = new Polynomial();
    }

    @Test
    @Tag("Minitester")
    @DisplayName("adding a single term")
    void singleTermAdded() {
        expected.addTermLast(new Term(1, new BigInteger("1")));
        actual.addTerm(new Term(1, new BigInteger("1")));

        assertAll(
                () -> assertEquals(1, expected.size()),
                () -> assertEquals(1, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Minitester")
    @DisplayName("adding multiple terms in descending order")
    void multipleTermsDescendingOrder() {
        expected.addTermLast(new Term(4, new BigInteger("5")));
        expected.addTermLast(new Term(3, new BigInteger("4")));
        expected.addTermLast(new Term(2, new BigInteger("3")));
        expected.addTermLast(new Term(1, new BigInteger("2")));
        expected.addTermLast(new Term(0, new BigInteger("1")));

        actual.addTerm(new Term(4, new BigInteger("5")));
        actual.addTerm(new Term(3, new BigInteger("4")));
        actual.addTerm(new Term(2, new BigInteger("3")));
        actual.addTerm(new Term(1, new BigInteger("2")));
        actual.addTerm(new Term(0, new BigInteger("1")));

        assertAll(
                () -> assertEquals(5, expected.size()),
                () -> assertEquals(5, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Minitester")
    @DisplayName("adding multiple terms in ascending order")
    void multipleTermsAscendingOrder() {
        expected.addTermLast(new Term(4, new BigInteger("1")));
        expected.addTermLast(new Term(3, new BigInteger("1")));
        expected.addTermLast(new Term(2, new BigInteger("1")));
        expected.addTermLast(new Term(1, new BigInteger("1")));
        expected.addTermLast(new Term(0, new BigInteger("1")));

        actual.addTerm(new Term(0, new BigInteger("1")));
        actual.addTerm(new Term(1, new BigInteger("1")));
        actual.addTerm(new Term(2, new BigInteger("1")));
        actual.addTerm(new Term(3, new BigInteger("1")));
        actual.addTerm(new Term(4, new BigInteger("1")));

        assertAll(
                () -> assertEquals(5, expected.size()),
                () -> assertEquals(5, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Minitester")
    @DisplayName("combining terms of the same exponent")
    void combiningTerms() {
        expected.addTermLast(new Term(4, new BigInteger("4")));
        expected.addTermLast(new Term(3, new BigInteger("3")));
        expected.addTermLast(new Term(2, new BigInteger("1")));
        expected.addTermLast(new Term(1, new BigInteger("1")));

        actual.addTerm(new Term(4, new BigInteger("4")));
        actual.addTerm(new Term(3, new BigInteger("3")));
        actual.addTerm(new Term(2, new BigInteger("2")));
        actual.addTerm(new Term(1, new BigInteger("1")));
        actual.addTerm(new Term(2, new BigInteger("-1")));

        assertAll(
                () -> assertEquals(4, expected.size()),
                () -> assertEquals(4, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }
    
    @Test
    @Tag("Megatester")
    @DisplayName("adds a term which should be inserted in the middle of a polynomial")
    void insertTermInMiddle() {
        expected.addTermLast(new Term(9, new BigInteger("3")));
        expected.addTermLast(new Term(4, new BigInteger("5")));
        expected.addTermLast(new Term(3, new BigInteger("4")));
        
        actual.addTerm(new Term(9, new BigInteger("3")));
        actual.addTerm(new Term(3, new BigInteger("4")));
        actual.addTerm(new Term(4, new BigInteger("5")));

        assertAll(
                () -> assertEquals(3, expected.size()),
                () -> assertEquals(3, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }
    
    @Test
    @Tag("Megatester")
    @DisplayName("adds an empty term")
    void addEmptyTerm() {
        expected.addTermLast(new Term(9, new BigInteger("3")));
        expected.addTermLast(new Term(4, new BigInteger("5")));
        expected.addTermLast(new Term(3, new BigInteger("4")));

        actual.addTerm(new Term(9, new BigInteger("3")));
        actual.addTerm(new Term(4, new BigInteger("5")));
        actual.addTerm(new Term(3, new BigInteger("4")));

        Term t = new Term(1, new BigInteger("120"));
        t.setCoefficient(BigInteger.ZERO);
        actual.addTerm(t);

        assertAll(
                () -> assertEquals(3, expected.size()),
                () -> assertEquals(3, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }
}