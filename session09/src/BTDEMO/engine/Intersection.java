package BTDEMO.engine;

import BTDEMO.entity.Vehicle;
import BTDEMO.pattern.TrafficLight;

import java.util.concurrent.locks.ReentrantLock;

public class Intersection {

    private ReentrantLock lock = new ReentrantLock();

    private TrafficLight trafficLight;

    public Intersection(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public void enterIntersection(Vehicle vehicle) {


            try {

                if (trafficLight.getState().equals("RED") && !vehicle.isPriority()) {
                    System.out.println(vehicle.getId() + " đang dừng vì đèn đỏ");
                    return;
                }

                lock.lock();

                System.out.println( vehicle.getId() + " đang đi qua ngã tư");

                Thread.sleep(1000);

                System.out.println( vehicle.getId() + " đã rời khỏi ngã tư");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }

            }
    }
}