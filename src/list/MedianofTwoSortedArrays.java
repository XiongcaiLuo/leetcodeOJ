package list;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * @author luoxiongcai
 *
 */
public class MedianofTwoSortedArrays {
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int tlen = nums1.length + nums2.length;
        if (tlen % 2 == 1)
        	return findK(nums1, nums2, tlen / 2 + 1);
        else{
        	double v1 = findK(nums1,nums2,tlen / 2);
        	double v2 = findK(nums1, nums2, tlen/2 + 1);
        	return (v1 + v2)/2.0;
        } 
    }
    
    private double findK(int [] nums1, int [] nums2, int k){
    	return helper(nums1, 0, nums2, 0, k);
    }
    
    private double helper(int [] nums1, int b1,  int [] nums2, int b2, int k){
    	if (b1 == nums1.length) return nums2[b2+k-1];
    	if (b2 == nums2.length) return nums1[b1+k-1];
    	if (k == 1) return Math.min(nums1[b1], nums2[b2]); // here! be careful!
    	if (nums1.length - b1 > nums2.length - b2) return helper(nums2, b2, nums1,b1,k); // be careful about here;
    	int half1 = Math.min(k / 2, nums1.length - b1 );  // be careful about out of range;
    	int half2 = k - half1;
    	if (nums1[b1 + half1 - 1] == nums2[b2 + half2 - 1])
    		return nums1[b1 + half1 - 1];
    	else if (nums1[b1 + half1 - 1] < nums2[b2 + half2 - 1]){
    		return helper(nums1,b1 + half1,nums2,b2,k - half1);
    	} else return helper(nums1, b1, nums2, b2 + half2, k - half2);
    }
	public static void main(String[] args) {
		MedianofTwoSortedArrays mt = new MedianofTwoSortedArrays();
		int[] nums1 = {2,3,4};
		int[] nums2 = {1,6};
		double median = mt.findMedianSortedArrays(nums1, nums2);
		System.out.println(median);;
	}

}
