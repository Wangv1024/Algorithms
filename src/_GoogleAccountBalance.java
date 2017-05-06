/**
 * Created by weihengwang on 4/30/17.
 */
public class _GoogleAccountBalance {
    public static int accountRebalance(int[] lenBorrow){
        boolean clear = true;
        for(int i = 0; i < lenBorrow.length; i++) {
            if (lenBorrow[i] != 0) {
                clear = false;
                break;
            }
        }
        if(clear) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < lenBorrow.length; i++){
            if(lenBorrow[i] > 0) {
                for (int j = 0; j < lenBorrow.length; j++) {
                    if (lenBorrow[j] < 0 ) {
                        int reserve_i = lenBorrow[i];
                        int reserve_j = lenBorrow[j];

                        if(Math.abs(lenBorrow[j]) > lenBorrow[i] ) {
                            lenBorrow[j] = lenBorrow[j] + lenBorrow[i];
                            lenBorrow[i] = 0;
                        }
                        else {
                            lenBorrow[i] = lenBorrow[i] + lenBorrow[j];
                            lenBorrow[j] = 0;
                        }

                        min = Math.min( accountRebalance(lenBorrow) + 1 , min);
                        lenBorrow[i] = reserve_i;
                        lenBorrow[j] = reserve_j;
                    }
                }
                break;
            }
        }
        return min;
    }
    public static void main(String[] args){
        System.out.println(accountRebalance(new int[]{-2, 3, 2, -3}));
    }
}
