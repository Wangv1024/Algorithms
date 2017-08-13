import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by weihengwang on 3/12/17.
 */
public class _210CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if(numCourses == 1)
            return res;
        List<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            int pre = edge[1];
            int course = edge[0];
            if(adj[pre] == null)
                adj[pre] = new ArrayList<Integer>();

            adj[pre].add(course);
            indegree[course]++;
        }

        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++)
            if(indegree[i] == 0)
                qu.offer(i);
        int st = 0;
        while(qu.isEmpty() == false){
            int pollout = qu.poll();
            res[st ++] = pollout;
            if(adj[ pollout ] != null){
                for(int course : adj[ pollout ]){
                    indegree[course]--;
                    if(indegree[course] == 0)
                        qu.offer(course);
                }
            }
        }
        if(st != numCourses)
            return new int[0];
        return res;
    }
// //  DFS version for topology sort
//    int pter = 0;
//    int[] res;
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        res = new int[numCourses];
//        pter = res.length - 1;
//
//        boolean[] visited = new boolean[numCourses];
//        boolean[] visiting = new boolean[numCourses];
//        List<Integer>[] adjlist = (List<Integer>[] ) new List[numCourses];
//        for(int[] oneEntry : prerequisites){
//
//            int prereq = oneEntry[1];
//            int course = oneEntry[0];
//            if(adjlist[prereq] == null)
//                adjlist[prereq] = new LinkedList<Integer>();
//            adjlist[prereq].add(course);
//        }
//
//        for(int i = 0; i < numCourses; i++)
//            if(visited[i] == false && dfsGraph(i, adjlist, visited, visiting))
//                return new int[0];
//
//        return res;
//    }
//    private boolean dfsGraph(int courseNum, List<Integer>[] adjlist, boolean[] visited, boolean[] visiting){
//        if(visited[courseNum] == true)
//            return false;
//
//        visiting[courseNum] = true;
//        for(int course : adjlist[courseNum] == null ? new LinkedList<Integer>() : adjlist[courseNum]){
//            if(visited[course] == true)
//                continue;
//            if(visiting[course] == true)
//                return true;
//            if(dfsGraph(course, adjlist, visited, visiting))
//                return true;
//        }
//        res[pter--] = courseNum;
//        visiting[courseNum] = false;
//        visited[courseNum] = true;
//
//        return false;
//    }
}
