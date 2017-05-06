import java.util.Random;

/**
 * Created by weihengwang on 5/4/17.
 */
public class _384ShuffleanArray {
    int[] origin;
    Random rd;
    public _384ShuffleanArray(int[] nums) {
        origin = nums;
        rd = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ret = origin.clone();
        for(int i = 0; i < ret.length; i++){
            int exch = rd.nextInt(i + 1);
            swap(ret, exch, i);
        }
        return ret;
    }
    private void swap(int[] arr, int i1, int i2){
        if(i1 == i2)
            return;
        arr[i1] = arr[i1] ^ arr[i2];
        arr[i2] = arr[i1] ^ arr[i2];
        arr[i1] = arr[i1] ^ arr[i2];
    }
}
