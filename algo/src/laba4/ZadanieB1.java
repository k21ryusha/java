package laba4;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ZadanieB1 {
    public static void main(String[] args) {
        System.out.println("Введите длину массива: ");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int[] nums = new int[input];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < input; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println("Какой по счету больший элемент вы хотите найти?");
        int k = in.nextInt();
        int result = findKthLargest(nums, k);
        System.out.println("K-ый самый большой элемент: " + result);
    }
    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}