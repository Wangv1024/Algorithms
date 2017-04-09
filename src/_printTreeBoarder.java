/**
 * Created by weihengwang on 4/7/17.
 */
public class _printTreeBoarder {
    public static TreeNode buildTree(int[] preorder, int[] glob) {
        int indx = glob[0];
        if (preorder[indx] == -1) {
            glob[0]++;
            return null;
        }
        TreeNode tn = new TreeNode(preorder[indx]);
        glob[0]++;
        tn.left = buildTree(preorder, glob);
        tn.right = buildTree(preorder, glob);
        return tn;
    }
    private static void printhelper(TreeNode node, boolean isleft, boolean isright){
        if(node == null)
            return;

        if(isleft)
            System.out.print(node.val + " ");
        printhelper(node.left, isleft, false);

        if( !isleft && !isright && node.left == null && node.right == null)
            System.out.print(node.val + " ");

        printhelper(node.right, false, isright);
        if(isright && !isleft)
            System.out.print(node.val + " ");
    }

    public static void main(String[] args){

        int[] arr = {1,2,4,-1,6,-1,-1,5,8,-1,-1,-1,3,6,-1,9,-1,-1,7,-1,10,11,-1,-1,-1};
        int[] arr2 = {1, -1, 3, 6, -1, 9, -1, -1, 7, -1, 10, 11, -1, -1, -1};
        TreeNode root = buildTree(arr, new int[1]);
        printhelper(root, true, true);
    }
}

//          1                1
//         /                   \
//        2                    2
//      /                       \
//      3                        3
//     /                          \
//    4                            4
//
//1 , 2, 3, 4                   1,4,3,2
