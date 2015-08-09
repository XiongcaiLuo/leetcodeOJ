import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

import tree.ListNode;

import java.util.ArrayList;
import java.util.Map.Entry;
public class Solution  {
	
	public Solution(){
		init();
	}
	
	public void init(){
		System.out.println("solution parent!");
	}
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length ==0) return 0;
		int curmax = nums[0], curmin = nums[0], max = nums[0];
		for(int i=1;i<nums.length;i++){ 
			int cmax = curmax, cmin = curmin;
			curmax = Math.max(Math.max(nums[i] * cmax, nums[i] * cmin),nums[i]);
			curmin = Math.min(Math.min(nums[i] * cmax, nums[i] * cmin),nums[i]);
			max = Math.max(max, curmax);
		}
		return max;
	}
	public static void main(String[] args) {
		Solution  sl = new Solution();
//		int[] vals = {-4,-3,-2};
//		int x = 3443;
//		int t = sl.maxProduct(vals);
//		System.out.println(t);
		

	}

}
