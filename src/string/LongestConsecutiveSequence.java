package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence. For example, Given [100, 4, 200, 1, 3, 2], The
 * longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @param args
 */
public class LongestConsecutiveSequence {


    public static int longestConsecutive2(int[] nums) {
        if (nums.length < 2) return nums.length;
        Set<Integer> sets = new HashSet<Integer>();
        for (int n : nums)
        	sets.add(n);
        int max = 1;
        for (int i = 0; i < nums.length; i++){
        	if (sets.contains(nums[i])){
        		int len = 1;
        		for (int next = nums[i] + 1; sets.contains(next); next++){
        			len++;
        			sets.remove(next);
        		}
        		for (int pre = nums[i] - 1; sets.contains(pre); pre--){
        			len++;
        			sets.remove(pre);
        		}
        		max = Math.max(max, len);
        	}
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = { 100, 5,4, 200, 1, 3, 2 };
		System.out.println(longestConsecutive2(num));
	}

}
