package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Ensure that numbers within the set are sorted in ascending order.
 * 
 * 
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * 
 * Output:
 * 
 * [[1,2,4]]
 * 
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * 
 * Output:
 * 
 * [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * @author luoxiongcai
 *
 */
public class CombinationSumIII {
	List<List<Integer>> result  = new ArrayList<List<Integer>>();
	int k,n;
	 public List<List<Integer>> combinationSum3(int k, int n) {
		 this.k = k;
		 this.n = n;
		 dfs(new ArrayList<Integer>(),0, 1);
		 return result;
	 }
	 private void dfs(ArrayList<Integer> already, int partSum, int start){
		 if (already.size() == k){
			 if (partSum == n){
				 result.add(new ArrayList<Integer>(already));
			 }
			 return;
		 } else if (partSum >= n || start > 9) return;
		 already.add(start);
		 dfs(already, partSum + start, start+1);
		 already.remove(already.size()-1);
		 dfs(already, partSum, start+1);
	 }
	public static void main(String[] args) {
		CombinationSumIII cs = new CombinationSumIII();
		List<List<Integer>> result = cs.combinationSum3(2, 6);
		System.out.println(result);
	}

}
