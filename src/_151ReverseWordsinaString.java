/**
 * Created by weihengwang on 2/16/17.
 */
public class _151ReverseWordsinaString {
    public String reverseWords(String s) {
        String str = s.trim();
        String[] strs = str.split(" ");

        if(strs.length <= 1)
            return str;

        String res = strs[0];
        for(int i = 1; i < strs.length; i++){
            if(strs[i].length() == 0)
                continue;
            res = strs[i] + " " + res;
        }
        return res;
    }

    public static void main(String[] args){
        _151ReverseWordsinaString obj = new _151ReverseWordsinaString();
        System.out.println( obj.reverseWords(" the   sky is blue   ") );
    }
}
