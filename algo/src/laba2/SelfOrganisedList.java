package laba2;

import java.util.HashMap;
import java.util.LinkedList;

class SelfOrganizingList<T> {
    private LinkedList<T> list;
    private HashMap<T, Integer> counts;

    public SelfOrganizingList() {
        this.list = new LinkedList<>();
        this.counts = new HashMap<>();
    }

    public void addToFront(T element) {
        counts.putIfAbsent(element, 0);
        this.insertForward(element);
    }

    public void addToEnd(T element) {
        counts.putIfAbsent(element, 0);
        this.insertForward(element);
    }

    public void addToMiddle(T element, int index) {
        counts.putIfAbsent(element, 0);
        if (index < list.size()) {
            list.add(index, element);
        } else {
            list.add(element);
        }
    }

    public void remove(T element) {
        int index = list.indexOf(element);
        if (index != -1) {
            list.remove(index);
        } else {
            System.out.println("Элемент '" + element + "' не найден в списке.");
        }
    }

    public int size() {
        return list.size();
    }

    public void printForward() {
        for (T element : list) {
            int count = counts.getOrDefault(element,0);
            System.out.print(element + "(" + count + ") ");
        }
        System.out.println();
    }

    public void printBackward() {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public void insertForward(T element) {
        int indEl = list.indexOf(element);
        int countEL = counts.getOrDefault(element,0);
        for (int i = 0; i < indEl; i++) {
            int count = counts.get(list.get(i));
            if (countEL > count) {
                list.remove(element);
                list.add(i, element);
            }
        }
    }

    public T get(T element) {
        counts.putIfAbsent(element, 0);
        if (!this.list.contains(element)) {
            list.addFirst(element);
        }
        counts.putIfAbsent(element,0);
        insertForward(element);
        return element;
    }
}