package list;

import java.util.HashMap;

public class TwoSum {

	/**
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
	 * @param args
	 */
    public int[] twoSum(int[] numbers, int target) {
    	HashMap<Integer,Integer> r=new HashMap<Integer,Integer>();
    	int[] result=new int[2];
    	int size=numbers.length;
    	for(int i=0;i<size;i++){
    		if (r.containsKey(target-numbers[i])){
    			result[0]=r.get(target-numbers[i]);
    			result[1]=i+1;
    			return result;
    		}
    		else r.put(numbers[i], i+1);
    	}
    	return result;
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
