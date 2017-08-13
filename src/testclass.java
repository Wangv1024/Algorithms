import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by weihengwang on 10/6/16.
 */
public class testclass {
    public static void main(String[] args){
//        int[][] ne =new int[][]{{1,3},{1,2},{2,4},{3,3},{2,2},{5,3},{6,6},{7,6},{2,2}};
//
//        Arrays.sort(ne, new Comparator<int[]>(){
//            @Override
//            public int compare(int[] a1, int[] a2){
////                if(a1[0] > a2[0] && a1[1] > a2[1])
////                    return 1;
////                if(a1[0] < a2[0] && a1[1] < a2[1])
////                    return -1;
////                return 0;
//
//                if(a1[0] > a2[0] && a1[1] > a2[1])
//                    return 1;
////                if(a2[0] < a1[0] && a2[1] < a1[1])
////                    return -1;
//                return -1;
//            }
//        });
//        System.out.println(Arrays.deepToString(ne));

        int[] arr = {3,2,1,3};
    //    partition(arr, 0, arr.length - 1);
        System.out.println(quickSelect(arr, 0, arr.length - 1, (arr.length - 1) / 2));
        System.out.println(Arrays.toString(arr));

    }
    private static int quickSelect(int[] nums, int st, int end, int index){
        if(st > end)
            return Integer.MIN_VALUE;
        if(st == end)
            return nums[st];

        shuffle(nums, st, end);
        int divid = partition(nums, st, end);
        if(divid == index)
            return nums[divid];

        if(divid < index)
            return quickSelect(nums, divid + 1, end, index);
        else
            return quickSelect(nums, st, divid - 1, index);
    }

    private static int partition(int[] nums, int st, int end){
        if(st == end)
            return st;
        int pivot = nums[st];
        int l = st, r = end + 1;

        while(true){

            while(++l < end && nums[l] < pivot)
                ;
            while(--r > st && nums[r] > pivot )
                ;
            if(r <= l)
                break;
            swap(r, l, nums);
        }
        swap(st, r, nums);
        return r ;
    }
    private static void swap(int id1, int id2, int[] nums){
        if(id1 == id2)
            return;
        nums[id1] = nums[id1] ^ nums[id2];
        nums[id2] = nums[id1] ^ nums[id2];
        nums[id1] = nums[id1] ^ nums[id2];
    }
    private static void shuffle(int[] nums, int st, int end){
        Random rd = new Random();
        for(int i = st; i <= end; i++){
            int num = rd.nextInt(i - st + 1) + st;
            swap( i, num, nums);
        }
    }
}
