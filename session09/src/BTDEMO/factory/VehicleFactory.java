package BTDEMO.factory;

import BTDEMO.entity.*;
import BTDEMO.engine.Intersection;

import java.util.Random;

public class VehicleFactory {

    private static int counter = 0;

    public static Vehicle createRandomVehicle(Intersection intersection) {

        Random random = new Random();
        counter++;

        int type = random.nextInt(4);

        switch (type) {
            case 0:
                return new StandardVehicle("Xe May-" + counter, 60, intersection);

            case 1:
                return new StandardVehicle("Xe Con-" + counter, 50, intersection);

            case 2:
                return new StandardVehicle("Xe Tai-" + counter, 40, intersection);

            default:
                return new PriorityVehicle("Xe Cuu Thuong-" + counter, 80, intersection);
        }
    }
}