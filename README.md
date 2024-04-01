### Car Rental Booking System

This Java program implements a simple Car Rental Booking System. It allows users to add cars to the system, view available cars for booking, book a car, and return a booked car.

### Car Class

The `Car` class represents a car in the system with the following attributes:

- `carId`: Unique identifier for the car
- `brand`: Brand of the car
- `model`: Model of the car
- `available`: Availability status of the car

### CarRentalSystem Class

The `CarRentalSystem` class manages car rental operations such as adding cars, getting available cars, booking a car, and returning a car. It contains the following methods:

- `addCar`: Adds a new car to the system.
- `getAvailableCars`: Retrieves a list of available cars for booking.
- `bookCar`: Books a car by its ID if it is available.
- `returnCar`: Returns a booked car to make it available again.

### Usage

To use the `CarRentalSystem`, you can create an instance of the class and perform operations such as adding cars, getting available cars, booking a car, and returning a car.

```java
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

```
