package oj;

public class ReverseInteger {

	/**
	 * @param args
	 */
    public static int reverse(int x) {
    	if(x==0) return 0;   	
       int sign=-1;
        if(x>0) sign=1;
        int absx=Math.abs(x);
        String s=String.valueOf(absx);
        StringBuffer revers=new StringBuffer();
        int len=s.length();
        for(int i=0;i<len;i++)
        	revers.append(s.charAt(len-1-i));
        int reInt=Integer.valueOf(revers.toString());
        return sign*reInt;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(1));

	}

}
