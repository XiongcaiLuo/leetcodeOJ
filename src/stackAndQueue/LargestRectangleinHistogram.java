package stackAndQueue;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example, Given height = [2,1,5,6,2,3], return 10.
 * 
 * @param args
 */
public class LargestRectangleinHistogram {

	/** 
	 * use a stack. 
	 * @param height
	 * @return
	 */
    public int largestRectangleArea(int[] h) {
    	int max = 0;
    	int[] height = new int[h.length + 1];
    	for (int i = 0; i< h.length; i++)
    		height[i] = h[i];
    	Stack<Integer> index = new Stack<Integer>();
    	for (int i =0 ; i < height.length; ){
    		if (index.isEmpty() || height[i] >= height[index.peek()])
    			index.push(i++);
    		else {
    			int curIndex = index.pop();
    			max = Math.max(max, height[curIndex] * (index.isEmpty() ? i: (i - index.peek() - 1)));
    		}
    	}
    	return max;
    }
    /**
     * use dp and similar to LeftNearestSmaller.java.
     * some problem. not right.
     * @param h
     * @return
     */
    public int largestRectangleArea2(int[] h) {
    	int[] lefts = leftSmaller(h);
    	int max = 0;
    	for (int i = 0; i < h.length ; i++){
    		max = Math.max(max, (i - lefts[i]) * h[i]);
    	}
    	return max;
    }
    
	private int[] leftSmaller(int[] nums){
		int[] result = new int[nums.length];
		Stack<Integer> index = new Stack<Integer>();
		for (int i = 0; i < nums.length; i++){
			while (!index.isEmpty() && nums[index.peek()] >= nums[i])
				index.pop();
			if (!index.isEmpty())
				result[i] = index.peek();
			else result[i] = -1;
			index.push(i);
		}
		return result;
	}
	public static void main(String[] args) {
		LargestRectangleinHistogram lr = new LargestRectangleinHistogram();
		int[] h = {1,2,2};
		int max = lr.largestRectangleArea2(h);
		System.out.println(max);
	}

}
