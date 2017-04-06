import java.util.Stack;

/**
 * Created by weihengwang on 8/30/16.
 */
public class MaximalRectangle85 {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length<1||matrix[0].length<1)
            return 0;
        int[] height = new int[matrix[0].length+1];
        int len = matrix.length;
        int collen = matrix[0].length;
        Stack<Integer> st = new Stack<>();
        int maxarea =0;
        for(int i =0;i<len;i++){
            for(int j=0;j<=collen;j++){
                if(j<collen) {
                    height[j]=matrix[i][j]=='0'? 0:height[j]+1;
                }
                int currentHeight = (j==collen)? -1:height[j];

                if(st.empty()||height[st.peek()]<=currentHeight){
                    st.push(j);
                }
                else {
                    int top = st.peek();
                    while(!st.empty() && height[top]>currentHeight){
                        st.pop();
                        int wide = st.empty()? j:(j-st.peek()-1);
                        int area = height[top] * wide;
                        System.out.print(" j:"+j+" area:"+area+" wide:"+wide+"  ");
                        maxarea = Math.max(area,maxarea);
                        top =!st.empty()? st.peek():1;
                    }
                    st.push(j);
                }

            }
            st.clear();
            for(int k=0;k<height.length;k++)
                System.out.print(height[k]);
            System.out.print("\n");
        }
        return maxarea;
    }
    /*
    public static int maximalRectangle1(char[][] matrix) {
        if(matrix.length<1||matrix[0].length<1){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
    }*/

    public static void main(String[] args){
        char[][] testarr = {{'1','0','1','0','0'},
                            {'1','0','1','1','1'},
                            {'1','1','1','1','1'},
                            {'1','0','0','1','0'}};
        System.out.print(maximalRectangle(testarr));
    }
}
