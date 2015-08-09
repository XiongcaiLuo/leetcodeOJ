package others;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 * @author luoxiongcai
 *
 */

public class FindMinimuminRotatedSortedArray {
	public int findMin(int[] num) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<num.length;i++)   
            min=Math.min(min,num[i]);
        return min;
	}
}
