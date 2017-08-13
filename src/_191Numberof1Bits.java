/**
 * Created by weihengwang on 6/18/17.
 */
public class _191Numberof1Bits {
    public static int hammingWeight(int n) {
        int total = 0;
        for(int i = 0; i < 32; i++){
            total += n & 1;
            n = n >>> 1;
        }
        return total;
    }
    public static void main(String[] args){
        System.out.println(hammingWeight(5));
    }
}
