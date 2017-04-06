import java.util.*;

/**
 * Created by weihengwang on 2/28/17.
 */
public class _127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        q1.offer(beginWord);
        Set<String> removeset = new HashSet<>();
        Set<String> wordSet = new HashSet<>();
        for(String str: wordList)
            wordSet.add(str);

        int level = 1;
        while( !q1.isEmpty() || !q2.isEmpty()){
            if(q1.isEmpty()){
                q1 = q2;
                q2 = new LinkedList<>();
                wordSet.removeAll(removeset);
                removeset = new HashSet<>();
                level++;
            }

            String startword = q1.poll();
            removeset.add(startword);
//            for(int i = 0; i < wordList.size(); i++ ){
//                String curstr = wordList.get(i);
//                if(isOneDiff(startword, curstr)) {
//                    q2.offer(curstr);
//                    if(curstr.equals(endWord))
//                        return level + 1;
//                }
//
//            }
            StringBuilder strb = new StringBuilder(startword);
            for(int i = 0; i < startword.length(); i++){
                char curchar = startword.charAt(i);
                for(char j = 'a'; j <= 'z'; j++){
                    if(j == curchar)
                        continue;
                    strb.setCharAt(i, j);
                    String transformed = strb.toString();
                    if(wordSet.contains(transformed)) {
                        q2.offer(transformed);
                        if(transformed.equals(endWord))
                            return level + 1;
                    }
                }
                strb.setCharAt(i, curchar);
            }

        }
        return 0;
    }

    private boolean isOneDiff(String str1, String str2){
        int count = 0;
        if(str1.length() != str2.length())
            return false;
        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i))
                count++;
            if (count > 1)
                return false;
        }
        return count == 1;
    }

//    private boolean isOneDiff(String s1, String s2) {
//
//        int count = 0;
//        for (int i = 0; i < s1.length(); i++) {
//            if (s1.charAt(i) != s2.charAt(i)) {
//                count++;
//            }
//            if (count > 1) {
//                return false;
//            }
//        }
//        return true;
//    }
//
    private static void swap(List<String> list, int i, int j) {

        String temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args){
        List<String> l1 = new ArrayList<>();
        l1.add("111");
        l1.add("222");
        swap(l1, 0, 1);
        System.out.println(l1);
    }
}
