import java.util.Arrays;

/**
 * Created by weihengwang on 6/18/17.
 */
public class _186ReverseWordsinaStringII {
    public void reverseWords(char[] s) {
        if(s.length <= 1)
            return;
        reverse(s, 0, s.length - 1);  // forget this part

        int prev = 0;
        for(int i = 0; i < s.length; i++){
            if(i + 1 == s.length || s[i + 1] == ' '){
                reverse(s, prev, i);
                //  i = i + 1;
                //  prev = i + 2;  // bugs !!! updating wrong
                prev = i + 2;
                i = i + 1;
            }
        }
    }
    private void reverse(char[] arr, int st, int end){
        if(st >= end)
            return;
        while(st < end)
            swap(arr, st ++, end --);
    }
    private void swap(char[] arr, int st, int end){
        if(st == end)
            return ;
        arr[st] = (char) (arr[st] ^ arr[end]);
        arr[end] = (char) (arr[st] ^ arr[end]);
        arr[st] = (char) (arr[st] ^ arr[end]);
    }

    public static void main(String[] args){
        char[] arr = "blue is the sky".toCharArray();
        _186ReverseWordsinaStringII obj = new _186ReverseWordsinaStringII();
        obj.reverseWords(arr);
        System.out.println(Arrays.toString(arr));
    }
}
