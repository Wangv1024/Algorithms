/**
 * Created by weihengwang on 5/7/17.
 */
public class _375GuessNumberHigherorLowerII {
//    public static int getMoneyAmount(int n) {
//        if(n == 1)
//            return 0;
//
//        int[][] tab = new int[n + 2][n + 2];
//        for(int range = 2; range <= n; range ++){
//            for(int st = 1; st <= n - range + 1; st ++){
//                int end = st + range - 1;
//                int cost = Integer.MAX_VALUE;
//                for(int exp = st; exp <= end; exp ++){
//                    int tempcost = exp + Math.max(tab[st][exp - 1], tab[exp + 1][end]);
//                    cost = Math.min(tempcost, cost);
//                }
//                tab[st][end] = cost;
//            }
//        }
//        return tab[1][n];
//    }
    public static int getMoneyAmount(int n) {
        int[][] tab = new int[n + 2][n + 1];
        for(int range = 2; range <= n; range ++){
            for(int st = 1; st <= n - range + 1; st ++){
                int end = st + range - 1;
                int cost = Integer.MAX_VALUE;
                for(int exp = st; exp <= end; exp ++){
                    cost = Math.min( cost, exp + Math.max(tab[st][exp - 1], tab[exp + 1][end]) );
                }
                tab[st][end] = cost;
            }
        }
        return tab[1][n];
    }
    public static void main(String[] args){
        System.out.println(getMoneyAmount(3));
    }
}
