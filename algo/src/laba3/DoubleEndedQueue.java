package laba3;

import java.util.Iterator;
import java.util.LinkedList;

public class DoubleEndedQueue {
    private LinkedList<Integer> deque;
    public DoubleEndedQueue() {
        deque = new LinkedList<>();
    }
    public boolean isEmpty(){
        return deque.isEmpty();
    }
    public int size(){
        return deque.size();
    }
    public void push (int element){
        deque.addLast(element);
    }
    public int pop(){
        if(deque.isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return deque.removeFirst();
    }

    public Iterator<Integer> iterator() {
        return deque.iterator();
    }
}
