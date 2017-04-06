import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by weihengwang on 3/28/17.
 */
public class _352DataStreamasDisjointIntervals {
    public TreeMap<Integer, Interval> tm;
    public _352DataStreamasDisjointIntervals() {
        tm = new TreeMap<>();
    }

    public void addNum(int val) {
        if(tm.containsKey(val))
            return;
        Map.Entry<Integer, Interval> lower = tm.lowerEntry(val);
        Map.Entry<Integer, Interval> higher = tm.higherEntry(val);
        if(lower != null && higher != null && lower.getValue().end + 1 == val && higher.getValue().start == val + 1){
            Interval low = lower.getValue();
            Interval hig = higher.getValue();
            low.end = Math.max(low.end, hig.end);
            tm.remove(hig.start);
        }
        else if(lower != null && lower.getValue().end + 1 >= val){
            Interval low = lower.getValue();
            low.end = Math.max(low.end, val);
        }
        else if(higher != null && higher.getValue().start == val + 1){
            Interval hi = higher.getValue();
            hi.start = val;
            tm.remove(val + 1);
            tm.put(val, hi);
        }
        else
            tm.put(val, new Interval(val, val));
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(tm.values());  //
    }
}
