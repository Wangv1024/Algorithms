import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by weihengwang on 4/9/17.
 */
public class findRectangle {
//    public static List<int[]> findrectan(int[][] panel){
//        int row = panel.length;
//        int col = panel[0].length;
//        boolean[][] visited = new boolean[row][col];
//
//        List<int[]> res = new ArrayList<>();
//        for(int i = 0; i < row; i++){
//            for(int j = 0; j < col; j++){
//                if(visited[i][j] == false && panel[i][j] == 0) {
//                    int[] re = dfsSearch(panel, i, j, visited);
//                    res.add(new int[]{i, j, re[0], re[1]});   // row, col, height, width
//
//            //      res.add(new int[]{i, j});
//                }
//            }
//        }
//        return res;
//    }
//    public static int[] dfsSearch(int[][] panel, int i, int j, boolean[][] visited){
//        int row = panel.length;
//        int col = panel[0].length;
//        if(i >= row || j >= col || i < 0 || j < 0)
//            return null;
//
//        if(visited[i][j] == true || panel[i][j] == 1)
//            return null;
//
//        int[] re = new int[]{i, j};
//        int[] right = dfsSearch(panel, i, j + 1, visited);
//        if(right != null) {
//            re[0] = Math.max(right[0], re[0]);
//            re[1] = Math.max(right[1], re[1]);
//        }
//
//        int[] bottom = dfsSearch(panel, i + 1, j, visited);
//        if(bottom != null) {
//            re[0] = Math.max(bottom[0], re[0]);
//            re[1] = Math.max(bottom[1], re[1]);
//        }
//
//        visited[i][j] = true;
//        return re;
//    }

    public static void main(String[] args){
        int[][] input = new int[][]{
                {1,1,1,1,1,1,1,1,1},
                {1,0,0,0,1,1,0,0,1},
                {1,0,0,0,1,1,1,1,0},
                {1,1,1,1,1,0,0,0,1}
        };
        for(int[] arr : findrectangle(input))
            System.out.println(Arrays.toString(arr));
    }
    public static List<int[]> findrectangle(int[][] panel){
        int nrow = panel.length ;
        int ncol = panel[0].length ;
        boolean[][] visited = new boolean[nrow][ncol];
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(visited[i][j] == false && panel[i][j] == 0) {
                    int[] re = dfssearch(panel, visited, i, j);
                    res.add(new int[]{i, j, re[0], re[1]});  // top left, and bottom right
                }
            }
        }
        return res;
    }
    public static int[] dfssearch(int[][] panel, boolean[][] visited, int r, int c){
        if(r < 0 || r >= panel.length || c < 0 || c >= panel[0].length)
            return null;
        if(visited[r][c] == true || panel[r][c] == 1)
            return null;
        int[] re1 = dfssearch(panel, visited, r + 1, c);
        int[] re2 = dfssearch(panel, visited, r, c + 1);

        visited[r][c] = true;

        int[] ret = new int[]{r, c};
        if(re1 != null) {
            ret[0] = Math.max(re1[0], ret[0]);
            ret[1] = Math.max(re1[1], ret[1]);
        }

        if(re2 != null){
            ret[0] = Math.max(re2[0], ret[0]);
            ret[1] = Math.max(re2[1], ret[1]);
        }

        return ret;
    }

}

