import java.util.*;

/**
 * Created by weihengwang on 3/30/17.
 */
public class _218TheSkylineProblem {
    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<Locate> houseposi = new PriorityQueue<>(10, new Comparator<Locate>(){
            @Override
            public int compare(Locate l1, Locate l2){
                return l1.xposi - l2.xposi;
            }
        });  // position will be sort by x cordinary
        for(int[] onebuilding : buildings){
            int leftposi = onebuilding[0];
            int rightposi = onebuilding[1];
            Building newbuilding = new Building(onebuilding[2]);
            Locate left = new Locate(leftposi, newbuilding);
            Locate right = new Locate(rightposi, newbuilding);
            right.isend = true;

            houseposi.offer(left);
            houseposi.offer(right);
        }

        PriorityQueue<Building> heightQue = new PriorityQueue<>(10, new Comparator<Building>(){
            @Override
            public int compare(Building b1, Building b2){
                return b2.height - b1.height;
            }
        });

        while(houseposi.isEmpty() == false){
            Locate curlocate = null;
            do{
                curlocate = houseposi.poll();
                if(curlocate.isend == true){
                    curlocate.build.isvalid = false;  // current building ended
                }
                else{
                    heightQue.offer(curlocate.build);
                }
            }while(houseposi.isEmpty() == false && curlocate.xposi == houseposi.peek().xposi);

            while(heightQue.isEmpty() == false && heightQue.peek().isvalid == false)
                heightQue.poll();

            int xposition = curlocate.xposi;
            int height = heightQue.isEmpty() ? 0 : heightQue.peek().height;
            if(res.size() > 0 && res.get(res.size() - 1)[1] == height )
                continue;
            else
                res.add(new int[]{xposition, height});
        }
        return res;
    }

    public static List<int[]> getSkyline2(int[][] buildings) {
        PriorityQueue <Integer> heightQue = new PriorityQueue<>(10, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        List<int[]> houseEdges = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        for(int[] onehouse : buildings){
            int height = onehouse[2];
            int left = onehouse[0];
            int right = onehouse[1];
            houseEdges.add(new int[]{left, - height});
            houseEdges.add(new int[]{right, height});
        }
        Collections.sort(houseEdges, new Comparator<int[]>(){
            @Override
            public int compare(int[] edg1, int[] edg2){
                if(edg1[0] != edg2[0])
                    return edg1[0] - edg2[0];
                return edg1[1] - edg2[1];
            }
        });
        int prevheight = 0;
        for(int[] onehouseEdge : houseEdges){
            if(onehouseEdge[1] < 0)  // onehouseEdge < 0 means it is start point of house  > 0 means end point
                heightQue.offer( - onehouseEdge[1]);
            else
                heightQue.remove(onehouseEdge[1]);

            int currentHeight = heightQue.isEmpty() ? 0 : heightQue.peek();
            if(currentHeight == prevheight)
                continue;
            else {
                result.add(new int[]{onehouseEdge[0], currentHeight});
                prevheight = currentHeight;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[][] input = {{3,8,5},{3,8,7},{3,8,2}};
        List<int[]> res = getSkyline2(input);
        for(int[] re : res)
            System.out.println(Arrays.toString(re));
    }
}
class Locate{
    int xposi;
    Building build;
    boolean isend;
    public Locate(int x, Building bui){
        build = bui;
        xposi = x;
    }
}
class Building{
    int height;
    boolean isvalid = true;
    public Building(int hei){
        height = hei;
    }
}