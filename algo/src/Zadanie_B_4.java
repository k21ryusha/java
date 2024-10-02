import java.util.Scanner;
public class Zadanie_B_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        String str = Integer.toString(input);

        for(int i=0;i<str.length();i++){
            char currentChar= str.charAt(i);
            if(Character.getNumericValue(currentChar)%2!=0){
                if(i==0){
                    System.out.print(currentChar+"-");
                }
                else if(i==str.length()-1){
                    System.out.print("-"+currentChar);
                }
                else{
                    System.out.print("-"+currentChar+"-");
                }
            } else{
                System.out.print(currentChar);
            }

        }

    }
}