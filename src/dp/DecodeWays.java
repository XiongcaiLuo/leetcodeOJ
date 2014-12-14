package dp;

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
	 * @param args
	 */
	
	/**
	 * 
	 * @param s
	 * @return
	 */
//	 public int numDecodings(String s) {
//		 if (s.length()==0 || s.charAt(0) == '0') return 0;
//		 int prev = 0;
//		 int cur = 1;
//		 
//		 for (int i = 1; i <= s.length(); ++i) {
//			 if (s.charAt(i-1) == '0') cur = 0;
//			 if (i < 2 || !(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')))
//				 prev = 0;
//			 int tmp = cur;
//			 cur = prev + cur;
//			 prev = tmp;
//		 }
//		 return cur;
//			 
//	 }
	 
	
	/**
	 * my method
	 * @param s
	 * @return
	 */
	 public int numDecodings(String s) {
		 if (s.length()==0 || s.charAt(0) == '0') return 0;
		 int n=s.length();
		 if (n==1)
			 return s.charAt(0)=='0'? 0:1;
		 int [] nums=new int[n];
		 nums[0]= s.charAt(0)=='0'? 0:1;
		 int flag=getFlag(s.charAt(0),s.charAt(1));
		 switch (flag){
		 case 0: nums[1]=0;break;
		 case 1: nums[1]=1;break;
		 case 2: nums[1]=nums[0];break;
		 case 3: nums[1]=2;break;
		 }
		 
		 for(int i=2;i<n;i++){
			 switch (getFlag(s.charAt(i-1),s.charAt(i))){
			 case 0: nums[i]=0;break;
			 case 1: nums[i]=nums[i-2];break;
			 case 2: nums[i]=nums[i-1];break;
			 case 3: nums[i]=nums[i-2]+nums[i-1];break;
			 }
		 }
		 return nums[n-1];
			 
	 }
	 
	 public static int getFlag(char a,char b){
		 if(b=='0' &&( a=='0' ||a>='3'))
				 return 0;
		 else if(b=='0' && (a=='1' ||a=='2'))
			 return 1;
		 else if((b>='1' && b<='9') && (a=='0' || (a-48)*10+(b-48)>26))
			 return 2;
		 else return 3;
	 }

	public static void main(String[] args) {
//		System.out.println(getFlag('3','0'));
		DecodeWays t=new DecodeWays();
		System.out.println(t.numDecodings("230"));
	}

}
