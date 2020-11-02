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
    @DisplayName("multiplying two polynomials with one term each and same exponents")
    void singleTermSameExponent() {
        term1.addTermLast(new Term(1, new BigInteger("1")));
        term2.addTermLast(new Term(1, new BigInteger("3")));

        expected.addTermLast(new Term(2, new BigInteger("3")));
        actual = Polynomial.multiply(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying two polynomials with one term each and different exponents")
    void singleTermDifferentExponent() {
        term1.addTermLast(new Term(2, new BigInteger("1")));
        term2.addTermLast(new Term(1, new BigInteger("3")));

        expected.addTermLast(new Term(3, new BigInteger("3")));

        actual = Polynomial.multiply(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying two polynomials with multiple terms each and same exponents")
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

        actual = Polynomial.multiply(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying two polynomials with multiple terms each and overlapping exponents")
    void multiTermOverlappingExponents() {
        term1.addTermLast(new Term(44, new BigInteger("25")));
        term1.addTermLast(new Term(35, new BigInteger("214")));
        term1.addTermLast(new Term(20, new BigInteger("53")));
        term1.addTermLast(new Term(8, new BigInteger("6423")));
        term1.addTermLast(new Term(2, new BigInteger("35")));
        term1.addTermLast(new Term(1, new BigInteger("5")));

        term2.addTermLast(new Term(51, new BigInteger("3125")));
        term2.addTermLast(new Term(44, new BigInteger("4")));
        term2.addTermLast(new Term(39, new BigInteger("243")));
        term2.addTermLast(new Term(4, new BigInteger("235")));
        term2.addTermLast(new Term(2, new BigInteger("33")));
        term2.addTermLast(new Term(0, new BigInteger("2")));

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

        actual = Polynomial.multiply(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying two polynomials with multiple terms each and completely different exponents")
    void multiTermDifferentExponents() {
        term1.addTermLast(new Term(142, new BigInteger("1")));
        term1.addTermLast(new Term(56, new BigInteger("4")));
        term1.addTermLast(new Term(43, new BigInteger("-1")));
        term1.addTermLast(new Term(25, new BigInteger("4")));
        term1.addTermLast(new Term(9, new BigInteger("1")));
        term1.addTermLast(new Term(1, new BigInteger("4")));

        term2.addTermLast(new Term(89, new BigInteger("3")));
        term2.addTermLast(new Term(86, new BigInteger("2")));
        term2.addTermLast(new Term(64, new BigInteger("3")));
        term2.addTermLast(new Term(34, new BigInteger("2")));
        term2.addTermLast(new Term(2, new BigInteger("3")));
        term2.addTermLast(new Term(0, new BigInteger("-2")));

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

        actual = Polynomial.multiply(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying two polynomials where the first polynomial is zero")
    void firstPolyZero() {
        term2.addTermLast(new Term(2, new BigInteger("3")));
        term2.addTermLast(new Term(0, new BigInteger("2")));

        actual = Polynomial.multiply(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying two polynomials where the second polynomial is zero")
    void secondPolyZero() {
        term1.addTermLast(new Term(2, new BigInteger("3")));
        term1.addTermLast(new Term(0, new BigInteger("2")));

        actual = Polynomial.multiply(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }

    @Test
    @Tag("Original")
    @DisplayName("multiplying two polynomials where both polynomials are zero")
    void bothPolyZero() {
        actual = Polynomial.multiply(term1, term2);

        assertTrue(actual.isDeepClone(expected));
    }
}