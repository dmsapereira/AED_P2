package bikeManagement.bikes;

import bikeManagement.pickup.PickUp;
import bikeManagement.parks.Park;
import dataStructures.Iterator;

import java.io.Serializable;

public interface Bike extends Serializable {

    /**
     * Retuns bike's unique ID
     *
     * @return bikeID
     */
    String getBikeId();

    /**
     * Returns bike's plate
     *
     * @return bike License Plate number
     */
    String getPlate();

    /**
     * Returns park where bike is currently parked
     *
     * @return <code>Park</code> where bike is parked, <code>null</code> if moving
     */
    Park getPark();

    /**
     * Picks up bike, unparking it and registering the pickup
     *
     * @param pickup Pre-created pick up with infortmation of the user and the bike being used
     */
    void pickUp(PickUp pickup);

    /**
     * Delivers the bike, parking it and registering the successful pickup
     */
    void pickDown();

    /**
     * Returns an <code>Iterator</code> for all the sucessful pickups
     *
     * @return <code>Iterator</code> for the pickups
     */
    Iterator<PickUp> getPickUps();

    /**
     * Asserts is bike is moving or not
     *
     * @return <code>true</code> if bike has been picked up, <code>false</code> if it's parked
     */
    boolean isMoving();
}
