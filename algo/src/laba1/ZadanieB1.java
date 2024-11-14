package laba1;
import java.util.Scanner;

public class ZadanieB1 {
    public static void main(String[] args) {
        System.out.print("Введите количество простых чисел, которые необходимо найти: ");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int num = 0;
        int k = 0;
        System.out.println("Первые " + input + " простых чисел:");
        eratosfen(input);
        System.out.println();
        while (k < input) {
            if (perebor_del(num)) {
               System.out.print(num + " ");
                k++;
            }
            num++;
        }
    }
    public static void eratosfen(int input) {
        long lim =2;
        int k = 0;
        while (true) {
            if (eratosfen_count((int)lim) >= input) {
                break;
            }
            lim *=2;
        }
        boolean[] b = new boolean[(int)lim + 1];
        for (int i = 2; i <= lim; i++) {
            b[i] = true;
        }
        b[0] = b[1] = false;
        for (int i = 2; i <= Math.sqrt(lim); i++) {
            if (b[i]) {
                for (int j = i * i; j <= lim; j += i) {
                    b[j] = false;
                }
            }
        }
        for (int i = 2; i <= lim && k < input; i++) {
            if (b[i]) {
                System.out.print(i + " ");
                k++;
            }
        }
    }

    public static int eratosfen_count(long lim) {
        boolean[] b = new boolean[(int)lim + 1];
        for (int i = 2; i <= lim; i++) {
            b[i] = true;
        }
        b[0] = b[1] = false;
        for (int i = 2; i <= Math.sqrt(lim); i++) {
            if (b[i]) {
                for (int j = i * i; j <= lim; j += i) {
                    b[j] = false;
                }
            }
        }
        int k = 0;
        for (int i = 2; i <= lim; i++) {
            if (b[i]) {
                k++;
            }
        }

        return k;
    }

    /// перебор делителей и сравнить скорость

    public static boolean perebor_del(int input) {
        if (input < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(input); i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }
}
/// простые числа не до числа а N чисел
/// перебор работает со сложность O(nsqrt(n)) a метод Эрастофена с O(n(log(log(n))^2)