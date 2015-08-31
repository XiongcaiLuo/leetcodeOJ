package string;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * @param args
 */
public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		if ("0".equals(num1) || "0".equals(num2)) return "0";
		int[] a1 = new int[(num1.length() - 1)/ 4 + 1];
		int[] a2 = new int[(num2.length() - 1)/ 4 + 1];
		seg(num1, a1);
		seg(num2, a2);
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < a1.length; i++){
			long carry = 0;
			for (int j = 0; j < a2.length; j++){
				long re = carry + a1[i] * a2[j] ;
				if (result.size() > i + j){
					re += result.get(i+j);
					result.set(i+j, (int)re);
				} else result.add((int) re);
				carry = re >> 32;
			}
		}
		String s = getString(result);
		return s;
	}
	
	private void seg(String num, int [] a){
		for (int i = num.length(),index = 0; i >0; i -= 4){
			a[index++] = Integer.valueOf(num.substring(Math.max(0, i - 4), i));
		}
	}
	
	private String getString(List<Integer> result) {
		int mask = 10000;
		String s = "";
		long sum = 0;
		for (int num : result){
			sum += num;
			s = String.format("%4s","" + sum % mask).replaceAll(" ", "0") + s;
			sum /= mask;
		}
		while (sum > 0){
			s = ("" + sum % mask) + s;
			sum /= mask;
		}
		int i = 0;
		while (s.charAt(i) == '0')  // remove leading 0;
			i++;
		return s.substring(i,s.length());
	}

	public static void main(String[] args) {
		MultiplyStrings ms = new MultiplyStrings();
		String num1 = "0";
		String num2 = "0";
		String re = ms.multiply(num1, num2);
		System.out.println(re);
	}

}
