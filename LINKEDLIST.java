
import java.util.LinkedList;

public class LINKEDLIST {


    public class LinkedListDoubleStack implements Deque {
        private LinkedList<Object> list = new LinkedList<>();
        public LinkedListDoubleStack(){


        }

        @Override
        public int size() {
            return list.size(); }

        @Override
        public boolean isEmpty() {
            return list.isEmpty();
        }

        @Override
        public Object first() throws StackEmptyException {
            if(isEmpty())
                throw new StackEmptyException("List is empty!");

            return list.getFirst();
        }

        @Override
        public Object last() throws StackEmptyException {
            if(isEmpty())
                throw new StackEmptyException("List is empty");

            return list.getLast();
        }

        @Override
        public void addFirst(Object element) {
            list.addFirst(element);
        }

        @Override
        public void addLast(Object element) {
            list.addLast(element);
        }

        @Override
        public Object removeFirst() throws StackEmptyException {
            if (isEmpty())
                throw new StackEmptyException("List is empty");

            return  list.removeFirst();
        }

        @Override
        public Object removeLast() throws StackEmptyException {
            if (isEmpty())
                throw new StackEmptyException("List is empty");

            return  list.removeLast();
        }


    }





}
