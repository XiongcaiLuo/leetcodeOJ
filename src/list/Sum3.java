package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤
 * b ≤ c) The solution set must not contain duplicate triplets. For example,
 * given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * @param args
 */


public class Sum3 {

	/**
	 * 会超时。可以尝试下面利用Map做缓存。这里应该利用set,因为可能存在重复的。比如[0,0,0,0,0].
	 * @param nums
	 * @return
	 */
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        if ( nums.length < 3) return result;
        Arrays.sort(nums);
        Set<List<Integer>> unique = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length -2; i++){
        	int j = i + 1, k = nums.length - 1;
        	while ( j < k){
        		if (nums[j] + nums [k] + nums[i] == 0){
        			List<Integer> re = new ArrayList<Integer>();
        			re.add(nums[i]); re.add(nums[j]); re.add(nums[k]);
        			unique.add(re);
        			j++;
        			k--;
        		} else if (nums[j] + nums [k] + nums[i] < 0)
        			j++;
        		else k--;
        	}
        }
        result.addAll(unique);
        return result;
    }


	public static void main(String[] args) {
		Sum3 s3 = new Sum3();
		int[] nums = {0,0,0,0,0,0};
		List<List<Integer>> result = s3.threeSum(nums);
		System.out.println(result);
	}

}
