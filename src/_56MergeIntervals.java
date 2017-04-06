import java.util.*;

/**
 * Created by weihengwang on 2/16/17.
 */
public class _56MergeIntervals {
//    public List<Interval> merge(List<Interval> intervals) {
//        if(intervals.size() <= 1)
//            return intervals;
//        Collections.sort(intervals, new IntervalsCmp());
//        List<Interval> res = new LinkedList<>();
//        Interval cur = intervals.get(0);
//        for(int i = 1; i < intervals.size(); i++){
//            if(cur.end >= intervals.get(i).start)
//                cur.end = Math.max(cur.end, intervals.get(i).end);
//            else{
//                res.add(cur);
//                cur = intervals.get(i);
//            }
//        }
//        res.add(cur);
//        return res;
//    }

//    public List<Interval> merge(List<Interval> intervals) {
//        if(intervals.size() <= 1)
//            return intervals;
//        Collections.sort(intervals, new Comparator<Interval>(){
//            @Override
//            public int compare(Interval i1, Interval i2){
//                return i1.start - i2.start;
//            }
//        });
//
//        List<Interval> res = new ArrayList<>();
//
//        for(int i = 0; i < intervals.size(); ){
//            Interval curinter = intervals.get(i);
//            int next = i + 1;
//            while(next < intervals.size() && intervals.get(next).start <= curinter.end){
//                curinter.end = Math.max(intervals.get(next).end, curinter.end);
//                next ++;
//            }
//
//            res.add(curinter);
//            i = next;
//        }
//        return res;
//    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1)
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        List<Interval> res = new LinkedList<>();
        Interval tomerge = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            if(tomerge.end >= intervals.get(i).start){
                tomerge.end = Math.max(tomerge.end, intervals.get(i).end);
            }
            else{
                res.add(tomerge);
                tomerge = intervals.get(i);
            }
        }
        res.add(tomerge);
        return res;
    }
}

class IntervalsCmp implements Comparator<Interval> {
    @Override
    public int compare(Interval i1, Interval i2){
        if(i1.start != i2.start)
            return i1.start - i2.start;
        else
            return i2.end - i1.end;
    }
}
