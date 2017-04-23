import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by weihengwang on 4/23/17.
 */
public class _368LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length <= 0)
            return new ArrayList<>();
        Arrays.sort(nums);
        int[] setTab = new int[nums.length];
        int[] pre = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            setTab[i] = 1;
            pre[i] = i;
        }
        int currentmaxlen = 1;
        int maxlenindex = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] % nums[j] == 0){
                    if(setTab[j] + 1 > setTab[i]){
                        setTab[i] = setTab[j] + 1;
                        pre[i] = j;
                        if(currentmaxlen < setTab[i]){
                            currentmaxlen = setTab[i];
                            maxlenindex = i;
                        }
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int index = maxlenindex;
        while(index != pre[index]){
            res.add(0, nums[index]);
            index = pre[index];
        }
        res.add(0, nums[index]);
        return res;
    }
}
