package laba2;

    class Node {
        int data;
        Node next;
        Node child;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }

    class MultilevelSinglyLinkedList {
        private Node head;

        public MultilevelSinglyLinkedList() {
            this.head = null;
        }

        public void addToFront(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public void addToEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public void addToMiddle(int data, int index) {
            if (index == 0) {
                addToFront(data);
                return;
            }
            Node newNode = new Node(data);
            Node current = head;
            int i = 0;
            while (current != null && i < index - 1) {
                current = current.next;
                i++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        public void remove(int ind) {
            if (ind == 0) {
                head = head.next;
                return;
            }
            Node current = head;
            int i = 0;
            while (current != null && i < ind - 1) {
                current = current.next;
                i++;
            }
            current.next = current.next.next;
        }

        // Подсчет числа элементов в списке
        public int size() {
            return size(head);
        }

        private int size(Node node) {
            if (node == null) {
                return 0;
            }
            int count = 1;
            count += size(node.next);
            count += size(node.child);
            return count;
        }

        public void printList() {
            printList(head, 0);
        }

        private void printList(Node node, int level) {
            if (node == null) {
                return;
            }
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
            System.out.println(node.data);
            printList(node.child, level + 1);
            printList(node.next, level);
        }
        // Добавление childa
        public void addChild(int parentData, int childData) {
            Node childNode = new Node(childData);
            Node current = head;
            while (current != null) {
                if (current.data == parentData) {
                    if (current.child == null) {
                        current.child = childNode;
                    } else {
                        Node a = current.child;
                        while (a.next != null) {
                            a = a.next;
                        }
                        a.next = childNode;
                    }
                    return;
                }
                current = current.next;
            }
        }
}
