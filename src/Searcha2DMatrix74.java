/**
 * Created by weihengwang on 9/2/16.
 */
public class Searcha2DMatrix74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length<=0 || matrix[0].length<=0){
            return false;
        }
        int rowst = 0;
        int colst = matrix[0].length-1;
        int rowlen = matrix.length;
        int collen = matrix[0].length;
        while(rowst<rowlen && colst>-1){
            if(matrix[rowst][colst]==target){
                return true;
            }
            else if(matrix[rowst][colst]<target){
                rowst++;
            }
            else
                colst--;
        }
        return false;
    }
    public static void main(String[] args){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.print(searchMatrix(matrix,15));
    }
}
