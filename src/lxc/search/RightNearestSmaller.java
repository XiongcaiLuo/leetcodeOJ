package lxc.search;

import java.util.Stack;

/**
 * given a unsorted array A[], return an array B[];
 * B[i] is the index of the element, which is in right nearest of A[i] and bigger than A[i];
 * @author luoxiongcai
 *
 */
public class RightNearestSmaller {

	/**
	 * scan from right to left.
	 * use a ascending order stack for index.
	 * @param nums
	 * @return
	 */
	public int[] rightBigger(int[] nums){
		int[] result = new int[nums.length];
		Stack<Integer> index = new Stack<Integer>();
		for (int i = nums.length - 1; i >= 0; i--){
			while (!index.isEmpty() && nums[index.peek()] > nums[i])
				index.pop();
			if (!index.isEmpty())
				result[i] = index.peek();
			else result[i] = -1;
			index.push(i);
		}
		return result;
	}
	public static void main(String[] args) {
		RightNearestSmaller rn = new RightNearestSmaller();
		int[] nums = {2,1,5,6,2,3};
		int[] result = rn.rightBigger(nums);
		for (int r : result)
			System.out.print(" "+r);
	}

}
