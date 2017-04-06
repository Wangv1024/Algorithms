/**
 * Created by weihengwang on 2/13/17.
 */
public class _297SerializeandDeserializeBinaryTree {
    int curindx;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        // String res = "";
        // Deque<TreeNode> st = new LinkedList<>();
        // TreeNode curnode = root;
        // while(st.isEmpty() == false || curnode != null){
        //     if(curnode == null){
        //         res = res +"N" + ",";
        //         curnode = st.pop();
        //     }
        //     if(curnode != null){
        //         res = res + Integer.toString(curnode.val) + ",";
        //   //     if(curnode.right != null)
        //         st.push(curnode.right);
        //         curnode = curnode.left;
        //     }
        // }
        StringBuilder strb = new StringBuilder();
        serier(strb, root);
        return strb.toString();
    }

    public void serier(StringBuilder strb, TreeNode tn){
        if(tn == null){
            strb.append("N").append(",");
            return;
        }
        strb.append(tn.val).append(",");
        serier(strb, tn.left);
        serier(strb, tn.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() <= 0 )
            return null;
        String[] seria = data.split(",");
        curindx = 0;
        return buildTree(seria);
    }

    private TreeNode buildTree(String[] seria){
        if( curindx >= seria.length || seria[curindx].equals("N")) {
            curindx++; // plus one when doing it.
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(seria[curindx++]));
        TreeNode left = buildTree(seria);
        TreeNode right = buildTree(seria);

        cur.left = left;
        cur.right = right;
        return cur;
    }
}
