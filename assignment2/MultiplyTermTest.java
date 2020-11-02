package assignment2;

import org.junit.jupiter.api.*;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTermTest {
    Polynomial expected;
    Polynomial actual;

    static Term zero;

    @BeforeAll
    static void createZeroTerm() {
        zero = new Term(1, BigInteger.ONE);
        zero.setCoefficient(BigInteger.ZERO);
    }

    @BeforeEach
    void createNewPolynomials() {
        expected = new Polynomial();
        actual = new Polynomial();
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying a constant term by zero") // this may be an extremely pointless test but it's still important
    void constantZero() {
        actual.addTermLast(new Term(0, new BigInteger("1")));

        actual.multiplyTerm(zero);

        assertAll(
                () -> assertEquals(0, expected.size()),
                () -> assertEquals(0, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying a single term by zero")
    void singleTermZero() {
        actual.addTermLast(new Term(1, new BigInteger("1")));

        actual.multiplyTerm(zero);

        assertAll(
                () -> assertEquals(0, expected.size()),
                () -> assertEquals(0, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Minitester")
    @DisplayName("multiplying a single term by a constant")
    void singleTermConstant() {
        expected.addTermLast(new Term(1, new BigInteger("2")));

        actual.addTermLast(new Term(1, new BigInteger("1")));
        actual.multiplyTerm(new Term(0, new BigInteger("2")));

        assertAll(
                () -> assertEquals(1, expected.size()),
                () -> assertEquals(1, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Minitester")
    @DisplayName("multiplying a single term by another single term")
    void singleTermSingleTerm() {
        expected.addTermLast(new Term(3, new BigInteger("4")));

        actual.addTermLast(new Term(1, new BigInteger("2")));
        actual.multiplyTerm(new Term(2, new BigInteger("2")));

        assertAll(
                () -> assertEquals(1, expected.size()),
                () -> assertEquals(1, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying many terms by zero")
    void multiTermZero() {
        actual.addTermLast(new Term(12, new BigInteger("4")));
        actual.addTermLast(new Term(6, new BigInteger("1")));
        actual.addTermLast(new Term(4, new BigInteger("2")));
        actual.addTermLast(new Term(3, new BigInteger("4")));
        actual.addTermLast(new Term(2, new BigInteger("1")));
        actual.addTermLast(new Term(0, new BigInteger("2")));

        actual.multiplyTerm(zero);

        assertAll(
                () -> assertEquals(0, expected.size()),
                () -> assertEquals(0, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Minitester") // Modified, but originally from minitester
    @DisplayName("multiplying many terms by a constant")
    void manyTermsConstant() {
        expected.addTermLast(new Term(12, new BigInteger("8")));
        expected.addTermLast(new Term(6, new BigInteger("2")));
        expected.addTermLast(new Term(4, new BigInteger("4")));
        expected.addTermLast(new Term(3, new BigInteger("8")));
        expected.addTermLast(new Term(2, new BigInteger("2")));
        expected.addTermLast(new Term(0, new BigInteger("4")));

        actual.addTermLast(new Term(12, new BigInteger("4")));
        actual.addTermLast(new Term(6, new BigInteger("1")));
        actual.addTermLast(new Term(4, new BigInteger("2")));
        actual.addTermLast(new Term(3, new BigInteger("4")));
        actual.addTermLast(new Term(2, new BigInteger("1")));
        actual.addTermLast(new Term(0, new BigInteger("2")));

        actual.multiplyTerm(new Term(0, new BigInteger("2")));

        assertAll(
                () -> assertEquals(6, expected.size()),
                () -> assertEquals(6, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Minitester") // Modified, but originally from minitester
    @DisplayName("multiplying many terms by a non-constant term")
    void manyTermsNonConstant() {
        expected.addTermLast(new Term(20, new BigInteger("6")));
        expected.addTermLast(new Term(18, new BigInteger("2")));
        expected.addTermLast(new Term(14, new BigInteger("4")));
        expected.addTermLast(new Term(6, new BigInteger("6")));
        expected.addTermLast(new Term(5, new BigInteger("2")));
        expected.addTermLast(new Term(4, new BigInteger("4")));

        actual.addTermLast(new Term(16, new BigInteger("3")));
        actual.addTermLast(new Term(14, new BigInteger("1")));
        actual.addTermLast(new Term(10, new BigInteger("2")));
        actual.addTermLast(new Term(2, new BigInteger("3")));
        actual.addTermLast(new Term(1, new BigInteger("1")));
        actual.addTermLast(new Term(0, new BigInteger("2")));

        actual.multiplyTerm(new Term(4, new BigInteger("2")));

        assertAll(
                () -> assertEquals(6, expected.size()),
                () -> assertEquals(6, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("multiplies a polynomial by a term with coefficient 0")
    void multiplyPolynomialByZero() {
        actual.addTerm(new Term(1, new BigInteger("1")));
        actual.addTerm(new Term(0, new BigInteger("1")));

        actual.multiplyTerm(zero);

        assertAll(
                () -> assertEquals(0, expected.size()),
                () -> assertEquals(0, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("multiplies an empty polynomial by a term with coefficient 0")
    void multiplyEmptyPolynomialByZero() {
        actual.multiplyTerm(zero);

        assertAll(
                () -> assertEquals(0, expected.size()),
                () -> assertEquals(0, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("multiplies an empty polynomial by a term")
    void multiplyEmptyPolynomialByTerm() {
        Term t = new Term(1, new BigInteger("1"));

        actual.multiplyTerm(t);

        assertAll(
                () -> assertEquals(0, expected.size()),
                () -> assertEquals(0, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }
}