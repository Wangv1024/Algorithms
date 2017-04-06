import java.util.*;

/**
 * Created by weihengwang on 2/27/17.
 */
public class CatchingAnInsiderTrader {
//    public List<String> getnames(String[] input){
//        Set<String> res = new HashSet<>();
//        List<String> transactions = new ArrayList<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(String onerec : input){
//            String[] split = onerec.split("|");
//            if(split.length > 2){
//                transactions.add(onerec);
//            }
//            else{
//                map.put(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
//            }
//        }
//
//        for(String transac: transactions){
//            String[] record = transac.split("|");
//            String name = record[1];
//            String buyOrSell = record[2];
//            int day = Integer.parseInt( record[0] );
//            int amount = Integer.parseInt(record[3]);
//
//            if(isInsidetrader(day, amount, map, buyOrSell))
//                res.add(transac);
//        }
//        List<String> ret = new ArrayList<>(res);
//        Collections.sort(ret, new Comparator<String>(){
//            @Override
//            public int compare(String str1, String str2){
//                String[] s1 = str1.split("|");
//                String[] s2 = str2.split("|");
//
//                if( !s1[0].equals(s2[0]))
//                    return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
//                else
//                    return s1[1].compareTo(s2[1]);
//            }
//        });
//        return new ArrayList<>(res);
//    }
//    public boolean isInsidetrader(int day, int amount, HashMap<Integer, Integer> map, String buyorSell){
//        int originday = day;
//        if(buyorSell.equals("Buy")){
//            while(map.containsKey(day) == false) day--; // Assumption: day 0 must exist
//            int initialPrice = map.get(day);
//            int maxprofit = Integer.MIN_VALUE;
//            for(int i = 1; i <= 3; i++){
//                if(map.containsKey(originday + i))
//                    maxprofit = Math.max(maxprofit, (map.get(originday + i) - map.get(initialPrice)) * amount );
//            }
//            if(maxprofit >= 5000000)
//                return true;
//        }
//        else{
//            while(map.containsKey(day) == false) day--; // Assumption: day 0 must exist, day will be positive
//            int initialPrice = map.get(day);
//            int maxprofit = Integer.MIN_VALUE;
//            for(int i = 1; i <= 3; i++){
//                if(map.containsKey(originday + i))
//                    maxprofit = Math.max(maxprofit, (map.get(initialPrice) - map.get(originday + i) ) * amount );
//            }
//            if(maxprofit >= 5000000)
//                return true;
//        }
//        return false;
//    }
static String[] findPotentialInsiderTraders(String[] datafeed) {
    Set<String> transactions = new HashSet<>();
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(String str: datafeed){
        String[] oneRec = str.split("\\|");
        if(oneRec.length == 2){
            int date = Integer.parseInt( oneRec[0] );
            int price = Integer.parseInt( oneRec[1]);
 //           System.out.println(date + " "+ price);
            hm.put(date, price);
        }
        else if(oneRec.length == 4){
            transactions.add(str);
  //          System.out.println(str);
        }
    }

    List<String> res = new ArrayList<>();
    for(Integer key : hm.keySet())
        System.out.println("" + key + "  " + hm.get(key));

    for(String onerec : transactions){
        String[] tuple = onerec.split("\\|");
        int date = Integer.parseInt( tuple[0]);
        String name = tuple[1];
        String type = tuple[2];
//        System.out.println(name + " " + type);
        int amount = Integer.parseInt( tuple[3]);
        if(isInsideTrator(date, type, amount, hm)) {
            String newstr = new String("" + date + "|" + name);
            System.out.println("newstr" + "newstr");
            res.add(newstr);
        }
    }
    System.out.println(res);
    Collections.sort(res, new Comparator<String>(){
        @Override
        public int compare(String str1, String str2){
            String[] strgroup1 = str1.split("\\|");
            String[] strgroup2 = str2.split("\\|");
            int day1 = Integer.parseInt(strgroup1[0]);
            int day2 = Integer.parseInt(strgroup2[0]);
            if( day1 != day2)
                return day1 - day2;

            return strgroup1[1].compareTo(strgroup2[1]);
        }
    });
    String[] retur = new String[res.size()];
    for(int i = 0; i < res.size(); i++)
        retur[i] = res.get(i);
    return retur;
}
    private static boolean isInsideTrator(int date, String type, int amount, HashMap<Integer, Integer> hm){
        if(type.equals("BUY")){
            int originDate = date;
            while(hm.containsKey(date) == false) date--;
            int buyprice = hm.get(date);
            for(int i = 1; i <= 3; i++){
                if(hm.containsKey(originDate + i)){
                    System.out.println("Here11");
                    long profit = ( hm.get(originDate + i) - buyprice ) * amount;
                    System.out.println(profit);
                    if(profit >= 500000)
                        return true;
                }
                System.out.println("Here");
            }
            return false;
        }
        else{
            int originDate = date;
            while(hm.containsKey(date) == false) date--;
            int sellprice = hm.get(date);
            long loss = 0;
            for(int i = 1; i <= 3; i++){
                if(hm.containsKey(originDate + i)){
                    System.out.println("Here14");
                    loss += (sellprice - hm.get(originDate + i) ) * amount;
                    System.out.println(loss);
                    if(loss >= 500000)
                        return true;
                }
                System.out.println("Here12");
            }
            return false;
        }
    }

    public static void main(String[] args){
        String[] input = {
                "0|20",
                "0|Kristi|SELL|300",
                "0|Will|BUY|500",
                "0|Tom|BUY|5000",
                "0|Shilpa|BUY|150",
                "1|Tom|BUY|150000",
                "3|25",
                "5|Shilpa|SELL|150",
                "8|Kristi|SELL|60000",
                "9|Shilpa|BUY|50",
                "10|15",
                "11|5",
                "14|Will|BUY|10000",
                "15|Will|BUY|10000",
                "16|Will|BUY|10000",
                "17|25"

        };

        System.out.println(Arrays.toString(findPotentialInsiderTraders(input)));
    }

}
