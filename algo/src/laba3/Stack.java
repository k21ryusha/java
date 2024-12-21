package laba3;

public class Stack<T> {
    private Object[] stack;
    private int size;

    public Stack() {
        stack = new Object[10];
        size = 0;
    }
    public int size() {;
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    private void checkCapacity() {
        if (size == stack.length) {
            Object[] newElements = new Object[stack.length * 2];
            System.arraycopy(stack, 0, newElements, 0, stack.length);
            stack = newElements;
        }
    }
    public void push(T value) {
       checkCapacity();
       stack[size++] = value;
    }
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        T value = (T) stack[--size];
        stack[size] = null;
        return value;
    }
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return (T) stack[size - 1];
    }
    public void printStack() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        System.out.println("Элементы стека: ");
        for (int i = 0; i >= size - 1; i--) {
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }
}
