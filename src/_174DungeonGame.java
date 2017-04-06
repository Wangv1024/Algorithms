/**
 * Created by weihengwang on 4/1/17.
 */
public class _174DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int nrow = dungeon.length;
        int ncol = dungeon[0].length;
        int[][] minpoint = new int[nrow][ncol];

        minpoint[nrow - 1][ncol - 1] = dungeon[nrow - 1][ncol - 1] >= 0 ? 1 : ( - dungeon[nrow - 1][ncol - 1] + 1);
        for(int c = ncol - 2; c >= 0; c--){
            int curreq = minpoint[nrow - 1][c + 1] + (0 - dungeon[nrow - 1][c]);
            curreq = curreq <= 0? 1 : curreq;
            minpoint[nrow - 1][c] = curreq;
        }

        for(int r = nrow - 2; r >= 0; r--){
            int curreq = minpoint[r + 1][ncol - 1] + (0 - dungeon[r][ncol - 1]);
            curreq = curreq <= 0 ? 1 : curreq;
            minpoint[r][ncol - 1] = curreq;
        }

        for(int c = ncol - 2; c >=0 ;c ++){
            for(int r = nrow - 2; r >= 0; r++){
                minpoint[r][c] = Math.min(minpoint[r + 1][c], minpoint[r][c + 1]) - dungeon[r][c];
                minpoint[r][c] = minpoint[r][c] <= 0? 1 : minpoint[r][c];
            }
        }
        return minpoint[0][0];
    }
}
