package bikeManagement.bikes;

import bikeManagement.PickUp;
import bikeManagement.parks.Park;
import dataStructures.Iterator;
import dataStructures.Queue;

import java.io.Serializable;

public interface Bike extends Serializable {

        String getBikeId();

        String getPlate();

        Park getPark();

        void pickUp(PickUp pickup);

        void pickDown();

        Iterator<PickUp> getPickUps();

        boolean isMoving();
}
