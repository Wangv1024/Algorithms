/**
 * Created by weihengwang on 5/16/17.
 */
public class _364NestedListWeightSumII {
//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        int weighted = 0, unweighted = 0;
//        while( !nestedList.isEmpty()){
//            List<NestedInteger> nextlevel = new LinkedList<>();
//            for(NestedInteger num : nestedList){
//                if(num.isInteger())
//                    unweighted += num.getInteger();
//                else
//                    nextlevel.addAll(num.getList());
//            }
//            weighted += unweighted;
//            nestedList = nextlevel;
//        }
//        return weighted;
//    }


//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        List<Integer> levelsum = new ArrayList<>();
//        List<NestedInteger> nextLev = new ArrayList<>();
//        while(nestedList.size() > 0 ){
//            int curlevel = 0;
//            for(NestedInteger curnest : nestedList){
//                if(curnest.isInteger())
//                    curlevel += curnest.getInteger();
//                else
//                    nextLev.addAll(curnest.getList());
//            }
//            levelsum.add(curlevel);
//            nestedList = nextLev;
//            nextLev = new ArrayList<>();
//        }
//        int sum = 0;
//        for(int i = levelsum.size() - 1; i >= 0 ;i--)
//            sum = sum + levelsum.get(i) * (levelsum.size() - i);
//
//        return sum;
//    }
}
