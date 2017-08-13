import java.util.*;

/**
 * Created by weihengwang on 8/12/17.
 */
public class _392IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        // First we encode all the character in string t into hashmap, with list recorde
        // the character ocurrance index of each character
        Map<Character, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < t.length(); ++ i){
            char ch = t.charAt(i);
            if( !mp.containsKey(ch)){
                mp.put(ch, new ArrayList<Integer>());
            }
            mp.get(ch).add(i);
        }

        int searchRange = 0;// we want char ocurrance index that is bigger or equal to 0, that is
        //   so initial point is 0;

        // we iterate all the character in string s, hoping to find them in string t. So we set start index as 0;
        // For each char int string t, the character right follow it has to show up with indice bigger than current char.
        // so once we find an char in current list, we need to find next char with range [current index + 1, t.length() - 1 ]
        for(char ch : s.toCharArray()){
            if( !mp.containsKey(ch) )
                return false;

            List<Integer> curlist = mp.get(ch);
            // Searchrange is the least index where a qualified current char should show up
            // but a bigger indice is qualified as well. that would make showUpindex a negative one.
            int showUpindex = Collections.binarySearch(curlist, searchRange);
            if(showUpindex < 0){ // we do not find exact element equal to searchRange in curlist, but we potentially find the
                showUpindex = -( showUpindex + 1);// index where a larger element locates.
            }
            if(showUpindex == curlist.size())// if the location is not valid, we do not have this element.
                return false;
            searchRange = curlist.get(showUpindex) + 1; // next char should locate after current index;
            // we will search next char location with condition that is bigger or equal
            // current finded element.
        }
        return true;
    }
}
