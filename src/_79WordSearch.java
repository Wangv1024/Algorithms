/**
 * Created by weihengwang on 2/18/17.
 */
public class _79WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0)
            return false;

        char[][] visited = new char[board.length][board[0].length];
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                if(helper(board, visited, word, 0, i, j))
                    return true;
            }
        return false;
    }

    public boolean helper(char[][] board, char[][] visited, String word, int cur, int row, int col){
        if(cur >= word.length())
            return true;
        int nrow = board.length - 1;
        int ncol = board[0].length - 1;
        if(col < 0 || col > ncol || row < 0 || row > nrow ||
                board[row][col] != word.charAt(cur) || visited[row][col] == 1)
            return false;
        visited[row][col] = 1;
        if(helper(board, visited, word, cur + 1, row + 1, col))
            return true;
        if(helper(board, visited, word, cur + 1, row - 1, col))
            return true;
        if(helper(board, visited, word, cur + 1, row, col + 1))
            return true;
        if(helper(board, visited, word, cur + 1, row, col - 1))
            return true;

        visited[row][col] = 0;
        return false;
    }
}
