package oj;



public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * @param args
	 */
	public static int getMaxIndex(String s,char c){
		int len=s.length();
		int i=len-1;
		for( i=len-1;i>=0;i--){
			if(c==s.charAt(i))
				break;
		}
		return i;
	}
    public static int lengthOfLongestSubstring(String s) {
        int len=s.length();

        if(len==0||len==1) return len;
        String[] subs=new String[len];  
        int[]c=new int[len];
        c[0]=1;
        subs[0]=""+s.charAt(0);
        for(int i=1;i<len;i++){
        	char currentChar=s.charAt(i);
        	if(!(subs[i-1].contains(""+currentChar))){
        		c[i]=c[i-1]+1;
        		subs[i]=subs[i-1]+currentChar;
        	}
        	else{
        		int index=getMaxIndex(subs[i-1],currentChar);
        		c[i]=c[i-1]-index;
        		subs[i]=subs[i-1].substring(index+1, subs[i-1].length())+currentChar;
        	}
        }
        //find max;
        int max=c[0];
        for(int i=1;i<len;i++){
        	if(c[i]>max)
        		max=c[i];
        }
        return max;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "bbbb";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
