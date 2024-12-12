package laba2;

import java.util.Comparator;

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
        public void quickSort() {
            head = quickSort(head);
        }

        private Node quickSort(Node node) {
            if (node == null || (node.next == null && node.child == null)) {
                return node;
            }

            Node pivot = node;
            Node lessHead = null;
            Node lessTail = null;
            Node greaterHead = null;
            Node greaterTail = null;

            Node current = node.next;
            pivot.next = null;

            while (current != null) {
                Node next = current.next;
                current.next = null;

                if (current.data <= pivot.data) {
                    if (lessHead == null) {
                        lessHead = current;
                        lessTail = current;
                    } else {
                        lessTail.next = current;
                        lessTail = current;
                    }
                } else {
                    if (greaterHead == null) {
                        greaterHead = current;
                        greaterTail = current;
                    } else {
                        greaterTail.next = current;
                        greaterTail = current;
                    }
                }

                current = next;
            }

            lessHead = quickSort(lessHead);
            greaterHead = quickSort(greaterHead);

            pivot.child = quickSort(pivot.child);

            Node sortedHead = lessHead;
            if (lessHead != null) {
                Node lessEnd = lessHead;
                while (lessEnd.next != null) {
                    lessEnd = lessEnd.next;
                }
                lessEnd.next = pivot;
            } else {
                sortedHead = pivot;
            }

            pivot.next = greaterHead;

            return sortedHead;
        }
    public void heapSort() {
            head = heapSort(head);
    }
    private Node heapSort(Node node) {
            if (node == null || (node.child == null && node.next == null)) {
                return node;
            }
            Node sortedParents = sortLevel(node);
            Node current = sortedParents;
            while (current != null) {
                if (current.child != null) {
                    current.child = heapSort(current.child);
                }
                current = current.next;
            }
            return sortedParents;
    }
    private Node sortLevel(Node node) {
            if (node == null || node.next == null) {
                return node;
            }
            Node sortedHead = null;
            while (node != null) {
                Node max = findMax(node);
                node = removeNode(node,max);
                max.next = sortedHead;
                sortedHead = max;
            }
            return sortedHead;
    }
    private Node removeNode(Node node, Node max) {
            if(node == null || max == null) {
                return node;
            }
            if(node == max){
                return node.next;
            }
            Node current = node;
            while (current.next != null) {
            if(current.next == max) {
                current.next = max.next;
                break;
                }
            current = current.next;
            }
            max.next = null;
            return node;
    }
    private Node findMax(Node node) {
            if (node == null) {
                return null;
            }
            Node max = node;
            Node current = node;
            while (current != null) {
                if (current.data > max.data) {
                    max = current;

                }
                current = current.next;
            }
            return max;
    }
    private Node reverseList(Node node) {
            Node prev = null;
            Node current = node;
            while (current != null) {
                Node next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;
    }
}
