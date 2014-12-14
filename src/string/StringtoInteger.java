package string;

public class StringtoInteger {

	/**
	 * @param args
	 */
    public int atoi(String str) {
    	if(str==null ||str.length()==0) return 0;
        int num=0;
        int sign=1;
        int n=str.length();
        int i=0;
        while(str.charAt(i)==' ' && i<n) i++;
        if(str.charAt(i)=='+') i++;
        else if(str.charAt(i)=='-'){sign=-1; i++;}
        
        for(;i<n;i++){
        	if(str.charAt(i)<'0' || str.charAt(i)>'9')
        		break;
        	if(num>Integer.MAX_VALUE/10 || (num==Integer.MAX_VALUE/10 && (str.charAt(i)-'0')>Integer.MAX_VALUE%10))
        		return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
        	num=num*10+str.charAt(i)-'0';
        }
        return num*sign;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
