/**
 * Created by weihengwang on 4/7/17.
 */
public class _536ConstructBinaryTreefromString {
    int curindex = 0;
    public TreeNode str2tree(String s) {
        if(s.length() <= 0)
            return null;
        return parseTree(s);
    }
    private TreeNode parseTree(String s){
        int stp = curindex;
        while(curindex < s.length() && s.charAt( curindex ) != '(' && s.charAt(curindex) != ')' )
            curindex++;

        int val = Integer.parseInt(s.substring(stp, curindex) );
        TreeNode tn = new TreeNode(val);

        if(curindex < s.length() && s.charAt(curindex) == '('){
            curindex++;   // get ride of '('
            tn.left = parseTree(s);
            curindex++;   // get ride of ')'
        }

        if(curindex < s.length() && s.charAt(curindex) == '('){
            curindex++;
            tn.right = parseTree(s);
            curindex++;
        }
        return tn;
    }

    public TreeNode str2tree2(String s){
        if(s.length() == 0)
            return null;
        int leftparent = s.indexOf("(");
        int val = leftparent == -1? Integer.parseInt(s) : Integer.parseInt(s.substring(0, leftparent));
        TreeNode tn = new TreeNode(val);
        if(leftparent == -1)
            return tn;
        int count = 0;
        int start = leftparent;
        boolean leftisDone = false;
        for(int i = start; i < s.length(); i++){
            if(s.charAt(i) == '(')
                count ++;
            else if(s.charAt(i) == ')')
                count--;

            if(count == 0 && !leftisDone){
                tn.left = str2tree2(s.substring(start + 1, i));
                start = i + 1;
                leftisDone = true;
            }
            else if(count == 0 && leftisDone ){
                tn.right = str2tree2(s.substring(start + 1, i));
            }
        }
        return tn;
    }

     public TreeNode parsehelper(String s, int st, int end){   // Method 3
         if(st > end)
             return null;

         int tmp = st;
         while(tmp <= end && s.charAt(tmp) != '(' && s.charAt(tmp) != ')')
             tmp++;
         int val = Integer.parseInt(s.substring(st, tmp) );
         TreeNode tn = new TreeNode(val);

         int count = 0;
         int backup = tmp;
         while(tmp <= end){
             if(s.charAt(tmp) == '(')
                 count++;
             if(s.charAt(tmp) == ')')
                 count--;
             if(count == 0)
                 break;
             tmp++;
         }
         tn.left = parsehelper(s, backup + 1, tmp - 1);
         tn.right = parsehelper(s, tmp + 2, end - 1);
         return tn;
     }
}
