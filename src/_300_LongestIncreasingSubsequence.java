import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by weihengwang on 3/13/17.
 */
public class _300_LongestIncreasingSubsequence {
//    public static int lengthOfLIS(int[] nums) {
//        if(nums.length <= 1)
//            return nums.length;
//
//        int[] tab = new int[nums.length];
//        List<Integer> seq = new ArrayList<>();
//        for(int i = 0; i < nums.length; i++){
//            if(seq.size() == 0 || nums[i] > seq.get(seq.size() - 1)) {
//                seq.add(nums[i]);
//                if(i > 0 && seq.size() > 1)
//                    tab[i] = seq.get(seq.size() - 2);
//            }
//            else {
//                int botton = 0, top = seq.size() - 1;
//                while(botton <= top){
//                    int mid = botton + ( top - botton ) / 2;
//                    if(mid < seq.size() - 1 && seq.get(mid) < nums[i] && seq.get(mid + 1) >= nums[i]) {
//                        seq.set(mid + 1, nums[i]);
//                        break;
//                    }
//                    else if( seq.get(mid) < nums[i] )
//                        botton = mid + 1;
//                    else
//                        top = mid - 1;
//                }
//                if(top < 0)
//                    seq.set(0, nums[i]);
//            }
//
//        }
//        return seq.size();
//    }

    public static int lengthOfLIS(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        int[] tab = new int[nums.length];
        for(int i = 0; i < tab.length; i++)
            tab[i] = -1;
        List<Integer> seq = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(seq.size() == 0 || nums[i] > nums[seq.get(seq.size() - 1)]) {
                if(seq.size() > 0)
                    tab[i] = seq.get(seq.size() - 1);
                seq.add(i);
            }
            else {
                int botton = 0, top = seq.size() - 1;
                while(botton <= top){
                    int mid = botton + ( top - botton ) / 2;
                    if(mid < seq.size() - 1 && nums[seq.get(mid)] < nums[i] && nums[seq.get(mid + 1)] >= nums[i]) {
                        seq.set(mid + 1, i);
                        tab[i] = seq.get(mid);
                        break;
                    }
                    else if( nums[seq.get(mid)] < nums[i] )
                        botton = mid + 1;
                    else
                        top = mid - 1;
                }
                if(top < 0)
                    seq.set(0, i);
            }
        }
        List<Integer> ori = new ArrayList<>();
        int lastindx = seq.get(seq.size() - 1 );
        while(lastindx != -1) {
            ori.add(0, nums[lastindx]); // use add to add element at index,
            lastindx = tab[lastindx];
        }
        System.out.println(ori);
        return seq.size();
    }

    public static int lengthOfLIS3(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        List<Integer> indxseq = new ArrayList<>();
        int[] prece = new int[nums.length];
        for(int i = 0; i < prece.length; i++)
            prece[i] = -1;

        for(int i = 0; i < nums.length; i++){
            if(indxseq.size() == 0 || nums[ indxseq.get(indxseq.size() - 1) ] < nums[i]){
                if(indxseq.size() > 0)
                    prece[i] = indxseq.get(indxseq.size() - 1);
                indxseq.add(i);
            }
            else{
                int top = indxseq.size() - 1, down = 0;
                while(down <= top){  // binary search in indxseq
                    int mid = down + (top - down) / 2;
                    if(nums[i] > nums[ indxseq.get(mid) ] && mid < indxseq.size() - 1 && nums[i] <= nums[indxseq.get(mid + 1) ]) {
                        indxseq.set(mid + 1, i);
                        prece[i] = indxseq.get(mid);
                        break;
                    }
                    else if(nums[i] > nums[ indxseq.get(mid) ] )
                        down = mid + 1;
                    else
                        top = mid - 1;
                }
                if(top < 0)
                    indxseq.set(0, i);
            }
        }

        List<Integer> seq = new ArrayList<>();
        int lastindx = indxseq.get(indxseq.size() - 1);
        while(lastindx != -1){   // lastindx != 0
            seq.add(0, nums[lastindx]);
            lastindx = prece[lastindx];
        }
        System.out.println(seq);

        return seq.size();
    }

    public static void main(String[] args){
    //    int[] input = {9,1,3,7,4,3,20};
        int[] input = {5,4,3,2,1};
        System.out.println(lengthOfLIS3(input));
    }
}
