import java.util.Scanner;

public class LearnOverriding {
    public static void main(String[] args) {
        int a;
        float b;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextByte();
        b = scanner.nextFloat();
        System.out.println(ovMethod(a, b));
    }

    private static int ovMethod(int a, double b) {
        return (int) (a * b);
    }

    private static int ovMethod(int a, float b) {
        return (int) (a - b);
    }


}
