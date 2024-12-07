package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientDemo {

    public static void main(String[] args) {

        // Create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Vehicle.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Truck.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Create Vehicle object
            Vehicle vehicle = new Vehicle();
            vehicle.setName("Generic Vehicle");
            vehicle.setType("SUV");
            vehicle.setMaxSpeed(180);
            vehicle.setColor("Black");

            // Create Car object
            Car car = new Car();
            car.setName("Toyota Camry");
            car.setType("Sedan");
            car.setMaxSpeed(200);
            car.setColor("White");
            car.setNumberOfDoors(4);

            // Create Truck object
            Truck truck = new Truck();
            truck.setName("Ford F-150");
            truck.setType("Pickup");
            truck.setMaxSpeed(160);
            truck.setColor("Blue");
            truck.setLoadCapacity(5000);

            // Start a transaction
            session.beginTransaction();

            // Save the objects
            session.save(vehicle);
            session.save(car);
            session.save(truck);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Objects saved!");

            // New session to fetch and print the data
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Fetch all vehicles
            System.out.println("\nFetching all vehicles...");
            Vehicle fetchedVehicle = session.get(Vehicle.class, 1);
            System.out.println(fetchedVehicle);

            // Commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
