import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by weihengwang on 5/1/17.
 */
public class _212WordSearchII_2 {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNod root = new TrieNod();
        for(String str : words)
            root.insert(str);
        Set<String> res = new HashSet<>();
        for(int r = 0; r < board.length; r++)
            for(int c = 0; c < board[0].length; c ++) {
                char curch = board[r][c];
                if (root.trieArr[curch - 'a'] != null)
                    trieSearch(res, board, r, c, root);
            }

        return new ArrayList<>(res);
    }
    private void trieSearch(Set<String> res, char[][] board, int row, int col, TrieNod root){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length )
            return;
        char curch = board[row][col];
        if(root.trieArr[curch - 'a'] == null || curch == '#')
            return;

        char resevechar = board[row][col];
        board[row][col] = '#';

        if(root.trieArr[curch - 'a'].str != null)
            res.add(root.trieArr[curch - 'a'].str);

        trieSearch(res, board, row + 1, col, root.trieArr[curch - 'a']);
        trieSearch(res, board, row - 1, col, root.trieArr[curch - 'a']);
        trieSearch(res, board, row, col + 1, root.trieArr[curch - 'a']);
        trieSearch(res, board, row, col - 1, root.trieArr[curch - 'a']);

        board[row][col] = resevechar;
    }
}
class TrieNod {
    String str;
    TrieNod[] trieArr = new TrieNod[26];
    public void insert(String string){
        insertHelper(string, 0);
    }
    public void insertHelper(String str, int index) {
        if (index >= str.length()) {
            this.str = str;
            return;
        }
        char curchar = str.charAt(index);
        if(this.trieArr[curchar - 'a'] == null){
            this.trieArr[curchar - 'a'] = new TrieNod();
        }
        this.trieArr[curchar - 'a'].insertHelper(str, index + 1);  // test cases figure out
    }
}
