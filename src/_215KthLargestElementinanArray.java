import java.util.Arrays;
import java.util.Random;

/**
 * Created by weihengwang on 2/13/17.
 */
public class _215KthLargestElementinanArray {
//    public static int findKthLargest(int[] nums, int k) {
//        shuffle(nums);
//        return quickselect(nums, nums.length - k, 0, nums.length - 1);
//    }
//
//    public static int quickselect(int[] nums, int indx, int start, int end){
//
//        int paritionidx = partition(nums, start, end);
//
//        if (paritionidx == indx)
//            return nums[indx];
//        else if (paritionidx > indx)
//            return quickselect(nums, indx, start, paritionidx - 1); // Get side wrong
//        else
//            return quickselect(nums, indx, paritionidx + 1, end); // get side wrong
//
//    }
//
//    public static int partition(int[] nums, int st, int end){
//        if(st > end)
//            return -1;
//        if(st == end)
//            return st;
//        int pivot = nums[st];
//        int i = st, j = end + 1;
//        while(true){
////            while(++i < end && nums[i] < pivot);
////            while(--j > st + 1 && nums[j] > pivot);
//            while(i < end && nums[++i] < pivot);
//            while(j > st && nums[--j] > pivot);
//            if( i >= j )
//                break;
//            swap(nums, i, j);
//        }
//        swap(nums, st, j);
//        return j;
//    }
    public static void shuffle(int[] nums){
        Random rd = new Random();
        for(int i = 0; i < nums.length; i++){
            int nextid = rd.nextInt(nums.length);
            swap(nums, nextid, i);
        }
    }
    private static void swap(int[] nums, int one, int two){
        int tmp = nums[one];
        nums[one] = nums[two];
        nums[two] = tmp;
    }

    public static void main(String[] args){
        int[] tt = {1,6,2,9,11,4,8,16};
        System.out.println(findKthLargest(tt, 1));

        System.out.println(Arrays.toString(tt));
    }


      public static int findKthLargest(int[] nums, int k) {
          shuffle(nums);
          return quickSelect(nums, 0, nums.length - 1, nums.length - k);
      }

      public static int quickSelect(int[] nums, int st, int end, int ith){
          if(st >= end)
              return nums[st];

          int pindx = partition(nums, st, end);

          if(pindx == ith)
              return nums[ith];
          else if(pindx > ith)
              return quickSelect(nums, st, pindx - 1, ith);
          else
              return quickSelect(nums, pindx + 1, end, ith);
      }

//      public static int partition(int[] nums, int st, int end){
//          if(st >= end)
//              return st;
//          int pivot = nums[st];
//          int leftp = st, rightp = end + 1;
//          while(true){
//              while(++leftp < end && nums[leftp] < pivot);
//              while(--rightp > st && nums[rightp] > pivot);
//              if(leftp >= rightp){
//                  break;
//              }
//              swap(nums, leftp, rightp);
//          }
//          swap(nums, rightp, st);
//          return rightp;
//      }

      public static int partition(int[] nums, int st, int end){
          if(st >= end)
              return st;
          int pivot = nums[st];
          int lp = st, rp = end + 1;
          int i = st + 1;
          while(i < rp){
              if( i < rp && nums[i] > pivot) {
                  rp--;
                  swap(nums, i, rp);
              }
              else if( i > lp && nums[i] < pivot){
                  lp++;
                  swap(nums, lp, i);
              }
              else
                  i++;
          }
          swap(nums, lp, st);
          return lp;
      }
}
