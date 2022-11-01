package dsa.dp;

import org.junit.jupiter.api.Test;

class ItemTimeCoefficientMaximiseTest {
    @Test
    void maxItemTimeProductSum() {
        ItemTimeCoefficientMaximise itemTimeCoefficientMaximise = new ItemTimeCoefficientMaximise();
        int[] values = {-1, 3, 4};
        int[] times = {1, 2, 3};
        System.out.println(itemTimeCoefficientMaximise.maxItemTimeProductSum(values, times));
    }
}