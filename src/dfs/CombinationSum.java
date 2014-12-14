package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

	/**
	 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
	 * @param args
	 */
	List<List<Integer>> results=new ArrayList<List<Integer>>();
	int[] sortCandi;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length==0) return results;
        Arrays.sort(candidates);
        sortCandi=candidates;
        ArrayList<Integer> temp=new ArrayList<Integer>();
        int level=candidates.length-1;
        dfs(temp,level,target);
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
		int times=(int) Math.floor(target*1.0/sortCandi[level]);
		for(int i=0;i<=times;i++){
			ArrayList<Integer> next=new ArrayList<Integer>(temp);
			int sum=0;
			for(int k=0;k<i;k++){
				next.add(sortCandi[level]);
				sum+=sortCandi[level];
			}
				
			dfs(next,level-1,target-sum);
		}
	}
	public static void main(String[] args) {
		System.out.println(Math.ceil(2.4));
	}

}
