package list;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * @param args
 */
public class ClimbingStairs {

	public static int climbStairs(int n) {
		if ( n <= 1) return n;
		int first = 1, second = 1;  // do not use a int[n]; save storage.
		for (int i = 2; i < n; i++){
			int temp = second;
			second += first;
			first = temp;
		}
		return second;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(climbStairs(2));
	}

}
