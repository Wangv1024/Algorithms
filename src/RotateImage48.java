/**
 * Created by weihengwang on 8/30/16.
 */
public class RotateImage48 {
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        if(len<=1){
            return;
        }
        for(int i=0;i<=(len-1)/2;i++){
            for(int j=0;j<len;j++){
                swap(matrix,i,j,len-1-i,j);
            }
        }
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                swap(matrix,i,j,j,i);
            }
        }

    }
    private static void swap(int[][] tar,int i,int j,int i1,int j1){
        int temp = tar[i][j];
        tar[i][j]=tar[i1][j1];
        tar[i1][j1]=temp;
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(matrix);
        for(int i =0;i<matrix.length;i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
