import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Car object
        System.out.println("Enter car details:");
        System.out.print("Make: ");
        String carMake = scanner.nextLine();
        System.out.print("Model: ");
        String carModel = scanner.nextLine();
        System.out.print("Year of Manufacture: ");
        int carYear = scanner.nextInt();
        Car car = new Car(carMake, carModel, carYear);
        System.out.print("Number of Doors: ");
        car.setNumberOfDoors(scanner.nextInt());
        scanner.nextLine(); // consume the newline
        System.out.print("Fuel Type (petrol, diesel, electric): ");
        car.setFuelType(scanner.nextLine());

        // Create a Motorcycle object
        System.out.println("Enter motorcycle details:");
        System.out.print("Make: ");
        String motoMake = scanner.nextLine();
        System.out.print("Model: ");
        String motoModel = scanner.nextLine();
        System.out.print("Year of Manufacture: ");
        int motoYear = scanner.nextInt();
        Motorcycle motorcycle = new Motorcycle(motoMake, motoModel, motoYear);
        System.out.print("Number of Wheels: ");
        motorcycle.setNumberOfWheels(scanner.nextInt());
        scanner.nextLine(); // consume the newline
        System.out.print("Type (sport, cruiser, off-road): ");
        motorcycle.setMotorcycleType(scanner.nextLine());

        // Create a Truck object
        System.out.println("Enter truck details:");
        System.out.print("Make: ");
        String truckMake = scanner.nextLine();
        System.out.print("Model: ");
        String truckModel = scanner.nextLine();
        System.out.print("Year of Manufacture: ");
        int truckYear = scanner.nextInt();
        Truck truck = new Truck(truckMake, truckModel, truckYear);
        System.out.print("Cargo Capacity (in tons): ");
        truck.setCargoCapacity(scanner.nextDouble());
        scanner.nextLine(); // consume the newline
        System.out.print("Transmission Type (manual, automatic): ");
        truck.setTransmissionType(scanner.nextLine());

        // Display details of each vehicle
        System.out.println("\nCar Details:");
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYearOfManufacture());
        System.out.println("Number of Doors: " + car.getNumberOfDoors());
        System.out.println("Fuel Type: " + car.getFuelType());

        System.out.println("\nMotorcycle Details:");
        System.out.println("Make: " + motorcycle.getMake());
        System.out.println("Model: " + motorcycle.getModel());
        System.out.println("Year: " + motorcycle.getYearOfManufacture());
        System.out.println("Number of Wheels: " + motorcycle.getNumberOfWheels());
        System.out.println("Type: " + motorcycle.getMotorcycleType());

        System.out.println("\nTruck Details:");
        System.out.println("Make: " + truck.getMake());
        System.out.println("Model: " + truck.getModel());
        System.out.println("Year: " + truck.getYearOfManufacture());
        System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
        System.out.println("Transmission Type: " + truck.getTransmissionType());

        scanner.close();
    }
}
