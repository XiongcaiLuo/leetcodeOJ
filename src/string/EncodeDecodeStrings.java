package string;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
	public String encode(List<String> strs){
		StringBuilder sb = new StringBuilder();
		for (String s : strs){
			sb.append( s.length() + "/" + s);
		}
		return sb.toString();
	}
	
	public List<String> decode(String str){
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < str.length(); ){
			int index = str.indexOf("/",i);
			int len = Integer.valueOf(str.substring(i, index));
			result.add(str.substring(index + 1, index + 1 + len));
			i = index + len + 1;
		}
		return result;
	}
	public static void main(String[] args) {
		EncodeDecodeStrings ed = new EncodeDecodeStrings();
		List<String> strs = new ArrayList<String>();
		strs.add("");
		strs.add("/");
		strs.add(" ");
		strs.add("hello");
		strs.add("\\");
		String encode = ed.encode(strs);
		System.out.println("encode:"+encode);
		List<String> decode  = ed.decode(encode);
		for (int i = 0; i < decode.size(); i++)
			System.out.println(i+":"+decode.get(i) + "END");
	}

}
