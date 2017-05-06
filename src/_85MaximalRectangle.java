import java.util.*;

/**
 * Created by weihengwang on 5/6/17.
 */
public class _85MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length <= 0 || matrix[0].length <= 0)
            return 0;
        int[] heights = new int[matrix[0].length];

        int maxArea = 0;
        for(int row = 0; row < matrix.length; row ++){
            for(int col = 0; col < matrix[0].length; col ++){
                if(matrix[row][col] == '0')
                    heights[col] = 0;
                else
                    heights[col] ++;
            }

            int colMax = calculateRectangle(heights);
            maxArea = Math.max(maxArea, colMax);
        }

        return maxArea;
    }
    private int calculateRectangle(int[] heights){
        int maxArea = 0;
        Deque<Integer> indexStack = new LinkedList<>();
        for(int i = 0; i <= heights.length; i++){
            int currentheight = ( i < heights.length ?  heights[i] : -1 );

            while( !indexStack.isEmpty() && currentheight < heights[indexStack.peek()] ){
                int height = heights[indexStack.pop()];
                int width = i - 1 - ( indexStack.isEmpty()? -1 : indexStack.peek() );
                maxArea = Math.max(maxArea, height * width);
            }
            indexStack.push(i);
        }
        return maxArea;
    }
}
