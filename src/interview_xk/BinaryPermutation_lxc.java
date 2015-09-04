package interview_xk;
/**
 * use bitset. 
 */

//package interviewquestions.google;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Given an integer, find the next highest and next lowest integers, with equal
 * number of 1s in their binary representation as the original number. Mainly
 * learned bit manipulation techniques, create some small help function as
 * marcos in C is a very good idea.
 */
public class BinaryPermutation_lxc {
	/**
	 * what about -1? Integer.MAX_VALUE? Integer.MIN_VALUE?
	 * assume the intput is valid positive.
	 * @param value
	 * @return
	 */
    public int findNextBinaryPermutation(int value) {
        BitSet bs =  BitSet.valueOf(new long[]{value});
        int f1 = bs.nextSetBit(0);
        int f0 = bs.nextClearBit(f1+1);
        bs.set(f0);
        bs.clear(0, f0);
        bs.set(0,f0 - f1 - 1);
        return (int) bs.toLongArray()[0];
    }


    public int findPrevBinaryPermutation(int value) {
        BitSet bs =  BitSet.valueOf(new long[]{value});
        int f0 = bs.nextClearBit(0);
        int f1 = bs.nextSetBit(f0 + 1);
        bs.clear(f1);
        bs.set(0,f1);
        bs.clear(0,f1 - f0 - 1);
        return (int) bs.toLongArray()[0];
    }
    
    public static void main(String[] args){
    	int value = 10;
    	BinaryPermutation_lxc bp = new BinaryPermutation_lxc();
    	int next = bp.findNextBinaryPermutation(value);
    	int pre = bp.findPrevBinaryPermutation(value);
    	System.out.println(next);
    	System.out.println(pre);
    }

}
