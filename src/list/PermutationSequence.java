package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * @param args
 */
public class PermutationSequence {
	private int[] factors;
	private void computeFact(int n){
		factors[0] = 1;
		for (int i =1; i <=n; i++ )
			factors[i] = i * factors[i - 1];
	}
    public String getPermutation(int n, int k) {
        factors = new int[n+1];
        computeFact(n);
        List<Integer> nums = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++){
        	nums.add(i);
        }
        StringBuilder sb = new StringBuilder();
        k--;                               //be careful here! mod运算时候，编号从0开始算起。
        for (int i = 1; i <= n; i++){
        	int ret = nums.remove(k/factors[n-i]);
        	sb.append(ret);
        	k = k % factors[n-i];
        }
        return sb.toString();	
    }

	public static void main(String[] args) {


	}

}
