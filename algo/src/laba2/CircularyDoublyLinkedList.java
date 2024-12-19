package laba2;

import java.util.Comparator;

class Node2<T> {
    T data;
    Node2<T> next;
    Node2<T> prev;

    public Node2(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class CircularDoublyLinkedList<T> {
    private Node2<T> head;
    private int size;

    public CircularDoublyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(T data) {
        Node2<T> newNode = new Node2<>(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (size == 1) {
            head = null;
        } else {
            Node2<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            if (index == 0) {
                head = current.next;
            }
        }
        size--;
    }

    public int size() {
        return size;
    }

    public void printForward() {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }
        Node2<T> current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public void printBackward() {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }

        Node2<T> current = head.prev;
        do {
            System.out.print(current.data + " ");
            current = current.prev;
        } while (current != head.prev);
        System.out.println();
    }

    public void quickSort(Comparator<T> comparator) {
        if (size <= 1) {
            return;
        }
        quickSort(head, head.prev, comparator);
    }

    private void quickSort(Node2<T> low, Node2<T> high, Comparator<T> comparator) {
        if (low == null || high == null) {
            return;
        }
        if (low == high) {
            return;
        }
        Node2<T> pivot = partition(low, high, comparator);
        quickSort(low, pivot.prev, comparator);
        quickSort(pivot.next, high, comparator);
    }

    private Node2<T> partition(Node2<T> low, Node2<T> high, Comparator<T> comparator) {
        T pivotData = high.data;
        Node2<T> i = low.prev;

        for (Node2<T> j = low; j != high; j = j.next) {
            if (comparator.compare(j.data, pivotData) <= 0) {
                if (i == null) {
                    i = low;
                } else {
                    i = i.next;
                }
                T temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }
        if (i == null) {
            i = low;
        } else {
            i = i.next;
        }
        T temp = i.data;
        i.data = high.data;
        high.data = temp;
        return i;
    }

    public void heapSort(Comparator<T> comparator) {
        if (size <= 1) {
            return;
        }
        buildHeap(comparator);
        sortHeap(comparator);
    }

    private void buildHeap(Comparator<T> comparator) {
        Node2<T> current = head;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(current, size, i, comparator);
            current = current.next;
        }
    }

    private void sortHeap(Comparator<T> comparator) {
        for (int i = size - 1; i > 0; i--) {
            Node2<T> last = getNode(i);
            T temp = head.data;
            head.data = last.data;
            last.data = temp;
            heapify(head, i, 0, comparator);
        }
    }

    private void heapify(Node2<T> start, int n, int i, Comparator<T> comparator) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && comparator.compare(getNode(left).data, getNode(largest).data) > 0) {
            largest = left;
        }

        if (right < n && comparator.compare(getNode(right).data, getNode(largest).data) > 0) {
            largest = right;
        }

        if (largest != i) {
            Node2<T> largestNode = getNode(largest);
            Node2<T> iNode = getNode(i);
            T temp = iNode.data;
            iNode.data = largestNode.data;
            largestNode.data = temp;
            heapify(start, n, largest, comparator);
        }
    }
    private Node2<T> getNode ( int index){
        Node2<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public boolean Check(){
        Node2<T> current = head.prev;
        return current.next == head && head.prev == current;
    }
}