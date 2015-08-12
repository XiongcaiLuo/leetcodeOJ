package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * The algorithm is the same as Sum3.
 * @param args
 */
public class Sum3Closest {

	public static int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int len = num.length;
		int closeSum = num[0] + num[1] + num[len - 1];
		for (int i = 0; i < len - 2; i++) {
			int begin = i + 1;
			int end = len - 1;
			while (begin < end) {
				int sum = num[i] + num[begin] + num[end];
				if (sum == target) {
					return target;
				} else if (sum < target) {
					begin++;
					if (Math.abs(closeSum - target) > Math.abs(sum - target))
						closeSum = sum;
				} else {
					end--;
					if (Math.abs(closeSum - target) > Math.abs(sum - target))
						closeSum = sum;
				}
			}
		}
		return closeSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { -3, -2, -5, 3, -4 };
		System.out.println(threeSumClosest(num, -1));

	}

}
