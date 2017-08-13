import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by weihengwang on 7/11/17.
 */
public class _286WallsandGates {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length == 0)
            return;
        Queue<int[]> que = new LinkedList<>();
        int[][] directs = new int[][]{{1, 0},{-1, 0},{0, -1},{0, 1}};

        for(int i = 0; i < rooms.length; i++)
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0)
                    que.offer(new int[]{i, j});
            }

        while( !que.isEmpty() ){
            int[] po = que.poll();
            int row = po[0];
            int col = po[1];
            int dist = rooms[row][col];

            for(int[] dire : directs){
                int newrow = row + dire[0];
                int newcol = col + dire[1];

                if(newrow < 0 || newrow >= rooms.length || newcol < 0 || newcol >= rooms[0].length)
                    continue;
                if(rooms[newrow][newcol] > dist + 1){
                    rooms[newrow][newcol] = dist + 1;
                    que.offer(new int[]{newrow, newcol});
                }
            }
        }
    }
}
