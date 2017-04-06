import java.util.ArrayList;
import java.util.List;

/**
 * Created by weihengwang on 1/26/17.
 */
public class _95UniqueBinarySearchTreesII {
    public static List<TreeNode> generateTrees(int n){
        if(n == 0)
            return new ArrayList<>();
        return getnTree(1, n);
    }
    public static List<TreeNode> getnTree( int st, int end){
        List<TreeNode> tmp = new ArrayList<>();
        if(st > end) {
            tmp.add(null);
            return tmp;
        }
        for(int i = st; i <= end; i++){
            List<TreeNode> left = getnTree(st, i - 1);
            List<TreeNode> right = getnTree(i + 1, end);
            for(TreeNode leftroot : left)
                for(TreeNode rightroot : right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftroot;
                    root.right = rightroot;
                    tmp.add(root);
                }
        }
        return tmp;
    }

    public static void main(String[] args){
        System.out.println(generateTrees(0));
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public String toString(){
        return "" + this.val;
    }
}
