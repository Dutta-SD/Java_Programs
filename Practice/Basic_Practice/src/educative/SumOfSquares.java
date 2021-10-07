/**
 * SumOfSquares
 */
import java.util.*;
public class SumOfSquares {

    public static void main(String[] args) {
        double a, b, c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 3 numbers");

        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        System.out.println(squareSum(a, b, c));

        scanner.close();        
    }

    public static double squareSum(
        double a,
        double b,
        double c
    ){
        return a*a + b*b + c*c;
    }
}