package list;

public class DecodeWays {

	/**
	 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
???how to treat o??? the problem doesn't say.
	 * @param args
	 */
	public static boolean isAlpha(String a1,String a2){
		int n1=Integer.valueOf(a1);
		int n2=Integer.valueOf(a2);
		if(n1*10+n2>26 ||n1==0 ||n2==0 )
			return false;
		else return true;
	}
    public static int numDecodings(String s) {
    	int len=s.length();
    	if(len==0 ) return 0; 
		if(len==1) {
			if(s.charAt(0)=='0') return 0;
			else return 1;
		}
		else if(len==2){
			if(s.equals("00"))return 0;
			else if(s.contains("0")) return 1;
			else if(isAlpha(s.substring(0,1), s.substring(1,2))) return 2;
			else return 1;
		}
		int[]f=new int[len];
		if(s.charAt(0)!='0') f[0]=1;
		else f[0]=0;
		if(s.charAt(1)==0) f[1]=f[0];
		else{
			if(s.charAt(0)==0)f[1]=1;
			else if(isAlpha(s.substring(0,1),s.substring(1,2)))
				f[1]=2;
			else f[1]=1;
		}
		for(int i=2;i<len;i++){
			if(isAlpha(s.substring(i-1,i),s.substring(i,i+1)))
				f[i]=f[i-1]+f[i-2];
			else f[i]=f[i-1];
		}
		return f[len-1];
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="00";
		System.out.println(numDecodings(s));

	}

}
