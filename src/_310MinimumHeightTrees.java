import java.util.*;

/**
 * Created by weihengwang on 7/30/17.
 */
public class _310MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){   // Empty input and one node situation
            List<Integer> res = new LinkedList<>();
            res.add(0);
            return res;
        }
        Set<Integer> set = new HashSet<>();
        int[] indegree = new int[n];
        List<Integer>[] adjList = ( List<Integer>[]) new List[ n ];
        for(int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            if(adjList[node1] == null)
                adjList[node1] = new LinkedList<>();
            if(adjList[node2] == null)
                adjList[node2] = new LinkedList<>();
            adjList[node1].add(node2);
            adjList[node2].add(node1);
            indegree[node1] ++;
            indegree[node2] ++;
            set.add(node1);
            set.add(node2);
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < indegree.length; i ++)
            if(indegree[i] == 1)
                que.offer(i);
        while( !que.isEmpty()){
            if(set.size() <= 2)
                break;
            int size = que.size();
            for(int i = 0; i < size; i ++){
                int id = que.poll();
                set.remove(id);
                for(int nodeId : adjList[id]){
                    indegree[nodeId] --;
                    if(indegree[nodeId] == 1){
                        que.offer(nodeId);
                    }
                }
            }
        }
        List<Integer> ls = new LinkedList<>();
        ls.addAll(set);
        return ls;
    }
}
