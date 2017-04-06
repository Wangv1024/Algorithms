/**
 * Created by weihengwang on 3/15/17.
 */
public class _306AdditiveNumber {
    public static boolean isAdditiveNumber(String num) {
        if(num.length() <= 2)
            return false;

        for(int trd = 2; trd < num.length() ; trd++){  // third number has to contains at least number, so trd has to be a valid index
            for(int sec = 1; sec < trd; sec ++){
                if(num.charAt(0) == '0' && sec >= 2) // first num start with leading 0 and length > 1 is invalid. like "01"
                    return false;

                if(num.charAt(sec) == '0' && trd - sec >= 2) // second num start with leading 0 and second num has length >= 2 is invalid
                    continue;

                long first = Long.parseLong(num.substring(0, sec));
                long second = Long.parseLong(num.substring(sec, trd));

                long third = first + second;

                if(verifyfollowing(num.substring(trd), second, third))
                    return true;
            }
        }
        return false;
    }
    public static boolean verifyfollowing(String str, long second, long tobeveri){
        if(str.length() == 0)
            return true;

        for(int verify = 0; verify < str.length(); verify++){ // verify str from 0 to range of last letter
            if(str.charAt(0) == '0' && verify > 0)
                return false;

            long tmp = Long.parseLong(str.substring(0, verify + 1));
            if(tmp == tobeveri && verifyfollowing(str.substring(verify + 1), tobeveri, second + tobeveri))
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        String str = "000001";
        System.out.println(isAdditiveNumber(str));
    }
}
