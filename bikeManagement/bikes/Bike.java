package bikeManagement.bikes;

import bikeManagement.PickUp;
import dataStructures.Iterator;
import dataStructures.Queue;

public interface Bike {

        String getBikeId();

        String getPlate();

        void pickUp(PickUp pickup);

        void pickDown();

        Iterator<PickUp> getPickUps();
}
