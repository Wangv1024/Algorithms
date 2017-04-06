import java.util.HashMap;

/**
 * Created by weihengwang on 9/15/16.
 */
public class MaxPointsonaLine149 {
    public static int maxPoints(Point[] points) {
        if(points.length<=2)
            return points.length;
        int len = points.length;
        HashMap<Integer,HashMap<Integer,Integer>> hm = new HashMap<>();
        int overlap =1;
        int max =0;
        int roundmax =0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int deltax = points[j].x-points[i].x;
                int deltay = points[j].y-points[i].y;
                if(deltax*deltay<0){
                    deltax=Math.abs(deltax);
                    deltay=-Math.abs(deltay);
                }
                else {
                    deltax=Math.abs(deltax);
                    deltay=Math.abs(deltay);
                }

                if(deltax==0 && deltay==0){
                    overlap++;
                    continue;
                }
                else if(deltax ==0)
                    deltay=1;
                else if(deltay ==0)
                    deltax=1;
                else{
                    int gcd = gcd(Math.abs(deltax),Math.abs(deltay));
                    deltax=deltax/gcd;
                    deltay=deltay/gcd;
                }

                if(hm.containsKey(deltax)){
                    if(hm.get(deltax).containsKey(deltay)){
                        int num =hm.get(deltax).get(deltay);
                        hm.get(deltax).put(deltay,num+1);
                    }
                    else{
                        hm.get(deltax).put(deltay,1);
                    }
                }
                else{
                    HashMap<Integer,Integer> newytonum =new HashMap<>();
                    newytonum.put(deltay,1);
                    hm.put(deltax,newytonum);
                }
                roundmax = Math.max(roundmax,hm.get(deltax).get(deltay));
            }
            hm.clear();
            max = Math.max(max,roundmax+overlap);
            overlap=1;
            roundmax=0;
        }
        return max;
    }

    public static int gcd(int a,int b){
        if(b==0)    return a;
        return gcd(b,a%b);
    }

    public static void main(String[] args){
   //     Point[] points ={new Point(-4,-4),new Point(-8,-582),new Point(-3,3),new Point(-9,-651), new Point(9,591)};
            Point[] points ={new Point(84,250),new Point(0,0),new Point(1,0),new Point(0,-70),new Point(0,-70), new Point(1,-1),new Point(21,10),new Point(42,90),new Point(-42,-230)};
        System.out.println(maxPoints(points));
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}