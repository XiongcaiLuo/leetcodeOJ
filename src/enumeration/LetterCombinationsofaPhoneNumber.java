package enumeration;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

	/**
	 * 
	 * @param args
	 */
	public String[] numStr={" ", "", "abc", "def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        ArrayList<String> strs=new ArrayList<String>();
        if(digits==null ) return strs;
        if(digits.length()==0){
            strs.add(new String(""));
            return strs;
        }
        String temp="";
        dfs(digits,0,temp,strs);
        return strs;
    }
    private void dfs(String digits, int index ,String temp,ArrayList<String> strs){
    	if(index>=digits.length()){
    		strs.add(temp);
    		return;
    	}
    	char c=digits.charAt(index);
    	System.out.println(c);
    	System.out.println(numStr.length);
    	int k=Integer.valueOf(""+c);
    	String set=numStr[k];
    	
    	if(set.isEmpty()){
    		dfs(digits,index+1,temp,strs);
    		return;
    	}
    		
    	for(int i=0;i<set.length();i++){
    		String next=new String(temp);
    		next+=set.substring(i,i+1);
    		dfs(digits,index+1,next,strs);
    	}
    	
    }
    
	public static void main(String[] args) {
		LetterCombinationsofaPhoneNumber t=new LetterCombinationsofaPhoneNumber();
		String s="2";
		System.out.println(t.letterCombinations(s));
	}

}
