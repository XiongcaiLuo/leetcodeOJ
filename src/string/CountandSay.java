package string;

public class CountandSay {

	/**
	 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
	 * @param args
	 */
    public static String countAndSay(int n) {
        if(n==1) return "1";
        int count=1;
        String currentStr="1";
        while(count<n){
        	count++;
        	currentStr=getNext(currentStr);
        }
        return currentStr;
    }
    
    private static String getNext(String num){
    	StringBuffer numNext=new StringBuffer();
    	char currentNum=num.charAt(0);
    	int currentCount=1,ptr=1;
    	while(ptr<num.length()){
    		if(num.charAt(ptr)==currentNum){
    			ptr++;
    			currentCount++;
    		}
    		else{
    			numNext.append(""+currentCount+currentNum);
    			currentCount=1;
    			currentNum=num.charAt(ptr);
    			ptr++;
    		}
    	}
    	numNext.append(""+currentCount+currentNum);
    	return numNext.toString();
    }
	public static void main(String[] args) {
		System.out.println(getNext("1211"));
		for(int i=1;i<6;i++)
			System.out.println(i+":"+countAndSay(i));
	}

}
