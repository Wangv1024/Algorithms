import java.util.*;

/**
 * Created by weihengwang on 2/21/17.
 */
public class _451SortCharactersByFrequency {
    public static String frequencySort(String s) {
        if(s.length() <= 1)
            return s;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char curchar = s.charAt(i);
            if(hm.containsKey(curchar))
                hm.put(curchar, hm.get(curchar) + 1);
            else
                hm.put(curchar, 1);
        }

        TreeMap<Integer, List<Character>> tm = new TreeMap<>(Collections.reverseOrder());
        StringBuilder strb = new StringBuilder();
        for(char key: hm.keySet()){
            int curvalue = hm.get(key);
            if( tm.containsKey(curvalue) ){
                tm.get(curvalue).add(key);
            }
            else{
                List<Character> ls = new ArrayList<>();
                ls.add(key);
                tm.put(curvalue, ls);
            }
        }

        Iterator iter = tm.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer, List<Character>> curEntry = (Map.Entry) iter.next();

            for(char curchar :curEntry.getValue()) { // mistakly written as while
                int i = 0;
                while (i++ < curEntry.getKey())
                    strb.append(curchar);
            }
        }

        return strb.toString();
    }

    public static void main(String[] args){
        System.out.println(frequencySort("treemapaper"));
    }
}
