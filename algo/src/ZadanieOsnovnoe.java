import java.util.Scanner;

public class ZadanieOsnovnoe {
    public static void main(String[] args) {
        int j, temp;
        System.out.println("Программа для реализации бинарного поиска");
        System.out.print("Введите длину искомого массива: ");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int[] arr = new int[input];
        System.out.print("Введите элементы искомого массива: ");
        for (int i = 0; i < input; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < input; i++) {
            for (j = i + 1; j < input; j++) {
                if (arr[j] < arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("Отсортированный массив: ");
        for (int i = 0; i < input; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("Введите число, номер которого вы хотите найти в отсортированном массиве: ");
        int n = in.nextInt();
        int result = binarySearch(arr, n);
        System.out.println("Номер вашего числа в отсортированном массиве равен " + result);
        int result1 = binarySearchRec(arr, n, 0, arr.length - 1);
        System.out.println("Номер вашего числа в отсортированном массиве равен " + result1 + " (рекурсия)");
    }

    public static int binarySearch(int[] arr, int n) {
        int start = 0;
        int tail = arr.length - 1;
        while (start <= tail) {
            int mid = (start + tail) / 2;
            if (n == arr[mid]) {
                return mid;
            }
            if (n > arr[mid]) {
                start = mid + 1;
            } else {
                tail = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRec(int[] arr, int n, int start, int tail) {
        if (start == tail) {
            if (arr[start] == n) {
                return start;
            }
            return -1;
        }
        int mid = (start + tail) / 2;
        if (arr[mid] == n) {
            return mid;
        }
        if (arr[mid] > n) {
            return binarySearchRec(arr, n, start, mid);
        }
        return binarySearchRec(arr, n, mid, tail);
    }
}
