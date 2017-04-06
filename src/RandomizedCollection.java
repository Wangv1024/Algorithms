import java.util.*;

/**
 * Created by weihengwang on 9/5/16.
 */
public class RandomizedCollection {
    List<Integer> arrList;
    HashMap<Integer,Set<Integer>> hm;
    Random rm;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        arrList = new ArrayList<>();
        hm = new HashMap<>();
        rm = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        int posi = arrList.size();
        if(!hm.containsKey(val)) {
            arrList.add(val);
            HashSet hs = new HashSet<>();
            hs.add(posi);
            hm.put(val,hs);
            return true;
        }
        else{
            arrList.add(val);
            Set hs = hm.get(val);
            hs.add(posi);
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!hm.containsKey(val))
            return false;
        else{
            Set<Integer> hsval = hm.get(val);
            Iterator<Integer> it = hsval.iterator();
            int indx = it.next();
            hsval.remove(indx);

            if(hsval.isEmpty())
                hm.remove(val);
            if(indx==arrList.size()-1) {
                arrList.remove(indx);
                return true;
            }

            int arrEndind = arrList.size()-1;
            int arrEndVal = arrList.get(arrEndind);
            Set<Integer> hsArrEnd = hm.get(arrEndVal);
            hsArrEnd.remove(arrEndind);
            hsArrEnd.add(indx);

            swap(indx,arrEndind);
            arrList.remove(arrEndind);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int result = rm.nextInt(arrList.size());
        return arrList.get(result);
    }

    private void swap(int indx,int arrEnd){
        int temp = arrList.get(arrEnd);
        arrList.set(arrEnd,arrList.get(indx));
        arrList.set(indx,temp);
    }
}
