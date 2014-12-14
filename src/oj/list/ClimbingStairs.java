package oj.list;

public class ClimbingStairs {

	/**
	 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	 * @param args
	 */
    public static int climbStairs(int n) {
        if(n<=1) return n;
        int nn=n+1;
        double s5=Math.sqrt(5);
        int result=(int) (1/s5 * (Math.pow((1+s5)/2, nn)-Math.pow((1-s5)/2, nn)));
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(climbStairs(2));
	}

}
