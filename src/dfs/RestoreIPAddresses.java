package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @param args
 */
public class RestoreIPAddresses {

	List<String> result  = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s,0,1,"");
        return result;
    }
    private void dfs(String s, int start, int step, String cur){
    	if (step == 5 && start == s.length()){
    		result.add(cur.substring(0, cur.length()-1));
    		return;
    	}
    	if (s.length() - start < 4 - step + 1)
    		return;
    	if (s.length() - start > (4 - step + 1) * 3)
    		return;
    	int num = 0;
    	for (int i = start; i < start + 3  && i < s.length(); i++){
    		num = num *10 + (s.charAt(i) - '0');
    		if (num <= 255){
    			
    			dfs(s, i + 1, step + 1, cur +num+".");
    		}
    		if (num == 0) break;
    	}
    }


	public static void main(String[] args) {
		RestoreIPAddresses t = new RestoreIPAddresses();
		t.restoreIpAddresses("010010");
		System.out.println();
	}

}
