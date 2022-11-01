package dsa.dp;

public class ItemTimeCoefficientMaximise {

    private int[] finalItemValues;
    private int[] finalItemTimes;

    private int[] addZeroToArrayBeginning(int[] arr) {
        int[] newArr = new int[arr.length + 1];
        newArr[0] = 0;
        System.arraycopy(arr, 0, newArr, 1, newArr.length);
        return newArr;
    }

    public int maxItemTimeProductSum(int[] itemValues, int[] itemTimes) {
        finalItemValues = addZeroToArrayBeginning(itemValues);
        finalItemTimes = addZeroToArrayBeginning(itemTimes);
        int[][] dpMatrix = getDpMatrix();
        return calculateMaxItemProductSum(dpMatrix);
    }

    private int[][] getDpMatrix() {
        return new int[finalItemTimes.length][finalItemValues.length];
    }

    private int calculateMaxItemProductSum(int[][] dp) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = i; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + finalItemTimes[i] * finalItemValues[j];
            }
        }
        return Math.max(dp[finalItemTimes.length - 1][finalItemValues.length - 1], 0);
    }
}
