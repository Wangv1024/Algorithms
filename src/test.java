import java.util.*;

/**
 * Created by weihengwang on 1/25/17.
 */
public class test {
    public static void main(String[] args){
//        String str = "//home/foo/";
//        String[] re = str.split("/");
//        System.out.println(re.length);
//
//        for(String onestr:re){
//            System.out.print("one:");
//            System.out.println(onestr);
//        }

//        StringBuilder strb = new StringBuilder();
//        strb.insert(1,'a');
//        System.out.println(strb);
//          List<String> re = new ArrayList<>();
//          re.add("100");
//          re.add("40");
//          re.add("70");
//        Collections.sort(re);
//        System.out.println(re);

//        int[] arr = {1,2,4,-1,6,-1,-1,5,8,-1,-1,-1,3,6,-1,9,-1,-1,7,-1,10,11,-1,-1,-1};
//        int[] arr2 = {1, -1, 3, 6, -1, 9, -1, -1, 7, -1, 10, 11, -1, -1, -1};
//        TreeNode root = buildTree(arr2, new int[1]);
//        printhelper(root, true, true);

//        String a = "gr";
//        String b = "rg";
//        int[] tab = new int[256];
//        System.out.println(a.toCharArray());
//        for(char ch : a.toCharArray())
//            tab[ch]++;
//        for(char ch : b.toCharArray())
//            tab[ch]--;
//        for(int i = 0; i < tab.length; i++)
//            if(tab[i] != 0)
//                System.out.println("False");

//        String[] arr = "172.16.254.1".split("\\.");
//
//        System.out.println(Arrays.toString(arr));

//        String ss = ":12:12";
//        System.out.println(ss.split(":").length);

    //    Set<String> se = new HashSet<>();
        List<String> se = new ArrayList<>();
        System.out.println(se.size());
        se.set(0, "ss");
        for(String str : se)
            System.out.println(str);

    }
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
}
