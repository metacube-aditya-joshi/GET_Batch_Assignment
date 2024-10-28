package abstractt.and.concrete;

final class Poly {
    final int[] polynomial;
    final int degree;

    /**
     * Constructs a polynomial from an array of coefficients.
     * 
     * @param coefficients an array of integers representing the coefficients of the
     *                     polynomial, where the index corresponds to the degree of
     *                     the term.
     * @throws Exception if the coefficients array is null or empty.
     */
    Poly(int[] coefficients) throws Exception {
	try {
	    if (coefficients == null || coefficients.length == 0) {
		throw new Exception("Input polynomial cannot be null or empty.");
	    }

	    this.degree = coefficients.length - 1;

	    this.polynomial = new int[degree + 1]; // Corrected

	    for (int i = 0; i <= degree; i++) {
		this.polynomial[i] = coefficients[i];
	    }
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}

    }

    /**
     * Evaluates the polynomial at a specific value (currently hardcoded to x = 1).
     * 
     * @throws Exception if any error or exception is hit.
     * @return the evaluated value of the polynomial as a float.
     */
    final float evalautePloy(float x) throws Exception {
	float eval = 0;
	try {
	    if (getDegree() == 0)
		return (float) this.polynomial[0];

	    for (int deg = 0; deg <= this.degree; deg++) {
		eval += this.polynomial[deg] * Math.pow(x, deg);
	    }

	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	return eval;
    }

    /**
     * Returns the degree of the polynomial.
     * 
     * @return the degree of the polynomial as an integer.
     */
    final int degreePoly() {
	return getDegree();
    }

    /**
     * Adds the current polynomial to another polynomial.
     * 
     * @param poly the polynomial to be added to the current polynomial.
     * @return a new Poly instance representing the sum of the two polynomials.
     * @throws Exception if the poly parameter is null or if the degrees of the two
     *                   polynomials are not the same.
     */
    final Poly addPoly(Poly poly) throws Exception {
	int[] resultCoefficients = null;
	try {
	    if (poly == null) {
		throw new Exception("The polynomial to add cannot be null.");
	    }

	    if (this.degree != poly.degree) {

		int maxDegree = Math.max(this.polynomial.length, getDegree());
		resultCoefficients = new int[maxDegree + 1];

		for (int index = 0; index < resultCoefficients.length; index++) {
		    if (index < this.polynomial.length && index < poly.polynomial.length)
			resultCoefficients[index] = this.polynomial[index] + poly.polynomial[index];
		}

	    } else {
		resultCoefficients = new int[this.polynomial.length];

		for (int index = 0; index <= this.degree; index++) {
		    resultCoefficients[index] = this.polynomial[index] + poly.polynomial[index];
		}
	    }

	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	return new Poly(resultCoefficients);
    }

    /**
     * Multiplies the current polynomial with another polynomial.
     * 
     * @param p the polynomial to be multiplied with the current polynomial.
     * @return a new Poly instance representing the product of the two polynomials.
     * @throws Exception if the polynomial p is null.
     */
    final Poly multiplyPoly(Poly p) throws Exception {
	int[] resultCoefficients;

	try {
	    if (p == null) {
		throw new Exception("The polynomial to multiply cannot be null.");
	    }

	    // The degree of the resulting polynomial is the sum of the degrees of the two
	    // polynomials
	    int resultDegree = this.degree + p.degree;
	    resultCoefficients = new int[resultDegree + 1]; // +1 for the constant term

	    // Multiply the polynomials
	    for (int i = 0; i <= this.degree; i++) {
		for (int j = 0; j <= p.degree; j++) {
		    resultCoefficients[i + j] += this.polynomial[i] * p.polynomial[j];
		}
	    }
	} catch (Exception e) {
	    // Handle exception if needed
	    throw new Exception(e.getMessage());
	}

	return new Poly(resultCoefficients);
    }

    /**
     * Returns the array of coefficients of the polynomial.
     * 
     * @return the polynomail
     */
    public int[] getPolynomail() {
	return polynomial;
    }

    /**
     * Returns the degree of the polynomial.
     * 
     * @return the degree
     */
    public int getDegree() {
	return degree;
    }

}
