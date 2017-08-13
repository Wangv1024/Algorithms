import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by weihengwang on 7/30/17.
 */
public class _317ShortestDistancefromAllBuildings {
    public int shortestDistance(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        int nrow = grid.length;
        int ncol = grid[0].length;
        int total = 0;
        int[][] totalDistance = new int[ grid.length ][ grid[0].length ];
        int[][] reachable = new int[nrow][ncol]; //
        for(int row = 0; row < nrow; ++ row){
            for(int col = 0; col < ncol; ++ col){
                if(grid[row][col] == 1){
                    total ++; // In total, how many buildings
                    bfsExpand(grid, totalDistance, reachable, new boolean[nrow][ncol], row, col);
                }
            }
        }
        int dis = Integer.MAX_VALUE;
        for(int row = 0; row < nrow; ++ row){
            for(int col = 0; col < ncol; ++ col){// bugs: only when reachable == total building, we consider it valid answer.
                if(grid[row][col] == 0 && reachable[row][col] == total)
                    dis = Math.min(dis, totalDistance[row][col]);
            }
        }
        return dis == Integer.MAX_VALUE? -1 : dis;
    }
    private void bfsExpand(int[][] grid, int[][] totalDistance, int[][] reachable, boolean[][] visited, int strow, int stcol){
        Queue<int[]> que = new LinkedList<>();
        int dist = 1;
        que.offer(new int[]{strow, stcol});
        int[][] directs = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        while( !que.isEmpty()){
            int levelsize = que.size();
            for(int i = 0; i < levelsize; ++ i){
                int[] point = que.poll();
                for(int[] direct : directs){
                    int row = point[0] + direct[0];
                    int col = point[1] + direct[1];
                    if( row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ){
                        continue;
                    }
                    if( grid[row][col] == 1 || grid[row][col] == 2 || visited[row][col] == true){
                        continue;
                    }
                    visited[row][col] = true;
                    totalDistance[row][col] += dist;
                    reachable[row][col] ++;
                    que.offer(new int[]{row, col});
                }
            }
            dist ++;
        }
    }
}
