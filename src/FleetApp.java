import java.util.ArrayList;
import java.util.Scanner;

public class FleetApp {

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n1. Show vehicles");
            System.out.println("2. Add car");
            System.out.println("3. Add bus");
            System.out.println("4. Total insurance");
            System.out.println("5. Service all");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                showVehicles();
            } else if (choice == 2) {
                addCar();
            } else if (choice == 3) {
                addBus();
            } else if (choice == 4) {
                totalInsurance();
            } else if (choice == 5) {
                serviceAll();
            } else if (choice == 6) {
                break;
            } else {
                System.out.println("Wrong choice");
            }
        }
    }

    void showVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles");
            return;
        }
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    void addCar() {
        scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Doors: ");
        int doors = scanner.nextInt();

        vehicles.add(new Car(model, year, price, doors));
    }

    void addBus() {
        scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Capacity: ");
        int capacity = scanner.nextInt();

        vehicles.add(new Bus(model, year, price, capacity));
    }

    void totalInsurance() {
        double sum = 0;
        for (Vehicle v : vehicles) {
            sum += v.calculateInsuranceFee();
        }
        System.out.println("Total insurance: " + sum);
    }

    void serviceAll() {
        for (Vehicle v : vehicles) {
            v.performService();
        }
    }
}
