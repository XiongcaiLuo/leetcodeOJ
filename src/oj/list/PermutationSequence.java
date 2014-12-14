package oj.list;

import java.util.ArrayList;
import java.util.Collections;

public class PermutationSequence {

	/**
	 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
	 * @param args
	 */
	private static int factor(int n){
		if(n<=1) return 1;
		int sum=1;
		for(int i=2;i<=n;i++)
			sum*=i;
		return sum;
	}
	private static String getResult(ArrayList<Integer> nums,int n) {
		StringBuilder str=new StringBuilder();
		for(int i=0;i<nums.size();i++)
			str.append(""+nums.get(i));
		for(int i=n;i>0;i--){
			if(!nums.contains(i))
				str.append(""+i);
		}
		return str.toString();
	}

    public static String getPermutation(int n, int k) {
    	ArrayList<Integer> nums=new ArrayList<Integer>();
    	int shang=0,remain=k;
    	String result="";
    	for(int i=1;i<=n;i++){
    		int f_n_i=factor(n-i);
    		shang=remain/f_n_i;
    		remain=remain%f_n_i;
    		if(remain==0){
                shang=getAi(nums,shang);
                nums.add(shang);
    			result=getResult(nums,n);
    			return result;
    		}
    		else{
    			shang=getAi(nums,shang+1);
    			nums.add(shang);
    		}
    		
    	}
    	StringBuilder str=new StringBuilder();
    	
    	for(int i=0;i<nums.size();i++)
    		str.append(nums.get(i));
		return str.toString();
        
    }

	private static int getAi(ArrayList<Integer> nums, int k) {
		ArrayList<Integer> temps=new ArrayList<Integer>(nums);
		Collections.sort(temps);
		for(int i=0;i<temps.size();i++){
			if(temps.get(i)<=k && temps.get(i)!=0)
				k++;
		}
		return k;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> nums=new ArrayList<Integer>();
		nums.add(1);
//		System.out.println(getResult(nums,3));
//		System.out.println(getAi(nums,1));
//		for(int i=1;i<7;i++)
			System.out.println(getPermutation(4,7));
//		System.out.println(factor(4));

	}

}
