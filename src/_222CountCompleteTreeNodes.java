/**
 * Created by weihengwang on 4/8/17.
 */
public class _222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int lefth = heightofNode(root.left);
        int righth = heightofNode(root.right);
        if(lefth == righth)
            return 1 + nodeCalculate(lefth) + countNodes(root.right);
        else
            return 1 + nodeCalculate(righth) + countNodes(root.left);
    }

    public int heightofNode(TreeNode node){
        if(node == null)
            return -1;
        return 1 + heightofNode(node.left);
    }

    public int nodeCalculate(int height){
        if(height < 0)
            return 0;

        return (int) Math.pow(2, height + 1) - 1;
    }
}
