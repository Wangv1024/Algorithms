/**
 * Created by weihengwang on 2/23/17.
 */
public class _486PredicttheWinner {
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length % 2 == 0)
            return true;

        int[][] cache = new int[nums.length][nums.length];
        int max = helper(nums, 0, nums.length - 1, cache);
        int sum = 0;
        for(int num : nums)
            sum = sum + num;

        return (max * 2) >= sum;
    }

    private int helper(int[] nums, int st, int end, int[][] cache){
        if(st > end)
            return 0;
        if(st == end)
            return nums[st];
        if(cache[st][end] != 0)
            return cache[st][end];

        int max1 = nums[st] + Math.min(helper(nums, st + 1, end - 1, cache), helper(nums,st + 2, end, cache));
        int max2 = nums[end] + Math.min(helper(nums, st, end - 2, cache), helper(nums, st + 1, end - 1, cache));
        cache[st][end] = Math.max(max1, max2);
        return cache[st][end];
    }

    public static void main(String[] args){
        _486PredicttheWinner obj = new _486PredicttheWinner();
        int[] input = {1,5,233,7,2};
        System.out.println(obj.PredictTheWinner(input));
    }
}
