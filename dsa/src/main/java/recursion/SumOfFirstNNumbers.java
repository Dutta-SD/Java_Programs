package recursion;

public class SumOfFirstNNumbers {
    public static void main(String[] args) {
        parameterisedSumOfNumbers(10, 0);
        System.out.println(functionalSumOfNumbers(10));
        parameterisedFactorial(4, 1);
        System.out.println(functionalFactorial(4));
    }

    static void parameterisedSumOfNumbers(int N, int sum) {
        if (N < 1) {
            System.out.println(sum);
            return;
        }
        parameterisedSumOfNumbers(N - 1, sum + N);
    }

    static long functionalSumOfNumbers(int N) {
        if (N == 0) return 0;
        return N + functionalSumOfNumbers(N - 1);
    }

    static void parameterisedFactorial(int N, long fact) {
        if (N == 0) {
            System.out.println(fact);
            return;
        }
        parameterisedFactorial(N - 1, N * fact);
    }

    static long functionalFactorial(int N) {
        if (N == 0) return 1;
        return N * functionalFactorial(N - 1);
    }
}
