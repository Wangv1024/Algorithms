import java.util.HashMap;

/**
 * Created by weihengwang on 9/27/16.
 */
public class IntegertoEnglishWords273 {
    public static String numberToWords(int num) {
        if(num==0)
            return "Zero";
        String[] tab = {"", "Thousand", "Million", "Billion"};
        HashMap <Integer,String> dict = new HashMap<>();
        dict.put(1,"One");dict.put(2,"Two");dict.put(3,"Three");dict.put(4,"Four");
        dict.put(5,"Five");dict.put(6,"Six");dict.put(7,"Seven");dict.put(8,"Eight");dict.put(9,"Nine");
        dict.put(10,"Ten");dict.put(11,"Eleven");dict.put(12,"Twelve");dict.put(13,"Thirteen");
        dict.put(14,"Fourteen");dict.put(15,"Fifteen");dict.put(16,"Sixteen");dict.put(17,"Seventeen");
        dict.put(18,"Eighteen");dict.put(19,"Nineteen");dict.put(20,"Twenty");dict.put(30,"Thirty");
        dict.put(40,"Forty");dict.put(50,"Fifty");dict.put(60,"Sixty");dict.put(70,"Seventy");
        dict.put(80,"Eighty");dict.put(90,"Ninety");
        String res = "";
        int i =0;
        while(num>0) {
            int current = num%1000;
            num = num/1000;
            String string =paserhundred(current, dict);
            if(i==0)
                res = string;
            else
                res = (string.length()==0)? res: string+" "+tab[i]+ (res.length()==0? res:" "+res);
            i++;
        }
        return res;
    }
    public static String paserhundred(int num, HashMap<Integer,String> dict) {
        if(num==0)
            return "";
        int hundred = num / 100;
        int tenth = num %100 - num%10;
        int lst = num % 10;
        String res = (hundred == 0 )? "":dict.get(hundred)+" Hundred";
        if(dict.containsKey(tenth+lst)){
            res = ( res.length()==0 )? dict.get(tenth+lst) : res +" "+ dict.get(tenth+lst);
            return res;
        }
        res = (tenth == 0)? res : (res.length()==0? res:res+" ") +dict.get(tenth);
        res = (lst==0)? res : (res.length()==0? res:res+" ") + dict.get(lst);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(1000));
    }
}
