package car;

import java.util.Optional;

public class Car {
    private String name;
    private String engine;

    public static int numberOfCar;

    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCar++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public static void main(String[] args) {
        Car car1=new Car("Maza 3","Skyactiv 3");
        System.out.println(Car.numberOfCar);
        Car car2=new Car("Maza 6","Skyactiv 6");
        System.out.println(Car.numberOfCar);
    }
}
