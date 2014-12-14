package enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	/**
	 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
	 * @param args
	 */

    public List<List<Integer>> subsetsWithDup(int[] S) {
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
    	int up=level;
    	
    	while(up<S.length && S[up]==S[level])
    		up++;
    	subsets(S,up,temp,result);
    	ArrayList<Integer> last=new ArrayList<Integer>(temp);
    	for(int i=level;i<up;i++){
    		ArrayList<Integer> cur=new ArrayList<>(last);
    		cur.add(S[level]);
    		subsets(S,up,cur,result);
    		last=cur;
    	}
    	

    }
    
	public static void main(String[] args) {

	}

}
