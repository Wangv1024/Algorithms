/**
 * Created by weihengwang on 8/5/17.
 */
public class _330PatchingArray {
    public int minPatches(int[] nums, int n) {
        long low = 0, range = 0;  // Use long, rather than int,  overflow int will became negative.
        int numspt = 0;
        int count = 0;
        for(long st = 1; st <= n; ++ st){

            if( numspt < nums.length && nums[ numspt ] <= st){
                range = range + nums[ numspt ++ ];
                st = range;
            }
            else if( st <= range ){
                st = range;
            }
            //		else if(numspt >= nums.length || st < nums[numspt]){
            else{
                range = range + st;
                st = range;
                ++ count;
            }
        }
        return count;
    }
}
