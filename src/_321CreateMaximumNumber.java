/**
 * Created by weihengwang on 8/1/17.
 */
public class _321CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = null;
        for(int fromS1 = Math.max(0, k - len2 ); fromS1 <= len1 && fromS1 <= k; ++ fromS1 ){
            int[] a1 = getMaxArray(nums1, fromS1);
            int[] a2 = getMaxArray(nums2, k - fromS1);
            int[] candid = merge( a1, a2 );
            if(ans == null || greater(candid, ans) )
                ans = candid;
        }
        return ans;
    }
    private int[] getMaxArray(int[] nums, int k){
        int[] ans = new int[k];
        int len = nums.length;
        int anspt = 0;

        for(int i = 0; i < nums.length; ++ i){
            int num = nums[i];
            while( anspt > 0 && ans[anspt - 1] < num && len - i + anspt > k)
                -- anspt;
            if(anspt < k)
                ans[anspt ++ ] = num;
        }
        return ans;
    }
    private boolean greater(int[] candid, int[] ans){
        int len = candid.length;
        int cp = 0;
        while(cp < len && candid[cp] == ans[cp]){
            ++ cp;
        }
        return cp == len || candid[cp] > ans[cp];
    }

    private int[] merge( int[] nums1, int[] nums2 ){
        int len =  nums1.length + nums2.length;
        int l1 = nums1.length, l2 = nums2.length;

        int[] ans = new int[ len ];
        int anspt = 0, s1pt = 0, s2pt = 0;

        while(anspt < len && ( s1pt < l1 || s2pt < l2) ){
            if(s1pt == l1 ){
                ans[anspt ++] = nums2[s2pt ++];
            }
            else if(s2pt == l2 ){
                ans[anspt ++] = nums1[s1pt ++];
            }
            else if(nums1[s1pt] < nums2[s2pt]){
                ans[anspt ++] = nums2[s2pt ++];
            }
            else if(nums1[s1pt] > nums2[s2pt]){
                ans[anspt ++] = nums1[s1pt ++];
            }
            else{
                int s1 = s1pt, s2 = s2pt;
                while( nums1[s1] == nums2[s2]){
                    //	s1 = (s1 == l1 ? l1 : s1 + 1);  // Stupid bugs s2 = (s2 == l2 ? l2 : s2 + 1);
                    //	s2 = (s2 == l2 ? l2 : s2 + 1);
                    s1 = (s1 == l1 - 1 ? s1 : s1 + 1);
                    s2 = (s2 == l2 - 1 ? s2 : s2 + 1); //  s2 = (s2 == l2 - 2 ? s2 : s2 + 1);
                    if(s1 == l1 - 1 && s2 == l2 - 1)
                        break;
                }
                if(nums1[s1] > nums2[s2])
                    //				while( s1pt <= s1 )   // Can we optimize it using while
                    ans[anspt ++] = nums1[s1pt ++];
                else
                    //				while( s2pt <= s2)
                    ans[anspt ++] = nums2[s2pt ++];
            }
        }
        return ans;
    }
}
