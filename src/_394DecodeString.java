import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by weihengwang on 4/17/17.
 */
public class _394DecodeString {
    public static String decodeString(String s) {
        if(s == null || s.length() == 0)
            return "";
        Deque<String> strst = new LinkedList<>();
        Deque<Integer> numst = new LinkedList<>();
        int count = 0;
        String curstr = "";
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i)) ){
                count = count * 10 + (s.charAt(i) - '0');
            }
            else if(s.charAt(i) == '['){
//                if(curstr.length() > 0)
                strst.push(curstr);
                curstr = "";
                numst.push(count);
                count = 0;
            }
            else if(s.charAt(i) == ']'){
                String tmp = strst.pop();
                int times = numst.pop();
                while(times > 0){
                    tmp = tmp + curstr;
                    times--;
                }
                curstr = tmp;
            }
            else
                curstr = curstr + s.charAt(i);
        }
        return curstr;
    }
    public static void main(String[] args){
        String str = "3[b3[a]]";
        System.out.println(decodeString(str));
    }
}
