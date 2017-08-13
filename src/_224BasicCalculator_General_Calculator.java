import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by weihengwang on 6/25/17.
 */
public class _224BasicCalculator_General_Calculator {
    public int calculate(String s) {
        Deque<Character> operaSt = new LinkedList<>();
        Deque<Integer> numst = new LinkedList<>();

        int curnum = 0;
        for(int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                curnum = curnum * 10 + ch - '0';
            }
            else if(ch == ' ')
                continue;
            else if(ch == '('){
                int matchend = getmatch(s, i);
                curnum = calculate(s.substring(i + 1, matchend));  // s.substring(i, matchend);

                i = matchend;
            }
            else{
                char curoper = ch;
                numst.push(curnum);
                curnum = 0;
                while(!operaSt.isEmpty() && getRank( operaSt.peek()) >= getRank(curoper)){
                    getResult(numst, operaSt);
                }
                operaSt.push(curoper);
            }
        }

        numst.push(curnum);
        while( !operaSt.isEmpty())
            getResult(numst, operaSt);

        return numst.peek();
    }
    private int getRank(char ch){
        if(ch == '+' || ch == '-')
            return 0;
        if(ch == '*' || ch =='/')
            return 1;
        else
            return 2;
    }
    private int getmatch(String s, int st){
        int count = 0;
        for(int i = st; i < s.length(); i ++){
            if(s.charAt(i) == '(')
                count++;
            else if(s.charAt(i) == ')')
                count--;

            if(count == 0)
                return i;
        }
        return -1;
    }
    private void getResult(Deque<Integer> numst, Deque<Character> operst){
        char oper = operst.pop();
        int num2 = numst.pop();
        int num1 = numst.pop();
        if(oper == '+')
            numst.push(num1 + num2);
        else if(oper == '-')
            numst.push(num1 - num2);
        else if(oper == '*')
            numst.push(num1 * num2);
        else if(oper == '/')
            numst.push(num1 / num2);
        else if(oper == '^'){
            if(num2 == 0){
                numst.push(1);
                return;
            }

            int res = num1;
            for(int i = 1; i < num2; i++)
                res = res * num1;
            numst.push(res);
        }

    }

    public static void main(String[] args){
        String str = "1-2*3^2 - 6 * (5 ^ 2)";
        _224BasicCalculator_General_Calculator obj = new _224BasicCalculator_General_Calculator();
        System.out.println(obj.calculate(str));
    }
}
