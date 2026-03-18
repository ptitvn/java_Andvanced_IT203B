package BTDEMO.entity;

import BTDEMO.engine.Intersection;

public abstract class Vehicle implements Runnable {

    protected String id;
    protected int speed;
    protected Intersection intersection;

    public Vehicle(String id, int speed, Intersection intersection) {
        this.id = id;
        this.speed = speed;
        this.intersection = intersection;
    }

    public String getId() {
        return id;
    }

    public abstract boolean isPriority();

    @Override
    public void run() {
        try {

            // Xe tiến vào giao lộ
            intersection.enterIntersection(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}