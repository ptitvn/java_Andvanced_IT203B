package BTDEMO.engine;

import BTDEMO.entity.Vehicle;
import BTDEMO.factory.VehicleFactory;
import BTDEMO.pattern.TrafficLight;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulationEngine {

    public void startSimulation() {

        TrafficLight trafficLight = new TrafficLight();

        Thread lightThread = new Thread(trafficLight);
        lightThread.setDaemon(true);
        lightThread.start();

        Intersection intersection = new Intersection(trafficLight);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {

            Vehicle vehicle = VehicleFactory.createRandomVehicle(intersection);

            executor.submit(vehicle);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}