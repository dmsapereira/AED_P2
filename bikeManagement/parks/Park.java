package bikeManagement.parks;

import bikeManagement.bikes.Bike;

public interface Park {

    String getParkId();

    void parkBike(Bike bike);

    void pickUp();

}
