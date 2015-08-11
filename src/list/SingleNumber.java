package list;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory? Let us change the question a little:
 * “If every element appears even number of times except for one element that
 * appears odd number of times, find that one element”, would the XOR approach
 * work? Why?
 * 
 * @author luoxiongcai
 *
 */
public class SingleNumber {
	public int singleNumber(int[] A) {
		int x = 0;
		for (int i = 0; i < A.length; i++)
			x ^= A[i];
		return x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
