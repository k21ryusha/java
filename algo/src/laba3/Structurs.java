package laba3;
import java.util.*;
public class Structurs {
    public static void CircularyDoublyLinkedList() {
        laba3.CircularDoublyLinkedList<Integer> list = new laba3.CircularDoublyLinkedList<>();
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(1);
        System.out.println("Список в прямом порядке:");
        list.printForward();
        System.out.println("Список в обратном порядке:");
        list.printBackward();
        System.out.println("Количество элементов в списке: "+list.size());
        System.out.println("Список после удаления одного элемента:");
        list.remove(3);
        list.printForward();
        System.out.println("Количество элементов в списке после удаления: "+list.size());
        //list.quickSort(Comparator.naturalOrder());
        //list.heapSort(Comparator.naturalOrder());
        //System.out.println(("Отсортированный массив: "));
        //list.printForward();
        System.out.println(list.Check());
    }

    public static void SelfOrganisedList(){
        laba3.SelfOrganizingList<String> list = new laba3.SelfOrganizingList<>();
        list.addToFront("B");
        list.addToFront("C");
        list.addToMiddle("A", 2);
        list.insertForward("E");
        System.out.println("Список в прямом порядке:");
        list.printForward();
        System.out.println("Список в обратном порядке:");
        list.printBackward();
        list.get("C");
        System.out.println("Список после доступа к элементу 'E':");
        list.printForward();
        list.get("B");
        System.out.println("Список после доступа к элементу 'A':");
        list.printForward();
        list.get("E");
        list.get("A");
        System.out.println("Список после доступа к элементу 'B':");
        list.printForward();
        list.remove("C");
        System.out.println("Список после удаления элемента 'C':");
        list.printForward();
        System.out.println("Число элементов в списке: " + list.size());
        System.out.println("Отсортированный массив: ");
        //list.quickSort(Comparator.naturalOrder());
        //list.heapSort(Comparator.naturalOrder());
        list.printForward();
    }
    public static void MultilevelSinglyLinkedList() {
        laba3.MultilevelSinglyLinkedList list = new laba3.MultilevelSinglyLinkedList();
        list.addToFront(1);
        list.addToFront(2);
        list.addToEnd(3);
        list.addToEnd(4);
        list.addToMiddle(5, 2);
        list.printList();
        list.addChild(1, 7);
        list.addChild(1, 6);
        list.addChild(2, 8);
        list.printList();
        list.remove(1); // Удаляем элемент с индексом 3
        System.out.println("Список после удаления элемента:");
        list.printList();
        System.out.println("Число элементов в списке: " + list.size());
        //list.quickSort();
        //list.heapSort();
        System.out.println("Отсортированный массив: ");
        list.printList();
    }
    public static void Stack(){
        System.out.println("Введите размер стека: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n+1; i++) {
            stack.push(i);
        }
        stack.printStack();
        for (int i = 0; i < n+1; i++) {
            System.out.println("Верхний элемент: " + stack.peek());
            System.out.println("Удален элемент: " + stack.pop());
        }
    }
    public static void main(String[] args) {
        //ArrayList();
        //LinkedList();
        //HashSet();
        //HashMap();
        //CircularyDoublyLinkedList();
        //SelfOrganisedList();
        //MultilevelSinglyLinkedList();
        Stack();
    }
}