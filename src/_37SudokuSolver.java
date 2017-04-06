/**
 * Created by weihengwang on 3/28/17.
 */
public class _37SudokuSolver {
    public void solveSudoku(char[][] board){
        solveSudo(board);
    }

    public boolean solveSudo(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        board[i][j] = ch;
                        if(isValid(board, i, j) && solveSudo(board))
                            return true;
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int row, int col){
        int nrow = board.length, ncol = board[0].length;
        int[] tab = new int[10];
        for(int i = 0; i < ncol; i++){
            if(board[row][i] == '.')
                continue;
            tab[board[row][i] - '0']++;
            if(tab[board[row][i] - '0'] > 1)
                return false;
        }

        tab = new int[10];
        for(int j = 0; j < nrow; j++){
            if(board[j][col] == '.')
                continue;
            tab[board[j][col] - '0']++;
            if(tab[board[j][col] - '0'] > 1)
                return false;
        }
        tab = new int[10];
        int rowst = row - row % 3;
        int colst = col - col % 3;
        for(int i = rowst; i < rowst + 3; i++)
            for(int j = colst; j < colst + 3; j++){
                if(board[i][j] == '.')
                    continue;

                tab[board[i][j] - '0']++;
                if(tab[board[i][j] - '0'] > 1)
                    return false;
            }
        return true;
    }
}
