package laba2;

import java.util.*;

public class ZadanieOsnovnoe {
    static long iterationsCount = 10000000;

    public static void ArrayList() {
        ArrayList<Student> students = new ArrayList<>();
        long startTime = System.nanoTime(); 
        for (long i = 0; i < iterationsCount; i++) {
            students.add(new Student(i, "student" + i));
        }
        long endTime = System.nanoTime(); 
        System.out.println("ArrayList:");
        System.out.println("Добавление " + iterationsCount + " элементов: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.add(new Student(iterationsCount, "student" + iterationsCount));
        endTime = System.nanoTime(); 
        System.out.println("1. Добавление элемента в конце: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.add(0, new Student(-1L, "student-1"));
        endTime = System.nanoTime(); 
        System.out.println("2. Добавление элемента в начало: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.remove((int) iterationsCount - 1);
        endTime = System.nanoTime(); 
        System.out.println("3. Удаление последнего элемента: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.remove(0);
        endTime = System.nanoTime(); 
        System.out.println("4. Удаление первого элемента: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        Student centralStudent = students.get((int) iterationsCount / 2);
        endTime = System.nanoTime(); 
        System.out.println("5. Взятие центрального элемента: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        Student lastStudent = students.get((int) iterationsCount - 1);
        endTime = System.nanoTime(); 
        System.out.println("6. Взятие последнего элемента: " + (endTime - startTime) + " наносекунд\n");
    }

    public static void LinkedList() {
        // работа с linked list
        LinkedList<Student> students = new LinkedList<>();
        long startTime = System.nanoTime(); 
        for (long i = 0; i < iterationsCount; i++) {
            students.add(new Student(i, "student" + i));
        }
        long endTime = System.nanoTime(); 
        System.out.println("LinkedList:");
        System.out.println("Добавление " + iterationsCount + " элементов: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.addLast(new Student(iterationsCount, "student" + iterationsCount));
        endTime = System.nanoTime(); 
        System.out.println("1. Добавление элемента в конце: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.addFirst(new Student(-1L, "student-1"));
        endTime = System.nanoTime(); 
        System.out.println("2. Добавление элемента в начало: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.removeLast();
        endTime = System.nanoTime(); 
        System.out.println("3. Удаление последнего элемента: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.removeFirst();
        endTime = System.nanoTime(); 
        System.out.println("4. Удаление первого элемента: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        Student centralStudent = students.get((int) iterationsCount / 2);
        endTime = System.nanoTime(); 
        System.out.println("5. Взятие центрального элемента: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        Student lastStudent = students.get((int) iterationsCount - 1);
        endTime = System.nanoTime(); 
        System.out.println("6. Взятие последнего элемента: " + (endTime - startTime) + " наносекунд\n");
    }

    public static void HashSet() {
        // работа с hash map
        HashSet<Student> students = new HashSet<>();
        long startTime = System.nanoTime(); 
        for (long i = 0; i < iterationsCount; i++) {
            students.add(new Student(i, "student" + i));
        }
        long endTime = System.nanoTime(); 
        System.out.println("HashSet:");
        System.out.println("Добавление " + iterationsCount + " элементов: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.add(new Student(iterationsCount, "student" + iterationsCount));
        endTime = System.nanoTime(); 
        System.out.println("1. Добавление элемента: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.add(new Student(-1L, "student-1"));
        endTime = System.nanoTime(); 
        System.out.println("2. Добавление элемента: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.remove(new Student(iterationsCount - 1, "student-" + (iterationsCount - 1)));
        endTime = System.nanoTime(); 
        System.out.println("3. Удаление элемента: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.remove(new Student(-1L, "student-1"));
        endTime = System.nanoTime(); 
        System.out.println("4. Удаление первого элемента: " + (endTime - startTime) + " наносекунд");
    }

    public static void HashMap() {
        // работа с hash map
        Map<Long, Student> students = new HashMap<>();
        long startTime = System.nanoTime(); 
        for (long i = 0; i < iterationsCount; i++) {
            students.put(i, new Student(i, "student" + i));
        }
        long endTime = System.nanoTime(); 
        System.out.println("HashMap:");
        System.out.println("Добавление " + iterationsCount + " элементов: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.put(iterationsCount, new Student(iterationsCount, "student" + iterationsCount));
        endTime = System.nanoTime(); 
        System.out.println("1. Добавление элемента в конце: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.put((long) -1, new Student(-1L, "student-1"));
        endTime = System.nanoTime(); 
        System.out.println("2. Добавление элемента в начало: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.remove(new Student(iterationsCount, "student-" + iterationsCount));
        endTime = System.nanoTime(); 
        System.out.println("3. Удаление элемента в конце : " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        students.remove(new Student(-1L, "student-1"));
        endTime = System.nanoTime(); 
        System.out.println("4. Удаление первого элемента: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        Student centralStudent = students.get((int) iterationsCount / 2);
        endTime = System.nanoTime(); 
        System.out.println("5. Взятие центрального элемента: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime(); 
        Student lastStudent = students.get((int) iterationsCount);
        endTime = System.nanoTime(); 
        System.out.println("6. Взятие последнего элемента: " + (endTime - startTime) + " наносекунд\n");
    }

    public static void CircularyDoublyLinkedList() {
        CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<>();
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
        list.heapSort(Comparator.naturalOrder());
        System.out.println(("Отсортированный массив: "));
        list.printForward();
    }

    public static void SelfOrganisedList(){
        SelfOrganizingList<String> list = new SelfOrganizingList<>();
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
        list.quickSort(Comparator.naturalOrder());
        list.heapSort(Comparator.naturalOrder());
        list.printForward();
    }
    public static void MultilevelSinglyLinkedList() {
        MultilevelSinglyLinkedList list = new MultilevelSinglyLinkedList();
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
        list.remove(3); // Удаляем элемент с индексом 3
        System.out.println("Список после удаления элемента:");
        list.printList();
        System.out.println("Число элементов в списке: " + list.size());
        //list.quickSort();
        list.heapSort();
        System.out.println("Отсортированный массив: ");
        list.printList();
    }
    public static void main(String[] args) {
        //ArrayList();
        //LinkedList();
        //HashSet();
        //HashMap();
        //CircularyDoublyLinkedList();
        //SelfOrganisedList();
        MultilevelSinglyLinkedList();
    }
}