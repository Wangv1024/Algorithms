/**
 * Created by weihengwang on 3/15/17.
 */
public class _4MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            int[] num = nums1.length == 0 ? nums2 : nums1;
            if(num.length % 2 == 0)
                return ( num[num.length / 2] + num[num.length / 2 - 1] ) * 1.0 / 2;
            else
                return num[num.length / 2] * 1.0;
        }

        if(nums1.length < nums2.length){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;

        int top = (len1 + len2) / 2; // top and down are index in nums1 used for searching
        int size = top;
        int botton = top - len2;
        while(top >= botton){   // mid and mid2 represents partition boundary which all number on right size of mid
                               // and mid2 includes mid and mid2 are bigger than all numbers on left side of boudary
            int mid = botton + ( top - botton ) / 2;  // mid is search index in nums1
            int mid2 = size - mid;  // mid2 is search index at nums2 array

            int top1 = mid < len1? nums1[mid] : Integer.MAX_VALUE;
            int top2 = mid2 < len2? nums2[mid2]: Integer.MAX_VALUE;

       //     int bot1 = mid > 0 ?  nums2[mid - 1] : Integer.MIN_VALUE;
            int bot1 = mid > 0 ?  nums1[mid - 1] : Integer.MIN_VALUE;
            int bot2 = mid2 > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;

            if(top2 >= bot1 && top1 >= bot2){
                if((len1 + len2) % 2 != 0 )
                    return mid == len1? nums2[mid2] : nums1[mid];

                int topmin = Math.min(top1, top2);
                int botmax = Math.max(bot1, bot2);

                return (topmin + botmax) * 1.0 / 2;
            }
            else if(top2 < bot1 ){
                top = mid - 1;
            }
            else
                botton = mid + 1;
        }
        return 1.0 * Integer.MIN_VALUE;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            int[] num = nums1.length == 0? nums2 : nums1;
            return num.length % 2 == 0? ( num[num.length / 2] + num[num.length / 2 - 1] ) * 1.0 / 2 : num[num.length / 2];
        }

        int len1 = nums1.length, len2 = nums2.length;
        int size = ( len1 + len2 ) / 2;
        int top = size, botton = size - len2;
        while(botton <= top){
            int mid1 = botton + (top - botton) / 2;
            int mid2 = size - mid1;

            int top1 = mid1 == len1 ? Integer.MAX_VALUE : nums1[mid1];
            int top2 = mid2 == len2 ? Integer.MAX_VALUE : nums2[mid2];
            int bot1 = mid1 - 1 >= 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int bot2 = mid2 - 1 >= 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;

            if(top1 >= bot2 && top2 >= bot1){
                return (len1 + len2) % 2 == 0? ( Math.min(top1, top2) + Math.max(bot1, bot2) ) * 1.0 / 2 : Math.min(top1, top2);
            }
            else if(top1 < bot2){
                botton = mid1 + 1;
            }
            else
                top = mid1 - 1;
        }
        return 1.0 * Integer.MIN_VALUE;
    }

    public static void main(String[] args){
//        int[] a1 = {3,4,5,8,10};
//        int[] a2 = {-9,-8,-7,-2,0,2};
//        System.out.println(findMedianSortedArrays(a1, a2));

        StringBuilder strb = new StringBuilder();
        strb.append("aab");
        System.out.println(strb.reverse());
        strb.deleteCharAt(strb.length() - 1);
        System.out.println(strb);
    }
}
