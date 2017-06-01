/**
 * Created by weihengwang on 5/26/17.
 */
public class _494TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum < S)  // early stop important
            return 0;

        int newt = S + sum;
        if(newt % 2 != 0)
            return 0;
        newt = newt / 2;

        int[] tab = new int[newt + 1];
        tab[0] = 1;
        for(int num : nums){
            for(int i = newt; i - num >= 0 ; i--)
                tab[i] = tab[i] + tab[i - num];
        }
        return tab[tab.length - 1];
    }
}
