import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by weihengwang on 10/24/16.
 */
public class _320GeneralizedAbbreviation {
//    public List<String> generateAbbreviations(String word) {
//        List<String> res = new ArrayList<>();
//        if(word== null || word.length()==0)
//            return res;
//        String strb = null;
//        helper(res,strb,word,0);
//        return res;
//    }
//    private void helper(List<String> li, String strb, String word, int st){
//        if(st>=word.length()){
//
//        }
//
//        for(int i=0; i<word.length(); i++){
//            strb=strb+word.charAt(i);
//
//        }
//    }
//    private String sumadjacent1(String str) {
//        for(int i=0;i<str.length();i++){
//
//        }
//    }

    public List<String> generateAbbreviations(String word) {
        List<String> res = new LinkedList<>();
        generateHelper(res, word.toCharArray(), new StringBuilder(), 0, 0);
        return res;
    }
    private void generateHelper(List<String> res, char[] charr, StringBuilder strb, int st, int abbrav){
        int len = strb.length();
        if(st == charr.length){
            if(abbrav != 0)
                strb.append(abbrav);
            // strb.append( strb );  ??  bugs !!
            res.add(strb.toString());
        }
        else{
            generateHelper(res, charr, strb, st + 1, abbrav + 1 );
            if( abbrav != 0 )
                strb.append( abbrav );
            generateHelper(res, charr, strb.append( charr[st] ), st + 1, 0);
        }
        strb.setLength( len );
    }
}
