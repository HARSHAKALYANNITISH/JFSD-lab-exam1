package com.klef.jfsd.exam;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {

    private int numberOfDoors;

    // Getters and setters
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return "Car [id=" + getId() + ", name=" + getName() + ", type=" + getType() + ", maxSpeed=" + getMaxSpeed() +
               ", color=" + getColor() + ", numberOfDoors=" + numberOfDoors + "]";
    }
}
