package laba1;
import java.util.Scanner;

public class ZadanieB1 {
    public static void main(String[] args) {
        System.out.print("Введите число до которого будут выведены простые числа: ");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        boolean[] b = new boolean[input + 1];
        for (int h = 0; h <= input; h++) {
            b[h] = true;
        }
        eratosfen(b, input);
        System.out.println("Простые числа до " + input + ":");
        for (int i = 2; i <= input; i++) {
            if (b[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void eratosfen(boolean[] b, int input) {
        b[0] = b[1] = false;
        for (int i = 2; i * i <= input; i++) {
            if (b[i]) {
                for (int j = i * i; j <= input; j += i) {
                    b[j] = false;
                }
            }
        }
    }
}
/// перебор делителей и сравнить скорость
/// простые числа не до числа а N чисел