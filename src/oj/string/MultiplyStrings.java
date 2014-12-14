package oj.string;

import java.math.BigInteger;

public class MultiplyStrings {

	/**
	 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
	 * @param args
	 */
    public String multiply(String num1, String num2) {
        BigInteger n1=new BigInteger(num1);
        BigInteger n2=new BigInteger(num2);
        return n1.multiply(n2).toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
