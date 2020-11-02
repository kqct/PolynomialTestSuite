package assignment2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTest {
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
    @DisplayName("multiplying two polynomials with one term each and same exponents")
    void singleTermSameExponent() {
        p1.addTermLast(new Term(1, new BigInteger("1")));
        p2.addTermLast(new Term(1, new BigInteger("3")));

        expected.addTermLast(new Term(2, new BigInteger("3")));
        actual = Polynomial.multiply(p1, p2);

        assertAll(
                () -> assertEquals(1, expected.size()),
                () -> assertEquals(1, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying two polynomials with one term each and different exponents")
    void singleTermDifferentExponent() {
        p1.addTermLast(new Term(2, new BigInteger("1")));
        p2.addTermLast(new Term(1, new BigInteger("3")));

        expected.addTermLast(new Term(3, new BigInteger("3")));

        actual = Polynomial.multiply(p1, p2);

        assertAll(
                () -> assertEquals(1, expected.size()),
                () -> assertEquals(1, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying two polynomials with multiple terms each and same exponents")
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

        expected.addTermLast(new Term(24, new BigInteger("3900")));
        expected.addTermLast(new Term(21, new BigInteger("1763401")));
        expected.addTermLast(new Term(18, new BigInteger("124775")));
        expected.addTermLast(new Term(17, new BigInteger("16240")));
        expected.addTermLast(new Term(16, new BigInteger("176044")));
        expected.addTermLast(new Term(14, new BigInteger("6794565")));
        expected.addTermLast(new Term(13, new BigInteger("19062076")));
        expected.addTermLast(new Term(12, new BigInteger("17249")));
        expected.addTermLast(new Term(11, new BigInteger("24552")));
        expected.addTermLast(new Term(10, new BigInteger("4980")));
        expected.addTermLast(new Term(9, new BigInteger("539057")));
        expected.addTermLast(new Term(8, new BigInteger("1446944")));
        expected.addTermLast(new Term(7, new BigInteger("154396")));
        expected.addTermLast(new Term(6, new BigInteger("437136")));
        expected.addTermLast(new Term(5, new BigInteger("65993")));
        expected.addTermLast(new Term(4, new BigInteger("187456")));
        expected.addTermLast(new Term(2, new BigInteger("460")));
        expected.addTermLast(new Term(0, new BigInteger("106")));

        actual = Polynomial.multiply(p1, p2);

        assertAll(
                () -> assertEquals(18, expected.size()),
                () -> assertEquals(18, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying two polynomials with multiple terms each and overlapping exponents")
    void multiTermOverlappingExponents() {
        p1.addTermLast(new Term(44, new BigInteger("25")));
        p1.addTermLast(new Term(35, new BigInteger("214")));
        p1.addTermLast(new Term(20, new BigInteger("53")));
        p1.addTermLast(new Term(8, new BigInteger("6423")));
        p1.addTermLast(new Term(2, new BigInteger("35")));
        p1.addTermLast(new Term(1, new BigInteger("5")));

        p2.addTermLast(new Term(51, new BigInteger("3125")));
        p2.addTermLast(new Term(44, new BigInteger("4")));
        p2.addTermLast(new Term(39, new BigInteger("243")));
        p2.addTermLast(new Term(4, new BigInteger("235")));
        p2.addTermLast(new Term(2, new BigInteger("33")));
        p2.addTermLast(new Term(0, new BigInteger("2")));

        expected.addTermLast(new Term(95, new BigInteger("78125")));
        expected.addTermLast(new Term(88, new BigInteger("100")));
        expected.addTermLast(new Term(86, new BigInteger("668750")));
        expected.addTermLast(new Term(83, new BigInteger("6075")));
        expected.addTermLast(new Term(79, new BigInteger("856")));
        expected.addTermLast(new Term(74, new BigInteger("52002")));
        expected.addTermLast(new Term(71, new BigInteger("165625")));
        expected.addTermLast(new Term(64, new BigInteger("212")));
        expected.addTermLast(new Term(59, new BigInteger("20084754")));
        expected.addTermLast(new Term(53, new BigInteger("109375")));
        expected.addTermLast(new Term(52, new BigInteger("41317")));
        expected.addTermLast(new Term(48, new BigInteger("5875")));
        expected.addTermLast(new Term(47, new BigInteger("1560789")));
        expected.addTermLast(new Term(46, new BigInteger("965")));
        expected.addTermLast(new Term(45, new BigInteger("20")));
        expected.addTermLast(new Term(44, new BigInteger("50")));
        expected.addTermLast(new Term(41, new BigInteger("8505")));
        expected.addTermLast(new Term(40, new BigInteger("1215")));
        expected.addTermLast(new Term(39, new BigInteger("50290")));
        expected.addTermLast(new Term(37, new BigInteger("7062")));
        expected.addTermLast(new Term(35, new BigInteger("428")));
        expected.addTermLast(new Term(24, new BigInteger("12455")));
        expected.addTermLast(new Term(22, new BigInteger("1749")));
        expected.addTermLast(new Term(20, new BigInteger("106")));
        expected.addTermLast(new Term(12, new BigInteger("1509405")));
        expected.addTermLast(new Term(10, new BigInteger("211959")));
        expected.addTermLast(new Term(8, new BigInteger("12846")));
        expected.addTermLast(new Term(6, new BigInteger("8225")));
        expected.addTermLast(new Term(5, new BigInteger("1175")));
        expected.addTermLast(new Term(4, new BigInteger("1155")));
        expected.addTermLast(new Term(3, new BigInteger("165")));
        expected.addTermLast(new Term(2, new BigInteger("70")));
        expected.addTermLast(new Term(1, new BigInteger("10")));

        actual = Polynomial.multiply(p1, p2);

        assertAll(
                () -> assertEquals(33, expected.size()),
                () -> assertEquals(33, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying two polynomials with multiple terms each and completely different exponents")
    void multiTermDifferentExponents() {
        p1.addTermLast(new Term(142, new BigInteger("1")));
        p1.addTermLast(new Term(56, new BigInteger("4")));
        p1.addTermLast(new Term(43, new BigInteger("-1")));
        p1.addTermLast(new Term(25, new BigInteger("4")));
        p1.addTermLast(new Term(9, new BigInteger("1")));
        p1.addTermLast(new Term(1, new BigInteger("4")));

        p2.addTermLast(new Term(89, new BigInteger("3")));
        p2.addTermLast(new Term(86, new BigInteger("2")));
        p2.addTermLast(new Term(64, new BigInteger("3")));
        p2.addTermLast(new Term(34, new BigInteger("2")));
        p2.addTermLast(new Term(2, new BigInteger("3")));
        p2.addTermLast(new Term(0, new BigInteger("-2")));

        expected.addTermLast(new Term(231, new BigInteger("3")));
        expected.addTermLast(new Term(228, new BigInteger("2")));
        expected.addTermLast(new Term(206, new BigInteger("3")));
        expected.addTermLast(new Term(176, new BigInteger("2")));
        expected.addTermLast(new Term(145, new BigInteger("12")));
        expected.addTermLast(new Term(144, new BigInteger("3")));
        expected.addTermLast(new Term(142, new BigInteger("6")));
        expected.addTermLast(new Term(132, new BigInteger("-3")));
        expected.addTermLast(new Term(129, new BigInteger("-2")));
        expected.addTermLast(new Term(120, new BigInteger("12")));
        expected.addTermLast(new Term(114, new BigInteger("12")));
        expected.addTermLast(new Term(111, new BigInteger("8")));
        expected.addTermLast(new Term(107, new BigInteger("-3")));
        expected.addTermLast(new Term(98, new BigInteger("3")));
        expected.addTermLast(new Term(95, new BigInteger("2")));
        expected.addTermLast(new Term(90, new BigInteger("20")));
        expected.addTermLast(new Term(89, new BigInteger("12")));
        expected.addTermLast(new Term(87, new BigInteger("8")));
        expected.addTermLast(new Term(77, new BigInteger("-2")));
        expected.addTermLast(new Term(73, new BigInteger("3")));
        expected.addTermLast(new Term(65, new BigInteger("12")));
        expected.addTermLast(new Term(59, new BigInteger("8")));
        expected.addTermLast(new Term(58, new BigInteger("12")));
        expected.addTermLast(new Term(56, new BigInteger("-8")));
        expected.addTermLast(new Term(45, new BigInteger("-3")));
        expected.addTermLast(new Term(43, new BigInteger("4")));
        expected.addTermLast(new Term(35, new BigInteger("8")));
        expected.addTermLast(new Term(27, new BigInteger("12")));
        expected.addTermLast(new Term(25, new BigInteger("-8")));
        expected.addTermLast(new Term(11, new BigInteger("3")));
        expected.addTermLast(new Term(9, new BigInteger("-2")));
        expected.addTermLast(new Term(3, new BigInteger("12")));
        expected.addTermLast(new Term(1, new BigInteger("-8")));

        actual = Polynomial.multiply(p1, p2);

        assertAll(
                () -> assertEquals(33, expected.size()),
                () -> assertEquals(33, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying two polynomials where the first polynomial is zero")
    void firstPolyZero() {
        p2.addTermLast(new Term(2, new BigInteger("3")));
        p2.addTermLast(new Term(0, new BigInteger("2")));

        actual = Polynomial.multiply(p1, p2);

        assertAll(
                () -> assertEquals(0, expected.size()),
                () -> assertEquals(0, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying two polynomials where the second polynomial is zero")
    void secondPolyZero() {
        p1.addTermLast(new Term(2, new BigInteger("3")));
        p1.addTermLast(new Term(0, new BigInteger("2")));

        actual = Polynomial.multiply(p1, p2);

        assertAll(
                () -> assertEquals(0, expected.size()),
                () -> assertEquals(0, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying two polynomials where both polynomials are zero")
    void bothPolyZero() {
        actual = Polynomial.multiply(p1, p2);

        assertAll(
                () -> assertEquals(0, expected.size()),
                () -> assertEquals(0, actual.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("tests basic functioning of multiply()")
    void generalMultiply() {
        p1.addTerm(new Term(1, new BigInteger("1")));
        p1.addTerm(new Term(0, new BigInteger("1")));

        p2.addTerm(new Term(1, new BigInteger("1")));
        p2.addTerm(new Term(0, new BigInteger("-1")));

        expected.addTermLast(new Term(2, new BigInteger("1")));
        expected.addTermLast(new Term(0, new BigInteger("-1")));

        actual = Polynomial.multiply(p1, p2);

        assertAll(
                () -> assertEquals(2, p1.size()),
                () -> assertEquals(2, p2.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("multiplies a polynomial by an empty polynomial")
    void multiplyByEmpty1() {
        p1.addTerm(new Term(1, new BigInteger("1")));
        p1.addTerm(new Term(0, new BigInteger("1")));

        actual = Polynomial.multiply(p1, p2);

        assertAll(
                () -> assertEquals(2, p1.size()),
                () -> assertEquals(0, p2.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("multiplies an empty polynomial by a polynomial")
    void multiplyByEmpty2() {
        p2.addTerm(new Term(1, new BigInteger("1")));
        p2.addTerm(new Term(0, new BigInteger("1")));

        actual = Polynomial.multiply(p1, p2);

        assertAll(
                () -> assertEquals(0, p1.size()),
                () -> assertEquals(2, p2.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("multiplies three polynomials together, where some terms disappear")
    void multiplyThreePolynomials() {
        Polynomial p3 = new Polynomial();

        p1.addTerm(new Term(1, new BigInteger("1")));
        p1.addTerm(new Term(0, new BigInteger("1")));
        p2.addTerm(new Term(1, new BigInteger("1")));
        p2.addTerm(new Term(0, new BigInteger("-1")));
        p3.addTerm(new Term(2, new BigInteger("1")));
        p3.addTerm(new Term(0, new BigInteger("1")));

        expected.addTermLast(new Term(4, new BigInteger("1")));
        expected.addTermLast(new Term(0, new BigInteger("-1")));

        Polynomial pTemp = Polynomial.multiply(p1, p2);

        actual = Polynomial.multiply(pTemp, p3);

        assertAll(
                () -> assertEquals(2, p1.size()),
                () -> assertEquals(2, p2.size()),
                () -> assertEquals(2, p3.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("multiplies two polynomials with a single term")
    void multiplyTwoSingleTerms() {
        p1.addTerm(new Term(54, new BigInteger("13")));
        p2.addTerm(new Term(13, new BigInteger("54")));

        expected.addTermLast(new Term(67, new BigInteger("702")));

        actual = Polynomial.multiply(p1, p2);

        assertAll(
                () -> assertEquals(1, p1.size()),
                () -> assertEquals(1, p2.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("multiplies polynomials with terms that add up to equivalent values")
    void multiplyPolynomialsEquivalentValues() {
        p1.addTerm(new Term(50, new BigInteger("1")));
        p1.addTerm(new Term(30, new BigInteger("1")));

        p2.addTerm(new Term(3, new BigInteger("1")));
        p2.addTerm(new Term(2, new BigInteger("1")));

        expected.addTermLast(new Term(53, new BigInteger("1")));
        expected.addTermLast(new Term(52, new BigInteger("1")));
        expected.addTermLast(new Term(33, new BigInteger("1")));
        expected.addTermLast(new Term(32, new BigInteger("1")));

        actual = Polynomial.multiply(p1, p2);

        assertAll(
                () -> assertEquals(2, p1.size()),
                () -> assertEquals(2, p2.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }

    @Test
    @Tag("Megatester")
    @DisplayName("multiplies two empty polynomials")
    void multiplyTwoEmpty() {
        actual = Polynomial.multiply(p1, p2);

        assertAll(
                () -> assertEquals(0, p1.size()),
                () -> assertEquals(0, p2.size()),
                () -> assertTrue(actual.isDeepClone(expected))
        );
    }
}