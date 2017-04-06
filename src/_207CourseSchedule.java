import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by weihengwang on 3/6/17.
 */
public class _207CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 1)
            return true;

        Queue<Integer> que = new LinkedList<>();
        List<Integer>[] graph = (List<Integer>[]) new List[numCourses];
        int[] indegree = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++){
            int prerequire = prerequisites[i][0];
            int course = prerequisites[i][1];
            if(graph[prerequire] == null){
                graph[prerequire] = new LinkedList<>();
            }
            graph[prerequire].add(course);
            indegree[course]++;
        }

        for(int i = 0; i < indegree.length; i++)
            if(indegree[i] == 0)
                que.offer(i);

        while(que.isEmpty() == false){
            int curcourse = que.poll();
            if(graph[curcourse] == null)
                continue;
            for(int followcourse : graph[curcourse]){  //  graph[curcourse] can not be empty
                indegree[followcourse]--;
                if(indegree[followcourse] == 0)
                    que.offer(followcourse);
            }
        }

        for(int i = 0; i < indegree.length; i++)
            if(indegree[i] != 0)
                return false;
        return true;
    }

    public static void main(String[] args){
        int[][] input1 = {{1,0},{1,2}};
        System.out.println(canFinish(3 , input1));
    }
}
