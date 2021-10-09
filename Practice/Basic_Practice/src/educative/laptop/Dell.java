package laptop;

public class Dell extends Laptop {
    Dell(){
        super();
    }

    Dell(String name){
        super(name);
    }

    String getDetails(){
        return getName();
    }   
}
