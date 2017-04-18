import java.util.HashMap;

/**
 * Created by weihengwang on 4/11/17.
 */
public class _13RomantoInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> dict = new HashMap<>();
        dict.put('I',1);
        dict.put('V', 5);  // "V" totally wrong
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            if(i < s.length() - 1 && dict.get(s.charAt(i)) < dict.get(s.charAt(i + 1)))
                num = num - dict.get(s.charAt(i));
            else
                num = num + dict.get(s.charAt(i));
        }
        return num;
    }
}
