import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by weihengwang on 10/6/16.
 */
public class testclass {
    public static void main(String[] args){
        int[][] ne =new int[][]{{1,3},{1,2},{2,4},{3,3},{2,2},{5,3},{6,6},{7,6},{2,2}};

        Arrays.sort(ne, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2){
//                if(a1[0] > a2[0] && a1[1] > a2[1])
//                    return 1;
//                if(a1[0] < a2[0] && a1[1] < a2[1])
//                    return -1;
//                return 0;

                if(a1[0] > a2[0] && a1[1] > a2[1])
                    return 1;
//                if(a2[0] < a1[0] && a2[1] < a1[1])
//                    return -1;
                return -1;
            }
        });
        System.out.println(Arrays.deepToString(ne));
    }
}
