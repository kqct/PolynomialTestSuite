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

    Polynomial p1;
    Polynomial p2;

    @BeforeEach
    void createNewPolynomials() {
        expected = new Polynomial();
        actual = new Polynomial();

        p1 = new Polynomial();
        p2 = new Polynomial();
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials with one term each and same exponents")
    void singleTermSameExponent() {
        p1.addTermLast(new Term(1, new BigInteger("1")));
        p2.addTermLast(new Term(1, new BigInteger("3")));

        expected.addTermLast(new Term(1, new BigInteger("4")));
        actual = Polynomial.add(p1, p2);

        assertAll(
                () -> assertEquals(1, expected.size()),
                () -> assertEquals(1, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials with one term each and different exponents")
    void singleTermDifferentExponent() {
        p1.addTermLast(new Term(2, new BigInteger("1")));
        p2.addTermLast(new Term(1, new BigInteger("3")));

        expected.addTermLast(new Term(2, new BigInteger("1")));
        expected.addTermLast(new Term(1, new BigInteger("3")));

        actual = Polynomial.add(p1, p2);

        assertAll(
                () -> assertEquals(2, expected.size()),
                () -> assertEquals(2, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials with multiple terms each and same exponents")
    void multiTermSameExponents() {
        p1.addTermLast(new Term(12, new BigInteger("12")));
        p1.addTermLast(new Term(9, new BigInteger("5425")));
        p1.addTermLast(new Term(5, new BigInteger("4")));
        p1.addTermLast(new Term(4, new BigInteger("412")));
        p1.addTermLast(new Term(2, new BigInteger("124")));
        p1.addTermLast(new Term(0, new BigInteger("53")));

        p2.addTermLast(new Term(12, new BigInteger("325")));
        p2.addTermLast(new Term(9, new BigInteger("23")));
        p2.addTermLast(new Term(5, new BigInteger("1245")));
        p2.addTermLast(new Term(4, new BigInteger("3512")));
        p2.addTermLast(new Term(2, new BigInteger("4")));
        p2.addTermLast(new Term(0, new BigInteger("2")));

        expected.addTermLast(new Term(12, new BigInteger("337")));
        expected.addTermLast(new Term(9, new BigInteger("5448")));
        expected.addTermLast(new Term(5, new BigInteger("1249")));
        expected.addTermLast(new Term(4, new BigInteger("3924")));
        expected.addTermLast(new Term(2, new BigInteger("128")));
        expected.addTermLast(new Term(0, new BigInteger("55")));

        actual = Polynomial.add(p1, p2);

        assertAll(
                () -> assertEquals(6, expected.size()),
                () -> assertEquals(6, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials with multiple terms each and overlapping exponents")
    void multiTermOverlappingExponents() {
        p1.addTermLast(new Term(44, new BigInteger("25")));
        p1.addTermLast(new Term(35, new BigInteger("214")));
        p1.addTermLast(new Term(20, new BigInteger("53")));
        p1.addTermLast(new Term(8, new BigInteger("6423")));
        p1.addTermLast(new Term(2, new BigInteger("35")));
        p1.addTermLast(new Term(1, new BigInteger("5")));

        p2.addTermLast(new Term(512, new BigInteger("3125")));
        p2.addTermLast(new Term(44, new BigInteger("4")));
        p2.addTermLast(new Term(39, new BigInteger("243")));
        p2.addTermLast(new Term(4, new BigInteger("235")));
        p2.addTermLast(new Term(2, new BigInteger("33")));
        p2.addTermLast(new Term(0, new BigInteger("2")));

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

        actual = Polynomial.add(p1, p2);

        assertAll(
                () -> assertEquals(10, expected.size()),
                () -> assertEquals(10, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials with multiple terms each and completely different exponents")
    void multiTermDifferentExponents() {
        p1.addTermLast(new Term(142, new BigInteger("1")));
        p1.addTermLast(new Term(56, new BigInteger("4")));
        p1.addTermLast(new Term(43, new BigInteger("1")));
        p1.addTermLast(new Term(25, new BigInteger("4")));
        p1.addTermLast(new Term(9, new BigInteger("1")));
        p1.addTermLast(new Term(1, new BigInteger("4")));

        p2.addTermLast(new Term(89, new BigInteger("3")));
        p2.addTermLast(new Term(86, new BigInteger("2")));
        p2.addTermLast(new Term(64, new BigInteger("3")));
        p2.addTermLast(new Term(34, new BigInteger("2")));
        p2.addTermLast(new Term(2, new BigInteger("3")));
        p2.addTermLast(new Term(0, new BigInteger("2")));

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

        actual = Polynomial.add(p1, p2);

        assertAll(
                () -> assertEquals(12, expected.size()),
                () -> assertEquals(12, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials where the first polynomial is zero")
    void firstPolyZero() {
        p2.addTermLast(new Term(2, new BigInteger("3")));
        p2.addTermLast(new Term(0, new BigInteger("2")));

        expected.addTermLast(new Term(2, new BigInteger("3")));
        expected.addTermLast(new Term(0, new BigInteger("2")));

        actual = Polynomial.add(p1, p2);

        assertAll(
                () -> assertEquals(2, expected.size()),
                () -> assertEquals(2, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials where the second polynomial is zero")
    void secondPolyZero() {
        p1.addTermLast(new Term(2, new BigInteger("3")));
        p1.addTermLast(new Term(0, new BigInteger("2")));

        expected.addTermLast(new Term(2, new BigInteger("3")));
        expected.addTermLast(new Term(0, new BigInteger("2")));

        actual = Polynomial.add(p1, p2);

        assertAll(
                () -> assertEquals(2, expected.size()),
                () -> assertEquals(2, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("adding two polynomials where both polynomials are zero")
    void bothPolyZero() {
        actual = Polynomial.add(p1, p2);

        assertAll(
                () -> assertEquals(0, expected.size()),
                () -> assertEquals(0, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }
    
    @Test
    @Tag("Megatester")
    @DisplayName("tests general functioning of add()")
    void generalAdd() {
        p1.addTerm(new Term(9, new BigInteger("3")));
        p1.addTerm(new Term(4, new BigInteger("5")));
        p1.addTerm(new Term(3, new BigInteger("4")));

        p2.addTerm(new Term(9, new BigInteger("3")));
        p2.addTerm(new Term(4, new BigInteger("2")));
        p2.addTerm(new Term(0, new BigInteger("1")));

        expected.addTermLast(new Term(9, new BigInteger("6")));
        expected.addTermLast(new Term(4, new BigInteger("7")));
        expected.addTermLast(new Term(3, new BigInteger("4")));
        expected.addTermLast(new Term(0, new BigInteger("1")));

        actual = Polynomial.add(p1, p2);

        assertAll(
                () -> assertEquals(4, expected.size()),
                () -> assertEquals(4, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }
    
    @Test
    @Tag("Megatester")
    @DisplayName("adds two polynomials where two terms cancel out")
    void termsCancelOut() {
        p1.addTerm(new Term(9, new BigInteger("3")));
        p1.addTerm(new Term(8, new BigInteger("2")));

        p2.addTerm(new Term(7, new BigInteger("1")));
        p2.addTerm(new Term(8, new BigInteger("-2")));

        expected.addTermLast(new Term(9, new BigInteger("3")));
        expected.addTermLast(new Term(7, new BigInteger("1")));

        actual = Polynomial.add(p1, p2);

        assertAll(
                () -> assertEquals(2, expected.size()),
                () -> assertEquals(2, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("adds a polynomial to an empty polynomial")
    void addEmpty() {
        p1.addTerm(new Term(9, new BigInteger("3")));
        p1.addTerm(new Term(4, new BigInteger("5")));
        p1.addTerm(new Term(3, new BigInteger("4")));

        expected.addTermLast(new Term(9, new BigInteger("3")));
        expected.addTermLast(new Term(4, new BigInteger("5")));
        expected.addTermLast(new Term(3, new BigInteger("4")));

        actual = Polynomial.add(p1, p2);

        assertAll(
                () -> assertEquals(3, expected.size()),
                () -> assertEquals(3, actual.size()),
                () -> assertEquals(0, p2.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("adds two polynomials which should result in an empty polynomial")
    void addToEmpty() {
        p1.addTerm(new Term(9, new BigInteger("3")));
        p2.addTerm(new Term(9, new BigInteger("-3")));

        actual = Polynomial.add(p1, p2);

        assertAll(
                () -> assertEquals(0, expected.size()),
                () -> assertEquals(0, actual.size()),
                () -> assertEquals(1, p2.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }
}