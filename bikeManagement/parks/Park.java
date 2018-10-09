package bikeManagement.parks;

import bikeManagement.bikes.Bike;
import dataStructures.Queue;

public interface Park {

    String getParkId();

    String getName();

    String getAddress();

    Queue<String> getParkInfo();

    void parkBike(Bike bike);

    void pickUp();

    int getPickups();

}
