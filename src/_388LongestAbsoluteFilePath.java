/**
 * Created by weihengwang on 5/27/17.
 */
public class _388LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\\n");
        int[] sta = new int[paths.length + 1];

        int maxlen = 0;
        for(String str : paths){
            int lev = str.lastIndexOf("\t") + 1;
            int curlen = sta[lev + 1] = sta[lev] + str.length() - lev + 1; //
            if(str.contains("."))
                maxlen = Math.max(maxlen, curlen - 1); // - 1 because first element does not have "/"
        }

        return maxlen;
    }

//    public int lengthLongestPath(String input) {
//        String[] paths = input.split("\\n"); //  split("  ") has regular expression match  use \\n to indicates \n
//        return getLongest(paths);
//    }
//    private int getLongest(String[] paths){
//        int max = 0;
//        Deque<Integer> st = new LinkedList<>();
//
//        for(String str : paths){
//            int index = str.lastIndexOf("\t"); //
//            int level = index + 1;
//            String curpath = str.substring(index + 1);
//
//            while(st.size() > level)
//                st.pop();
//            int prevLen = st.isEmpty() ? 0 : st.peek();
//            int curlen = prevLen + curpath.length() + (prevLen == 0? 0 : 1); //   / symbol length
//            st.push(curlen);
//
//            if(curpath.contains("."))
//                max = Math.max(max, curlen);
//        }
//        return max;
//    }
}
