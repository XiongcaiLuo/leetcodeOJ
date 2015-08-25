package list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 * 
 * Note that 1 is typically treated as an ugly number.
 * 
 * Hint:
 * 
 * The naive approach is to call isUgly for every number until you reach the nth
 * one. Most numbers are not ugly. Try to focus your effort on generating only
 * the ugly ones. An ugly number must be multiplied by either 2, 3, or 5 from a
 * smaller ugly number. The key is how to maintain the order of the ugly
 * numbers. Try a similar approach of merging from three sorted lists: L1, L2,
 * and L3. Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 *
 * 2, L2 * 3, L3 * 5).
 * 
 * @author luoxiongcai
 *
 */
public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        Queue<Long> q2 = new LinkedList<Long>();
        Queue<Long> q3 = new LinkedList<Long>();
        Queue<Long> q5 = new LinkedList<Long>();
        q2.offer(2L);
        q3.offer(3L);
        q5.offer(5L);
        int count = 1, curMin = 1;
        while (count < n){
        	curMin = (int) Math.min(Math.min(q2.peek(),q3.peek()), q5.peek());
        	if ( q2.peek() == curMin){
        		q2.poll();
        		q2.offer(curMin * 2L);
        		q3.offer(curMin * 3L);
        		q5.offer(curMin * 5L);
        	}  else if ( q3.peek() == curMin){
        		q3.poll();
        		q3.offer(curMin * 3L);
        		q5.offer(curMin * 5L);
        	} else {
        		q5.poll();
        		q5.offer(curMin * 5L);
        	}
        	count++;
        }
        return curMin;
    }
	public static void main(String[] args) {
		UglyNumber2 un = new UglyNumber2();
		int re =  un.nthUglyNumber(1600);
		System.out.println(re);
	}

}
