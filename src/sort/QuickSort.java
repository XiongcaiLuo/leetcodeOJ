package sort;

import java.util.Stack;

public class QuickSort {
	/**
	 * recursion.
	 * @param nums
	 */
	public static void sort(int[] nums){
		if (nums == null || nums.length < 2) return;
		partition(nums, 0, nums.length - 1);
	}
	
	private static void partition(int[] nums, int begin, int end ){
		if (begin >= end) return;
		int i = begin - 1, j = end + 1, k = begin;
		int pivot = nums[begin];
		while ( k < j ){
			if (nums[k] > pivot)
				swap(nums, k , --j);
			else if (nums[k] < pivot)
				swap(nums, k++, ++i);
			else k++;
		}
		partition(nums, begin, i);
		partition(nums, j, end);
	}
	
	private static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	/**
	 * iteration.
	 * @param nums
	 */
	public static void sort_ite(int[] nums){
		if (nums == null || nums.length < 2) return;
		Stack<Integer> bounds = new Stack<Integer>();
		bounds.push(nums.length - 1);
		bounds.push(0);
		while ( !bounds.isEmpty()){
			int begin = bounds.pop();
			int end = bounds.pop();
			if (begin >= end) continue;
			int i = begin - 1, j = end + 1, k = begin;
			int pivot = nums[begin];
			while ( k < j ){
				if (nums[k] > pivot)
					swap(nums, k , --j);
				else if (nums[k] < pivot)
					swap(nums, k++, ++i);
				else k++;
			}
			bounds.push(i); bounds.push(begin);
			bounds.push(end); bounds.push(j);
		}
	}
	
	/**
	 * Original method.
	 * @param nums
	 */
	public static void sort_ori(int[] nums){
		if (nums == null || nums.length < 2) return;
		quickSort_ori(nums, 0 , nums.length - 1);
	}
	
	private static void quickSort_ori(int[] nums, int begin, int end){
		if (begin >= end) return;
		int k = partition_ori(nums, begin, end);
		quickSort_ori(nums, begin, k - 1);
		quickSort_ori(nums, k + 1, end);
	}
	
	private static int partition_ori(int [] nums, int begin, int end){
		int i = begin, j = end;
		int pivot = nums[begin];
		while (i <= j){
			while ( i <= j && nums[i] <= pivot) i++;
			if ( i > j ) break;
			while (i <= j && nums[j] > pivot) j--;
			if (j < i) break;
		}
		swap(nums, begin, j);
		return j;
	}
	
	public static void print(int[] nums){
		for (int i: nums){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] nums = {-1,-2,-3,-4};
		QuickSort.sort_ori(nums);
		print(nums);
		
	}

}
