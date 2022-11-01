package java.basicHashing;

import dsa.basicHashing.BasicHashing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicHashingTest {
    private int[] arr;

    @BeforeEach
    void setUp() {
        this.arr = new int[]{1, 2, 2, 3, 5, 1, 2, 9, 0, 4, 1, 2};
    }

    @Test
    void getArrayElementFrequencies() {
        System.out.println(BasicHashing.getArrayElementFrequencies(arr));
    }

    @Test
    void getMostFrequentElements() {
        int maxValue = BasicHashing.getMostFrequentElement(arr);
        Assertions.assertEquals(maxValue, 2);
    }
}