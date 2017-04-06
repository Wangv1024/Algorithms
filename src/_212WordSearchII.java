import java.util.ArrayList;
import java.util.List;

/**
 * Created by weihengwang on 3/6/17.
 */
public class _212WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(words.length <= 0)
            return res;
        TrieNode root = new TrieNode();
        creatTrie(root, words);

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(root.next[board[i][j] - 'a'] != null)
                    search(root, board, i, j, res);
            }
        }
        return res;
    }

    public void search(TrieNode root, char[][] board, int i, int j, List<String> res){
        if(root.str != null)
            res.add(root.str);
        int rowlen = board.length - 1;
        int collen = board[0].length - 1;
        if(i < 0 || j < 0 || i > rowlen || j > collen || root.next[board[i][j] - 'a'] == null)
            return;
        root = root.next[board[i][j] - 'a'];

        search(root, board, i + 1, j, res);
        search(root, board, i - 1, j, res);
        search(root, board, i,  j + 1, res);
        search(root, board, i,  j - 1, res);
    }

    public void creatTrie(TrieNode root, String[] words){
        for(String str : words){
            TrieNode curnode = root;
            for(int i = 0; i < str.length(); i++){
                char curchar = str.charAt(i);
                if(curnode.next[curchar - 'a'] == null){
                    curnode.next[curchar - 'a'] = new TrieNode();
                }
                curnode = curnode.next[curchar - 'a'];

            }
            curnode.str = str;
        }
    }
}

class TrieNode {
    String str;
    TrieNode[] next = new TrieNode[26];
}
