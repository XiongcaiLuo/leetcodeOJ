package string;
public class WordDictionary {
    private static final int R = 26;
    private Node root;
    private static class Node{
        Object v;
        Node[] next = new Node[R];
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        root = put(root, word, 0);
    }
    
    private Node put( Node cur, String word, int d){
        if (cur == null) cur = new Node();
        if ( d == word.length()){
            cur.v = new Object();
            return cur;
        }
        int c = word.charAt(d) - 'a';
        cur.next[c] = put(cur.next[c], word, d + 1);
        return cur;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(root, word, 0);
    }
    
    private boolean search(Node cur, String word, int d){
        if (cur == null ) return false;
        if (d == word.length()){
            return cur.v != null;
        }
        char c = word.charAt(d);
        if ( c == '.'){
            for (char i = 0; i < R; i++){
                if (search(cur.next[i], word, d + 1))
                    return true;
            }
            return false;
        } else {
            return search(cur.next[c - 'a'], word, d + 1);
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");