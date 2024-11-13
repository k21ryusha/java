package laba1;

import java.util.Scanner;

public class ZadanieB3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        char currentChar = input.charAt(0);
        System.out.print(currentChar);
        for (int i = 1; i < input.length(); i++) {
            currentChar = input.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                System.out.print(" " + currentChar);
            }else{
                System.out.print(currentChar);
            }
        }
    }
}
