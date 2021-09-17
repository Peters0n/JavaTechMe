import java.util.Random;

import exceptions.ExceptionOutOfOdd;

public class Car {
    private String model;
    private double velocity;
    private double price;

    public Car(String model, double velocity, double price) {
        this.model = model;
        this.velocity = velocity;
        this.price = price;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void start() throws ExceptionOutOfOdd {
        System.out.println("Model " + getModel() + "; velocity: " + getVelocity() + "; price: " + getPrice() + ";");
        int aExcept = new Random().nextInt(20);
        System.out.println("Random gidit is " + aExcept);
        if (aExcept % 2 == 0) {
            throw new ExceptionOutOfOdd();
        } else {
            System.out.println("Car " + this.model + " was started!");
        }
    }

    public static void main(String[] args) {
        var auto1 = new Car("Ford", 200, 25000);
        var auto2 = new Car("Audi", 250, 40000);
        try {
            auto1.start();

        } catch (ExceptionOutOfOdd e) {
            e.exception_OutOfOdd();
        }
        try {
            auto2.start();

        } catch (ExceptionOutOfOdd e) {
            e.exception_OutOfOdd();
        }
    }
}
