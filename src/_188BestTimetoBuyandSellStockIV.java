/**
 * Created by weihengwang on 5/21/17.
 */
public class _188BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if(prices.length <= 1 || k <= 0)
            return 0;
        if(prices.length / 2 <= k)
            return shortCut(prices);
        int[][] profit = new int[k + 1][prices.length];
        for(int count = 1; count <= k; count ++){
            int bestbuy = -prices[0];
            for(int i = 1; i < prices.length; i++){
                profit[count][i] = Math.max(profit[count][i - 1], bestbuy + prices[i]);
                bestbuy = Math.max(bestbuy, profit[count - 1][i - 1] + prices[i]);
            }
        }
        return profit[k][prices.length - 1];
    }

    private int shortCut(int[] prices){
        int sum = 0;
        for(int i = 1; i < prices.length; i++)
            if(prices[i] - prices[i - 1] > 0)
                sum += prices[i] - prices[i - 1];
        return sum;
    }
}
