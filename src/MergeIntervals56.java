/**
 * Created by weihengwang on 8/22/16.
 */

import java.util.*;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals56 {
    static class SortRule implements Comparator<Interval>{
        public int compare(Interval inter1,Interval inter2){
            return inter1.start - inter2.start;
        }
    }
    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals==null||intervals.size()<=1)
            return intervals;
        Collections.sort(intervals,new SortRule());
        List<Interval> result = new ArrayList<>();
        int blockstart = 1;
        int baseblock = 0;
        result.add(intervals.get(baseblock));
        while(blockstart<intervals.size()){
            Interval currentInter = intervals.get(blockstart);
            Interval baseInter = intervals.get(baseblock);
            if(baseInter.end >=currentInter.start){
                baseInter.end = Math.max(currentInter.end,baseInter.end);
            }
            else {
                baseblock=blockstart;
                baseInter = intervals.get(baseblock);
                result.add(baseInter);
            }
            blockstart++;
        }
        return result;
    }

    public static void main(String[] args){
        List<Interval> testList = new ArrayList<>();
        testList.add(new Interval(1,3));
        testList.add(new Interval(2,6));
        testList.add(new Interval(8,10));
        testList.add(new Interval(15,18));
        System.out.print(merge(testList));
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    public String toString(){
        return new String("["+start+","+end+"]");
    }
}
