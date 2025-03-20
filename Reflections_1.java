import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

class Car {
    private String make;
    private int year;

    public Car(String make, int year) {
        this.make = make;
        this.year = year;
    }

    private void startEngine() {
        System.out.println("Engine started");
    }

    private void stopEngine() {
        System.out.println("Engine stopped");
    }
}

public class Reflections_1 {
    public static void main(String[] args) throws Exception {
        // Create an instance of Car
        Car car = new Car("Toyota", 2025);

        // Access private fields using reflection
        Field makeField = Car.class.getDeclaredField("make");
        Field yearField = Car.class.getDeclaredField("year");

        // Make fields accessible
        makeField.setAccessible(true);
        yearField.setAccessible(true);

        // Print field values
        System.out.println("Make: " + makeField.get(car));
        System.out.println("Year: " + yearField.get(car));

        // Modify the make field dynamically
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Favourite Car Brand:");
        String choice = sc.nextLine();
        makeField.set(car, choice);
        System.out.println("Modified Make: " + makeField.get(car));

        // Invoke private methods using reflection
        Method startEngineMethod = Car.class.getDeclaredMethod("startEngine");
        Method stopEngineMethod = Car.class.getDeclaredMethod("stopEngine");

        // Make methods accessible
        startEngineMethod.setAccessible(true);
        stopEngineMethod.setAccessible(true);

        // Invoke methods
        startEngineMethod.invoke(car);
        stopEngineMethod.invoke(car);
    }
}