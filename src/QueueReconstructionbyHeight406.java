import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by weihengwang on 10/10/16.
 */
public class QueueReconstructionbyHeight406 {
    public static int[][] reconstructQueue(int[][] people) {
        if(people.length<=1)
            return people;
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1,int[] a2){
                if(a2[0] != a1[0])
                    return a2[0]-a1[0];
                else
                    return a1[1]-a2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] one:people) {
            res.add(one[1],one);
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args){
        int[][] arr = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(Arrays.deepToString(reconstructQueue(arr)));
    }
}
