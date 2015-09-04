package interview_xk;
//package interviewquestions.google;

import java.util.*;

/**
 * we will name a number "aggregated number" if this number has the following
 * attribute: just like the Fibonacci numbers 1,1,2,3,5,8,13.....
 * 
 * the digits in the number can divided into several parts, and the later part
 * is the sum of the former parts.
 * 
 * like 112358, because 1+1=2, 1+2=3, 2+3=5, 3+5=8 122436, because 12+24=36
 * 1299111210, because 12+99=111, 99+111=210 112112224, because 112+112=224 so
 * can you provide a function to check whether this number is aggregated number
 * or not?
 */
public class AggregratedNumber_lxc { 
    public boolean isAggregratedNumber(String num) {
    	if (num == null || num.length() < 3) return false;
    	int begin = 0;
    	for (int i = 1; i < num.length() - 1; i++){
    		for (int j = i + 1; j < num.length(); j++){
    			if (isAggregrated(num, begin, i, j))
    				return true;
    		}
    	}
    	return false;
    } 
    
    private boolean isAggregrated(String num, int begin, int i, int j){
    	if ( j == num.length()) return true;
    	int num1 = Integer.valueOf(num.substring(begin,i));
    	int num2 = Integer.valueOf(num.substring(i,j));
    	String sum = num1 + num2 + "";
    	if (sum.length() > num.length() - j) return false;
    	else return sum.equals(num.substring(j, j + sum.length())) && isAggregrated(num, i, j , j+ sum.length());
    }
    
    public static void main(String[] args){
    	AggregratedNumber_lxc ag = new AggregratedNumber_lxc();
    	String num = "224668";
    	boolean flag = ag.isAggregratedNumber(num);
    	System.out.println(flag);
    }
}