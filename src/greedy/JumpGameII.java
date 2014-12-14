package greedy;

public class JumpGameII {

	/**
	 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
	 * @param args
	 */
    public int jump(int[] A) {
    	int step = 0; // 最小步数
    	int left = 0;
    	int right = 0; // [left, right] 是当前能覆盖的区间
    	if (A.length == 1) return 0;
    	while (left <= right) { // 尝试从每一层跳最远
    	++step;
    	 int old_right = right;
    	for (int i = left; i <= old_right; ++i) {
    	int new_right = i + A[i];
    	if (new_right >= A.length - 1) return step;
    	if (new_right > right) right = new_right;
    	}
    	left = old_right + 1;
    	}
    	return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
