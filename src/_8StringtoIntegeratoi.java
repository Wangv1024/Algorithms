/**
 * Created by weihengwang on 3/18/17.
 */
public class _8StringtoIntegeratoi {
//    public int myAtoi(String str) {
//        if(str.length() == 0)
//            return 0;
//        int i = 0;
//        while(i < str.length() && str.charAt(i) == ' ') i++;
//        int sign = 1, base = 0;
//        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
//            sign = str.charAt(i) == '-' ? -1 : 1;
//            i++;
//        }
//        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
//            if(base > Integer.MAX_VALUE / 10 || base == Integer.MAX_VALUE / 10 && str.charAt(i) > '7')
//                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//            base = base * 10 + str.charAt(i) - '0';
//            i++;
//        }
//        return sign * base;
//    }
    public int myAtoi(String str) {
        if (str.length() == 0)
            return 0;
        int st = 0, base = 0, sign = 1;
        while (str.charAt(st) == ' ') st++;
        if (str.charAt(st) == '+' || str.charAt(st) == '-'){
            sign = str.charAt(st) == '-' ? -1 : 1;
            st++;
        }
        while(st < str.length() && str.charAt(st) <= '9' && str.charAt(st) >= '0'){
            if(base > Integer.MAX_VALUE / 10 || base == Integer.MAX_VALUE / 10  && str.charAt(st) > '7')
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            base = base * 10 + str.charAt(st) - '0';
            st++;
        }
        return sign * base;
    }

    public static void main(String[] args){
        int remain = 8;
        StringBuilder strb = new StringBuilder();
        int dig = remain;
        switch (dig){
            case 9 : strb.append("IX"); break;
            case 8 : ; case 7 : ; case 6 : ;
            case 5 : strb.append("V"); dig -= 5;
            default : while(dig-- > 0) strb.append("I");
        }
        System.out.println(strb.toString());
    }
}
