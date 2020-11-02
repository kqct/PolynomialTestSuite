package assignment2;

import java.math.BigInteger;
import java.util.Iterator;

public class Polynomial implements DeepClone<Polynomial> {
    private final SLinkedList<Term> polynomial;

    private Polynomial(SLinkedList<Term> p) {
        polynomial = p;
    }

    public Polynomial() {
        polynomial = new SLinkedList<Term>();
    }

    //TODO: Add two polynomial without modifying either
    public static Polynomial add(Polynomial p1, Polynomial p2) {
        /**** ADD CODE HERE ****/
        return null;
    }

    //TODO: multiply two polynomials
    public static Polynomial multiply(Polynomial p1, Polynomial p2) {
        /**** ADD CODE HERE ****/

        return null;
    }

    public int size() {
        return polynomial.size();
    }

    // Returns a deep copy of the object.
    public Polynomial deepClone() {
        return new Polynomial(polynomial.deepClone());
    }

    /*
     * TODO: Add new term to the polynomial. Also ensure the polynomial is
     * in decreasing order of exponent.
     */
    public void addTerm(Term t) {
        /**** ADD CODE HERE ****/

        // Hint: Notice that the function SLinkedList.get(index) method is O(n),
        // so if this method were to call the get(index)
        // method n times then the method would be O(n^2).
        // Instead, use a Java enhanced for loop to iterate through
        // the terms of an SLinkedList.
  /*
  for (Term currentTerm: polynomial)
  {
   // The for loop iterates over each term in the polynomial!!
   // Example: System.out.println(currentTerm.getExponent()) should print the exponents of each term in the polynomial when it is not empty.
  }
  */
    }

    public Term getTerm(int index) {
        return polynomial.get(index);
    }

    //TODO: multiply this polynomial by a given term.
    public void multiplyTerm(Term t) {
        /**** ADD CODE HERE ****/
    }

    // TODO: evaluate this polynomial.
    // Hint:  The time complexity of eval() must be order O(m),
    // where m is the largest degree of the polynomial. Notice
    // that the function SLinkedList.get(index) method is O(m),
    // so if your eval() method were to call the get(index)
    // method m times then your eval method would be O(m^2).
    // Instead, use a Java enhanced for loop to iterate through
    // the terms of an SLinkedList.

    public BigInteger eval(BigInteger x) {
        /**** ADD CODE HERE ****/
        return new BigInteger("0");
    }

    // Checks if this polynomial is a clone of the input polynomial
    public boolean isDeepClone(Polynomial p) {
        if (p == null || polynomial == null || p.polynomial == null || this.size() != p.size())
            return false;

        int index = 0;
        for (Term term0 : polynomial) {
            Term term1 = p.getTerm(index);

            // making sure that p is a deep clone of this
            if (term0.getExponent() != term1.getExponent() ||
                    term0.getCoefficient().compareTo(term1.getCoefficient()) != 0 || term1 == term0)
                return false;

            index++;
        }
        return true;
    }

    // This method blindly adds a term to the end of LinkedList polynomial.
    // Avoid using this method in your implementation as it is only used for testing.
    public void addTermLast(Term t) {
        polynomial.addLast(t);
    }


    @Override
    public String toString() {
        if (polynomial.size() == 0) return "0";
        return polynomial.toString();
    }
}
