package list;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2 3,2,1 →
 * 1,2,3 1,1,5 → 1,5,1
 * 
 * @param args
 */
public class NextPermutation {

	public void reverse(int[] nums, int begin, int end) {
		for (int i = begin, j = end; i < j; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}

	public void nextPermutation(int[] nums) {
		int len = nums.length;
		int index = len - 1;
		for (; index >= 1; index--) {
			if (nums[index - 1] < nums[index])
				break;
		}
		if (index == 0) {
			reverse(nums, 0, len - 1);
		} else {
			reverse(nums, index, len - 1);
			for (int i = index; i < nums.length; i++){
				if (nums[i] > nums[index - 1]){
					int temp = nums[index - 1];
					nums[index - 1] = nums[i];
					nums[i] = temp;
					break;
				}
			}
		}
	}

	public static void main(String[] args) {

	}

}
