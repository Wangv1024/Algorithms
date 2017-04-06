import java.util.ArrayList;
import java.util.List;

/**
 * Created by weihengwang on 4/5/17.
 */
public class _57InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if(intervals.size() <= 0){
            res.add(newInterval);
            return res;
        }
        int st = 0;
        while(st < intervals.size() && intervals.get(st).end < newInterval.start){
            res.add(intervals.get(st));
            st++;
        }

        while(st < intervals.size() && intervals.get(st).start <= newInterval.end){
            newInterval.start = Math.min(newInterval.start, intervals.get(st).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(st).end);
            st++;
        }
        res.add(newInterval);
        while(st < intervals.size()){
            res.add( intervals.get(st) );
            st++;
        }
        return res;
    }
}
