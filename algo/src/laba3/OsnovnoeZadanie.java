package laba3;

import java.util.Scanner;

public class OsnovnoeZadanie {

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        int border = arr[middle];
        int i = low;
        int j = high;
        while (i <= j) {
            while (arr[i] < border) {
                i++;
            }
            while (arr[j] > border) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (i < high) {
            quickSort(arr, i, high);
        }
    }
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val = val;
            left = right = null;
        }
    }
    private static TreeNode insert(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(val < root.val){
            root.left = insert(root.left, val);
        }
        else if(val > root.val){
            root.right = insert(root.right, val);
        }
        return root;
    }
    private static int inOrder(TreeNode root,int[] arr, int index){
        if(root != null){
            index = inOrder(root.left, arr, index);
            arr[index++] = root.val;
            index = inOrder(root.right, arr , index);
        }
        return index;
    }
    public static void treeSort(int[] arr){
        TreeNode root = null;
        for (int val: arr) {
            root = insert(root, val);
        }
        inOrder(root, arr, 0);
    }

    public static void heapSort(int[] arr){
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr,n,i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr,i,0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }



    public static void main(String[] args) {
        System.out.print("Введите длину массива: ");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int[] arr = new int[input];
        System.out.println("Введите элементы неотсортированного массива: ");
        for (int i = 0; i < input; i++) {
            int num = in.nextInt();
            arr[i] = num;
        }
        System.out.println("Неотсортированный массив:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        quickSort(arr, 0, arr.length - 1);
        treeSort(arr);
        heapSort(arr);
        System.out.println();
        System.out.println("Отсортированный массив: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
