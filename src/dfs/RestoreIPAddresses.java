package dfs;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	/**
	 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
	 * @param args
	 */
	List<String> results=new ArrayList<String>();
	String input;
    public List<String> restoreIpAddresses(String s) {
    	input=s;
        String temp=new String();
        int level=0;
        int startIndex=0;
        dfs(temp,level,startIndex);
        return results;
        
    }
	private void dfs(String temp,int level, int startIndex) {
		if(level==4 && startIndex==input.length()){
			results.add(temp.substring(1,temp.length()));
			return;
		}
		if(input.length()-startIndex>(4-level)*3) return;
		if(input.length()-startIndex<(4-level)) return;
		int num=0;
		for(int i=startIndex;i<startIndex+3 && i<input.length() ;i++){
			num=num*10+(input.charAt(i)-'0');
			if(num<=255){
				String next=new String(temp);
				next+=("."+num);
				dfs(next,level+1,i+1);
			}
			if(num==0) break;
			
		}
		
	}
	

	public static void main(String[] args) {
		RestoreIPAddresses t= new RestoreIPAddresses();
		t.restoreIpAddresses("1111");
		
	}

}
