import java.util.*;

/**
 * Created by weihengwang on 9/2/16.
 */
public class WordLadderII126 {
    public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(beginWord.equals(endWord))
            return res;

        int curdist =0;
        int enddistan = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();
        Set<String> unvisited = new HashSet<>();
        unvisited.addAll(wordList);
        unvisited.remove(beginWord);
        unvisited.add(endWord);

        Queue<WordNode> que = new LinkedList<>();
        que.add(new WordNode(beginWord,0));

        while(!que.isEmpty()){
            WordNode node = que.poll();
            if(curdist<node.dist){
                unvisited.removeAll(visited);
            }
            curdist = node.dist;

            if(node.word.equals(endWord)){
                enddistan = curdist;
                trackPath(res,node);
            }
            if(curdist>enddistan)
                break;

            List<String> neigborList = getNeigbor(node, unvisited);
            for(String neighbor : neigborList){
                WordNode wn = new WordNode(neighbor,curdist+1);
                wn.pre = node;
                que.add(wn);
                visited.add(wn.word);
            }
        }
        return res;
    }
    public static void trackPath(List<List<String>> res, WordNode wn){
        List<String> path = new LinkedList<>();
        path.add(wn.word);
        while(wn.pre!=null){
            wn=wn.pre;
            path.add(0,wn.word);
        }
        res.add(path);
    }
    public static List<String> getNeigbor(WordNode wn, Set<String> unvisited){
        String word = wn.word;
        List<String> res = new ArrayList<>();
        char[] charr = word.toCharArray();
        for(int i=0;i<charr.length;i++){
            for(char a='a';a<='z';a++){
                char temp = charr[i];
                if(a!=charr[i]){
                    charr[i]=a;
                }
                else
                    continue;
                String shiftword = String.valueOf(charr);
                if(unvisited.contains(shiftword))
                    res.add(shiftword);
                charr[i] = temp;
            }
        }
        return res;
    }
    public static void main(String[] args){
        /*
        Set<String> unvisited = new HashSet<>();
        unvisited.add("hot");
        unvisited.add("hit");
        unvisited.add("god");
        unvisited.add("git");
        unvisited.add("zit");
        System.out.println(getNeigbor(new WordNode("got",0),unvisited));*/

/*        WordNode w1 = new WordNode("aaa",0);
        WordNode w2 = new WordNode("bbb",1);
        WordNode w3 = new WordNode("ccc",2);
        WordNode w4 = new WordNode("ddd",3);
        w2.pre = w1;
        w3.pre = w2;
        w4.pre = w3;
        List<List<String>> res = new ArrayList<>();
        trackPath(res,w4);
        System.out.println(res); */
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> dictionary = new HashSet<>();

        dictionary.add("hot");
        dictionary.add("dot");
        dictionary.add("lot");
        dictionary.add("log");
        dictionary.add("dog");
        System.out.println(findLadders(beginWord,endWord,dictionary));
    }
}
class WordNode{
    String word;
    WordNode pre;
    int dist;
    WordNode(String word){
        this.word = word;
    }
    WordNode(String word,int dist){
        this.word = word;
        this.dist = dist;
    }
}
