package calculator;

public class Demo {
    public static void main(String[] args) {
        Calculator c = new Calculator(10, 12);
        System.out.println(c.add());
        System.out.println(c.subtract());
        System.out.println(c.multiply());
        System.out.println(c.divide());
    }    
}
