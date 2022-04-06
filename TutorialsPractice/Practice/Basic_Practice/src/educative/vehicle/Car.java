package vehicle;

public class Car extends Vehicle {
    private String carName;

    Car(String carName, String speed, String model){
        this.carName = carName;
        setModel(model);
        setSpeed(speed);    
    }

    public String getDetails(String name){
        return String.format("%s, %s, %s", this.carName, getModel(), getSpeed());        
    }   
}
