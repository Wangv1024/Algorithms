/**
 * Created by weihengwang on 8/28/16.
 */
public class BestTimetoBuyandSellStockIII123 {
/*
    public static int maxProfit(int[] prices) {
        if(prices.length<=1)
            return 0;
        int len = prices.length;
        int kk = 2;
        int[][] kprofit =new int[kk+1][len];
        int maxprofit = 0;
        for(int k=1;k<=kk;k++){
            int tempMax = kprofit[k-1][0]-prices[0];
            for(int j=1;j<len;j++){
                kprofit[k][j] = Math.max(kprofit[k-1][j], tempMax+prices[j]);
                tempMax = Math.max(tempMax, kprofit[k-1][j-1]-prices[j]);
                maxprofit = Math.max(maxprofit,kprofit[k][j]);
            }
        }
        return maxprofit; */



    public static int maxProfit(int[] prices) {
        if(prices.length<=1)
            return 0;
        int len = prices.length;
        int k =2;
        int[][] pro = new int[k+1][len];
        for(int kk=1;kk<=k;kk++){
            int maxcursale = 0-prices[0];
            for(int i=1;i<len;i++){
                pro[kk][i] =Math.max(pro[kk][i-1], maxcursale+prices[i]);
                maxcursale = Math.max(maxcursale,pro[kk-1][i]-prices[i]);
            }
        }
        return pro[k][len-1];
    }
    public static void main(String[] args){
        int testPrices[] = {6,1,3,2,4,7};
        System.out.print(maxProfit(testPrices));
    }
}
