import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by weihengwang on 4/4/17.
 */
public class _84LargestRectangleinHistogram {
    public static int largestRectangleArea(int[] heights) {
        if(heights.length <= 0)
            return 0;
        if(heights.length == 1)
            return heights[0];
        int maxarea = 0;
        Deque<Integer> st = new LinkedList<>();  // st is current index of histogram
        for(int i = 0; i <= heights.length; i++){
            int currenthig = i == heights.length ? 0 : heights[i];
            while(st.isEmpty() == false && heights[st.peek()] > currenthig){
                int indx = st.pop();
                int hig = heights[indx];
                int width = st.isEmpty() ? i : i - 1 - st.peek();
                maxarea = Math.max(maxarea, hig * width);
            }
            st.push(i);
        }

        return maxarea;
    }

    public static void main(String[] args){
//        int[] input = {2,6,3,4,5,1};
//        System.out.println(largestRectangleArea(input));
        String st = "sd + j";
        System.out.println(st.contains("-"));
    }
}
