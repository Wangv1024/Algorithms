/**
 * Created by weihengwang on 3/28/17.
 */
public class _351AndroidUnlockPatterns {
    public static int numberOfPatterns(int m, int n) {
        if(n > 9)
            n = 9;
        if(m > n || m <= 0)
            return 0;
        int[] total = new int[1];
        boolean[][] visited = new boolean[3][3];
        for(int len = m; len <= n; len++){
            getPatternNumAt(len, 0, visited, total, null, null);
        }
        return total[0];
    }

    public static void getPatternNumAt(int len, int curlen, boolean[][] visited, int[] total, Integer prerow, Integer precol){
        if(curlen >= len){
            total[0]++;
            return;
        }

        for(int i = 0; i < 3 ; i++){
            for(int j = 0; j < 3; j++){
                if(visited[i][j] == true)
                    continue;

                if(prerow == null || pathValid(visited, prerow, precol, i, j)) {
                    visited[i][j] = true;
                    getPatternNumAt(len, curlen + 1, visited, total, new Integer(i), new Integer(j));
                    visited[i][j] = false;
                }
            }
        }
    }

    public static boolean pathValid(boolean[][] visited, Integer prerow, Integer precol, int i, int j){
        int prer = prerow, prec = precol;
        if(Math.abs(prer - i) == 1 || Math.abs(prec - j) == 1)
            return true;
        if(prer == i || prec == j){
            if(Math.abs(prer - i) == 2 && visited[(prer + i) / 2][prec] == false)
                return false;
            if(Math.abs(prec - j) == 2 && visited[prer][(prec + j) / 2] == false)
                return false;
        }
        else if(Math.abs(prer - i) == 2 && Math.abs(prec - j) == 2 && visited[1][1] == false)
            return false;

        return true;
    }

    public static void main(String[] args){
        System.out.println(numberOfPatterns(1,9));
    }
}
