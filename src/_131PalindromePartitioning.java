import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by weihengwang on 3/2/17.
 */
public class _131PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        if(s.length() == 0)
            return res;
        helper(s, res, new ArrayList<String>(), 0);
        return res;
    }

    public void helper(String str, List<List<String>> res, List<String> tmp, int st){
        if(st >= str.length()){
            List<String> added = new ArrayList<>(tmp);
            res.add(added);
            return;
        }

        for(int i = st; i < str.length(); i++){
            if(isPalidrome(str.substring(st, i + 1))){
                tmp.add(new String(str.substring(st, i + 1)));
                helper(str, res, tmp, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }

    }
    public boolean isPalidrome(String s){
        int left = 0, right = s.length() - 1;
        while(left < right && s.charAt(left) == s.charAt(right)){
            left++;
            right--;
        }
        return left == right;
    }
}
