package oj;

public class ReverseWords {

	/**
	 * @param args
	 */
    public static String reverseWords(String s) {
        if(s==null) return null;
        if(s.trim().isEmpty()) return "";
        String[] words=s.trim().split("\\s+");
        StringBuffer rW=new StringBuffer();
        int len=words.length;
        for(int i=0;i<len;i++){
        	rW.append(words[len-1-i].trim()+" ");
        }
        return rW.toString().trim();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="   a   b  ";  
		System.out.println(reverseWords(a));
	}

}
