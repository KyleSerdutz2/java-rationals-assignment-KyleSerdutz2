package com.cooksys.ftd.assignments.objects;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SimplifiedRational implements IRational {
	private int numerator;
	private int denominator;
	
	static int[] primeNumbers = new int[] { //Goes up to 101...
	2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
	};
    /**
     * Determines the greatest common denominator for the given values
     *
     * @param a the first value to consider
     * @param b the second value to consider
     * @return the greatest common denominator, or shared factor, of `a` and `b`
     * @throws IllegalArgumentException if a <= 0 or b < 0
     */
    public static int gcd(int a, int b) throws IllegalArgumentException {
        //Options for solving:
    	//A study up on the Euclidean algorithm
    	//B some stupid method you made up
    	
    	//throw new NotImplementedException();
    }

    /**
     * Simplifies the numerator and denominator of a rational value.
     * <p>
     * For example:
     * `simplify(10, 100) = [1, 10]`
     * or:
     * `simplify(0, 10) = [0, 1]`
     *
     * @param numerator   the numerator of the rational value to simplify
     * @param denominator the denominator of the rational value to simplify
     * @return a two element array representation of the simplified numerator and denominator
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public static int[] simplify(int numerator, int denominator) throws IllegalArgumentException {
        if(denominator == 0)
        	throw new IllegalArgumentException();
    	
    	int[] returnRation = new int[2];
        returnRation[0] = numerator;
        returnRation[0] = denominator;
        
        for(int i = 0; i < primeNumbers.length; i++) {
        	if(returnRation[0]%primeNumbers[i] == 0 && returnRation[1]%primeNumbers[i] == 0) {
        		returnRation[0]/=primeNumbers[i];
        		returnRation[1]/=primeNumbers[i];
        		//better restart to check we didn't miss anything
        		i = 0;
        	}
        }
        
        return returnRation;
    	//throw new NotImplementedException();
    }

    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * Simplification of numerator/denominator pair should occur in this method.
     * If the numerator is zero, no further simplification can be performed
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public SimplifiedRational(int numerator, int denominator) throws IllegalArgumentException {
        if(denominator == 0)
        	throw new IllegalArgumentException();
        
        this.numerator = numerator;
        this.denominator = denominator;
    	//throw new NotImplementedException();
    }

    /**
     * @return the numerator of this rational number
     */
    @Override
    public int getNumerator() {
        throw new NotImplementedException();
    }

    /**
     * @return the denominator of this rational number
     */
    @Override
    public int getDenominator() {
        throw new NotImplementedException();
    }

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator   the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value (specifically, a SimplifiedRational value)
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public SimplifiedRational construct(int numerator, int denominator) throws IllegalArgumentException {
        this.numerator = numerator;
    	this.denominator = denominator;
        
    	int[] returnRation = simplify(this.numerator, this.denominator);
    	
        return new SimplifiedRational(returnRation[0], returnRation[1]);
    	//throw new NotImplementedException();
    }

    /**
     * @param obj the object to check this against for equality
     * @return true if the given obj is a rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
    	if (obj instanceof SimplifiedRational) {
    		SimplifiedRational objConvert = (SimplifiedRational)obj;
    		if(this.numerator == objConvert.getNumerator() && this.denominator == objConvert.getDenominator())
        	return true;
    	}
    	return false;
    }

    /**
     * If this is positive, the string should be of the form `numerator/denominator`
     * <p>
     * If this is negative, the string should be of the form `-numerator/denominator`
     *
     * @return a string representation of this rational value
     */
    @Override
    public String toString() {
        throw new NotImplementedException();
    }
    
    /*Personally added methods*/
    /*
    SimplifiedRational add(IRational that) throws IllegalArgumentException {
		if(that == null)
			throw new IllegalArgumentException();
		
		if(that instanceof Rational) {
			int commonDenominator = this.getNumerator()*that.getDenominator();
			
			int alteredThisNumerator = this.getNumerator()*that.getDenominator();
			int alteredThatNumerator = that.getNumerator()*this.getDenominator();
			
			SimplifiedRational returnRational = new SimplifiedRational(alteredThisNumerator+alteredThatNumerator, commonDenominator);
			int[] returnRation = simplify(returnRational.numerator, returnRational.denominator);
	    	
	        return new SimplifiedRational(returnRation[0], returnRation[1]);
			//throw new NotImplementedException();
	}
	*/
}
