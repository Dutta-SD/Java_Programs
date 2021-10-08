package calculator;

public class Calculator {
    private double num1, num2;

    // Constructor
    public Calculator(double num1, double num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public double add(){
        return this.num1 + this.num2;
    }
    public double subtract(){
        return this.num1 - this.num2;
    }
    public double multiply(){
        return this.num1 * this.num2;
    }
    public double divide(){
        return this.num1 / this.num2;
    }   
}