package bikeManagement;

import bikeManagement.bikes.Bike;
import bikeManagement.parks.Park;
import bikeManagement.users.User;

import java.io.Serializable;

public interface PickUp extends Serializable {

    User getUser();

    Bike getBike();

    void pickDown(Park park, int duration);

    Park getInitialPark();

    Park getFinalPark();

    int getDuration();

    int getDelay();

    int getCost();
}
