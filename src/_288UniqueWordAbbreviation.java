import java.util.HashSet;
import java.util.Set;

/**
 * Created by weihengwang on 10/23/16.
 */
public class _288UniqueWordAbbreviation {

}
class ValidWordAbbr {
    Set<String> dict;
    public ValidWordAbbr(String[] dictionary) {
        dict = new HashSet<>();
        for(int i=0; i<dictionary.length; i++){
            if(dictionary[i].length()<=2)
                dict.add(dictionary[i]);
            else{
                String currentword = dictionary[i];
                int abbnum = currentword.length()-2;
                String entry = ""+currentword.charAt(0)+abbnum+currentword.charAt(currentword.length()-1);
                dict.add(entry);
            }
        }

    }

    public boolean isUnique(String word) {
        if(word.length()<=2)
            return !dict.contains(word);
        StringBuilder strb = new StringBuilder();
        int len = word.length()-2;
        strb.append(word.charAt(0));
        strb.append(len);
        strb.append(word.charAt(word.length()-1));

        return !dict.contains(strb.toString());
    }
    public static void main(String[] args) {
        int a =12;
        String as = "";
        as = as + a;
        System.out.println(as);
    }
}
