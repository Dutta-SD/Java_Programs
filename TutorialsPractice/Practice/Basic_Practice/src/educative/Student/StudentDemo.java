package Student;

public class StudentDemo {
    public static void main(String[] args) {
        Student s = new Student("Jack", 60, 70);
        System.out.println(s.getMarks(1));
        System.out.println(s.getMarks(2));
        System.out.println(s.calcTotal());        
    }
}
