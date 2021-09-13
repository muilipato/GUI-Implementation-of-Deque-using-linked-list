public interface Deque {

    public int size();

    public boolean isEmpty();

    public Object first() throws StackEmptyException;

    public Object last() throws StackEmptyException;

    public void addFirst(Object element);

    public void addLast(Object element);

    public Object removeFirst() throws StackEmptyException;

    public Object removeLast() throws StackEmptyException;



    public static class StackEmptyException extends Exception{
        public StackEmptyException(String args){
            super(args);
        }
    }

    public static class OutOfBoundException extends Exception{
        public OutOfBoundException(String args){
            super(args);
        }
    }
}
