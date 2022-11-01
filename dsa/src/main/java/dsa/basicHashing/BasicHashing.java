package dsa.basicHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BasicHashing {

    private static int maxKey = -1;
    private static int maxValue = Integer.MIN_VALUE;

    public static Map<Integer, Integer> getArrayElementFrequencies(int[] arr) {
        Map<Integer, Integer> frequencyCounts = new HashMap<>();
        Arrays.stream(arr).forEach(e -> frequencyCounts.merge(e, 1, Integer::sum));
        return frequencyCounts;
    }

    private static void compareForGreaterCount(int currentKey, int currentValue) {
        if (currentValue > maxValue) {
            maxValue = currentValue;
            maxKey = currentKey;
        }
    }

    public static int getMostFrequentElement(int[] arr) {
        Map<Integer, Integer> frequencyCounts = getArrayElementFrequencies(arr);
        frequencyCounts.forEach(BasicHashing::compareForGreaterCount);
        return maxKey;
    }
}
