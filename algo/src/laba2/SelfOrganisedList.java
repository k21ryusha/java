package laba2;

import java.util.Comparator;
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
    public void quickSort(Comparator<T> comparator) {
        if (list.size() <= 1) {
            return;
        }
        quickSort(0, list.size() - 1, comparator);
    }

    private void quickSort(int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quickSort(low, pivotIndex - 1, comparator);
            quickSort(pivotIndex + 1, high, comparator);
        }
    }

    private int partition(int low, int high, Comparator<T> comparator) {
        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);

            }
        }
        T temp = list.get(i+1);
        list.set(i+1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }

    public void heapSort(Comparator<T> comparator) {
        if (list.size() <= 1) {
            return;
        }
        buildHeap(comparator);
        sortHeap(comparator);
    }
    private void buildHeap(Comparator<T> comparator) {
        int n = list.size();
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(n,i,comparator);
        }
    }
    private void sortHeap(Comparator<T> comparator) {
        int n = list.size();
        for (int i = n -1; i >= 0; i--) {
            T temp = list.get(0);
            list.set(0,list.get(i));
            list.set(i, temp);
            heapify(i,0,comparator);
        }
    }
    private void heapify(int n, int i, Comparator<T> comparator) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && comparator.compare(list.get(left), list.get(largest)) > 0) {
            largest = left;
        }
        if (right < n && comparator.compare(list.get(right), list.get(largest)) > 0) {
            largest = right;
        }
        if (largest != i) {
            T temp = list.get(largest);
            list.set(largest,list.get(i));
            list.set(i, temp);
            heapify(n,i,comparator);
        }
    }
}