package BTDEMO.entity;

import BTDEMO.engine.Intersection;

public class PriorityVehicle extends Vehicle {

    public PriorityVehicle(String id, int speed, Intersection intersection) {
        super(id, speed, intersection);
    }

    @Override
    public boolean isPriority() {
        return true;
    }
}