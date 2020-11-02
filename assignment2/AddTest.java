package assignment2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {
    Polynomial expected;
    Polynomial actual;

    Polynomial term1;
    Polynomial term2;

    @BeforeEach
    void createNewPolynomials() {
        expected = new Polynomial();
        actual = new Polynomial();

        term1 = new Polynomial();
        term2 = new Polynomial();
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials with one term each and same exponents")
    void singleTermSameExponent() {
        term1.addTermLast(new Term(1, new BigInteger("1")));
        term2.addTermLast(new Term(1, new BigInteger("3")));

        expected.addTermLast(new Term(1, new BigInteger("4")));
        actual = Polynomial.add(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials with one term each and different exponents")
    void singleTermDifferentExponent() {
        term1.addTermLast(new Term(2, new BigInteger("1")));
        term2.addTermLast(new Term(1, new BigInteger("3")));

        expected.addTermLast(new Term(2, new BigInteger("1")));
        expected.addTermLast(new Term(1, new BigInteger("3")));

        actual = Polynomial.add(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials with multiple terms each and same exponents")
    void multiTermSameExponents() {
        term1.addTermLast(new Term(12, new BigInteger("12")));
        term1.addTermLast(new Term(9, new BigInteger("5425")));
        term1.addTermLast(new Term(5, new BigInteger("4")));
        term1.addTermLast(new Term(4, new BigInteger("412")));
        term1.addTermLast(new Term(2, new BigInteger("124")));
        term1.addTermLast(new Term(0, new BigInteger("53")));

        term2.addTermLast(new Term(12, new BigInteger("325")));
        term2.addTermLast(new Term(9, new BigInteger("23")));
        term2.addTermLast(new Term(5, new BigInteger("1245")));
        term2.addTermLast(new Term(4, new BigInteger("3512")));
        term2.addTermLast(new Term(2, new BigInteger("4")));
        term2.addTermLast(new Term(0, new BigInteger("2")));

        expected.addTermLast(new Term(12, new BigInteger("337")));
        expected.addTermLast(new Term(9, new BigInteger("5448")));
        expected.addTermLast(new Term(5, new BigInteger("1249")));
        expected.addTermLast(new Term(4, new BigInteger("3924")));
        expected.addTermLast(new Term(2, new BigInteger("128")));
        expected.addTermLast(new Term(0, new BigInteger("55")));

        actual = Polynomial.add(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials with multiple terms each and overlapping exponents")
    void multiTermOverlappingExponents() {
        term1.addTermLast(new Term(44, new BigInteger("25")));
        term1.addTermLast(new Term(35, new BigInteger("214")));
        term1.addTermLast(new Term(20, new BigInteger("53")));
        term1.addTermLast(new Term(8, new BigInteger("6423")));
        term1.addTermLast(new Term(2, new BigInteger("35")));
        term1.addTermLast(new Term(1, new BigInteger("5")));

        term2.addTermLast(new Term(512, new BigInteger("3125")));
        term2.addTermLast(new Term(44, new BigInteger("4")));
        term2.addTermLast(new Term(39, new BigInteger("243")));
        term2.addTermLast(new Term(4, new BigInteger("235")));
        term2.addTermLast(new Term(2, new BigInteger("33")));
        term2.addTermLast(new Term(0, new BigInteger("2")));

        expected.addTermLast(new Term(512, new BigInteger("3125")));
        expected.addTermLast(new Term(44, new BigInteger("29")));
        expected.addTermLast(new Term(39, new BigInteger("243")));
        expected.addTermLast(new Term(35, new BigInteger("214")));
        expected.addTermLast(new Term(20, new BigInteger("53")));
        expected.addTermLast(new Term(8, new BigInteger("6423")));
        expected.addTermLast(new Term(4, new BigInteger("235")));
        expected.addTermLast(new Term(2, new BigInteger("68")));
        expected.addTermLast(new Term(1, new BigInteger("5")));
        expected.addTermLast(new Term(0, new BigInteger("2")));

        actual = Polynomial.add(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials with multiple terms each and completely different exponents")
    void multiTermDifferentExponents() {
        term1.addTermLast(new Term(142, new BigInteger("1")));
        term1.addTermLast(new Term(56, new BigInteger("4")));
        term1.addTermLast(new Term(43, new BigInteger("1")));
        term1.addTermLast(new Term(25, new BigInteger("4")));
        term1.addTermLast(new Term(9, new BigInteger("1")));
        term1.addTermLast(new Term(1, new BigInteger("4")));

        term2.addTermLast(new Term(89, new BigInteger("3")));
        term2.addTermLast(new Term(86, new BigInteger("2")));
        term2.addTermLast(new Term(64, new BigInteger("3")));
        term2.addTermLast(new Term(34, new BigInteger("2")));
        term2.addTermLast(new Term(2, new BigInteger("3")));
        term2.addTermLast(new Term(0, new BigInteger("2")));

        expected.addTermLast(new Term(142, new BigInteger("1")));
        expected.addTermLast(new Term(89, new BigInteger("3")));
        expected.addTermLast(new Term(86, new BigInteger("2")));
        expected.addTermLast(new Term(64, new BigInteger("3")));
        expected.addTermLast(new Term(56, new BigInteger("4")));
        expected.addTermLast(new Term(43, new BigInteger("1")));
        expected.addTermLast(new Term(34, new BigInteger("2")));
        expected.addTermLast(new Term(25, new BigInteger("4")));
        expected.addTermLast(new Term(9, new BigInteger("1")));

        expected.addTermLast(new Term(2, new BigInteger("3")));
        expected.addTermLast(new Term(1, new BigInteger("4")));
        expected.addTermLast(new Term(0, new BigInteger("2")));

        actual = Polynomial.add(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials where the first polynomial is zero")
    void firstPolyZero() {
        term2.addTermLast(new Term(2, new BigInteger("3")));
        term2.addTermLast(new Term(0, new BigInteger("2")));

        expected.addTermLast(new Term(2, new BigInteger("3")));
        expected.addTermLast(new Term(0, new BigInteger("2")));

        actual = Polynomial.add(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials where the second polynomial is zero")
    void secondPolyZero() {
        term1.addTermLast(new Term(2, new BigInteger("3")));
        term1.addTermLast(new Term(0, new BigInteger("2")));

        expected.addTermLast(new Term(2, new BigInteger("3")));
        expected.addTermLast(new Term(0, new BigInteger("2")));

        actual = Polynomial.add(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials where both polynomials are zero")
    void bothPolyZero() {
        actual = Polynomial.add(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }
}