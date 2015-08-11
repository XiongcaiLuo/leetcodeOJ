package search;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author luoxiongcai
 *
 */

public class FindMinimuminRotatedSortedArray {
	/**
	 * 利用二分搜索最小值，最大值，特定值，插入位置。 有重复，没重复。
	 * @param num
	 * @return
	 */
	public int findMin(int[] num) {
		int L = 0, R = num.length - 1;
		while (L < R && num[L] >= num[R]){
			int mid = (L + R) / 2;
			if (num[mid] > num[R])
				L = mid + 1;
			else R = mid;
		}
		return num[L];
	}
	
	
	public static void main(String [] args){
		FindMinimuminRotatedSortedArray fr = new FindMinimuminRotatedSortedArray();
		int[] num = {6,7,0,1,2,4,5};
		int min = fr.findMin(num);
		System.out.println(min);
	}
}
