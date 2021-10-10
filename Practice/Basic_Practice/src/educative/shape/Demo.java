package shape;

class Shape {
    private String name;

    public String getName() {
        return name;
    }

    Shape() {
        this.name = "Shape";
    }

    Shape(String name) {
        this.name = name;
    }
}
    

class XShape extends Shape {
    private String name;

    @Override
    public String getName() {
        return super.getName() + ", " + this.name;
    }

    XShape(String name) {
        this.name = name;
    }
}

public class Demo {
    public static void main(String[] args) {
        Shape s = new XShape("Circle");
        System.out.println(s.getName());
    }
}