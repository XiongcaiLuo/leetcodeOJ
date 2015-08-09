package oj;

public class PlusOne {

	/**
	 * @param args
	 */    
	public static int[] plusOne(int[] digits) {
	        int len=digits.length;
	        int jinwei=1;
	        int i=len-1;
	        for( i=len-1;i>=0;i--){
	        	if(digits[i]+jinwei==10){
	        		digits[i]=0;
	        	}
	        	else {
	        		digits[i]+=jinwei;
	        		break;
	        	}	        	
	        }
	        if(i==-1){
	        	int[] result=new int[len+1];
	        	result[0]=1;
	        	for(int k=1;k<=len;k++){
	        		result[k]=0;
	        	}
	        	return result;
	        }
	        return digits;
	    }
	public static void print(int[] digits){
		for(int i=0;i<digits.length;i++){
			System.out.print(digits[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits={9,9,9,9};
		print(plusOne(digits));
		System.out.println();
	}

}
