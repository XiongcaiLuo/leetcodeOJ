package dp;

import java.util.Arrays;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @author luoxiongcai
 *
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m <=0 || n <= 0) return 0;
        int [] step = new int[n];               // always be careful to save storage;
        Arrays.fill(step, 1);
        for (int i = 1; i < m; i++){
        	for (int j = 1; j < n; j++)
        		step[j] += step[j - 1];
        }
        return step[n-1];
    }
	public static void main(String[] args) {

	}

}
