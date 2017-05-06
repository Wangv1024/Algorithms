import java.util.*;

/**
 * Created by weihengwang on 5/6/17.
 */
public class biggestSubSet {
    public static int getbigestSubSet(GraphNode node){
        HashMap<Integer, Integer> mapCount = new HashMap<>();
        Queue<GraphNode> que = new LinkedList<>();
        que.offer(node);

        while( !que.isEmpty()){
            GraphNode curn = que.poll();
            for(int color = 1; color <= curn.forbid.size() + 1; color ++){
                if(!curn.forbid.contains(color)) {
                    curn.color = color;
                    mapCount.put(color, mapCount.containsKey(color)? mapCount.get(color) + 1 : 1);
                    break;
                }
            }

            for(GraphNode adjNode : curn.adj){
                adjNode.forbid.add( curn.color );

                if(adjNode.color == 0){
                    que.offer(adjNode);
                    adjNode.color = -1; // node has been added to queue.
                }
            }
        }
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : mapCount.entrySet())
            max = Math.max( entry.getValue(), max);

        return max;
    }

    public static void main(String[] args){
        GraphNode n1 = new GraphNode();
        GraphNode n2 = new GraphNode();
        GraphNode n3 = new GraphNode();
        GraphNode n4 = new GraphNode();
        GraphNode n5 = new GraphNode();
        n1.adj.add(n2);
        n1.adj.add(n3);
        n2.adj.add(n1);
        n2.adj.add(n3);
        n2.adj.add(n4);
        n3.adj.add(n1);
        n3.adj.add(n2);
        n3.adj.add(n4);
        n4.adj.add(n2);
        n4.adj.add(n3);

        n5.adj.add(n3);
        n3.adj.add(n5);

        System.out.println(getbigestSubSet(n1));

    }
}
class GraphNode {
    int color;
    List<Integer> forbid = new ArrayList<>();
    List<GraphNode> adj = new LinkedList<>();
}
