package enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;



public class Permutations {

	/**
	 * Given a collection of numbers, return all possible permutations.
	 * 
	 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
	 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 * 
	 * @param args
	 */
	public int len;
	public HashSet<Integer> numSet;
	public List<List<Integer>> permute(int[] num) {
        ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();
        if(num==null||num.length==0) return result;
        len=num.length;
        numSet=new HashSet<Integer>(new ArrayList(Arrays.asList(num)));
        ArrayList<Integer> temp=new ArrayList<Integer>();
        dfs(0,temp,result);
        return result;
	}

	private void dfs( int level,ArrayList<Integer> temp,ArrayList<List<Integer>> result){
		if(level==len){
			result.add(temp);
			return ;
		}
		HashSet<Integer> tempSet=new HashSet<Integer>(numSet);
		tempSet.removeAll(temp);
		Iterator<Integer> ite=tempSet.iterator();
		while(ite.hasNext()){
			ArrayList<Integer> curTemp=new ArrayList<Integer>(temp);
			 Integer tt=ite.next();
			curTemp.add(1);
			dfs(level+1,curTemp,result);
		}
		
		
	}
	
	public static void main(String[] args) {
		Permutations t=new Permutations();
		int[] num=new int[]{2};
		t.permute(num);
	}

}
