import java.util.*;

/**
 * Created by weihengwang on 9/10/16.
 */
public class PalindromePairs336 {
    public static List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> res = new HashSet<>();
        if(words.length<=1)
            return new ArrayList<>(res);
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<words.length;i++)
            hm.put(words[i],i);

        for(int i=0;i<words.length;i++){
            hm.remove(words[i]);
            int len = words[i].length();
            for(int j=0;j<=len;j++){
                String head = words[i].substring(0,j);
                String tail = words[i].substring(j);

                if(ispalidrome(head)){
                    String find = new StringBuilder(tail).reverse().toString();
                    if(hm.containsKey(find)) {
                        int ind = hm.get(find);
                        List<Integer> li = new ArrayList<>();
                        li.add(ind);
                        li.add(i);
                        res.add(li);
                    }
                }
                if(ispalidrome(tail)){
                    String find = new StringBuilder(head).reverse().toString();
                    if(hm.containsKey(find)) {
                        int ind = hm.get(find);
                        List<Integer> li = new ArrayList<>();
                        li.add(i);
                        li.add(ind);
                        res.add(li);
                    }
                }
            }
            hm.put(words[i],i);
        }
        return new ArrayList<>(res);
    }

    private static boolean ispalidrome(String str){
        int i = 0;
        int j = str.length()-1;
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args){
    //    String[] str = {"bat","tab","cat"};
        String[] str = {"abcd","dcba","lls","s","sssll"};
        System.out.println(palindromePairs(str));
    }

}
