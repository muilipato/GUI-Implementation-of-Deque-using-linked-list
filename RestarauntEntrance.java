
import java.util.LinkedList;

public class RestarauntEntrance implements Deque {


    private LinkedList<Object> list = new LinkedList<>();
    public RestarauntEntrance(){

    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Object first() throws StackEmptyException {
        if(isEmpty())
            throw new StackEmptyException("List IS Empty");

        return list.getFirst();
    }

    @Override
    public Object last() throws StackEmptyException {
        if(isEmpty())
            throw new StackEmptyException("List IS Empty");

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
            throw new StackEmptyException("List is Empty");

        return  list.removeFirst();
    }

    @Override
    public Object removeLast() throws StackEmptyException {
        if (isEmpty())
            throw new StackEmptyException("List is Empty");

        return  list.removeLast();
    }






}
