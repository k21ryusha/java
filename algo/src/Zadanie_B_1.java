import java.util.Arrays;
import java.util.Scanner;
public class Zadanie_B_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        boolean[] b = new boolean[input + 1];
        Arrays.fill(b, true);
        Eratosfen(b,input);
        System.out.println("Простые числа до " + input + ":");
        for (int i = 2; i <= input; i++) {
            if (b[i]) {
                System.out.print(i + " ");
            }
        }
    }
    public static void Eratosfen(boolean[] b, int input) {
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
