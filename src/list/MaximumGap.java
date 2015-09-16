package list;

/**
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in
 * the 32-bit signed integer range.
 * 
 * @author luoxiongcai
 *
 */
public class MaximumGap {

	public int maximumGap(int[] num) {
		if (num == null || num.length < 2)
			return 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			max = Math.max(max, num[i]);
			min = Math.min(min, num[i]);
		}
		int len = (max - min) / (num.length - 1);
		if (len == 0)
			len = 1;
		int buckCount = (max - min) / len + 1;
		int[][] minMax = new int[2][buckCount];
		for (int i = 0; i < buckCount; i++) {
			minMax[0][i] = Integer.MAX_VALUE;
			minMax[1][i] = Integer.MIN_VALUE;
		}

		for (int i = 0; i < num.length; i++) {
			int buckId = (num[i] - min) / len;
			minMax[0][buckId] = Math.min(minMax[0][buckId], num[i]);
			minMax[1][buckId] = Math.max(minMax[1][buckId], num[i]);

		}
		int maxGap = 0;
		int pre = min;
		for (int i = 0; i < buckCount; i++) {
			//empty bucket.
			if (minMax[0][i] == Integer.MAX_VALUE
					|| minMax[1][i] == Integer.MIN_VALUE) {
				continue;
			}
			int gap = minMax[0][i] - pre;
			maxGap = Math.max(maxGap, gap);
			pre = minMax[1][i];

		}
		return maxGap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
