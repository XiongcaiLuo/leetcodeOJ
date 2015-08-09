package string;

import java.math.BigInteger;

public class AddBinary {

	/**
	 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
	 * @param args
	 */
    public static String addBinary(String a, String b) {
        BigInteger na=new BigInteger(a, 2);
        BigInteger nb=new BigInteger(b, 2);
        BigInteger nc=na.add(nb);
        return nc.toString(2);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("1","11"));
	}

}
