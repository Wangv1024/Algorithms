import java.util.Stack;

/**
 * Created by weihengwang on 8/25/16.
 */
public class LargestRectangleinHistogram84 {
    /*
    public static int largestRectangleArea(int[] h){
        int len = h.length;
        int maxArea = 0;
        int[] st = new int[len+1];
        int p = -1;
        for(int i=0;i<=len;i++){
            int ch = (i==len)? 0:h[i];
            while(p!=-1 && h[st[p]]> ch){
                int currentheigh = h[st[p]];
                p--;
                int wid = (p==-1)? i : i-st[p]-1;
                int area = currentheigh* wid;
                maxArea = Math.max(area,maxArea);
            }
            st[++p] = i;
        }
        return maxArea;
    }*/
    /*
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxarea =0;
        int i =0;
        while(i<=len){
            int currentHeight = (i==len)? 0:heights[i];
            if(st.empty() || currentHeight >= st.peek()){
                st.push(i);
                i++;
            }
            else {
                while(!st.empty() && currentHeight <st.peek()) {
                    int tpidx = st.pop();
                    int wide = st.empty()? i:i-tpidx;
                    int area = heights[tpidx] * wide;
                    maxarea = Math.max(area, maxarea);
                }

            }
        }
        return maxarea;
    } */

    public static int largestRectangleArea(int[] heights){
        int len = heights.length;
        int stp = -1;
        int maxArea = 0;
        int[] stack = new int[len+1];
        for(int i=0;i<len+1;i++){
            int height = (i==len)? 0:heights[i];
            while(stp!=-1 && heights[stack[stp]] > height){
            //    int wid =(stp==-1)? i: i - stack[stp];
            //    int area = heights[stack[stp--]]*wid;
            //    maxArea = Math.max(area,maxArea);
              //      int hei = heights[stack[stp--]]
                    int wid =(stp-1==-1)? i: i - stack[stp-1]-1;
                    int area = heights[stack[stp--]]*wid;
                    maxArea = Math.max(area,maxArea);

            }
            stack[++stp] = i;
        }
        return maxArea;
    }
    public static void main(String[] args){
   //     int hist[] = {6, 2, 5, 4, 5, 1, 6};
        int hist[] = {2,0,2,1,1,0};
        System.out.print(largestRectangleArea(hist));
    }
}
