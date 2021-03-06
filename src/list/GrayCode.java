package list;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0 01 - 1 11 - 3 10 - 2 Note: For a given n, a gray code sequence is not
 * uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the
 * above definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code
 * sequence. Sorry about that.
 * 
 * @param args
 */
public class GrayCode {
	/**
	 * 利用反射性质.递归可能栈空间溢出。
	 * @param n
	 * @return
	 */
	public static List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
		if ( n == 1){
			result.add(0);
			result.add(1);
			return result;
		}
		result = grayCode(n - 1);
		int size = result.size();
		for (int i = size - 1; i >= 0; i--)
			result.add((1 << (n - 1)) + result.get(i));
		return result;

	}
	/**
	 * 公式： g = n ^ (n/2);
	 * @param n
	 * @return
	 */
	public static List<Integer> grayCode2(int n){
		int max = 1 << n ;
		List<Integer> result = new ArrayList<Integer>(max);
		for (int i = 0; i < max; i++ )
			result.add( i ^ ( i >> 1));
		return result;
	}

	public static void main(String[] args) {

		System.out.println(grayCode(4));
		System.out.println(grayCode2(4));

	}

}
