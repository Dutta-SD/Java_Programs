package dsa.recursion;

public class RecursionSimpleProblems {
    static int count;
    static String NAME = "myName";
    static int N;

    public static void main(String[] args) {
        // Run only one function at a time
        count = N = 10;
        printNTo1();
    }

    public static void printNameNTimes() {
        if (count == N) return;
        System.out.println(count + NAME);
        count++;
        printNameNTimes();
    }

    public static void print1ToN() {
        if (count == N) return;
        System.out.println(count++);
        print1ToN();
    }

    public static void printNTo1() {
        // Set count to N before running
        if (count == 0) return;
        System.out.println(count--);
        printNTo1();
    }
}
