package oj;

public class ZigZagConversion {

	/**
	 * @param args
	 */
//	public static int[] getOrder(int len,int row){
//		int[]order=new int[len];
//		for(int i=0;i<row;i++){
//			
//		}
//	}
    public static String convert(String s, int nRows) {
    	if(nRows==1||s.length()<=2) return s;
    	if(nRows>=s.length()) return s;
        int len=s.length();
        StringBuffer result=new StringBuffer();
        int step=2*nRows-2;
        for(int i=0;i<len;i=i+step)
        	result.append(s.charAt(i));
        for(int i=1;i<nRows-1;i++){
        	result.append(s.charAt(i));
        	int step1=2*(nRows-i-1);
        	int step2=2*i;
        	int ptr=i;
        	while(ptr+step1<len){  //"PAHNAPLSIIGYIR"
        		ptr+=step1;
        		result.append(s.charAt(ptr));
        		
        		if(ptr+step2<len){
        			ptr+=step2;
        			result.append(s.charAt(ptr));
        		}
        		else break;       		
        	}        	
        }
        
        for(int i=nRows-1;i<len;i=i+step){
        	result.append(s.charAt(i));
        }
        return result.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="ABCD";
		System.out.println(convert(s,3));

	}

}
