import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by weihengwang on 10/11/16.
 */
public class PacificAtlanticWaterFlow417 {
    int[][] direction = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        int rown = matrix.length;
        int coln = matrix[0].length;
        boolean[][] pavisited = new boolean[rown][coln];
        boolean[][] atvisited = new boolean[rown][coln];
        Queue<int[]> paqueue = new LinkedList<>();
        Queue<int[]> atqueue = new LinkedList<>();
        for(int i=0; i<coln; i++){
            pavisited[0][i] = true;
            atvisited[rown-1][i] = true;
            paqueue.offer(new int[]{0,i});
            atqueue.offer(new int[]{rown-1,i});
        }
        for(int i=0;i<rown;i++){
            pavisited[i][0]=true;
            atvisited[i][coln-1]=true;
            paqueue.offer(new int[]{i,0});
            atqueue.offer(new int[]{i,coln-1});
        }
        BFS(matrix,pavisited,paqueue);
        BFS(matrix,atvisited,atqueue);
        List<int[]> res = new LinkedList<>();
        for(int i=0;i<rown;i++) {
            for (int j = 0; j < coln; j++) {
                if (pavisited[i][j] == true && atvisited[i][j] == true)
                    res.add(new int[]{i,j});
            }
        }
        return res;
    }

    public void BFS(int[][] matrix, boolean[][] visited, Queue<int[]> que){
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        while(!que.isEmpty()){
            int[] point = que.poll();
            for(int[] di:direction){
                int x = point[0] + di[0];
                int y = point[1] + di[1];
                if(x<0 || x > ncol || y < 0 || y > nrow || visited[x][y] == true ||
                        matrix[x][y]<matrix[point[0]][point[1]])
                    continue;
                visited[x][y] = true;
                que.offer(new int[]{x,y});
            }
        }
    }
}
