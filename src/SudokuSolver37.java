import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by weihengwang on 9/9/16.
 */
public class SudokuSolver37 {
     checkrecord[] rowcheck;
     checkrecord[] colcheck;
     checkrecord[][] surrcheck;

    public void solveSudoku(char[][] board) {
        int rowlen = board.length;
        int collen = board[0].length;
        rowcheck = new checkrecord[rowlen];
        for(int i =0;i<rowlen;i++)
            rowcheck[i] = new checkrecord();
        colcheck = new checkrecord[collen];
        for(int i =0;i<collen;i++)
            colcheck[i] = new checkrecord();

        surrcheck = new checkrecord[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                surrcheck[i][j]=new checkrecord();

        for (int i = 0; i < rowlen; i++) {
            for (int j = 0; j < collen; j++) {
                if(board[i][j]!='.'){
                    rowcheck[i].rec.add(board[i][j]);
                    colcheck[j].rec.add(board[i][j]);
                    surrcheck[i/3][j/3].rec.add(board[i][j]);
                }
            }
        }
        solve(0,0,board);
    }
    private boolean solve(int ist, int jst,char[][] board){

        for(int i =ist;i<9;i++){

            for(int j=0;j<9;j++){

                if(board[i][j]=='.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if ( !rowcheck[i].rec.contains(ch) && !colcheck[j].rec.contains(ch)
                                && !surrcheck[i/3][j/3].rec.contains(ch)){
                            board[i][j]=ch;
                            rowcheck[i].rec.add(ch);
                            colcheck[j].rec.add(ch);
                            surrcheck[i/3][j/3].rec.add(ch);
                            boolean solvable = solve(i,j,board);
                            if(solvable)
                                return true;

                            board[i][j]='.';
                            rowcheck[i].rec.remove(ch);
                            colcheck[j].rec.remove(ch);
                            surrcheck[i/3][j/3].rec.remove(ch);
                        }
                    }
                    return false;
                }

            }

        }
        return true;
    }
    public static void main(String[] args){
        String[] ori = {"53..7....","6..195...",".98....6.",
                        "8...6...3","4..8.3..1","7...2...6",
                        ".6....28.","...419..5","....8..79"};
        char[][] board = new char[9][9];
        for(int i=0;i<9;i++)
            board[i] = ori[i].toCharArray();

        SudokuSolver37 so = new SudokuSolver37();
        so.solveSudoku(board);

        for(int i=0;i<9;i++)
            ori[i] = Arrays.toString(board[i]);
        for(String str:ori)
            System.out.println(str);
    }

}
class checkrecord{
    Set<Character> rec = new HashSet<>();
}