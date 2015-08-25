package enumeration;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	/**
	 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
	 * @param args
	 */
    public List<List<Integer>> combine(int n, int k) {
    	ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();
        if(n<1||k>n)  return result;
        ArrayList<Integer> temp=new ArrayList<Integer>();
        dfs(result,temp,0,n,k);
        return result;
    }
    
    private void dfs(ArrayList<List<Integer>> result,ArrayList<Integer> temp,int level,int n,int k){
    	if(level == n){
    		if(temp.size()==k){
    			result.add(temp);
    			return;
    		}
    		else return;
    	}
    	if(temp.size()==k){
    		result.add(temp);
    		return;
    	}else{
    		ArrayList<Integer> other=new ArrayList<Integer>(temp);
    		other.add(level);
    		dfs(result,temp,level+1,n,k);
    		dfs(result,other,level+1,n,k);
    	}
    		
    }
    
	public static void main(String[] args) {
		ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();

	}

}
