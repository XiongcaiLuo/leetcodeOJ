package list;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author luoxiongcai
 *
 */
public class TrappingRainWater {
	public static int trap(int[] height) {
 		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];
		for (int i = 1; i < height.length; i++){
			leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
			rightMax[height.length-1-i] = Math.max(rightMax[height.length-i], height[height.length  - i]);
		}
		int sum = 0;
		for (int i = 0; i < height.length; i++) {
		    int min = Math.min(leftMax[i], rightMax[i]);
		    if (height[i] < min)
		    	sum += min - height[i];
		}
		return sum; 
	}
	
	/**
	 * the max height is always in use. so, save the storage;
	 * @param height
	 * @return
	 */
	public static int trap2(int[] height) {
		if (height.length <3) return 0;
		int mindex = 0,max = height[0];
		for (int i = 1; i < height.length; i++){
			if (height[i] > max){
				max = height[i];
				mindex = i;
			}
		}
		int sum = 0;
		for (int i=0, peek = 0; i < mindex; i++){
			if (height[i] > peek) peek = height[i];
			else sum += height[i] - peek;
		}
		for (int i = height.length-1, top = 0; i > mindex; i--){
			if (height[i] > top) top = height[i];
			else sum += height[i] - top;
		}
		return sum;
	}
	
}