import java.util.Arrays;
import java.util.Random;

/**
 * Created by weihengwang on 2/13/17.
 */
public class _324WiggleSortII {
    public static void wiggleSort(int[] nums) {
        if(nums.length <= 1)
            return ;
        shuffle(nums);
        int len = nums.length;
        int median = quickselect(nums, (nums.length - 1) / 2, 0, nums.length - 1);

        int left = -1, right = nums.length, i = 0;
        while( i < right){
            if(i < right && nums[ vitualindx(i, len) ] < median ) {  // bugs  > median
                swap(nums, vitualindx(i, len), vitualindx( --right, len));
          //      right--;
            }
            else if( i > left && nums[vitualindx(i, len)] > median){  // bugs  < median
                swap(nums, vitualindx(i, len), vitualindx( ++left, len));
         //       left ++;
            }
            else
                i++;
        }
    }
    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static int vitualindx(int idx, int len){
        return (2 * idx + 1) % (len | 1); //   (2 * idx + 1) % (idx | 1);
    }

    public static void shuffle(int[] nums){
        Random rd = new Random();
        for(int i = 0; i < nums.length; i++){
            swap(nums, i, rd.nextInt(nums.length));
        }
    }

    public static int quickselect(int[] nums, int idx, int st, int end){
        if(nums.length == 1 )
            return nums[0];

        int newindx = partition(nums, st, end);
        if(newindx == idx)
            return nums[idx];
        else if(newindx < idx)
            return quickselect(nums, idx, newindx + 1, end);
        else
            return quickselect(nums, idx, st, newindx - 1);
    }
    public static int partition(int[] nums, int st, int end){
        if(nums.length == 1)
            return 0;
        int pivot = nums[st];
        int i = st, j = end + 1;
        while(true){
            while( ++i < end && nums[i] < pivot );
            while( --j > st  && nums[j] > pivot );
            if( i >= j)  // (i <= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, st, j);
        return j;
    }
    public static int partition2(int[] nums, int st, int end){
        if(nums.length == 1)
            return nums[0];
        int left = st, right = end + 1, pivot = nums[st], i = st + 1;
        while( i < right){
            if( i < right && nums[i] > pivot ){
                swap(nums, i, --right);
            }
            else if(left < i && nums[i] < pivot )
                swap(nums, i, ++left);
            else
                i++;
        }
        swap(nums, right - 1, st);
        return right - 1;
    }

    public static void main(String[] args){
        int[] arr = {7,1,2,4,14,3,8};
        wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

