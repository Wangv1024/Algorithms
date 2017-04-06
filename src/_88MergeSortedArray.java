import java.util.Arrays;

/**
 * Created by weihengwang on 2/17/17.
 */
public class _88MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int mergindx = m + n - 1;
        int s1indx = m - 1, s2indx = n - 1;
        while(s1indx >= 0 || s2indx >= 0){
            int curs1 = s1indx >= 0?  nums1[s1indx] : Integer.MIN_VALUE;
            int curs2 = s2indx >= 0?  nums2[s2indx] : Integer.MIN_VALUE;

            if(curs1 < curs2) {
                nums1[mergindx--] = curs2;
                s2indx--;
            }
            else {
                nums1[mergindx--] = curs1;
                s1indx--;
            }

        }
    }

    public static void main(String[] args){
        int[] nums1 = {1,2,5,7,0,0,0,0};
        int[] nums2 = {3,4,10,15};
        merge(nums1, 0, nums2, 4);
        System.out.println(Arrays.toString(nums1));
    }

}
