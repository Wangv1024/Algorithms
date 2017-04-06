/**
 * Created by weihengwang on 2/15/17.
 */
public class _473MatchstickstoSquare {
    public boolean makesquare(int[] nums) {
        if(nums.length < 4)
            return false;
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum = sum + nums[i];
        if(sum % 4 != 0 )
            return false;

        int oneside = sum / 4;
        int[] fourside = new int[4];
        for(int i = 0; i < 4; i++)
            fourside[i] = oneside;
        int[] register = new int[nums.length];
        return helper(0, fourside, 0, nums, register);
    }

    public boolean helper(int st, int[] fourside, int arrindx, int[] nums, int[] register){
        if(st >= fourside.length) {
            return true;
        }
        for(int i = arrindx; i < nums.length; i++){
            if(register[i] == 1)
                continue;
            if(fourside[st] >= nums[i]){ // <= bugs
                fourside[st] = fourside[st] - nums[i];
                register[i] = 1;
                if(fourside[st] == 0 && helper(st + 1, fourside, 0, nums, register) )
                    return true;
                if(fourside[st] > 0 && helper(st, fourside, i + 1, nums, register) ) // <0 bugs
                    return true;
                fourside[st] = fourside[st] + nums[i];
                register[i] = 0;
            }

        }
        return false;
    }

    public static void main(String[] args){
        _473MatchstickstoSquare obj = new _473MatchstickstoSquare();
        int[] input = {3,3,3,3,4};
        System.out.println(obj.makesquare(input));
    }
}
