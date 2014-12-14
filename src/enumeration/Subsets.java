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
	 * @param args
	 */
    public List<List<Integer>> subsets(int[] S) {
        ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();
        ArrayList<Integer> temp=new ArrayList<>();
        Arrays.sort(S);
        subsets(S,0,temp,result);
        return result;
    }
    private void subsets(int[] S, int level, ArrayList<Integer> temp, ArrayList<List<Integer>> result ){
    	if(level==S.length){
    		result.add(temp);
    		return;
    	}
    	ArrayList<Integer> another=new ArrayList<>(temp);
    	subsets(S,level+1,temp,result);
    	another.add(S[level]);
    	subsets(S,level+1,another,result);
    }
    
	public static void main(String[] args) {
		System.out.println(1<<3);
	}

}
