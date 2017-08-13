/**
 * Created by weihengwang on 6/22/17.
 */
public class _208ImplementTrie {
//    String str = null;
//    Trie[] root;
//    /** Initialize your data structure here. */
//    public Trie() {
//        root = new Trie[26];
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        inserthelper(word, 0);
//    }
//
//    private void inserthelper(String word, int st){
//        if(st >= word.length()){
//            this.str = word;
//            return;
//        }
//        char ch = word.charAt(st);
//        if(root[ch - 'a'] == null){
//            root[ch - 'a'] = new Trie();
//        }
//
//        root[ch - 'a'].inserthelper(word, st + 1);
//    }
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        return searchhelper(word, 0);
//    }
//
//    private boolean searchhelper(String word, int st){
//        if(word.length() <= st)
//            return word.equals(this.str);
//
//        char ch = word.charAt(st);
//        if(root[ch - 'a'] == null)
//            return false;
//        return root[ch - 'a'].searchhelper(word, st + 1);
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        return startsWithhelper(prefix, 0);
//    }
//
//    private boolean startsWithhelper(String word, int st){
//        if(word.length() <= st)
//            return true;
//
//        char ch = word.charAt(st);
//        if(root[ch - 'a'] == null)
//            return false;
//        return root[ch - 'a'].startsWithhelper(word, st + 1);
//    }
}
