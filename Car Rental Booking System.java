import java.util.ArrayList;
import java.util.List;

// Car class representing a car in the system
class Car {
    private String carId;
    private String brand;
    private String model;
    private boolean available;

    public Car(String carId, String brand, String model) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.available = true; // Initially, car is available for booking
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

// CarRentalSystem class managing the car rental operations
public class CarRentalSystem {
    private List<Car> cars;

    public CarRentalSystem() {
        cars = new ArrayList<>();
    }

    // Add a new car to the system
    public void addCar(String carId, String brand, String model) {
        cars.add(new Car(carId, brand, model));
    }

    // Get available cars for booking
    public List<Car> getAvailableCars() {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAvailable()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    // Book a car by car ID
    public boolean bookCar(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && car.isAvailable()) {
                car.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    // Return a booked car
    public boolean returnCar(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && !car.isAvailable()) {
                car.setAvailable(true);
                return true;
            }
        }
        return false;
    }

    // Main method to test the CarRentalSystem
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();
        rentalSystem.addCar("001", "Toyota", "Camry");
        rentalSystem.addCar("002", "Honda", "Accord");

        List<Car> availableCars = rentalSystem.getAvailableCars();
        System.out.println("Available Cars:");
        for (Car car : availableCars) {
            System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());
        }

        System.out.println("Booking Car 001...");
        if (rentalSystem.bookCar("001")) {
            System.out.println("Car 001 booked successfully!");
        } else {
            System.out.println("Failed to book Car 001.");
        }

        System.out.println("Available Cars after booking:");
        availableCars = rentalSystem.getAvailableCars();
        for (Car car : availableCars) {
            System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());
        }
    }
}
