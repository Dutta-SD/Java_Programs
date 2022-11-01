package dsa.sorting1;


import java.util.Arrays;

public class SelectionSortRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 9, -1, 5, 10, 6};
        selectionSortRecursively(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void selectionSortRecursively(int[] arr, int startIdx) {
        if (startIdx == arr.length) return;
        int minElementIdx = getMinElementIndex(arr, startIdx);
        swap(arr, minElementIdx, startIdx);
        int newStartIdx = startIdx + 1;
        selectionSortRecursively(arr, newStartIdx);
    }

    private static int getMinElementIndex(int[] arr, int startIdx) {
        int minValue = Integer.MAX_VALUE;
        int idxOfMin = 0;
        for (int currentIdx = startIdx; currentIdx < arr.length; currentIdx++) {
            if (arr[currentIdx] < minValue) {
                minValue = arr[currentIdx];
                idxOfMin = currentIdx;
            }
        }
        return idxOfMin;
    }
}

