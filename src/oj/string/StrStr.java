package oj.string;

import java.util.HashMap;

public class StrStr {

	/**
	 * Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
	 * @param args
	 */
	
	String uniqueStr="";
	int[][]DAF;
    public int strStr(String haystack, String needle) {
    	if(needle ==null || needle.isEmpty()) return -1;
    	else if(haystack ==null || haystack.isEmpty()) return -1;
        uniqueStr=getUnique(needle);
        getDAF(needle);
        int n=haystack.length(),m=needle.length();
        int state =0;
        for(int i=0;i<n;i++){
        	char c=haystack.charAt(i);
        	int j=uniqueStr.indexOf(c);
        	if(j==-1) {
        		state=0;
        		continue;
        	}
        	state=DAF[j][state];
        	if(state==m) return i-m+1;
        }
        return -1;
    }
    
    public  String getUnique(String needle){
    	HashMap<Character,Integer> charIndex=new HashMap<Character,Integer>();
    	StringBuilder strB=new StringBuilder();
    	int len=needle.length();
    	for(int i=0;i<len;i++){
    		char c=needle.charAt(i);
    		if(!charIndex.containsKey(c)){
    			strB.append(c);
    			charIndex.put(c,0);
    		}
    	}
    	return strB.toString();
    }
    
    public void getDAF(String needle){
    	int m=uniqueStr.length(), n=needle.length();
    	DAF=new int[m][n];
    	
    	// initial
    	for(int i=0;i<m;i++){
    		if(uniqueStr.charAt(i)==needle.charAt(0))
    			DAF[i][0]=1;
    		else DAF[i][0]=0;
    	}
    	
    	// for iteration 
    	int x=0;
    	for(int j=1;j<n;j++){
    		for(int i=0;i<m;i++){
    			if(uniqueStr.charAt(i)==needle.charAt(j))
    				DAF[i][j]=j+1;
    			else DAF[i][j]=DAF[i][x];
    		}
    		x=DAF[uniqueStr.indexOf(needle.charAt(j))][x];
    	}
    	
    }
    

    
	public static void main(String[] args) {
		StrStr t= new StrStr();
		int index=t.strStr("babba", "bbb");
		System.out.println(index);
	}

}
