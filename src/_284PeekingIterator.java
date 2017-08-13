import java.util.*;

/**
 * Created by weihengwang on 7/7/17.
 */
public class _284PeekingIterator {

    public static void main(String[] args){
        List<Double> ls = new LinkedList<>();
        ls.add(2.11);
        ls.add(7.3);

        // you can not use peek() if you use Iterator as type
        MyIterator it = new MyIterator(ls.iterator());
        while(it.hasNext())
            System.out.println("" + it.peek() + " " + it.next());
    }
}


class MyIterator <T> implements Iterator <T> {
    Iterator<T>  it;
    T current = null;
    public MyIterator(Iterator<T> iter){
        it = iter;
        current = it.hasNext()? it.next() : null;
    }
    @Override
    public boolean hasNext(){
        return current != null;
    }

    @Override
    public T next(){
        T ret = current;
        current = it.hasNext()? it.next() : null;
        return ret;
    }

    public T peek(){
        return current;
    }
    @Override
    public void remove(){
        next();
    }
}