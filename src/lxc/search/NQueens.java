package lxc.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N-queens problem
 * no recursion.
 * use iteration:backtracking.
 * @author luoxiongcai
 *
 */
public class NQueens {
	public int count;
	public List<List<Integer>> result;
	public void solve(int N){
		count = 0;
		result = new ArrayList<List<Integer>>();
		int[] rows = new int[N];
		Arrays.fill(rows, -1);
		int k = 0;
		while ( k >= 0){
			if (k == N){
				collect(rows);
				k--;
			}
			int col = (++rows[k]);
			while ( col < N && !isValid(rows,k,col)) col++;
			if (col == N){
				rows[k] = -1;       //reset the number.
				k--;
			} else {
				rows[k] = col;
				k++;
			}
		}
	}
	
	private boolean isValid(int[] rows, int row, int col){
		for (int i = 0; i < row; i++){
			if (rows[i] == col ||Math.abs(rows[i] - col) == Math.abs(i - row))
				return false;
		}
		return true;
	}
	
	private void collect(int[] rows){
		count++;
		List<Integer> re = new ArrayList<Integer>();
		for (int c : rows){
			re.add(c);
		}
		result.add(re);
	}
	public static void main(String[] args) {
		NQueens nq = new NQueens();
		nq.solve(8);
		int count = nq.count;
		System.out.println(count);
	}

}
