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

    public int maxProfit2(int k, int[] prices) {
        int[] tab = new int[prices.length];
        int[] prevtab = new int[prices.length];
        // tab[j][i] means biggest profit gained so far at time i which using j times transactions.
        if(prices.length <= 1)
            return 0;
        if(k >= prices.length / 2)
            return shortcut(prices);


        for(int times = 1; times <= k; times ++){
            int bestBuy = - prices[0];
            for(int i = 1; i < prices.length; i++){
                tab[i] = Math.max(tab[i - 1], bestBuy + prices[i] );
                bestBuy = Math.max(bestBuy, prevtab[i] - prices[i]);
            }
            int[] tmp = prevtab;
            prevtab = tab;
            tab = tmp;
        }
        return prevtab[prices.length - 1];
    }
    private int shortcut(int[] prices){
        int profit = 0;
        for(int i = 1; i < prices.length; i++)
            if(prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        return profit;
    }
}
