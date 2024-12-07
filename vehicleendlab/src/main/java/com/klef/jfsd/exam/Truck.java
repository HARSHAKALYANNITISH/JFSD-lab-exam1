package com.klef.jfsd.exam;

import javax.persistence.Entity;

@Entity
public class Truck extends Vehicle {

    private int loadCapacity;

    // Getters and setters
    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "Truck [id=" + getId() + ", name=" + getName() + ", type=" + getType() + ", maxSpeed=" + getMaxSpeed() +
               ", color=" + getColor() + ", loadCapacity=" + loadCapacity + "]";
    }
}
