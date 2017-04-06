/**
 * Created by weihengwang on 3/6/17.
 */
public class _59SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if(n < 1)
            return null;
        int[][] res = new int[n][n];
        int rowst = 0, rowen = n - 1, colst = 0, colen = n - 1;
        int st = 1;
        while(rowst <= rowen && colst <= colen){
            for(int i = colst; i <= colen; i++)
                res[rowst][i] = st++;
            if(++rowst > rowen)
                break;

            for(int i = rowst; i <= rowen; i++)
                res[i][colen] = st++;
            if(colst > --colen)
                break;

            for(int i = colen; i >= colst; i--)
                res[rowen][i] = st++;
            if(rowst > --rowen)
                break;

            for(int i = rowen; i >= rowst; i--)
                res[i][colst] = st++;
            if(++colst > colen)
                break;
        }
        return res;
    }
}
