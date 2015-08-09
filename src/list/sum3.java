package oj.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
class MyMap<K,V> extends HashMap<K,V>{

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		if(!this.containsKey(key))
			return super.put(key, value);
		else {
			Integer val=(Integer) this.get(key);
			val+=(Integer)value;          // newValue+oldValue;
			return super.put(key, (V)val);
		}
	}
	
}
public class sum3 {

	/**
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
	 * @param args
	 */
/**
 * time limited
 */
    public static List<List<Integer>> threeSum(int[] num) {
    	if(num==null ||num.length<3) return null;
    	List<List<Integer>> results=new ArrayList<List<Integer>>() ;
    	MyMap<Integer,Integer>numMap=new MyMap<Integer, Integer>();
    	for(int i:num) numMap.put(i,1);

    	for(int i=0;i<num.length;i++){

    		for(int j=i+1;j<num.length;j++){

    			int remain=-(num[i]+num[j]);
    			if(numMap.containsKey(remain)){
    				boolean flag=false;
    				if(remain!=num[i]&& remain!=num[j]) flag=true;
    				else if(remain==0&& num[i]==0 &&num[j]==0) flag=true;
    				else if((remain == num[i]|| remain==num[j])&& numMap.get(remain)>2) flag =true;
    				
    				if(flag){
      	   				List<Integer> triple=new ArrayList<Integer>();
        				triple.add(num[i]);
        				triple.add(num[j]);
        				triple.add(remain);
        				Collections.sort(triple);
        				if(!results.contains(triple))
        					results.add(triple);
        				}
    			}
    
    		}


    	}
		return results;
        
    }
    
    public static List<List<Integer>> threeSum2(int[] num) {
    	if(num==null ) return null;
    	if(num.length<3) return new ArrayList<List<Integer>>();
    	List<List<Integer>> results=new ArrayList<List<Integer>>() ;
    	Arrays.sort(num);
    	int len=num.length;
    	for(int i=0;i<len-2;i++){
    		int begin=i+1;
    		int end=len-1;
    		for(;begin<end;){
	    		int sum=num[i]+num[begin]+num[end];
	    		if(sum==0){
	    			List<Integer> triple=new ArrayList<Integer>();
					triple.add(num[i]);
					triple.add(num[begin]);
					triple.add(num[end]);
					if(!results.contains(triple))
						results.add(triple);

					begin++;
					end--;
				}
	    		else if(sum<0) begin++;
	    		else end--;
    		}
    	}

    	return results;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num={};

		System.out.println(threeSum2(num));


			
	}

}
