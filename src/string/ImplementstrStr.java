package oj.string;

public class ImplementstrStr {

	/**
	 * Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
	 * @param args
	 */
    public static String strStr(String haystack, String needle) {
        if(haystack==null || needle==null ||haystack.length()<needle.length()) return null;
        int index=haystack.indexOf(needle);
        System.out.println(index);
        if(index<0) return null;
        else return haystack.substring(index, index+needle.length());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hay="";
		String needle="";
		System.out.println(strStr(hay,needle));

	}

}
