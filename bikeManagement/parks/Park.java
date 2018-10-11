package bikeManagement.parks;

import bikeManagement.bikes.Bike;
import dataStructures.Queue;

import java.io.Serializable;

public interface Park extends Serializable {

    /**
     * Returns park's unique ID
     * @return <code>Park</code> ID
     */
    String getParkId();

    /**
     * Returns the park's name
     * @return <code>Park</code>'s name
     */
    String getName();

    /**
     * Returns the park's address
     * @return <code>Park</code>'s address
     */
    String getAddress();

    /**
     * Returns a queue of info regarding the park
     * @return <code>Queue</code> with information: name->address->number of bikes parked
     */
    Queue<String> getParkInfo();

    /**
     * @pre: bike!=null
     * Parks a bike in the park
     * @param bike <code>Bike</code> to be parked
     */
    void parkBike(Bike bike);

    /**
     * @pre: bike!=null
     * Registers a new bike on the park. This is different from parkBike(...) because this does not register as a pickdown
     * @param bike <code>Bike</code> to be added
     */
    void addBike(Bike bike);

    /**
     * Deletes the <code>Bike</code> from the Park
     */
    void deleteBike();

    /**
     * Picks up the <code>Bike</code> that's currently in the park
     */
    void pickUp();

    /**
     * Returns the number of pickups
     * @return number of pickups
     */
    int getPickups();

    /**
     * Returns the <code>Bike</code> that's parked
     * @return parked <code>Bike</code>
     */
    Bike getParkedBike();

}
