package bfs;

import java.util.HashSet;
import java.util.Set;

public class WordLadder {

	/**
	 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
	 * @param args
	 */
	int pathLen=Integer.MAX_VALUE;
	String start,end;
	Set<String> dict;
	
    public int ladderLength(String start, String end, Set<String> dict) {
    	if(start.equals(end)) return 2;
        if(dict==null || dict.size()==0){
        	if(start.equals(end))
        		return 2;
        	else return 0;
        }
        this.start=start;this.end=end;
        this.dict=dict;
        dfs(start,0,1,1);
        return pathLen==Integer.MAX_VALUE?0:pathLen;
    }
    
    private  void dfs(  String re, int index, int charIndex,int curLen){
    	if(index==start.length()){
    		if(re.equals(end)){
    			pathLen=Math.min(pathLen,curLen);
    			return;
    		}
    	}
    	
    	
    	
    }

	public static void main(String[] args) {
		char a=(char)(96+1);
		System.out.println(a);
	}

}
