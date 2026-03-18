package BTDEMO.entity;

import BTDEMO.engine.Intersection;

public class StandardVehicle extends Vehicle {

    public StandardVehicle(String id, int speed, Intersection intersection) {
        super(id, speed, intersection);
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}