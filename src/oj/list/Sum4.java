package oj.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class IntPair{
	public int fIndex;
	public int sIndex;
	public IntPair(int fIndex,int sIndex){
		this.fIndex=fIndex;
		this.sIndex=sIndex;
	}
}
public class Sum4 {

	/**
	 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
	 * @param args
	 */
	/**
	 * o(n^3)
	 */
    public static List<List<Integer>> fourSum(int[] num, int target) {
    	if(num==null ) return null;
    	if(num.length<4) return new ArrayList<List<Integer>>();
    	List<List<Integer>> results=new ArrayList<List<Integer>>() ;
    	Arrays.sort(num);
    	int len=num.length;
    	for(int i=0;i<len-3;i++){
    		for(int j=i+1;j<len-2;j++){
	    		int begin=j+1;
	    		int end=len-1;
	    		for(;begin<end;){
		    		int sum=num[i]+num[j]+num[begin]+num[end];
		    		if(sum==target){
		    			List<Integer> triple=new ArrayList<Integer>();
						triple.add(num[i]);
						triple.add(num[j]);
						triple.add(num[begin]);
						triple.add(num[end]);
						if(!results.contains(triple))
							results.add(triple);
	
						begin++;
						end--;
					}
		    		else if(sum<target) begin++;
		    		else end--;
	    		}
    		}
    	}

    	return results;
        
    }
    /**
     * hashmap 缓存两个数的和，o(n^2),o(n^2). some problem.
     * @param num
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum1(int[] num, int target) {
    	if(num==null ) return null;
    	if(num.length<4) return new ArrayList<List<Integer>>();
    	List<List<Integer>> results=new ArrayList<List<Integer>>() ;
    	Arrays.sort(num);
    	HashMap<Integer,ArrayList<IntPair>> sum2Cache=new HashMap<Integer,ArrayList<IntPair>>();
    	
    	int len=num.length;
    	for(int i=0;i<len-1;i++){
    		for(int j=i+1;j<len;j++){
    			ArrayList<IntPair> temp=null;
    			if(!sum2Cache.containsKey(num[i]+num[j])){
    				temp=new ArrayList<IntPair>();
    				temp.add(new IntPair(i,j));
    				sum2Cache.put(num[i]+num[j],temp);
    			}
    			else {
    				temp=sum2Cache.get(num[i]+num[j]);
    				temp.add(new IntPair(i,j));
    				sum2Cache.put(num[i]+num[j],temp);
    			}
    		}
    	}
    	for(int i=0;i<len-3;i++){
    		for(int j=i+1;j<len-2;j++){
    			int remain=target-num[i]-num[j];
    			if(sum2Cache.containsKey(remain)){
    				ArrayList<IntPair> temp=sum2Cache.get(remain);
    				
    				for(IntPair intP: temp){
    					List<Integer> quad=new ArrayList<Integer>();
    					quad.add(i);
    					quad.add(j);
    					quad.add(intP.fIndex);
    					quad.add(intP.sIndex);
    					results.add(quad);
    					
    				}
    			}
    		}
    	}
    	
    			
		return results;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] num={1,0,-1,0,-2,2};
		System.out.println(fourSum1(num,0));

	}

}
