package others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {

	/**
	 * Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 * @param args
	 */
	List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] num) {
    	dfs(new HashSet<Integer>(),new ArrayList<Integer>(),num);
    	return result;
    }
    
    public void dfs(HashSet<Integer> set,List<Integer> used,int[] num){
    	if(used.size()==num.length){
    		result.add(used);
    		return ;
    	}
    	for(int i=0;i<num.length;i++){
    		if(!set.contains(num[i])){
    			ArrayList<Integer> new_used=new ArrayList<Integer>(used);
    			new_used.add(num[i]);
    			HashSet<Integer> new_set=new HashSet<Integer> (set);
    			new_set.add(num[i]);
    			dfs(new_set,new_used,num);
    		}
    	}
    }
	public static void main(String[] args) {
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		Permutations t=new Permutations();
		result = t.permute(new int[]{1});
		System.out.println("d");
	}

}
