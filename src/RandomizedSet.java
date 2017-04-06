import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by weihengwang on 9/5/16. https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class RandomizedSet {
    HashMap<Integer,Integer> hm;
    List<Integer> list;
    Random rd;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        hm = new HashMap<>();
        list = new ArrayList<>();
        rd = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hm.containsKey(val))
            return false;
        else{
            list.add(val);
            int indx = list.size()-1;
            hm.put(val,indx);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(hm.containsKey(val)){
            int indx = hm.get(val);
            int lastind = list.size()-1;
            int lastindVal = list.get(lastind);

            hm.put(lastindVal,indx);
            hm.remove(val);
            swap(indx,lastind);
            list.remove(lastind);
            return true;
        }
        else
            return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rd.nextInt(list.size()));
    }

    private void swap(int indx, int lastind){
        int temp = list.get(lastind);
        list.set(lastind, list.get(indx));
        list.set(indx, temp);
    }
}
