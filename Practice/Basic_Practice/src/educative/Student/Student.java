package Student;

public class Student {
    private String name;
    private double mark1, mark2;

    public Student(){
        this.name = "";
        this.mark1 = 0.0;
        this.mark2 = 0.0;
    }

    public Student(String name, double mark1, double mark2){
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.name = name;
    }

    public double getMarks(int markNumber){
        if(markNumber == 1) return this.mark1;
        else return this.mark2;
    }

    public double calcTotal(){
        return this.getMarks(1) + this.getMarks(2);
    }

    public String getName() {
        return name;
    }

    public double getMark1() {
        return mark1;
    }

    public double getMark2() {
        return mark2;
    }
}
