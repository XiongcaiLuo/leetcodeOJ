package greedy;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * @param args
 */
public class JumpGameII {

	public int jump(int[] A) {
		if (A.length == 1) return 0;
		int step = 0; 
		int left = 0;
		int right = 0;
		while ( left <= right && right <A.length - 1 ){
			step++;
			int old_right = right;
			for (int i = left; i <= old_right; i++){
				right = Math.max(right, A[i] + i);
				if (right >= A.length - 1) 
					return step;
			}
			left = old_right + 1;
			
		}
		return step;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
