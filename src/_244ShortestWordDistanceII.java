/**
 * Created by weihengwang on 2/15/17.
 */
public class _244ShortestWordDistanceII {
    public static int shortest(String word1, String word2, String[] words) {
        String curstr = null;
        String trackingstr = word2;
        int dist = 0, mindist = Integer.MAX_VALUE;
        int i = 0;
        for( ; i < words.length; i++){
            if(words[i].equals(word1) || words[i].equals(word2)){
                curstr = (words[i].equals(word1) == true)? word1 : word2;
                trackingstr = (words[i].equals(word1) == true)? word2 : word1;
                i++;
                break;
            }
        }

        for(; i < words.length; i++){
            dist ++;
            if(curstr.equals(words[i])){
                dist = 0;
            }
            else if(trackingstr.equals(words[i])){
                mindist = Math.min(mindist, dist);
                dist = 0;
                String tmp = curstr;
                curstr = trackingstr;
                trackingstr = tmp;
            }
        }
        return mindist;
    }

    public static void main(String[] args){
        String[] arr = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortest("makes", "coding", arr));
    }
}
