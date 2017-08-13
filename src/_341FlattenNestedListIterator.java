import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by weihengwang on 8/7/17.
 */
//public class _341FlattenNestedListIterator implements Iterator<Integer> {
//    Deque<Iterator<NestedInteger>> st;
//    Integer currentElement = null;
//    public NestedIterator(List<NestedInteger> nestedList) {
//        st = new LinkedList<>();
//        st.push(nestedList.iterator());
//    }
//
//    @Override
//    public Integer next() {
//        Integer ret = currentElement;
//        currentElement = null;
//        return ret;
//    }
//
//    @Override
//    public boolean hasNext() {
//        if(currentElement != null){
//            return true;
//        }
//
//        while( !st.isEmpty() ){
//            if( !st.peek().hasNext()){
//                st.pop();
//            }
//            else{
//                NestedInteger current = st.peek().next();
//                if(current.isInteger()){
//                    currentElement = current.getInteger();
//                    break;
//                }
//                else{
//                    //  st.push( current.iterator() );
//                    st.push(current.getList().iterator());
//                }
//            }
//        }
//        return currentElement != null;
//    }
//}
