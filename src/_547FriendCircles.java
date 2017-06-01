import java.util.*;
/**
 * Created by weihengwang on 5/12/17.
 */
public class _547FriendCircles {
    public int findCircleNum(int[][] M) {
        if(M.length <= 0)
            return 0;
        int circle = 0;
        boolean[] visited = new boolean[M.length];
        for(int Id = 0; Id < visited.length; Id ++){
            int circlenum = bfsExplore(visited, M, Id);
            circle = circle + circlenum;
        }
        return circle;
    }
    private int bfsExplore(boolean[] visited, int[][] matrix, int id){
        Queue<Integer> qu = new LinkedList<>();
        if(visited[id] == true)
            return 0;
        visited[id] = true;

        qu.offer(id);
        while( !qu.isEmpty() ){
            int newid = qu.poll();
            // if(visited[newid] == true)
            //     continue;

            for(int i = 0; i < matrix[newid].length; i++){
                if(matrix[newid][i] == 1 && visited[i] == false){
                    qu.offer(i);
                    visited[i] = true;
                }
            }
        }

        int size = 1;
        return size;
    }
}
