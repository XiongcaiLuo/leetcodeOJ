package sort;

import java.util.Arrays;

public class MergeSort {
	/**
	 * recursion.
	 * @param nums
	 */
	public static void sort(int[] nums){
		if ( nums == null || nums.length < 2) return;
		mergeSort(nums, 0, nums.length - 1);
	}
	
	private static void mergeSort(int[] nums, int begin, int end){
		if (begin >= end) return;
		int mid = (begin + end) / 2;
		mergeSort(nums, begin, mid);
		mergeSort(nums, mid + 1, end);
		merge( nums, begin, mid, end);
	}
	
	private static void merge(int[] nums, int begin, int mid, int end){
		int[] copy = Arrays.copyOf(nums, nums.length);
		for (int i = begin, j = mid + 1, c = begin; i <= mid || j <= end;){
			if (i > mid) break;
			if ( j > end)
				copy[c++] = nums[i++];
			else{
				if (nums[i] > nums[j])
					copy[c++] = nums[j++];
				else copy[c++] = nums[i++];
			}
		}
		System.arraycopy(copy, begin, nums,begin , end - begin + 1);
	}
	
	/**
	 * iteration. bottom up.
	 * @param nums
	 */
	public static void sort_ite(int[] nums){
		if ( nums == null || nums.length < 2) return;
		for (int step = 1; step < nums.length ; step *= 2){
			for (int begin = 0; begin < nums.length - step; begin += step*2)
				merge(nums,begin, begin+step-1, Math.min(begin + step*2 - 1,nums.length - 1));
		}
	}
	
	public static void print(int[] nums){
		for (int i: nums){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] nums = {2,4,1,-6};
		MergeSort.sort_ite(nums);
		print(nums);
	}

}
