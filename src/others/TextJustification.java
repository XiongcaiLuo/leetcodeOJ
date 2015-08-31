package others;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
 * @author luoxiongcai
 *
 */
public class TextJustification {
	/**
	 * 
	 * @param words
	 * @param maxWidth
	 * @return
	 */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        if (maxWidth == 0 ) {
            for (int i = 0; i < words.length; i++)
                result.add("");
            return result;
        }
        int i = 0;
        while ( i < words.length){
        	int count = words[i].length();
        	int j = i + 1;
        	for (; j < words.length; j++){
        		if (count + words[j].length() + 1 > maxWidth)
        			break;
        		count += words[j].length() + 1;
        	}
        	// average the spaces.
        	StringBuilder sb = new StringBuilder();
        	int remain = maxWidth - count + j - i -1;
        	int segs = j - i;
        	int avg = remain / segs;
        	int more = remain % segs;
        	for (int k = 0; k < j - i; k++){
        		String space = "";
        		if (k < more){
        			space = spaces(avg + 1);
        		} else space = spaces(avg);
        		sb.append(words[i+k]+space);
        	}
        	result.add(sb.toString());
        	i = j;
        }
        return result;
    }
    
    private String spaces(int k){
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < k ; i++)
    		sb.append(" ");
    	return sb.toString();
    }
	public static void main(String[] args) {
		TextJustification tf = new TextJustification();
		String[] words = {"Listen","to","many,","speak","to","a","few."};
		int maxWidth = 6;
		List<String> result = tf.fullJustify(words, maxWidth);
		System.out.println(result);
	}

}
