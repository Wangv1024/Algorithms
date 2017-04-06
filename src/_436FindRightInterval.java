import java.util.Map;
import java.util.TreeMap;

/**
 * Created by weihengwang on 3/27/17.
 */
public class _436FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++){
            tmap.put(intervals[i].start, i);
        }
        int[] res = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            Map.Entry<Integer, Integer> getentry = tmap.ceilingEntry(intervals[i].start);
            if(getentry != null)
                res[i] = getentry.getValue();
            else
                res[i] = -1;
        }
        return res;
    }
}

