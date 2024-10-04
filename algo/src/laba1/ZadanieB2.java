import java.util.Scanner;

public class ZadanieB2 {
    public static void main(String[] args) {
        System.out.println("Введите длину бинарного массива: ");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int[] bi_arr = new int[input];
        System.out.println("Введите элементы бинарного массива: ");
        for (int i = 0; i < input; i++) {
            bi_arr[i] = in.nextInt();
        }
        System.out.println("Введите число для проверки делимости: ");
        int N = in.nextInt();
        boolean[] bi_arr_bool = delimost(input, bi_arr, N);
        System.out.println("Массив с результатами делимости");
        for (boolean b : bi_arr_bool) {
            System.out.println(b + " ");
        }
    }

    public static boolean[] delimost(int input, int[] bi_arr, int N) {
        boolean[] arr_bool = new boolean[input];
        int temp = 0;
        for (int i = 0; i < input; i++) {
            temp = (temp << 1) | bi_arr[i];
            arr_bool[i] = temp % N == 0;
        }
        return arr_bool;
    }
}
