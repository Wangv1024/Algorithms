import java.util.LinkedList;
import java.util.List;

/**
 * Created by weihengwang on 6/19/17.
 */
public class _305NumberofIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] map = new int[m][n];
        int[] islandparent = new int[positions.length];
        int[] islandranks = new int[positions.length];
        int total = 0;
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < map.length; i++)
            for(int j = 0; j < map[0].length; j++)
                map[i][j] = -1;

        for(int i = 0; i < positions.length; i++){
            int row = positions[i][0];
            int col = positions[i][1];
            if(map[row][col] != -1){
                res.add(total);
                continue;
            }

            islandparent[i] = i;
            islandranks[i] = 1;


            map[row][col] = i;
            int jointimes = 0;
            if(row + 1 < map.length && map[row + 1][col] != -1){
                jointimes = union(islandparent, islandranks, i, map[row + 1][col]) ? jointimes + 1 : jointimes;
            }
            if(row - 1 >= 0 && map[row - 1][col] != -1){
                jointimes = union(islandparent, islandranks, i, map[row - 1][col]) ? jointimes + 1 : jointimes;
            }
            if(col + 1 < map[0].length && map[row][col + 1] != -1){
                jointimes = union(islandparent, islandranks, i, map[row][col + 1]) ? jointimes + 1 : jointimes;
            }
            if(col - 1 >= 0 && map[row][col - 1] != -1){
                jointimes = union(islandparent, islandranks, i, map[row][col - 1]) ? jointimes + 1 : jointimes;
            }

        	if(jointimes == 0)
                total ++;
        	else
                total = total - jointimes + 1;
        	res.add(total);
        }
        return res;
                }
        private boolean union(int[] parent, int[] ranks, int a, int b){
            int aparent = find(parent, a);
            int bparent = find(parent, b);

            if(aparent == bparent)
                return false;
            if(ranks[aparent] > ranks[bparent]){
                ranks[aparent] = ranks[aparent] + ranks[bparent];
                parent[bparent] = aparent;
            }
            else{
                ranks[bparent] = ranks[aparent] + ranks[bparent];
                parent[aparent] = bparent;
            }
            return true;
        }
        private int find(int[] parent, int a){
            while(parent[a] != parent[ parent[a] ])
            parent[a] = parent[ parent[a] ];
            return parent[a];
        }
}
