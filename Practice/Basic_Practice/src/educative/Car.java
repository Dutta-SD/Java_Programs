class Car {
    int x, y, z;

    public Car(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Parameterized Constructor
    public Car(int x, int y, int z){
        this(x, y);
        this.z = z;
    }       
}