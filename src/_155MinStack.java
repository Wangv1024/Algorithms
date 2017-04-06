import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by weihengwang on 2/14/17.
 */
public class _155MinStack {
    Deque<Integer> st;
    int base;
     public _155MinStack() {
         st = new LinkedList<>();
         base = 0;
     }

     public void push(int x) {
        if( st.isEmpty() == true){
            base = x;
            st.push(0);
        }
        else{
            if(base > x){
                st.push(x - base);
                base = x;
            }
            else {
                st.push(x - base);
            }
        }

     }

     public void pop() {
         if(st.peek() >= 0)
             st.pop();
         else{
             base = base - st.pop();
        }
     }

     public int top() {
        if(st.peek() >= 0)
            return base + st.peek();
         return base;
     }

     public int getMin() {
         return base;
     }

     public static void main(String[] args){
         _155MinStack minst = new _155MinStack();
         minst.push(-1); minst.push(0); minst.push(3);
         minst.push(-2); minst.push(3);
         System.out.println(minst.getMin());
         minst.pop(); minst.pop();
         System.out.println(minst.getMin());
         System.out.println(minst.top());
     }
}
