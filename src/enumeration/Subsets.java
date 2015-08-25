package enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	/**
	 * Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
	 * @param args:dfs
	 */
    public List<List<Integer>> subsets(int[] S) {
        ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();
        ArrayList<Integer> temp=new ArrayList<Integer>();
        Arrays.sort(S);
        subsets(S,0,temp,result);
        return result;
    }
    private void subsets(int[] S, int level, ArrayList<Integer> temp, ArrayList<List<Integer>> result ){
    	if(level==S.length){
    		result.add(temp);
    		return;
    	}
    	ArrayList<Integer> another=new ArrayList<Integer>(temp);
    	subsets(S,level+1,temp,result);
    	another.add(S[level]);
    	subsets(S,level+1,another,result);
    }
    
    /**
     * recursion.
     * @param args
     */
    public List<List<Integer>> subsets2(int[] S) {
    	Arrays.sort(S);
    	return subsets(S, S.length - 1);
    }
    private List<List<Integer>> subsets(int[]S, int index){
    	List<List<Integer>> result=new ArrayList<List<Integer>>();
    	if (index == -1 ){
    		List<Integer> zero = new ArrayList<Integer>();
    		result.add(zero);
    		return result;
    	}
    	result = subsets(S,index - 1);
    	int size = result.size();
    	for (int i = 0; i< size; i++){
    		List<Integer> plus = new ArrayList<Integer>(result.get(i));
    		plus.add(S[index]);
    		result.add(plus);
    	}
    	return result;
    }
    
    
	public static void main(String[] args) {
		System.out.println(1<<3);
	}

}
