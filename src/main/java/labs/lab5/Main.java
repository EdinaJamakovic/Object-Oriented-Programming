package labs.lab5;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Toyota Corolla", 50000, 80));
        vehicles.add(new Truck("Ford F-150", 80000, 70));
        vehicles.add(new Motorcycle("Kawasaki Ninja", 20000, 90));

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.service());
            vehicle.simulateYear();
            System.out.println(vehicle);

            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                car.drive(150);
                System.out.println(car.repair());
            } else if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                truck.haul(6000);
                System.out.println(truck.repair());
            } else if (vehicle instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                motorcycle.race(100);
            }
        }

        System.out.println("performMaintenance on vehicles:");
        for (Vehicle vehicle : vehicles) {
            Vehicle.performMaintenance(vehicle);
        }
    }

}
