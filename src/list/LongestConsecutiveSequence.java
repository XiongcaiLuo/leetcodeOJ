package oj.list;

import java.util.HashMap;

public class LongestConsecutiveSequence {

	/**
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
	 * @param args
	 */
    public static int longestConsecutive(int[] num) {
    	if(num==null) return 0;
    	if(num.length<=1) return num.length;
        HashMap<Integer,Boolean> numMap=new HashMap<Integer, Boolean>();
        for(int i:num){
        	numMap.put(i, false);
        }
        int maxLen=0;
   
        for(int k:num){
        	if(numMap.get(k)) continue;
        	int len=1;
        	for(int j=k+1;numMap.containsKey(j);j++){
        		len++;
        		numMap.put(j, true);
        	}
        	for(int j=k-1;numMap.containsKey(j);j--){
        		len++;
        		numMap.put(j, true);
        	}
        	maxLen=Math.max(len, maxLen);
        }
   
    	return maxLen;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num={100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(num));
	}

}
