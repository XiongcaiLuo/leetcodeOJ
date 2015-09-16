package lxc.search;

import java.util.Stack;

/**
 * similar as leftnearestbigger, but request for smaller.
 * @author luoxiongcai
 *
 */
public class LeftNearestSmaller {
	
	/**
	 * use a descending order stack.
	 * scan from left to right.
	 * @param nums
	 * @return
	 */
	public int[] leftSmaller(int[] nums){
		int[] result = new int[nums.length];
		Stack<Integer> index = new Stack<Integer>();
		for (int i = 0; i < nums.length; i++){
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
		LeftNearestSmaller rn = new LeftNearestSmaller();
		int[] nums = {2,1,5,6,2,3};
		int[] result = rn.leftSmaller(nums);
		for (int r : result)
			System.out.print(" "+r);
	}
}
