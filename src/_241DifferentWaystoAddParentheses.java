import java.util.ArrayList;
import java.util.List;

/**
 * Created by weihengwang on 4/14/17.
 */
public class _241DifferentWaystoAddParentheses {
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                List<Integer> l1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> l2 = diffWaysToCompute(input.substring(i + 1));
                for(int l1num : l1)
                    for(int l2num : l2){
                        int re = 0;
                        switch ( input.charAt(i) ) {
                            case '+':
                                re = l1num + l2num;
                                break;
                            case '-':
                                re = l1num - l2num;
                                break;
                            case '*':
                                re = l1num * l2num;
                                break;
                        }
                        res.add(re);
                    }
            }
        }

        if(res.size() <= 0)
            res.add(Integer.parseInt(input));
        return res;
    }

    public static void main(String[] args){
        String input = "1+2*3+4";
        System.out.println(diffWaysToCompute(input));
    }
}
