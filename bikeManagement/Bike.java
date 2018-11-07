package bikeManagement;

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
