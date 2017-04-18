import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by weihengwang on 4/10/17.
 */
public class _12IntegertoRoman {
    public String intToRoman(int num) {
        int[] numsTab = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] Roma = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int st = 0;
        StringBuilder strb = new StringBuilder();
        while(st < numsTab.length){
            while(num >= numsTab[st]) {
                strb = strb.append(Roma[st]);
                num = num - numsTab[st];
            }

            st++;
        }
        return strb.toString();
    }
}
