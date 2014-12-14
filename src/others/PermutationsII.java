package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class PermutationsII {

	/**
	 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
	 * @param args
	 */
	List<List<Integer>> result=new ArrayList<List<Integer>>();
	int len;
    public List<List<Integer>> permuteUnique(int[] num) {
        len=num.length;
        HashMap<Integer,Integer> map=genMap(num);
        List<Integer> used=new ArrayList<Integer>();
        dfs(map,used);
        return result;
    }
    
    public HashMap<Integer,Integer> genMap(int[] num){
    	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    	for(int i=0;i<num.length;i++){
    		Integer fre=map.get(num[i]);
    		if(fre==null){
    			map.put(num[i], 1);
    		}else {
    			fre++;
    			map.put(num[i], fre);
    		}
    	}
    	return map;
    }
    
    public void dfs(HashMap<Integer,Integer> leftNum,List<Integer> used){
    	if(used.size()==len){
    		result.add(used);
    		return;
    	}
    	Iterator<Entry<Integer,Integer>> ite=leftNum.entrySet().iterator();
    	while(ite.hasNext()){
    		Entry<Integer,Integer> en = ite.next();
    		int key=en.getKey();
    		int val=en.getValue();
    		HashMap<Integer,Integer> new_leftNum=new HashMap<Integer, Integer>(leftNum);
    		List<Integer> new_used=new ArrayList<Integer>(used);
    		new_used.add(key);
    		if(val==1)
    			new_leftNum.remove(key);
    		else new_leftNum.put(key, val-1);
    		dfs(new_leftNum,new_used);
    	}
    }
	public static void main(String[] args) {
		PermutationsII t=new PermutationsII();
		int[]num={-1,-1,3,-1};
		List<List<Integer>> result=t.permuteUnique(num);
		System.out.println();
	}

}
