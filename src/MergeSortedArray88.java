import java.util.Arrays;

/**
 * Created by weihengwang on 9/4/16.
 */
public class MergeSortedArray88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int endind = m-1+n;
        int p1=m-1;
        int p2=n-1;
        while(p1>-1 && p2>-1){
            if(nums1[p1]>nums2[p2]){
                nums1[endind]=nums1[p1];
                --p1;
            }
            else{
                nums1[endind]=nums2[p2];
                --p2;
            }
            --endind;
        }
        while(p2>-1) {
            nums1[endind]=nums2[p2];
            --p2;
            --endind;
        }
    }
    public static void main(String[] args){
        int[] nums1 = {1,3,5,8,0,0,0};
        int[] nums2 = {2,6,7};
        merge(nums1,4,nums2,3);
        System.out.print(Arrays.toString(nums1));
    }
}
