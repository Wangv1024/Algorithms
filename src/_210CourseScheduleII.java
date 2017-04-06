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
}
