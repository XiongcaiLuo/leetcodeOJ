package tails;
/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 * @author luoxiongcai
 *
 */

public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
    	int preMax=A[0],preMin=A[0];
    	int max=A[0];
    	for(int i=1;i<A.length;i++){
    		int tempMax=Math.max(Math.max(A[i], A[i]*preMax),A[i]*preMin);
    		preMin=Math.min(Math.min(A[i], A[i]*preMax),A[i]*preMin);
    		max=Math.max(max, tempMax);
    		preMax=tempMax;
    	}
    	return max;
    }
}
