package oj.list;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	/**
	 * The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
	 * @param args
	 */
    public static List<Integer> grayCode(int n) {
    	ArrayList<Integer> results=new ArrayList<Integer>();
    	if(n==0) {
    		results.add(0);
    		return results;
    	}
    	ArrayList<String> gc=new ArrayList<String>();
    	gc.add("0");gc.add("1");
    	for(int i=2;i<=n;i++){
    		int len=gc.size();
    		for(int j=len-1;j>=0;j--){
    			String str=gc.get(j);
    			gc.add("1"+str);
    			gc.set(j, "0"+str);
    		}
    	}
    	for(int i=0;i<gc.size();i++)
    		results.add(Integer.parseInt(gc.get(i),2));
    	return results;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<Integer> aa=new ArrayList<Integer>();
//		aa.add(1);
//		aa.add(2);
//		aa.set(0, 3);
//		System.out.println(aa);
		
		System.out.println(grayCode(4));
		
	}

}
