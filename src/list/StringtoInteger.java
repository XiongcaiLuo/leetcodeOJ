package list;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringtoInteger {

	/**
	 * @param args
	 */
	public static String getNum(String s){
		 Pattern pattern = Pattern.compile("([\\-\\+]*\\d+)");
		  Matcher matcher = pattern.matcher(s);
		 String numStr="";
		  if(matcher.find()){
		   numStr=matcher.group(1);
		  }
		  return numStr;
	}
   public static int atoi(String str) {
   	if(str==null||str.trim().isEmpty()) return 0;
   	String[]tokens=str.trim().split("\\s+");
   	str=getNum(tokens[0]);
   	if(str==null||str.trim().isEmpty()) return 0; 
   	long num=0;
   	try{
   		num=Long.valueOf(str.trim());
   	}catch (NumberFormatException e){
   		return 0;
   	}
   	if(num>=Integer.MAX_VALUE) return 0;
   	else if(num<=Integer.MIN_VALUE) return 0;
       return (int)num;
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="++1";
		System.out.println(getNum(s));
		System.out.println(atoi(s));


	}

}
