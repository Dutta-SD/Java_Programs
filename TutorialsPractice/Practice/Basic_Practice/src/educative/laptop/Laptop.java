package laptop;

public class Laptop {
    private String name;

    public String getName() {
        return name;
    }

    Laptop(){
        this.name = "";
    }

    Laptop(String name){
        this.name = name;
    }    
}