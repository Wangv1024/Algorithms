import java.util.LinkedList;
import java.util.List;

/**
 * Created by weihengwang on 3/19/17.
 */
public class _17LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","xyz"};
        LinkedList<String> qu = new LinkedList<>();
        qu.add("");
        for(int i = 0; i < digits.length(); i++){
            int num = digits.charAt(i) - '0';
            while(qu.peek().length() == i) {
                String str = qu.remove();
                for (char ch : mapping[num].toCharArray()) {
                    qu.add(str + ch);
                }
            }
        }
        return qu;
    }
}
