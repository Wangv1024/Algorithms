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


    ///////////////////////////////////////////
    // Plan B

    //////////////////////////////////////////

    public void wiggleSortII(int[] nums) {
        if(nums.length <= 1)
            return;
        int medIndex = nums.length / 2;
        int median = quickSelect(nums, medIndex, 0, nums.length - 1);

        int left = 0, right = nums.length - 1;
        int len = nums.length;
        for(int i = 0; i < nums.length; i++){
            if( i >= left && nums[ trans(i, len) ] > median ){
                swap(trans(i, len), trans(left, len), nums );
                left ++;
            }
            else if( i <= right && nums[trans(i, len)] < median){
                swap(trans(i, len), trans(right, len), nums);
                right--;
                i --; // left i stay on current position
            }         // so we can exam new element exchanged to current index.

    /*		if( trans(i, len) >= trans(left, len) && nums[ trans(i, len) ] > median ){
    			swap(trans(i, len), trans(left, len), nums );
    			left ++;
    		}
    		else if(trans(i, len) <= trans(right, len) && nums[trans(i, len)] < median){
    			swap(trans(i, len), trans(right, len), nums);
    			right--; i --;
    		} */
        }
    }

    private int trans(int index, int len){
        return (index * 2 + 1) % (len | 1); // (index * 2 + 1) % (index | 1);
    }
    public int quickSelect(int[] nums, int index, int st, int end){
        if(st >= end)
            return nums[st];
        int parindex = rdpartition(nums, st, end); // partindex is the
        if(parindex == index)         // pivot index of random partition.
            return nums[index];
        if(index < parindex)
            return quickSelect(nums, index, st, parindex - 1);
        else
            return quickSelect(nums, index, parindex + 1, end);
    }
    private int rdpartition(int[] nums, int st, int end){
        if(st >= end)
            return st;
        Random rd = new Random();
        int piv = rd.nextInt(end - st + 1) + st;
        swap(st, piv, nums);
        int pivot = nums[st];

        int left = st, right = end + 1;
        while(true){
            while(++left <= end && nums[left] < pivot);
            while(--right > st && nums[right] > pivot);
            if(left >= right)
                break;
            swap(left, right, nums);
        }
        swap(st, right, nums);
        return right;
    }
    private void swap(int i1, int i2, int[] nums){
        if(i1 == i2)
            return;
        nums[i1] = nums[i1] ^ nums[i2];
        nums[i2] = nums[i1] ^ nums[i2];
        nums[i1] = nums[i1] ^ nums[i2];
    }
}

