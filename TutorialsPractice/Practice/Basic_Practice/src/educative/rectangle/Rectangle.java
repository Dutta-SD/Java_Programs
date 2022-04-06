package rectangle;

public class Rectangle {
    private int length;
    private int breadth;

    Rectangle(){
        this.length = 0;
        this.breadth = 0;
    }

    Rectangle(int length, int breadth){
        this.breadth = breadth;
        this.length = length;
    }

    int getArea(){
        return (this.length * this.breadth);
    }    
}