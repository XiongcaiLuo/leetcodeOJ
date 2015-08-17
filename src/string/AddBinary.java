package string;

import java.math.BigInteger;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * @param args
 */
public class AddBinary {

	
	/**
	 * mock
	 * @param a
	 * @param b
	 * @return
	 */
	public static String addBinary(String a, String b) {
		if (a.length() > b.length())
			return addBinary(b,a);
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1;
		int carry = 0;
		while ( i >=0 || j >=0){
			int ai = i >=0 ? a.charAt(i) - '0' : 0;
			int bj = j >=0 ? b.charAt(j) - '0' : 0;
			int sum = ai + bj + carry;
			carry = sum / 2;
			sb.append(""+(sum%2));
			i--; j--;
		}
		if (carry == 1)
			sb.append(1);
		return sb.reverse().toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("1", "11"));
	}

}
