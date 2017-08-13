/**
 * Created by weihengwang on 6/5/17.
 */
public class _135Candy {
    public static int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        if(ratings.length <= 1)
            return ratings.length;
        candy[0] = 1;
        for(int i = 0; i < ratings.length - 1; i++){
            if(ratings[i] < ratings[i + 1])
                candy[i + 1] = candy[i] + 1;
            else
                candy[i + 1] = 1;
        }
        int total = 0;
        for(int i = ratings.length - 1; i > 0; i--){
            if(ratings[i - 1] > ratings[i])
                candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
            total += candy[i];
        }
        total += candy[0];
        return total;
    }
    public static void main(String[] args){
        System.out.println(candy(new int[]{1,2,3,3,3,1}));
    }
}
