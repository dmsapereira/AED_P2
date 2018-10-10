package bikeManagement.parks;

import bikeManagement.bikes.Bike;
import dataStructures.Queue;

import java.io.Serializable;

public interface Park extends Serializable {

    String getParkId();

    String getName();

    String getAddress();

    Queue<String> getParkInfo();

    void parkBike(Bike bike);

    void addBike(Bike bike);

    void deleteBike();

    void pickUp();

    int getPickups();

    Bike getParkedBike();

}
