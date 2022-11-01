package dsa.recursion;

import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        // Reverse with customisable start and end index. Can be used for partial reversal
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        reverseParameterised(arr, 0, 6);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void reverseParameterised(int[] arr, int start, int end) {
        if (start >= end) return;
        swap(arr, start, end);
        reverseParameterised(arr, start + 1, end - 1);
    }
}
