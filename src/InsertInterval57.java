import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by weihengwang on 8/23/16.
 */
public class InsertInterval57 {
    static class SortRule implements Comparator<Interval> {
        public int compare(Interval inter1,Interval inter2){
            return inter1.start - inter2.start;
        }
    }
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if(intervals==null) {
            result.add(newInterval);
            return result;
        }
        Collections.sort(intervals,new SortRule());
        int i =0;
        while(i<intervals.size() && intervals.get(i).end < newInterval.start){
            result.add(intervals.get(i));
            i++;
        }
        /*
        while(i<intervals.size() ){
            if(intervals.get(i).start<= newInterval.start && newInterval.start <= intervals.get(i).end
                    || intervals.get(i).start<=newInterval.end && newInterval.end<=intervals.get(i).end){
                newInterval.start =Math.min(newInterval.start,intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
                i++;
            }
            else
                break;
        }*/
        while(i<intervals.size() && intervals.get(i).start<=newInterval.end){
            newInterval.start =Math.min(newInterval.start,intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
            i++;
        }
        /*
        while(intervals.get(i).start<= newInterval.start && newInterval.start <= intervals.get(i).end
                || intervals.get(i).start<=newInterval.end && newInterval.end<=intervals.get(i).end){
            newInterval.start =Math.min(newInterval.start,intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
            i++;
        } */
        result.add(newInterval);

        while(i<intervals.size()) {
            result.add(intervals.get(i));
            i++;
        }

        return result;
    }

    public static void main(String[] args){
        List<Interval> testList = new ArrayList<>();
        testList.add(new Interval(1,2));
        testList.add(new Interval(3,5));
        testList.add(new Interval(6,7));
        testList.add(new Interval(8,10));
        testList.add(new Interval(12,16));

        System.out.print(insert(testList,new Interval(4,9)));
    }
/*    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if(intervals==null) {
            result.add(newInterval);
            return result;
        }
        Collections.sort(result,new SortRule());
        boolean added =false;
        int start = newInterval.start;
        int end = newInterval.end;
        int endi = 0;
        int endj = 0;
        for(int i=0; i<intervals.size(); i++){
            if(start < intervals.get(i).start ){
                endi = i;
                break;
            }
        }
        for(int i=0; i<intervals.size(); i++){
            if(end < intervals.get(i).start ){
                endj = i;
                break;
            }
        }
        return result;
    }
    private void addrestPart(List<Interval> intervals, int restInd, List<Interval> result){
        for(int i=restInd;i<intervals.size();i++){
            result.add(intervals.get(i));
        }
    }
    private int checkCases(Interval inter1,Interval inter2){

    } */
}
