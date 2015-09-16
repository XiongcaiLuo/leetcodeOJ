package others;

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] �� num[i+1], find a peak element and return
 * its index.
 * 
 * You may imagine that num[-1] = num[n] = -��.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 * 
 * click to show spoilers.
 * 
 * Note: Your solution should be in logarithmic complexity.
 * 
 * @author luoxiongcai
 *
 */
public class FindPeakElement {

	public int findPeakElement(int[] num) {
		return helper(num, 0, num.length - 1);
	}

	private int helper(int[] num, int low, int high) {
		if (low == high)
			return low;
		else {
			int mid1 = (low + high) / 2;
			int mid2 = mid1 + 1;
			if (num[mid1] > num[mid2])
				return helper(num, low, mid1);
			else
				return helper(num, mid2, high);
		}
	}

	public static void main(String[] args) {
		FindPeakElement t = new FindPeakElement();
		int[] num = { 1, 2 };
		int peek = t.findPeakElement(num);
		System.out.println(peek);
	}

}
