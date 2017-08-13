/**
 * Created by weihengwang on 6/7/17.
 */
public class _255VerifyPreorderSequenceinBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        int stpt = -1;
        if(preorder.length <= 1)
            return true;
        Integer lowbound = null;
        for(int i = 0; i < preorder.length; i++){
            int curnum = preorder[i];
            if(lowbound != null && curnum <= lowbound)
                return false;

            while(stpt != -1 && preorder[stpt] < curnum){
                lowbound = preorder[stpt];
                stpt --;
            }

            preorder[ ++stpt ] = curnum;
        }
        return true;
    }

    public boolean verifyPreorder1(int[] preorder) {
        if(preorder.length <= 1)
            return true;
        int stPointer = -1;
        Integer lowbound = null;

        for(int i = 0; i < preorder.length; i++){
            int curnum = preorder[i];

            if(lowbound != null && lowbound >= curnum)
                return false;  // curnumber smaller than lowbound, not a valid preorder sequence

            if(stPointer == -1 || curnum < preorder[ stPointer ] ){
                stPointer++;
                preorder[stPointer] = curnum;
            }
            else {  // We assume all elements in array are unique.
                while(stPointer != -1 && curnum > preorder[stPointer] ){
                    lowbound = preorder[stPointer];
                    stPointer --;
                }
                stPointer ++;
                preorder[stPointer] = curnum;
            }
        }
        return true;
    }
}
