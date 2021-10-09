package rectangle;

public class RectangleDemo {
    private static final int _10 = 10;
    private static final int _18 = 18;

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(_18, _10);
        System.out.println(rect.getArea());
    }    
}
