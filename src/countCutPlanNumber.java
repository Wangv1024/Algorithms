import java.util.*;

/**
 * Created by weihengwang on 5/2/17.
 */
public class countCutPlanNumber {
    public static int countCutRobPlan(int[] prices, int length){
        int[] profit = new int[length + 1];
        profit[0] = 0;

        int[] lastcut = new int[length + 1];
        lastcut[0] = 1;

        for(int len = 1; len <= length; len ++){ // get maximum price at len
            for(int sublen = 0; sublen < len ; sublen ++){
                if(prices[len - sublen - 1] + profit[ sublen ] > profit[len]) {
                    profit[len] = prices[len - sublen - 1] + profit[ sublen ];
                }
            }
        }

        int[][] count = new int[length + 1][length + 1]; // count[ cutUpbound ][ length ]

        for(int i = 0; i < count.length; i++)
            for(int j = 0; j < count[0].length; j++)
                count[i][j] = -1;

        int total = countNumber(count, length, length, profit, prices);
        System.out.println("total: " + total );


        Set<String> se = new HashSet<>();
        dfsCount(profit, prices, se, new ArrayList<Integer>(), profit.length - 1);
        System.out.println(se);

        return total;
    }
    private static int countNumber(int[][] count, int cutupbound, int remainLen, int[] profit, int[] prices){
        if(remainLen < 0)
            return 0;

//        if( count[len] != -1 )  // index is the table index we want to fill in.
//            return count[len];
//        count[len] = 0; // set it as 0 to start accumulate sum

        if(remainLen == 0)
            return 1;
        if(count[cutupbound][remainLen] != -1)
            return count[cutupbound][remainLen];

        int num = 0;
//        for(int cut = cutupbound; cut >= 1; cut --){  // cut  1, 2,  ... cutUpBound
        for(int cut = 1; cut <= cutupbound && cut <= remainLen; cut ++){  // cut  1, 2,  ... cutUpBound
            if(profit[remainLen] == profit[remainLen - cut] + prices[cut - 1]) {
//                count[len] = count[len] + countNumber(count, cut, len - cut, profit, prices);
                num = num + countNumber(count, cut, remainLen - cut, profit, prices);
            }
        }
        count[cutupbound][remainLen] = num;
        return num;
    }


    private static void dfsCount(int[] profit, int[] price, Set<String> res, List<Integer> tmp, int endIndex){
        if(endIndex <= 0){
            List<Integer> newlist = new ArrayList<>(tmp);
            Collections.sort(newlist);

            StringBuilder strb = new StringBuilder();
            for(int num : newlist)
                strb.append(" " + num);
            res.add(strb.toString().trim());
            return;
        }

        for(int len = 1; len <= endIndex && len - 1 < price.length; len ++){
            if(profit[endIndex] == profit[endIndex - len] + price[len - 1]){
                tmp.add(len);

                dfsCount(profit, price, res, tmp, endIndex - len);
                tmp.remove(tmp.size() - 1);
            }

        }
    }


    public static void main(String[] args){
   //     int[] arr = {1, 5, 8, 9, 10, 17, 18, 20};
        int[] arr = {4, 8, 8, 9, 10, 17, 18};
        System.out.println(countCutRobPlan(arr, 6));
   //      System.out.println(countCutRobPlan(arr, 7));
    }
}
