import java.util.Arrays;

/**
 * Created by weihengwang on 5/4/17.
 */
public class countCutRobPlan_BottonUp {

    public static int countCutRobPlan(int[] prices, int length){
        int[] pricesTab = new int[prices.length + 1];
        System.arraycopy(prices, 0 , pricesTab, 1, prices.length);

        int[][] profitTab = new int[length + 1][length + 1];
        int[][] countTab = new int[length + 1][length + 1];// cutUpBound,  robLength

        for(int i = 0; i <= length; i++)
            countTab[i][0] = 1;
//        for(int i = 0; i <= length; i++)  // bound == 0 is
//            countTab[0][i] = 1;

    //        int maxprof = 0;
        for(int robLen = 1; robLen <= length; robLen ++){
            for(int cutUpBound = 1; cutUpBound <= length; cutUpBound ++){ // Not cutUpBound <= robLen  Attention !!

                for(int cutTimes = 0; cutTimes <= robLen / cutUpBound; cutTimes ++ ) {
                    int tmpProfit = pricesTab[cutUpBound] * cutTimes + profitTab[cutUpBound - 1][robLen - cutTimes * cutUpBound];

                    if(tmpProfit > profitTab[cutUpBound][robLen]){
                        profitTab[cutUpBound][robLen] = tmpProfit;

                        countTab[cutUpBound][robLen] = countTab[cutUpBound - 1][robLen - cutTimes * cutUpBound];

                    }
                    else if(tmpProfit == profitTab[cutUpBound][robLen])
                        countTab[cutUpBound][robLen] += countTab[cutUpBound - 1][robLen - cutTimes * cutUpBound];

                }

            }

        }


        return countTab[length][length];
    }

    public static void main(String[] args){
        int[] arr = {1, 5, 8, 9, 10, 17, 18, 20};
//              int[] arr = {4, 8, 8, 9, 10, 17, 18};
//              System.out.println(countCutRobPlan(arr, 6));
        System.out.println(countCutRobPlan(arr, 7));
 //       countCutRobPlan(arr, 7);
    }
}
