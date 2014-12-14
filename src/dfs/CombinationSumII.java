package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CombinationSumII {

	/**
	 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
	 * @param args
	 */
	List<List<Integer>> results=new ArrayList<List<Integer>>();
	
	int[] sortCandi;
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates==null || candidates.length==0) return results;
        sortCandi=candidates;
        ArrayList<Integer> temp=new ArrayList<Integer>();
        int level=candidates.length-1;
        dfs(temp,level,target);
        results=new ArrayList<List<Integer>>(new HashSet<List<Integer>>(results));
        return results;
    }
	private void dfs(ArrayList<Integer> temp, int level, int target) {
		if( target==0){
			Collections.sort(temp);
			results.add(temp);
			return;
		} 
		if(level<0)	return;
		if(target<0) return;
		ArrayList<Integer> next=new ArrayList<Integer>(temp);
		next.add(sortCandi[level]);
		dfs(temp,level-1,target);
		dfs(next,level-1,target-sortCandi[level]);
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
