package laba2;

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
}
