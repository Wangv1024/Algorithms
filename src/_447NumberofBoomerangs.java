import java.util.HashMap;

/**
 * Created by weihengwang on 2/1/17.
 */
public class _447NumberofBoomerangs {
    public static int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer>[] hmarr = new HashMap[points.length];
        for(int i = 0; i < hmarr.length; i++)
            hmarr[i] = new HashMap<>();

        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){

                int dist = getdist(points[i], points[j]);
                if( !hmarr[i].containsKey(dist) )
                    hmarr[i].put(dist, 0);
                hmarr[i].put(dist, hmarr[i].get(dist) + 1);
                System.out.println(" i "+ i + " dist " + dist + " num " + hmarr[i].get(dist));

                if( !hmarr[j].containsKey(dist) )
                    hmarr[j].put(dist, 0);
                hmarr[j].put(dist, hmarr[j].get(dist) + 1);
                System.out.println(" j "+ j + " dist " + dist + " num " + hmarr[j].get(dist));
            }
        }
        int sum = 0;
        for(int i = 0; i < hmarr.length; i++){
            HashMap<Integer, Integer> curmap = hmarr[i];
            for(int dist : curmap.keySet()){
                int pnum = curmap.get(dist);
        //        System.out.println(points[i][0] + "," + points[i][1] + " dist: " + dist + " num " + pnum);
                sum += pnum * (pnum - 1);
            }
        }

        return sum;
    }
    public static int getdist(int[] p1, int[] p2){
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args){
        int[][] input = {{0,0},{1,0},{2,0}};
        System.out.println(numberOfBoomerangs(input));
    }
}
